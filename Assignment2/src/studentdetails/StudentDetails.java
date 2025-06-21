package studentdetails;

import java.util.Scanner;

public class StudentDetails {
    public static void main(String[] args) {
        // Create Scanner object for input
        Scanner scanner = new Scanner(System.in);
        
        // Read full name
        System.out.println("Enter Full Name with Initial:");
        String fullName = scanner.nextLine();
        
        // Read roll number
        System.out.println("Enter Roll Number:");
        String rollNumber = scanner.nextLine();
        
        // Read grade
        System.out.println("Enter Grade:");
        String grade = scanner.nextLine();
        
        // Read percentage
        System.out.println("Enter Percentage:");
        String percentage = scanner.nextLine();
        
        // Display the details
        System.out.println(fullName);
        System.out.println(rollNumber);
        System.out.println(grade);
        System.out.println(percentage);
        
        // Close scanner
        scanner.close();
    }
}