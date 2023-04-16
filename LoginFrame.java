import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {
    private JLabel userLabel;
    private JTextField userText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JButton exitButton;
    private JButton withdrawButton;
    private JButton depositButton;
    private JLabel balanceLabel;
    private double balance;

    public LoginFrame() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        userLabel = new JLabel("Username");
        userText = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordText = new JPasswordField();
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit");
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        balanceLabel = new JLabel("Balance: $0.00");

        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        depositButton.addActionListener(this);
        withdrawButton.setEnabled(false);
        depositButton.setEnabled(false);

        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(new JLabel(""));
        panel.add(loginButton);
        panel.add(new JLabel(""));
        panel.add(exitButton);
        panel.add(new JLabel(""));
        panel.add(withdrawButton);
        panel.add(new JLabel(""));
        panel.add(depositButton);
        panel.add(new JLabel(""));
        panel.add(balanceLabel);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            if (username.equals("admin") && password.equals("admin123")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                balance = 1000.00;
                balanceLabel.setText("Balance: $" + String.format("%.2f", balance));
                withdrawButton.setEnabled(true);
                depositButton.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == withdrawButton) {
            String amountString = JOptionPane.showInputDialog(this, "Enter Amount to Withdraw:");
            double amount = Double.parseDouble(amountString);
            if (amount > balance) {
                JOptionPane.showMessageDialog(this, "Insufficient Funds");
            } else {
                balance -= amount;
                balanceLabel.setText("Balance: $" + String.format("%.2f", balance));
            }
        } else if (e.getSource() == depositButton) {
            String amountString = JOptionPane.showInputDialog(this, "Enter Amount to Deposit:");
            double amount = Double.parseDouble(amountString);
            balance += amount;
            balanceLabel.setText("Balance: $" + String.format("%.2f", balance));
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}