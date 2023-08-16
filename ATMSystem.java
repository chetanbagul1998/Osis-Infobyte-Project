package com.company.ATM;

import java.util.*;

class User {
    private final String userId;
    private final String userPin;

    public User(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPin() {
        return userPin;
    }
}

class Transaction {
    private final String type;
    private final double amount;
    private final String timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = generateTimestamp();
    }

    private String generateTimestamp() {
        return new Date().toString();
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Amount: " + amount + ", Timestamp: " + timestamp;
    }
}

class BankAccount {
    private double balance;
    private final List<Transaction> transactionHistory;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public double getBalance() {
        return balance;
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = new User("user123", "1234");
        BankAccount account = new BankAccount(1000.0);

        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter user PIN: ");
        String userPin = scanner.nextLine();

        if (userId.equals(user.getUserId()) && userPin.equals(user.getUserPin())) {
            System.out.println("Authentication successful. Welcome to the ATM!");
            performATMOperations(scanner, account);
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    public static void performATMOperations(Scanner scanner, BankAccount account) {
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    List<Transaction> transactions = account.getTransactionHistory();
                    System.out.println("\nTransaction History:");
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction);
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



