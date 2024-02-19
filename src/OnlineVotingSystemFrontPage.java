import javax.swing.*;
import java.awt.*;

public class OnlineVotingSystemFrontPage extends JFrame {

    public OnlineVotingSystemFrontPage() {
        super("Online Voting System");

        // Set frame properties to maximize and remove decorations
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        // Create main content panel with black background
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.BLACK);

        // Panel to hold the name and additional information
        JPanel infoPanel = new JPanel(new GridLayout(0, 1));
        infoPanel.setOpaque(false); // Make panel transparent
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label for the name of the online voting system
        JLabel nameLabel = new JLabel("Online Voting System");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 72)); // Adjust font size as needed
        nameLabel.setForeground(Color.WHITE); // Set font color to white
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align text
        infoPanel.add(nameLabel);

        // Text area for additional information
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setText("Welcome to Online Voting System!\n\nThis system allows registered voters to cast their votes online.\nIt provides a convenient and secure platform for voters to participate in elections from the comfort of their homes.\nVoters can log in, view candidate information, and submit their votes electronically.\nThe system ensures the integrity and confidentiality of votes, making the election process efficient and accessible to all.\nPlease click the 'Login' button below to proceed.");
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 24)); // Adjust font size as needed
        descriptionArea.setForeground(Color.WHITE); // Set font color to white
        descriptionArea.setOpaque(false); // Make text area transparent
        descriptionArea.setEditable(false);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        infoPanel.add(descriptionArea);

        // Add info panel to content pane
        contentPane.add(infoPanel, BorderLayout.CENTER);

        // Create panel for login button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Make panel transparent
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 40, 80));

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            // Open the login pop-up
            new OnlineVotingSystemLogin();
        });
        buttonPanel.add(loginButton);

        // Add button panel to content pane
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Set content pane
        setContentPane(contentPane);

        // Set frame visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OnlineVotingSystemFrontPage::new);
    }
}

class ShapePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Draw shapes of your choice here, e.g.,
        g2d.setColor(Color.BLUE);
        g2d.fillOval(50, 50, 200, 200);  // Adjust coordinates and dimensions as needed
        g2d.setColor(Color.GREEN);
        g2d.fillRect(300, 100, 150, 150);
    }
}
