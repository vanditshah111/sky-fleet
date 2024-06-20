import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RecordMaintenance extends JFrame implements ActionListener {
    private JTextField modelNoField, newPostField, newSalaryField;
    private JLabel currentPostLabel, currentSalaryLabel,modelNoLabel,titleLabel;
    private JPanel formPanel, secPanel;
    private JButton enterButton;

    RecordMaintenance() {
        setTitle("Record Maintenance");
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(190, 190, 190));

        secPanel = new JPanel(new GridBagLayout());
        secPanel.setBackground(new Color(190, 190, 190));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        titleLabel = new JLabel("Record Maintenance");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(titleLabel, gbc);

        // Add model number label and field
        modelNoLabel = new JLabel("Aircraft Model No.:");
        modelNoLabel.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(modelNoLabel, gbc);

        modelNoField = new JTextField(10);
        modelNoField.setFont(new Font("Arial", Font.PLAIN, 28));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(modelNoField, gbc);

        enterButton = new JButton("Enter");
        enterButton.setFont(new Font("Arial", Font.BOLD, 28));
        enterButton.setBackground(new Color(200, 200, 200));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(enterButton, gbc);
        enterButton.addActionListener(this);

        add(formPanel);
    }

    public void actionPerformed(ActionEvent e) {
        String s = modelNoField.getText();
        if (s.equals("yes")) {
            formPanel.remove(modelNoLabel); // Remove Crew ID label
            formPanel.remove(modelNoField); // Remove Crew ID text field
            formPanel.remove(enterButton); // Remove Enter button
            formPanel.remove(titleLabel); // Remove Enter button

            // Show "Current Post" label
            String sb="01/11/2004";
            currentPostLabel = new JLabel("Last Maintenance performed on :"+sb);
            currentPostLabel.setFont(new Font("Arial", Font.BOLD, 28));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            secPanel.add(currentPostLabel, gbc);

            // Show "New Post" label and text field
            JLabel newPostLabel = new JLabel("Latest Maintenance Date:");
            newPostLabel.setFont(new Font("Arial", Font.BOLD, 28));
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.anchor = GridBagConstraints.LINE_END;
            secPanel.add(newPostLabel, gbc);

            newPostField = new JTextField(10);
            newPostField.setFont(new Font("Arial", Font.PLAIN, 28));
            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            secPanel.add(newPostField, gbc);

            // Show "Enter" button again
            JButton enterButton2 = new JButton("Enter");
            enterButton2.setFont(new Font("Arial", Font.BOLD, 28));
            enterButton2.setBackground(new Color(200, 200, 200));
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            secPanel.add(enterButton2, gbc);
            enterButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Handle action for new "Enter" button
                    String newPost = newPostField.getText();
                    // Process the new post and salary
                }
            });

            add(secPanel);
            revalidate(); // Refresh the frame to reflect changes
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RecordMaintenance RecordMaintenance = new RecordMaintenance();
                RecordMaintenance.setVisible(true);
            }
        });
    }
}
