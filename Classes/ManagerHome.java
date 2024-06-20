import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ManagerHome extends JFrame implements ActionListener{

    private JButton addAircraft,removeAircraft,addRoute,removeRoute,viewFlights,addCrew,removeCrew,promoteCrew,changeCrewAssgn,renewInsurance,recordMaintenance,changeCaterer,modifyConfig,enterLedger;
    public ManagerHome() {
        setTitle("Manager Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 20, 20)); // 2 rows, 4 columns, with gaps
        buttonPanel.setBorder(new EmptyBorder(75, 75, 75, 75));

        // Create buttons for various functionalities
        addAircraft= new JButton("Add Aircraft");
        removeAircraft= new JButton("Remove Aircraft");
        addCrew = new JButton("Add Crew Member");
        removeCrew = new JButton("Remove Crew Member");
        viewFlights = new JButton("View Flights");
        addRoute = new JButton("Add Route");
        removeRoute = new JButton("Remove Route");
        promoteCrew = new JButton("Promote/Demote Crew Member");
        changeCrewAssgn=new JButton("Change Crew Assignment");
        renewInsurance = new JButton("Renew Insurance");
        recordMaintenance = new JButton("Record Aircraft Maintenance");
        changeCaterer = new JButton("Change Caterer");
        modifyConfig = new JButton("Modify Aircraft Configuration");
        enterLedger=new JButton("Enter into Ledger");

        // Set font and size for buttons
        Font buttonFont = new Font(Font.DIALOG, Font.PLAIN, 30);
        addAircraft.setFont(buttonFont);
        removeAircraft.setFont(buttonFont);
        addCrew.setFont(buttonFont);
        removeCrew.setFont(buttonFont);
        viewFlights.setFont(buttonFont);
        addRoute.setFont(buttonFont);
        removeRoute.setFont(buttonFont);
        promoteCrew.setFont(buttonFont);
        renewInsurance.setFont(buttonFont);
        recordMaintenance.setFont(buttonFont);
        changeCaterer.setFont(buttonFont);
        modifyConfig.setFont(buttonFont);
        changeCrewAssgn.setFont(buttonFont);
        enterLedger.setFont(buttonFont);

        addAircraft.setBackground(new Color(237,247,252));
        removeAircraft.setBackground(new Color(237,247,252));
        addCrew.setBackground(new Color(230,247,252));
        removeCrew.setBackground(new Color(230,247,252));
        viewFlights.setBackground(new Color(237,247,250));
        addRoute.setBackground(new Color(237,247,242));
        removeRoute.setBackground(new Color(237,247,242));
        promoteCrew.setBackground(new Color(237,247,250));
        renewInsurance.setBackground(new Color(247,247,252));
        recordMaintenance.setBackground(new Color(247,247,252));
        changeCaterer.setBackground(new Color(232,242,252));
        modifyConfig.setBackground(new Color(232,242,252));
        changeCrewAssgn.setBackground(new Color(237,247,252));
        enterLedger.setBackground(new Color(237,247,252));

        // Add buttons to the panel
        buttonPanel.add(addAircraft);
        buttonPanel.add(removeAircraft);
        buttonPanel.add(addRoute);
        buttonPanel.add(removeRoute);
        buttonPanel.add(addCrew);
        buttonPanel.add(removeCrew);
        buttonPanel.add(promoteCrew);
        buttonPanel.add(changeCrewAssgn);
        buttonPanel.add(viewFlights);
        buttonPanel.add(renewInsurance);
        buttonPanel.add(recordMaintenance);
        buttonPanel.add(changeCaterer);
        buttonPanel.add(modifyConfig);
        buttonPanel.add(enterLedger);

        addAircraft.addActionListener(this);
        removeAircraft.addActionListener(this);
        addCrew.addActionListener(this);
        removeCrew.addActionListener(this);
        viewFlights.addActionListener(this);
        addRoute.addActionListener(this);
        removeRoute.addActionListener(this);
        promoteCrew.addActionListener(this);
        renewInsurance.addActionListener(this);
        recordMaintenance.addActionListener(this);
        changeCaterer.addActionListener(this);
        modifyConfig.addActionListener(this);
        changeCrewAssgn.addActionListener(this);
        enterLedger.addActionListener(this);

        // Add the panel to the frame
        buttonPanel.setBackground(new Color(230,230,230));
        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==addAircraft)
        {
            dispose();
            AddAircraft AddAircraftpanel=new AddAircraft();
            AddAircraftpanel.setVisible(true);
        }
        if(e.getSource()==removeAircraft)
        {
            dispose();
            RemoveAircraft RemoveAircraftpanel=new RemoveAircraft();
            RemoveAircraftpanel.setVisible(true);
        }
        if(e.getSource()==addRoute)
        {
            dispose();
            AddFlight AddFlightpanel=new AddFlight();
            AddFlightpanel.setVisible(true);
        }
        if(e.getSource()==removeRoute)
        {
            dispose();
            RemoveFlight RemoveFlightpanel=new RemoveFlight();
            RemoveFlightpanel.setVisible(true);
        }
        if(e.getSource()==addCrew)
        {
            dispose();
            AddCrew AddCrewpanel=new AddCrew();
            AddCrewpanel.setVisible(true);
        }
        if(e.getSource()==removeCrew)
        {
            dispose();
            RemoveCrew RemoveCrewpanel=new RemoveCrew();
            RemoveCrewpanel.setVisible(true);
        }
        if(e.getSource()==viewFlights)
        {
            dispose();
            ViewFlights ViewFlightspanel=new ViewFlights();
            ViewFlightspanel.setVisible(true);
        }
        if(e.getSource()==promoteCrew)
        {
            dispose();
            PromoteCrew PromoteCrewpanel=new PromoteCrew();
            PromoteCrewpanel.setVisible(true);
        }
         if(e.getSource()==changeCrewAssgn)
         {
             dispose();
             ChangeCrewAssgn ChangeCrewAssgnpanel=new ChangeCrewAssgn();
             ChangeCrewAssgnpanel.setVisible(true);
         }
        if(e.getSource()==renewInsurance)
        {
            dispose();
            RenewInsurance RenewInsurancepanel=new RenewInsurance();
            RenewInsurancepanel.setVisible(true);
        }
        if(e.getSource()==recordMaintenance)
        {
            dispose();
            RecordMaintenance RecordMaintenancepanel=new RecordMaintenance();
            RecordMaintenancepanel.setVisible(true);
        }
        if(e.getSource()==changeCaterer)
        {
            dispose();
            ChangeCaterer ChangeCatererpanel=new ChangeCaterer();
            ChangeCatererpanel.setVisible(true);
        }
        if(e.getSource()==modifyConfig)
        {
            dispose();
            ModifyConfig ModifyConfigpanel=new ModifyConfig();
            ModifyConfigpanel.setVisible(true);
        }
        if(e.getSource()==enterLedger)
        {
            dispose();
            EnterLedger EnterLedgerpanel=new EnterLedger();
            EnterLedgerpanel.setVisible(true);   
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ManagerHome managerHome = new ManagerHome();
                managerHome.setVisible(true);
            }
        });
    }
}
