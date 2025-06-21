package bank;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

public class BankAccount {
    private int accountNumber;
    private double balance;

    // Parameterized constructor to initialize account number and balance
    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit an amount into the account
    // Throws InvalidAmountException if the amount is negative or zero
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive: " + amount);
        }
        balance += amount;
        System.out.println("Successfully deposited $" + amount);
    }

    // Method to withdraw an amount from the account
    // Throws InvalidAmountException if the amount is negative or zero
    // Throws InsufficientFundsException if the balance is insufficient
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive: " + amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal: " + amount + ", Current balance: " + balance);
        }
        balance -= amount;
        System.out.println("Successfully withdrew $" + amount);
    }

    // Method to display the current balance of the account
    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + String.format("%.2f", balance));
    }

    // Getter for balance (used in Main for validation)
    public double getBalance() {
        return balance;
    }
}