import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ChangeCrewAssgn extends JFrame implements ActionListener {
    private JTextField modelNoField, newPostField, newSalaryField;
    private JLabel currentPostLabel, currentSalaryLabel,modelNoLabel,titleLabel;
    private JPanel formPanel, secPanel;
    private JButton enterButton;
    private ConnectionClass connection;

    ChangeCrewAssgn() {
        setTitle("Change Assignment");
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(190, 190, 190));

        secPanel = new JPanel(new GridBagLayout());
        secPanel.setBackground(new Color(190, 190, 190));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        titleLabel = new JLabel("Change Assignment");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(titleLabel, gbc);

        // Add model number label and field
        modelNoLabel = new JLabel("Assignment ID:");
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
        
        connection=new ConnectionClass();

        add(formPanel);
    }

    public void actionPerformed(ActionEvent e) {
        String s = modelNoField.getText();
            formPanel.remove(modelNoLabel); // Remove Crew ID label
            formPanel.remove(modelNoField); // Remove Crew ID text field
            formPanel.remove(enterButton); // Remove Enter button
            formPanel.remove(titleLabel);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            String q1 = "SELECT Flight_ID, Crew_ID FROM Assign WHERE Assignment_ID = '" + s + "'";
            System.out.println(q1);

            String s1 = ""; // Post
            int s2=0; // Salary

            try {
                ResultSet resultSet = connection.stm.executeQuery(q1);
                // Check if the ResultSet has any rows
                if (resultSet.next()) {
                    // If there are rows, retrieve values for the first row
                    s1 = resultSet.getString("Flight_ID");
                    s2 = resultSet.getInt("Crew_ID");
                } else {
                    // No rows returned, handle accordingly (e.g., print a message)
                    System.out.println("No data found for Assgn ID: " + s);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            // Show "Current Post" label
            currentPostLabel = new JLabel("Flight ID:"+s1);
            currentPostLabel.setFont(new Font("Arial", Font.BOLD, 28));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            secPanel.add(currentPostLabel, gbc);

            // Show "Current Salary" label
            currentSalaryLabel = new JLabel("Crew ID:"+s2);
            currentSalaryLabel.setFont(new Font("Arial", Font.BOLD, 28));
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            secPanel.add(currentSalaryLabel, gbc);

            // Show "New Post" label and text field
            JLabel newPostLabel = new JLabel("New Flight ID:");
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

            // Show "New Salary" label and text field
            JLabel newSalaryLabel = new JLabel("New Crew ID:");
            newSalaryLabel.setFont(new Font("Arial", Font.BOLD, 28));
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.anchor = GridBagConstraints.LINE_END;
            secPanel.add(newSalaryLabel, gbc);

            newSalaryField = new JTextField(10);
            newSalaryField.setFont(new Font("Arial", Font.PLAIN, 28));
            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            secPanel.add(newSalaryField, gbc);

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
                    String newSalary = newSalaryField.getText();
                    String updateQuery = "UPDATE assign SET Flight_ID = '" + newPost + "', Crew_ID = '" + newSalary + "' WHERE Assignment_ID = '" + s + "'";

                	try{
                    	boolean b=connection.stm.execute(updateQuery);
                    	if(!b)
                    	{
                    		System.out.println("nothing");
                    	}
                    }catch(SQLException en)
                    {
                    	en.printStackTrace();
                    }
                    // Process the new post and salary
                }
            });

            add(secPanel);
            revalidate(); // Refresh the frame to reflect changes
        }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ChangeCrewAssgn promoteCrew = new ChangeCrewAssgn();
                promoteCrew.setVisible(true);
            }
        });
    }
}
