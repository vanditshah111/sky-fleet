import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCrew extends JFrame implements ActionListener{
    private JTextField crewIDField, nameField, genderField, postField, salaryField;
    private JLabel errorMsg;
    private ConnectionClass connection;
    AddCrew() {
        setTitle("Add Crew Member");
        setSize(800, 650); // Adjusted size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(190, 190, 190)); // Set background color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Add "Add Crew" label on top with larger font
        JLabel titleLabel = new JLabel("Add Crew Member");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(titleLabel, gbc);

        // Add model number label and field
        JLabel crewIDLabel = new JLabel("Crew ID:");
        crewIDLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(crewIDLabel, gbc);

        crewIDField = new JTextField(10);
        crewIDField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(crewIDField, gbc);

        // Add model name label and field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(nameLabel, gbc);

        nameField = new JTextField(10);
        nameField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(nameField, gbc);

        // Add economy class seats label and field
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(genderLabel, gbc);

        genderField = new JTextField(10);
        genderField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(genderField, gbc);

        // Add business class seats label and field
        JLabel postLabel = new JLabel("Post:");
        postLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(postLabel, gbc);

        postField = new JTextField(10);
        postField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(postField, gbc);

        // Add first class seats label and field
        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(salaryLabel, gbc);

        salaryField = new JTextField(10);
        salaryField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(salaryField, gbc);

        
        // Add "Enter" button
        JButton enterButton = new JButton("Enter");
        enterButton.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        enterButton.setBackground(new Color(200, 200, 200)); // Set background color
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(enterButton, gbc);
        enterButton.addActionListener(this);

        errorMsg = new JLabel("Crew with this ID number already exists! Try again.");
        errorMsg.setFont(new Font("Arial", Font.BOLD, 18));
        errorMsg.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(errorMsg, gbc);
        errorMsg.setVisible(false);

        connection=new ConnectionClass();
        // Add form panel to the frame
        add(formPanel);
    }

    public void actionPerformed(ActionEvent e)
    {
    	String fid=crewIDField.getText();
        try {
        ResultSet resultSet = connection.stm.executeQuery("SELECT * FROM flight WHERE Flight_ID = " + fid);

        // If resultSet has any rows, it means the flight ID already exists
        if (resultSet.next()) {
            errorMsg.setVisible(true);
        } else {
            // If resultSet is empty, proceed with adding the flight to the database
            // You can implement the logic to add the flight here
            // For demonstration purposes, we're just printing a message
            System.out.println("Adding flight with ID: " + fid);
        }

        // Close the ResultSet
        resultSet.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        String source=nameField.getText();
        String destination=genderField.getText();
        String arrivaltime=postField.getText();
        String departuretime=salaryField.getText();
        
        String insertQuery="INSERT into crew(Crew_ID,Name,Gender,Post,Salary) "+"VALUES("+fid+",'"+source+"','"+destination+"','"+arrivaltime+"',"+departuretime+");";
        System.out.println(insertQuery);
        try {

       	    // Execute the insert query
       	    int rowsAffected = connection.stm.executeUpdate(insertQuery);

       	    // Check if any rows were affected
       	    if (rowsAffected > 0) {
       	        // Insert successful
       	        System.out.println("Flight inserted successfully.");
       	    } else {
       	        // No rows were inserted (possibly due to a failed insert)
       	        System.out.println("No rows inserted.");
       	    }
       	} catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AddCrew addCrew = new AddCrew();
                addCrew.setVisible(true);
            }
        });
    }
}
