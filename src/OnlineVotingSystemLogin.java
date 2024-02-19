import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineVotingSystemLogin extends JFrame {

    private JButton adminLoginButton;
    private JButton userLoginButton;

    public OnlineVotingSystemLogin() {
        super("Online Voting System Login");

        // Create main content panel
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        // Add some text to make the screen look appealing
        JLabel titleLabel = new JLabel("Welcome to Online Voting System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titleLabel, BorderLayout.NORTH);

        // Create panel for login buttons
        JPanel loginButtonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        loginButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));

        // Admin Login button
        adminLoginButton = new JButton("Admin Login");
        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current login window
                new AdminLoginFrame(); // Open the admin login frame
            }
        });
        loginButtonPanel.add(adminLoginButton);

        // User Login button
        userLoginButton = new JButton("User Login");
        userLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current login window
                new UserLoginFrame(); // Open the user login frame
            }
        });
        loginButtonPanel.add(userLoginButton);

        // Add login buttons panel to content pane
        contentPane.add(loginButtonPanel, BorderLayout.CENTER);

        // Set content pane
        setContentPane(contentPane);

        // Set frame properties
        setSize(400, 150);
        setLocationRelativeTo(null); // Center the frame on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OnlineVotingSystemLogin();
            }
        });
    }
}

class AdminLoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public AdminLoginFrame() {
        super("Admin Login");

        // Create main content panel
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        // Create panel for admin login components
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 1, 5, 5));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80));

        // Username field
        usernameField = new JTextField();
        usernameField.setBorder(BorderFactory.createTitledBorder("Admin Username"));
        loginPanel.add(usernameField);

        // Password field
        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder("Admin Password"));
        loginPanel.add(passwordField);

        // Login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform admin login authentication
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Call a method to authenticate admin login
                if (authenticateAdmin(username, password)) {
                    dispose();
                    new AdminHomePage();
                } else {
                    JOptionPane.showMessageDialog(AdminLoginFrame.this, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        loginPanel.add(loginButton);

        // Add admin login panel to content pane
        contentPane.add(loginPanel, BorderLayout.CENTER);

        // Set content pane
        setContentPane(contentPane);

        // Set frame properties
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private boolean authenticateAdmin(String username, String password) {
        // Add authentication logic for admin login here
        // For demonstration purposes, simply return true if username and password match
        return username.equals("admin") && password.equals("admin123");
    }
}

class UserLoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public UserLoginFrame() {
        super("User Login");

        // Create main content panel
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        // Create panel for user login components
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 1, 5, 5));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80));

        // Username field
        usernameField = new JTextField();
        usernameField.setBorder(BorderFactory.createTitledBorder("User Username"));
        loginPanel.add(usernameField);

        // Password field
        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder("User Password"));
        loginPanel.add(passwordField);

        // Login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform user login authentication
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Call a method to authenticate user login
                if (authenticateUser(username, password)) {
                    dispose();
                    new UserHomePage();
                } else {
                    JOptionPane.showMessageDialog(UserLoginFrame.this, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        loginPanel.add(loginButton);

        // Add user login panel to content pane
        contentPane.add(loginPanel, BorderLayout.CENTER);

        // Set content pane
        setContentPane(contentPane);

        // Set frame properties
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private boolean authenticateUser(String username, String password) {
        // Add authentication logic for user login here
        // For demonstration purposes, simply return true if username and password match
        return username.equals("user") && password.equals("user123");
    }
}

class AdminHomePage extends JFrame {

    public AdminHomePage() {
        super("Admin Home Page");

        // Create main content panel
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(3, 1));

        // Results button
        JButton resultsButton = new JButton("View Election Results");
        resultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to view election results
                JOptionPane.showMessageDialog(AdminHomePage.this, "Displaying Election Results");
            }
        });
        contentPane.add(resultsButton);

        // Add party button
        JButton addPartyButton = new JButton("Add Party");
        addPartyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to add a new party
                JOptionPane.showMessageDialog(AdminHomePage.this, "Adding New Party");
            }
        });
        contentPane.add(addPartyButton);

        // Voters list button
        JButton votersListButton = new JButton("View Voters List");
        votersListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to view voters list
                JOptionPane.showMessageDialog(AdminHomePage.this, "Displaying Voters List");
            }
        });
        contentPane.add(votersListButton);

        // Set content pane
        setContentPane(contentPane);

        // Set frame properties
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class UserHomePage extends JFrame {

    public UserHomePage() {
        super("User Home Page");

        // Create main content panel
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        // Add some text to make the screen look appealing
        JLabel titleLabel = new JLabel("Welcome to User Home Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titleLabel, BorderLayout.NORTH);

        // Set content pane
        setContentPane(contentPane);

        // Set frame properties
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
