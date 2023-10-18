import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class mainGUI {
    private static JTextPane fileContentTextPane; // Text pane to display the file content

    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("KAE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Set initial size

        // Create a label
        JLabel label = new JLabel("Karate API Editor");

        // Create a button
        JButton browseButton = new JButton("Browse feature file");

        // Create a panel to organize components
        JPanel topPanel = new JPanel();
        topPanel.add(label);

        // Add the label and button to the top panel
        topPanel.add(browseButton);

        // Create a text pane for displaying the file content
        fileContentTextPane = new JTextPane();
        fileContentTextPane.setEditable(false);

        // Create a scroll pane for the text pane
        JScrollPane scrollPane = new JScrollPane(fileContentTextPane);

        // Create a main panel and use BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH); // Place the top panel at the top
        mainPanel.add(scrollPane, BorderLayout.CENTER); // Place the text pane in the center

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Make the frame visible
        frame.setVisible(true);

        // Create a file filter to select only ".feature" files
        FileFilter featureFileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".feature");
            }

            @Override
            public String getDescription() {
                return "Feature Files (*.feature)";
            }
        };

        // Set the file filter for the file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(featureFileFilter);

        browseButton.addActionListener(e -> {
            // Show the file dialog
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                File selectedFile = fileChooser.getSelectedFile();

                // Read the content of the selected file
                try {
                    String fileContent = new String(Files.readAllBytes(selectedFile.toPath()));

                    // Set the file content in the text pane
                    fileContentTextPane.setText(fileContent);

                    // Change the window size to 700 by 500
                    frame.setSize(700, 500);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
