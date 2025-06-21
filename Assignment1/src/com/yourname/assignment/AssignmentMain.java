package com.yourname.assignment;

import com.yourname.assignment.employees.*;
import com.yourname.assignment.utilities.EmployeeUtilities;

/**
 * Main class to test the employee system.
 */
public class AssignmentMain {
    public static void main(String[] args) {
        Manager manager = new Manager("Alice", 1001, 90000, "Sales");
        Developer developer = new Developer("Bob", 1002, 85000, "Java");

        System.out.println("Manager Details:");
        EmployeeUtilities.printEmployeeDetails(manager);
        System.out.println("\nDeveloper Details:");
        EmployeeUtilities.printEmployeeDetails(developer);
    }
}
