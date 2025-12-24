package GUI;

import java.awt.*;
import javax.swing.*;

public class BankAccount {
    private static double balance = 0.0;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bank Balance");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Welcome to your account");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);
        
        JPanel balancePanel = new JPanel();
        JLabel balanceLabel = new JLabel("Balance: $0.00");
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        balancePanel.add(balanceLabel);
        
        JPanel inputPanel = new JPanel();
        JLabel amountLabel = new JLabel("Amount: $");
        JTextField amountField = new JTextField(10);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
        
        JPanel statusPanel = new JPanel();
        JLabel statusLabel = new JLabel(" ");
        statusLabel.setForeground(Color.BLUE);
        statusPanel.add(statusLabel);
        
        JPanel buttonPanel = new JPanel();
        
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0) {
                    balance += amount;
                    balanceLabel.setText(String.format("Balance: $%.2f", balance));
                    statusLabel.setText(String.format("Deposited $%.2f", amount));
                    statusLabel.setForeground(Color.GREEN);
                    amountField.setText("");
                } else {
                    statusLabel.setText("Please enter positive amount");
                    statusLabel.setForeground(Color.RED);
                }
            } catch (NumberFormatException ex) {
                statusLabel.setText("Please enter a valid number");
                statusLabel.setForeground(Color.RED);
            }
        });
        
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0) {
                    if (amount <= balance) {
                        balance -= amount;
                        balanceLabel.setText(String.format("Balance: $%.2f", balance));
                        statusLabel.setText(String.format("Withdrew $%.2f", amount));
                        statusLabel.setForeground(Color.GREEN);
                        amountField.setText("");
                    } else {
                        statusLabel.setText("Insufficient funds!");
                        statusLabel.setForeground(Color.RED);
                    }
                } else {
                    statusLabel.setText("Please enter positive amount");
                    statusLabel.setForeground(Color.RED);
                }
            } catch (NumberFormatException ex) {
                statusLabel.setText("Please enter a valid number");
                statusLabel.setForeground(Color.RED);
            }
        });
        
        JButton showButton = new JButton("Show Balance");
        showButton.addActionListener(e -> {
            statusLabel.setText(String.format("Current balance: $%.2f", balance));
            statusLabel.setForeground(Color.BLUE);
        });
        
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            JLabel finalMessage = new JLabel(String.format("Final Balance: $%.2f", balance));
            finalMessage.setHorizontalAlignment(JLabel.CENTER);
            
            JPanel exitPanel = new JPanel(new BorderLayout());
            exitPanel.add(finalMessage, BorderLayout.CENTER);
            
            JFrame exitFrame = new JFrame("Thank you, Goodbye");
            exitFrame.setSize(300, 150);
            exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            exitFrame.setLocationRelativeTo(frame);
            exitFrame.add(exitPanel);
            exitFrame.setVisible(true);
            
            frame.dispose();
        });
        
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(showButton);
        buttonPanel.add(exitButton);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(titlePanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(balancePanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(statusPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(buttonPanel);
        
        frame.add(mainPanel, BorderLayout.CENTER);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JFrame initialFrame = new JFrame("Initial Balance");
        initialFrame.setSize(300, 150);
        initialFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initialFrame.setLayout(new BorderLayout());
        initialFrame.setLocationRelativeTo(frame);
        
        JPanel initialPanel = new JPanel();
        initialPanel.setLayout(new BoxLayout(initialPanel, BoxLayout.Y_AXIS));
        
        JLabel initialLabel = new JLabel("Enter initial balance:");
        initialLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextField initialField = new JTextField(10);
        initialField.setMaximumSize(new Dimension(150, 30));
        
        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel initialStatus = new JLabel(" ");
        initialStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        submitButton.addActionListener(e -> {
            try {
                balance = Double.parseDouble(initialField.getText());
                balanceLabel.setText(String.format("Balance: $%.2f", balance));
                initialFrame.dispose();
            } catch (NumberFormatException ex) {
                initialStatus.setText("Invalid number. Using $0.00");
                initialStatus.setForeground(Color.RED);
                balanceLabel.setText("Balance: $0.00");
            }
        });
        
        initialPanel.add(Box.createVerticalStrut(20));
        initialPanel.add(initialLabel);
        initialPanel.add(Box.createVerticalStrut(10));
        initialPanel.add(initialField);
        initialPanel.add(Box.createVerticalStrut(10));
        initialPanel.add(submitButton);
        initialPanel.add(Box.createVerticalStrut(5));
        initialPanel.add(initialStatus);
        
        initialFrame.add(initialPanel);
        initialFrame.setVisible(true);
    }
}