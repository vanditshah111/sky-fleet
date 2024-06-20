import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class FontDemo extends JFrame {
    public FontDemo() {
        setTitle("Font Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create a panel for the label
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Create a label with different fonts
        JLabel label1 = new JLabel("Arial Bold 18");
        label1.setFont(new Font(Font.SERIF, Font.PLAIN, 24));

        JLabel label2 = new JLabel("Times New Roman Italic 24");
        label2.setFont(new Font("DUBAI-BOLD", Font.PLAIN, 24));

        panel.add(label1);
        panel.add(label2);

        // Add the panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FontDemo fontDemo = new FontDemo();
                fontDemo.setVisible(true);
            }
        });
    }
}
