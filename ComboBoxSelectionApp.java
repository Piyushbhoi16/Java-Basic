import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxSelectionApp extends JFrame {
    private JComboBox<String> stateComboBox;
    private JComboBox<String> languageComboBox;
    private JLabel selectedStateLabel;
    private JLabel selectedLanguageLabel;

    public ComboBoxSelectionApp() {
        // Set up the frame
        setTitle("ComboBox Selection Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create JComboBox for states
        String[] states = {"Select State", "California", "Texas", "New York", "Florida", "Illinois"};
        stateComboBox = new JComboBox<>(states);
        stateComboBox.addActionListener(new ComboBoxListener());

        // Create JComboBox for languages
        String[] languages = {"Select Language", "English", "Spanish", "French", "German", "Mandarin"};
        languageComboBox = new JComboBox<>(languages);
        languageComboBox.addActionListener(new ComboBoxListener());

        // Create labels to display selected items
        selectedStateLabel = new JLabel("Selected State: None");
        selectedLanguageLabel = new JLabel("Selected Language: None");

        // Add components to the frame
        add(new JLabel("Select State:"));
        add(stateComboBox);
        add(new JLabel("Select Language:"));
        add(languageComboBox);
        add(selectedStateLabel);
        add(selectedLanguageLabel);

        // Set frame visibility
        setVisible(true);
    }

    private class ComboBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Update selected state label
            String selectedState = (String) stateComboBox.getSelectedItem();
            selectedStateLabel.setText("Selected State: " + selectedState);

            // Update selected language label
            String selectedLanguage = (String) languageComboBox.getSelectedItem();
            selectedLanguageLabel.setText("Selected Language: " + selectedLanguage);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ComboBoxSelectionApp::new);
    }
}
