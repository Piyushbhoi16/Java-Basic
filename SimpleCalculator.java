import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    private JFrame frame;
    private JTextField inputField;
    private double firstNumber;
    private String operator;

    public SimpleCalculator() {
        // Set up the frame
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        // Create the text field
        inputField = new JTextField();
        inputField.setEditable(false);
        frame.add(inputField, BorderLayout.NORTH);

        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        // Button labels
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        // Create buttons and add to the panel
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Set frame visibility
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                // If the button pressed is a number, append it to the text field
                inputField.setText(inputField.getText() + command);
            } else if (command.equals("C")) {
                // Clear the input field
                inputField.setText("");
                firstNumber = 0;
                operator = null;
            } else if (command.equals("=")) {
                // Perform the calculation
                if (operator != null && !inputField.getText().isEmpty()) {
                    double secondNumber = Double.parseDouble(inputField.getText());
                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "*":
                            result = firstNumber * secondNumber;
                            break;
                        case "/":
                            if (secondNumber != 0) {
                                result = firstNumber / secondNumber;
                            } else {
                                JOptionPane.showMessageDialog(frame, "Cannot divide by zero");
                                return;
                            }
                            break;
                        case "%":
                            result = firstNumber % secondNumber;
                            break;
                    }

                    inputField.setText(String.valueOf(result));
                    operator = null; // Clear operator after calculation
                }
            } else {
                // If an operator is pressed, store the first number and operator
                if (!inputField.getText().isEmpty()) {
                    firstNumber = Double.parseDouble(inputField.getText());
                    operator = command;
                    inputField.setText(""); // Clear field for the next number
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleCalculator::new);
    }
}
