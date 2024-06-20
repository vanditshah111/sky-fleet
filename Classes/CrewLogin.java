import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class CrewLogin extends JFrame implements ActionListener {
    private JPanel loginpanel;
    private JTextField username;
    private JPasswordField password;
    private JLabel incorrectMessage;
    private ConnectionClass connection;
    int inpu;int inpp;
    private CrewHome crewhome;

    CrewLogin() {
        setTitle("Crew Login");
        setSize(800, 650); // Adjusted size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize login panel
        loginpanel = new JPanel();
        loginpanel.setBackground(new Color(190, 190, 190)); // Set background color
        loginpanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Add "Welcome Manager" label on top with larger font
        JLabel welcomeLabel = new JLabel("Welcome Crew Member!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginpanel.add(welcomeLabel, gbc);

        // Add username label and field
        JLabel usrlbl = new JLabel("Username:");
        usrlbl.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginpanel.add(usrlbl, gbc);

        username = new JTextField(15);
        username.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginpanel.add(username, gbc);

        // Add password label and field
        JLabel pwdlbl = new JLabel("Password:");
        pwdlbl.setFont(new Font("Arial", Font.BOLD, 28)); // Set font
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginpanel.add(pwdlbl, gbc);

        password = new JPasswordField(15);
        password.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginpanel.add(password, gbc);

        JButton enter=new JButton("Enter");
        enter.setFont(new Font("Times New Roman",Font.BOLD,30));
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginpanel.add(enter, gbc);
        enter.addActionListener(this);

        incorrectMessage=new JLabel("Incorrect Username/Password! Try again.");
        incorrectMessage.setFont(new Font("Arial",Font.BOLD,20));
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=2;
        gbc.anchor=GridBagConstraints.CENTER;
        loginpanel.add(incorrectMessage,gbc);
        incorrectMessage.setVisible(false);

        connection=new ConnectionClass();        // Add login panel to the frame
        add(loginpanel);
    }

    public void actionPerformed(ActionEvent e)
    {
        inpu = Integer.parseInt(username.getText());
        inpp = Integer.parseInt( new String(password.getPassword()));
       
        String query = "SELECT Password FROM crew WHERE Crew_ID = "+inpu+";";
        System.out.println(query);
        try {
     
            ResultSet resultSet = connection.stm.executeQuery(query);
            if (resultSet.next()) {
                int storedPassword = resultSet.getInt("Password");
                if (inpp==storedPassword) {
                    // Passwords match, login successful
                    System.out.println("Valid Credentials");
                    dispose();
                    crewhome=new CrewHome(inpu);
                    crewhome.setVisible(true);
                    
                } else {
                    // Passwords don't match, show incorrect message
                    incorrectMessage.setVisible(true);
                }
            } else {
                // No matching Crew_ID found, show incorrect message
                incorrectMessage.setVisible(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 ManagerLogin app = new ManagerLogin();
                 app.setVisible(true);
             }
         });
     }
}