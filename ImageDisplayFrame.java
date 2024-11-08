import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageDisplayFrame extends JFrame {
    private JLabel imageLabel;

    public ImageDisplayFrame() {
        // Set up the frame
        setTitle("Image Display Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a button with an image icon
        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\piyus\\Downloads\\computer-program-coding-screen.jpg"); 
        JButton button = new JButton("Show Image", buttonIcon);
        button.addActionListener(new ButtonClickListener());

        // Create a label to display the image
        imageLabel = new JLabel();

        // Add components to the frame
        add(button);
        add(imageLabel);

        // Set frame visibility
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Load and display the image
            ImageIcon imageIcon = new ImageIcon("path/to/your/image.png"); // Change this to your display image path
            imageLabel.setIcon(imageIcon);
            imageLabel.repaint(); // Refresh the label to show the new image
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageDisplayFrame::new);
    }
}
