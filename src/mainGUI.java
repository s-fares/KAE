import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class mainGUI {

    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Karate API Editor");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label
        JLabel label = new JLabel("Welcome to the Karate API Editor");

        // Create a button
        JButton browseButton = new JButton("Browse feature file");

        // Create a panel to organize components
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(browseButton);

        // Add the panel to the frame
        frame.add(panel);

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a file chooser
                JFileChooser fileChooser = new JFileChooser();

                // Show the file dialog
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file
                    File selectedFile = fileChooser.getSelectedFile();
                    String fileName = selectedFile.getName();

                    // Create a new window to display the selected file name
                    createNewWindow(fileName);
                }
            }
        });

        frame.setVisible(true);
    }

    private static void createNewWindow(String fileName) {
        JFrame newFrame = new JFrame("Selected Feature");
        newFrame.setSize(300, 100);

        // Create a label to display the file name
        JLabel fileNameLabel = new JLabel("Selected Feature: " + fileName);

        // Add the label to the new window
        newFrame.add(fileNameLabel);

        newFrame.setVisible(true);
    }
}
