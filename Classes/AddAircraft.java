import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddAircraft extends JFrame implements ActionListener{
    private JTextField modelNoField, modelNameField, economyClassSeatsField, businessClassSeatsField, fClassSeatsField, docField, iedField, maintenanceField;
    private JLabel errorMsg;
    private ConnectionClass connection;
    AddAircraft() {
        setTitle("Add Aircraft");
        setSize(800, 650); // Adjusted size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(190, 190, 190)); // Set background color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Add "Add Aircraft" label on top with larger font
        JLabel titleLabel = new JLabel("Add Aircraft");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(titleLabel, gbc);

        // Add model number label and field
        JLabel modelNoLabel = new JLabel("Model Number:");
        modelNoLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(modelNoLabel, gbc);

        modelNoField = new JTextField(10);
        modelNoField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(modelNoField, gbc);

        // Add model name label and field
        JLabel modelNameLabel = new JLabel("Model Name:");
        modelNameLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(modelNameLabel, gbc);

        modelNameField = new JTextField(10);
        modelNameField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(modelNameField, gbc);

        // Add economy class seats label and field
        JLabel economyClassSeatsLabel = new JLabel("Economy Class Seats:");
        economyClassSeatsLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(economyClassSeatsLabel, gbc);

        economyClassSeatsField = new JTextField(10);
        economyClassSeatsField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(economyClassSeatsField, gbc);

        // Add business class seats label and field
        JLabel businessClassSeatsLabel = new JLabel("Business Class Seats:");
        businessClassSeatsLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(businessClassSeatsLabel, gbc);

        businessClassSeatsField = new JTextField(10);
        businessClassSeatsField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(businessClassSeatsField, gbc);

        // Add first class seats label and field
        JLabel fClassSeatsLabel = new JLabel("First Class Seats:");
        fClassSeatsLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(fClassSeatsLabel, gbc);

        fClassSeatsField = new JTextField(10);
        fClassSeatsField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(fClassSeatsField, gbc);

        // Add date of commission label and field
        JLabel docLabel = new JLabel("Date of Commission:");
        docLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(docLabel, gbc);

        docField = new JTextField(10);
        docField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(docField, gbc);

        JLabel iedLabel = new JLabel("Insurance Expiry Date:");
        iedLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(iedLabel, gbc);

        iedField = new JTextField(10);
        iedField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(iedField, gbc);

        // Add maintenance schedule label and field
        JLabel maintenanceLabel = new JLabel("Maintenance:");
        maintenanceLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(maintenanceLabel, gbc);

        maintenanceField = new JTextField(10);
        maintenanceField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(maintenanceField, gbc);

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

        errorMsg = new JLabel("Aircraft with this model number already exists! Try again.");
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
    	String fid=modelNoField.getText();
        try {
        ResultSet resultSet = connection.stm.executeQuery("SELECT * FROM aircraft_instance WHERE Model_No = " + fid);

        // If resultSet has any rows, it means the flight ID already exists
        if (resultSet.next()) {
            errorMsg.setVisible(true);
        } else {
            // If resultSet is empty, proceed with adding the flight to the database
            // You can implement the logic to add the flight here
            // For demonstration purposes, we're just printing a message
            System.out.println("Adding aircraft with ID: " + fid);
        }

        // Close the ResultSet
        resultSet.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        String source=modelNameField.getText();
        String destination=economyClassSeatsField.getText();
        String arrivaltime=businessClassSeatsField.getText();
        String departuretime=fClassSeatsField.getText();
        String aid=docField.getText();
        String cid=iedField.getText();
        String dist=maintenanceField.getText();
        
        String insertQuery="INSERT into aircraft_instance(Model_No,Model_Name,Economy_Class_Seats,Business_Class_Seats,First_Class_Seats,Date_Of_Commission,Insurance_Expiry_Date,Last_Maintenance_Date) "+"VALUES("+fid+",'"+source+"','"+destination+"','"+arrivaltime+"','"+departuretime+"','"+aid+"','"+cid+"','"+dist+"');";
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
                 AddAircraft addAircraft = new AddAircraft();
                 addAircraft.setVisible(true);
             }
         });
     }
}
