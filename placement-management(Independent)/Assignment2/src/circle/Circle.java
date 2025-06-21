package circle;

import java.util.Scanner;

public class Circle {
    // Data members
    double radius;
    String colour;
    
    // Method to accept details
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Radius:");
        radius = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        System.out.println("Enter Colour:");
        colour = scanner.nextLine();
    }
    
    // Method to calculate and display area
    public void calcArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
    
    public static void main(String[] args) {
        // Create Circle object
        Circle circle = new Circle();
        // Call methods
        circle.getInput();
        circle.calcArea();
    }
}