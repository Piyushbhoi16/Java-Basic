import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserForm {
    private JFrame frame;
    private JTextField nameField, emailField, passwordField;
    private JRadioButton maleRadio, femaleRadio, otherRadio;
    private JCheckBox javaCheckBox, pythonCheckBox, cppCheckBox, javascriptCheckBox;
    private JTextArea addressArea;
    private JComboBox<String> countryComboBox;
    private JButton submitButton;

    public UserForm() {
        frame = new JFrame("User Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new GridLayout(0, 1));

        // Name Field
        frame.add(new JLabel("Name:"));
        nameField = new JTextField();
        frame.add(nameField);

        // Email Field
        frame.add(new JLabel("Email:"));
        emailField = new JTextField();
        frame.add(emailField);

        // Password Field
        frame.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        frame.add(passwordField);

        // Gender Selection
        frame.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        otherRadio = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        genderPanel.add(otherRadio);
        frame.add(genderPanel);

        // Known Languages Selection
        frame.add(new JLabel("Known Languages:"));
        JPanel languagesPanel = new JPanel();
        javaCheckBox = new JCheckBox("Java");
        pythonCheckBox = new JCheckBox("Python");
        cppCheckBox = new JCheckBox("C++");
        javascriptCheckBox = new JCheckBox("JavaScript");
        languagesPanel.add(javaCheckBox);
        languagesPanel.add(pythonCheckBox);
        languagesPanel.add(cppCheckBox);
        languagesPanel.add(javascriptCheckBox);
        frame.add(languagesPanel);

        // Address Field
        frame.add(new JLabel("Address:"));
        addressArea = new JTextArea(4, 20);
        frame.add(new JScrollPane(addressArea));

        // Country Selection
        frame.add(new JLabel("Country:"));
        String[] countries = {"USA", "Canada", "UK", "Australia", "India"};
        countryComboBox = new JComboBox<>(countries);
        frame.add(countryComboBox);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        frame.add(submitButton);

        frame.setVisible(true);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText(); // In real apps, don't display this!
            String gender = maleRadio.isSelected() ? "Male" :
                            femaleRadio.isSelected() ? "Female" :
                            otherRadio.isSelected() ? "Other" : "Not specified";
            StringBuilder languages = new StringBuilder();
            if (javaCheckBox.isSelected()) languages.append("Java ");
            if (pythonCheckBox.isSelected()) languages.append("Python ");
            if (cppCheckBox.isSelected()) languages.append("C++ ");
            if (javascriptCheckBox.isSelected()) languages.append("JavaScript ");
            String address = addressArea.getText();
            String country = (String) countryComboBox.getSelectedItem();

            String message = "Name: " + name +
                             "\nEmail: " + email +
                             "\nPassword: " + password +
                             "\nGender: " + gender +
                             "\nKnown Languages: " + languages.toString().trim() +
                             "\nAddress: " + address +
                             "\nCountry: " + country;

            JOptionPane.showMessageDialog(frame, message, "User Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserForm::new);
    }
}
