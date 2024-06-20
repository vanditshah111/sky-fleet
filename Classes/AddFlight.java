import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddFlight extends JFrame implements ActionListener{
    private JTextField flightIDField, sourceField, destinationField, arrivaltField, departuretField, aidField, cidField, distField;
    private JLabel errorMsg;
    private ConnectionClass connection;
    AddFlight() {
        setTitle("Add Flight");
        setSize(800, 650); // Adjusted size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(190, 190, 190)); // Set background color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Add "Add Aircraft" label on top with larger font
        JLabel titleLabel = new JLabel("Add Flight");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(titleLabel, gbc);

        // Add model number label and field
        JLabel modelNoLabel = new JLabel("Flight ID:");
        modelNoLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(modelNoLabel, gbc);

        flightIDField = new JTextField(10);
        flightIDField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(flightIDField, gbc);

        // Add model name label and field
        JLabel modelNameLabel = new JLabel("Source:");
        modelNameLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(modelNameLabel, gbc);

        sourceField = new JTextField(10);
        sourceField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(sourceField, gbc);

        // Add economy class seats label and field
        JLabel economyClassSeatsLabel = new JLabel("Destination:");
        economyClassSeatsLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(economyClassSeatsLabel, gbc);

        destinationField = new JTextField(10);
        destinationField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(destinationField, gbc);

        // Add business class seats label and field
        JLabel businessClassSeatsLabel = new JLabel("Arrival Time:");
        businessClassSeatsLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(businessClassSeatsLabel, gbc);

        arrivaltField = new JTextField(10);
        arrivaltField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(arrivaltField, gbc);

        // Add first class seats label and field
        JLabel fClassSeatsLabel = new JLabel("Departure Time:");
        fClassSeatsLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(fClassSeatsLabel, gbc);

        departuretField = new JTextField(10);
        departuretField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(departuretField, gbc);

        // Add date of commission label and field
        JLabel docLabel = new JLabel("Aircraft Model No.:");
        docLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(docLabel, gbc);

        aidField = new JTextField(10);
        aidField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(aidField, gbc);

        JLabel iedLabel = new JLabel("Caterer ID:");
        iedLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(iedLabel, gbc);

        cidField = new JTextField(10);
        cidField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(cidField, gbc);

        // Add maintenance schedule label and field
        JLabel maintenanceLabel = new JLabel("Distance:");
        maintenanceLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(maintenanceLabel, gbc);

        distField = new JTextField(10);
        distField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(distField, gbc);

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

        errorMsg = new JLabel("Flight with this id already exists! Try again.");
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
         String fid=flightIDField.getText();
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
         String source=sourceField.getText();
         String destination=destinationField.getText();
         String arrivaltime=arrivaltField.getText();
         String departuretime=departuretField.getText();
         String aid=aidField.getText();
         String cid=cidField.getText();
         int dist=Integer.parseInt(distField.getText());
         
         String insertQuery="INSERT into flight(Flight_ID,Source,Destination,Arrival_Time,Departure_Time,Distance,Model_No,Caterer_ID) "+"VALUES("+fid+",'"+source+"','"+destination+"','"+arrivaltime+"','"+departuretime+"','"+aid+"','"+cid+"',"+dist+");";
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
                AddFlight addAircraft = new AddFlight();
                addAircraft.setVisible(true);
            }
        });
    }
}