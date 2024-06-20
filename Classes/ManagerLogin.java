import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagerLogin extends JFrame implements ActionListener {
    private JPanel loginpanel;
    private JTextField username;
    private JPasswordField password;
    private JLabel incorrectMessage;
    private ManagerHome ManagerHomepanel;
    String inpu,inpp;

    ManagerLogin() {
        setTitle("Manager Login");
        setSize(800, 650); // Adjusted size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize login panel
        loginpanel = new JPanel();
        loginpanel.setBackground(new Color(190, 190, 190)); // Set background color
        loginpanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Add "Welcome Manager" label on top with larger font
        JLabel welcomeLabel = new JLabel("Welcome Manager!");
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

        username = new JTextField(10);
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

        password = new JPasswordField(10);
        password.setFont(new Font("Arial", Font.PLAIN, 28)); // Set font
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginpanel.add(password, gbc);

        JButton enter=new JButton("Enter");
        enter.setFont(new Font("Times New Roman",Font.BOLD,20));
        enter.setBackground(new Color(200,200,200));
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

        // Add login panel to the frame
        add(loginpanel);
    }
    public void actionPerformed(ActionEvent e)
    {
        inpu=username.getText();
        inpp=new String(password.getPassword());
        if(inpu.equals("vandit")&&inpp.equals("shah"))
        {
            dispose();
            ManagerHomepanel=new ManagerHome();
            ManagerHomepanel.setVisible(true);
        }
        else
        {
            // System.out.println("Invalid Credentials");
            incorrectMessage.setVisible(true);
        }
    }
    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(new Runnable() {
    //         public void run() {
    //             ManagerLogin app = new ManagerLogin();
    //             app.setVisible(true);
    //         }
    //     });
    // }
}
