import javax.swing.*;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class RenewInsurance extends JFrame implements ActionListener {
    private JTextField modelNoField, newPostField, newSalaryField;
    private JLabel currentPostLabel, currentSalaryLabel,modelNoLabel,titleLabel;
    private JPanel formPanel, secPanel;
    private JButton enterButton;
    private ConnectionClass connection;
    RenewInsurance() {
        setTitle("Renew Insurance");
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(190, 190, 190));

        secPanel = new JPanel(new GridBagLayout());
        secPanel.setBackground(new Color(190, 190, 190));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        titleLabel = new JLabel("Renew Insurance");
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

            GridBagConstraints gbc2 = new GridBagConstraints();
            gbc2.insets = new Insets(10, 10, 10, 10);
            // Show "Current Post" label
            String pre="";
            String getQuery="SELECT Insurance_Expiry_date from aircraft_instance where Model_No = "+s+";";
            try{
            	ResultSet resultset=connection.stm.executeQuery(getQuery);
            	if(!resultset.next())
            	{
            		System.out.println("nothing");
            	}
            	pre=resultset.getString("Insurance_Expiry_date");
            }catch(SQLException en)
            {
            	en.printStackTrace();
            }
            
         // Show "Current Post" label
            currentPostLabel = new JLabel("Current Insurance expires on: " + pre);
            currentPostLabel.setFont(new Font("Arial", Font.BOLD, 28));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc2.gridx = 0;
            gbc2.gridy = 1;
            gbc2.anchor = GridBagConstraints.CENTER;
            secPanel.add(currentPostLabel, gbc2);

//             Set layout manager for secPanel
  secPanel.setLayout(new GridBagLayout());

             //Show "New Post" label and text field
            JLabel newPostLabel = new JLabel("New Insurance Expiry Date:");
            newPostLabel.setFont(new Font("Arial", Font.BOLD, 28));
            gbc2.gridx = 0;
            gbc2.gridy = 2; // Increase gridy to create space between components
            gbc2.anchor = GridBagConstraints.LINE_END;
            secPanel.add(newPostLabel, gbc2);

            newPostField = new JTextField(20);
            newPostField.setFont(new Font("Arial", Font.PLAIN, 28));
            gbc2.gridx = 1;
            gbc2.anchor = GridBagConstraints.LINE_START;
            secPanel.add(newPostField, gbc2);

            // Show "Enter" button again
            JButton enterButton2 = new JButton("Enter");
            enterButton2.setFont(new Font("Arial", Font.BOLD, 28));
            enterButton2.setBackground(new Color(200, 200, 200));
            gbc2.gridx = 0;
            gbc2.gridy = 3; // Adjust gridy to create space between components
            gbc2.gridwidth = 2;
            gbc2.anchor = GridBagConstraints.CENTER;
            secPanel.add(enterButton2, gbc2);
            enterButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Handle action for new "Enter" button
                	String newExpiryDate = newPostField.getText(); // Assuming newExpiryDate is the input from the frontend
                	String updateQuery = "UPDATE aircraft_instance SET Insurance_Expiry_date = '" + newExpiryDate + "' WHERE Model_No = '" + s + "'";
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
                RenewInsurance RenewInsurance = new RenewInsurance();
                RenewInsurance.setVisible(true);
            }
        });
    }
}
