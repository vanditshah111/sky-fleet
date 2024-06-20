import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewFlights extends JFrame {
    private JTextArea flightDataTextArea;
    private ConnectionClass connection;

    ViewFlights() {
        setTitle("View Flights");
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Instantiate ConnectionClass to establish database connection
        connection = new ConnectionClass();

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(190, 190, 190));

        // Create JTextArea to display flight data
        flightDataTextArea = new JTextArea(20, 40);
        flightDataTextArea.setEditable(false); // Make it read-only
        JScrollPane scrollPane = new JScrollPane(flightDataTextArea);

        // Add JTextArea to formPanel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(scrollPane, gbc);

        // Add formPanel to the frame
        add(formPanel);

        // Retrieve and display flight data
        displayFlightData();
    }

    private void displayFlightData() {
        try {
            // Execute SQL query to retrieve data from flights table
            ResultSet resultSet = connection.stm.executeQuery("SELECT * FROM flight");

            // Process the ResultSet and display flight data
            StringBuilder flightData = new StringBuilder();
            while (resultSet.next()) {
                // Assuming flights table has columns: flight_id, origin, destination, departure_time, etc.
                int flightId = resultSet.getInt("Flight_id");
                String origin = resultSet.getString("Source");
                String destination = resultSet.getString("Destination");
                String departureTime = resultSet.getString("Departure_Time");
                String arrivalTime = resultSet.getString("Arrival_Time");
                
                

                // Append flight data to the StringBuilder
                flightData.append("Flight ID: \t").append(flightId).append(",\t");
                flightData.append("Origin: \t").append(origin).append(",\t");
                flightData.append("Destination: \t").append(destination).append(",\t");
                flightData.append("Departure Time: \t").append(departureTime).append(",\t");
                flightData.append("Arrival Time: \t").append(arrivalTime).append(",\t");
                //flightData.append("Number of Crew: \t").append(count).append("\n");
            }

            // Display flight data in the JTextArea
            flightDataTextArea.setText(flightData.toString());

            // Close the ResultSet
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewFlights viewFlights = new ViewFlights();
            viewFlights.setVisible(true);
        });
    }
}
