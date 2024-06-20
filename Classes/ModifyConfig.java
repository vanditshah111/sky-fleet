import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyConfig extends JFrame implements ActionListener {
    private JTextField modelNoField, newPostField, newSalaryField;
    private JLabel currentPostLabel, currentSalaryLabel,modelNoLabel,titleLabel;
    private JPanel formPanel, secPanel;
    private JButton enterButton;
    private ConnectionClass connection;
    
    ModifyConfig() {
        setTitle("Modify Configuration");
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(190, 190, 190));

        secPanel = new JPanel(new GridBagLayout());
        secPanel.setBackground(new Color(190, 190, 190));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        titleLabel = new JLabel("Modify Configuration");
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

        connection=new ConnectionClass();
        add(formPanel);
    }

    public void actionPerformed(ActionEvent e) {
        String s = modelNoField.getText();
            formPanel.remove(modelNoLabel); // Remove Crew ID label
            formPanel.remove(modelNoField); // Remove Crew ID text field
            formPanel.remove(enterButton); // Remove Enter button
            formPanel.remove(titleLabel); // Remove Enter button

            // Show "Current Post" label
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            String q1 = "SELECT Economy_Class_Seats,Business_Class_Seats,First_Class_Seats FROM aircraft_instance WHERE Model_No = '" + s + "'";
            System.out.println(q1);

            String s1 = ""; // Post
            String s2=""; // Salary
            String s3="";
            String s4="";
            try {
                ResultSet resultset = connection.stm.executeQuery(q1);
                // Check if the ResultSet has any rows
                if (resultset.next()) {
                    // If there are rows, retrieve values for the first row
                    s1 = Integer.toString(resultset.getInt("Economy_Class_Seats"));
                    s2 = Integer.toString(resultset.getInt("Business_Class_Seats"));
                    s3 = Integer.toString(resultset.getInt("First_Class_Seats"));
                    
                } else {
                    // No rows returned, handle accordingly (e.g., print a message)
                    System.out.println("No data found for Crew ID: " + s);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            s4=s1+","+s2+","+s3;
            currentPostLabel = new JLabel("Economy Class, Business Class, First Class :"+s4);
            currentPostLabel.setFont(new Font("Arial", Font.BOLD, 28));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            secPanel.add(currentPostLabel, gbc);

            // Show "New Post" label and text field
            JLabel newPostLabel = new JLabel("New Configuration :");
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
                	String[] parts = newPost.split(",");
                	int[] values = new int[parts.length];
                	for (int i = 0; i < parts.length; i++) {
                	    values[i] = Integer.parseInt(parts[i].trim());
                	}
                	String updateQuery = "UPDATE aircraft_instance SET Economy_Class_Seats = " + values[0] + ", Business_Class_Seats = " + values[1] +",First_Class_Seats = "+values[2]+ " WHERE Model_No = '" + s + "'";
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
                ModifyConfig ModifyConfig = new ModifyConfig();
                ModifyConfig.setVisible(true);
            }
        });
    }
}
