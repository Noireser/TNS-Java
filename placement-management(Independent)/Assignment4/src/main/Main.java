package main;

import bank.BankAccount;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize a bank account with a starting balance
        System.out.println("Enter account number (integer):");
        int accountNumber;
        if (scanner.hasNextInt()) {
            accountNumber = scanner.nextInt();
        } else {
            System.out.println("Invalid account number. Please enter an integer.");
            scanner.close();
            return;
        }

        System.out.println("Enter initial balance (double, e.g., 1000 or 1000.0):");
        double initialBalance;
        if (scanner.hasNextDouble()) {
            initialBalance = scanner.nextDouble();
            if (initialBalance < 0) {
                System.out.println("Initial balance cannot be negative.");
                scanner.close();
                return;
            }
        } else {
            System.out.println("Invalid initial balance. Please enter a number.");
            scanner.close();
            return;
        }

        BankAccount account = new BankAccount(accountNumber, initialBalance);
        account.displayBalance();

        // Loop to perform banking operations
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1: Deposit");
            System.out.println("2: Withdraw");
            System.out.println("3: Display Balance");
            System.out.println("4: Exit");
            System.out.println("Enter choice (1-4):");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid choice. Please enter an integer (1-4).");
                continue;
            }

            if (choice == 4) {
                System.out.println("Exiting program.");
                break;
            }

            try {
                switch (choice) {
                    case 1: // Deposit
                        System.out.println("Enter amount to deposit (double, e.g., 500 or 500.0):");
                        double depositAmount;
                        if (scanner.hasNextDouble()) {
                            depositAmount = scanner.nextDouble();
                        } else {
                            System.out.println("Invalid deposit amount. Please enter a number.");
                            continue;
                        }
                        account.deposit(depositAmount);
                        break;

                    case 2: // Withdraw
                        System.out.println("Enter amount to withdraw (double, e.g., 200 or 200.0):");
                        double withdrawAmount;
                        if (scanner.hasNextDouble()) {
                            withdrawAmount = scanner.nextDouble();
                        } else {
                            System.out.println("Invalid withdrawal amount. Please enter a number.");
                            continue;
                        }
                        account.withdraw(withdrawAmount);
                        break;

                    case 3: // Display Balance
                        account.displayBalance();
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
                        break;
                }
            } catch (InvalidAmountException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Operation completed.");
            }
        }

        scanner.close();
    }
}