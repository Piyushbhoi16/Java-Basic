import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseSelectionApp extends JFrame {
    private JCheckBox course1, course2, course3, course4;
    private JRadioButton male, female, other;
    private JTextArea displayArea;

    public CourseSelectionApp() {
        // Set up the frame
        setTitle("Course Selection");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create course checkboxes
        course1 = new JCheckBox("Java Programming");
        course2 = new JCheckBox("Web Development");
        course3 = new JCheckBox("Data Science");
        course4 = new JCheckBox("Mobile App Development");

        // Create gender radio buttons
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        // Group radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        // Create display area
        displayArea = new JTextArea(5, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());

        // Add components to the frame
        add(course1);
        add(course2);
        add(course3);
        add(course4);
        add(new JLabel("Gender:"));
        add(male);
        add(female);
        add(other);
        add(submitButton);
        add(scrollPane);

        // Set frame visibility
        setVisible(true);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder selectedCourses = new StringBuilder("Selected Courses:\n");
            if (course1.isSelected()) selectedCourses.append(course1.getText()).append("\n");
            if (course2.isSelected()) selectedCourses.append(course2.getText()).append("\n");
            if (course3.isSelected()) selectedCourses.append(course3.getText()).append("\n");
            if (course4.isSelected()) selectedCourses.append(course4.getText()).append("\n");

            String gender = "";
            if (male.isSelected()) gender = "Male";
            else if (female.isSelected()) gender = "Female";
            else if (other.isSelected()) gender = "Other";

            selectedCourses.append("\nGender: ").append(gender);
            displayArea.setText(selectedCourses.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CourseSelectionApp::new);
    }
}
