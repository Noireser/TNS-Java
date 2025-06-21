package main;

import airfare.Airfare;
import airindia.AirIndia;
import kingfisher.KingFisher;
import indigo.Indigo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input specifications
        System.out.println("Enter choice (1 for AirIndia, 2 for KingFisher, 3 for Indigo):");
        int choice;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            System.out.println("Invalid choice. Please enter an integer (1, 2, or 3).");
            scanner.close();
            return;
        }

        System.out.println("Enter hours of travel (integer):");
        int hours;
        if (scanner.hasNextInt()) {
            hours = scanner.nextInt();
        } else {
            System.out.println("Invalid hours. Please enter an integer.");
            scanner.close();
            return;
        }

        System.out.println("Enter cost per hour:");
        double costPerHour;
        if (scanner.hasNextDouble()) {
            costPerHour = scanner.nextDouble();
        } else {
            System.out.println("Invalid cost per hour. Please enter a number.");
            scanner.close();
            return;
        }

        // Create appropriate object based on choice
        Airfare airfare = null;
        if (choice == 1) {
            airfare = new AirIndia(hours, costPerHour);
        } else if (choice == 2) {
            airfare = new KingFisher(hours, costPerHour);
        } else if (choice == 3) {
            airfare = new Indigo(hours, costPerHour);
        } else {
            System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            scanner.close();
            return;
        }
        
        // Calculate and display the amount
        double amount = airfare.calculateAmount();
        System.out.printf("Total amount: %.2f%n", amount);
        
        scanner.close();
    }
}