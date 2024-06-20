import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginApp extends JFrame implements ActionListener {
    private JPanel loginPanel;
    private JButton managerLoginBtn, crewLoginBtn;
    private ManagerLogin ManagerLoginPanel;
    private CrewLogin CrewLoginPanel;
    public LoginApp() {
        setTitle("Login");
        setSize(800, 650); // Adjusted size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ConnectionClass c1=new ConnectionClass();
        // Initialize components
        managerLoginBtn = new JButton("Manager Login");
        managerLoginBtn.setFont(new Font("Verdana", Font.BOLD, 48));
        managerLoginBtn.setBackground(new Color(102,178,178));
        managerLoginBtn.addActionListener(this);

        crewLoginBtn = new JButton("Crew Login");
        crewLoginBtn.setFont(new Font("Verdana", Font.BOLD, 48));
        crewLoginBtn.setBackground(Color.BLACK);
        crewLoginBtn.setForeground(new Color(100,100,100));
        crewLoginBtn.addActionListener(this);

        // Create login panel
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(2, 1));
        loginPanel.add(managerLoginBtn);
        loginPanel.add(crewLoginBtn);

        // Add login panel to main frame
        add(loginPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == managerLoginBtn) {
            dispose();
            ManagerLoginPanel=new ManagerLogin();
            ManagerLoginPanel.setVisible(true);
        } else if (e.getSource() == crewLoginBtn) {
            dispose();
            CrewLoginPanel=new CrewLogin();
            CrewLoginPanel.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginApp app = new LoginApp();
                app.setVisible(true);
            }
        });
    }
}
