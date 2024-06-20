import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class RemoveFlight extends JFrame implements ActionListener{
	private JTextField modelNoField;
	private ConnectionClass connection;

	RemoveFlight() {
		setTitle("Remove Flight");
        setSize(800, 650); // Adjusted size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(190, 190, 190)); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Remove Flight");
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

        modelNoField = new JTextField(10);
        modelNoField.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(modelNoField, gbc);

        JButton enterButton = new JButton("Enter");
        enterButton.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        enterButton.setBackground(new Color(200, 200, 200)); // Set background color
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(enterButton, gbc);
        enterButton.addActionListener(this);

        connection=new ConnectionClass();
        // Add form panel to the frame
        add(formPanel);
    }

    public void actionPerformed(ActionEvent e)
    {
    	String flightId = modelNoField.getText(); // Assuming flightId is the input from the frontend
    	String deleteQuery = "DELETE FROM flight WHERE Flight_ID = '" + flightId + "'";
    	try {
			boolean b=connection.stm.execute(deleteQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RemoveFlight addFlight = new RemoveFlight();
                addFlight.setVisible(true);
            }
        });
    }
}