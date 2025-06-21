package commission;

import java.util.Scanner;

public class commission {
    // Data members
    String name;
    String address;
    String phone;
    double salesAmount;
    
    // Method to accept details
    public void acceptDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name:");
        name = scanner.nextLine();
        System.out.println("Enter Address:");
        address = scanner.nextLine();
        System.out.println("Enter Phone:");
        phone = scanner.nextLine();
        System.out.println("Enter Sales Amount:");
        salesAmount = scanner.nextDouble();
    }
    
    // Method to calculate and display commission
    public void calculateCommission() {
        double commission = 0.0;
        if (salesAmount >= 100000) {
            commission = salesAmount * 0.10; // 10%
        } else if (salesAmount >= 50000 && salesAmount < 100000) {
            commission = salesAmount * 0.05; // 5%
        } else if (salesAmount >= 30000 && salesAmount < 50000) {
            commission = salesAmount * 0.03; // 3%
        } else {
            commission = 0.0; // No commission
        }
        System.out.println("Commission: " + commission);
    }
    
    public static void main(String[] args) {
        // Create Commission object
        commission employee = new commission();
        // Call methods
        employee.acceptDetails();
        employee.calculateCommission();
    }
}