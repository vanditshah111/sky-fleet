import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CrewHome extends JFrame {
    private JPanel contentPane;
    private JTextArea flightInfoTextArea;

    public CrewHome(int cid) {
        setTitle("Crew Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        flightInfoTextArea = new JTextArea();
        flightInfoTextArea.setEditable(false);
        scrollPane.setViewportView(flightInfoTextArea);
        displayAssignedFlights(cid);
    }

    private void displayAssignedFlights(int cid) {
        StringBuilder flightInfo = new StringBuilder();
        ConnectionClass connection = new ConnectionClass(); // Assuming ConnectionClass handles database connection

        try {
            // Establish a connection to the database
           

            // Query to select flight information for the given crew member
            String query = "SELECT f.* FROM flight f JOIN assign a ON f.Flight_id = a.Flight_id WHERE a.Crew_ID = " + cid;
           
            ResultSet resultSet = connection.stm.executeQuery(query);

            // Iterate over the result set and append flight information to the StringBuilder
            while (resultSet.next()) {
                int flightId = resultSet.getInt("Flight_id");
                String origin = resultSet.getString("Source");
                String destination = resultSet.getString("Destination");
                String departureTime = resultSet.getString("Departure_Time");
                String arrivalTime = resultSet.getString("Arrival_Time");

                // Append flight information to the StringBuilder
                flightInfo.append("Flight ID: ").append(flightId).append("\n");
                flightInfo.append("Origin: ").append(origin).append("\n");
                flightInfo.append("Destination: ").append(destination).append("\n");
                flightInfo.append("Departure Time: ").append(departureTime).append("\n");
                flightInfo.append("Arrival Time: ").append(arrivalTime).append("\n\n");
            }

            // Close Statement and ResultSet
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Display flight information in the JTextArea
        flightInfoTextArea.setText(flightInfo.toString());
    }



    public static void main(String[] args) {
        // Example usage:
        SwingUtilities.invokeLater(() -> {
            int crewId = 123; // Example crew ID
            CrewHome frame = new CrewHome(crewId);
            frame.setVisible(true);
        });
    }
}
