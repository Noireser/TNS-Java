package com.yourname.assignment.utilities;

import com.yourname.assignment.employees.*;

/**
 * Utility class for employee-related operations.
 */
public class EmployeeUtilities {

    public static void printEmployeeDetails(Employee e) {
        System.out.println("Name: " + e.getName());
        System.out.println("Employee ID: " + e.getEmployeeId());
        System.out.println("Salary: $" + e.getSalary());

        if (e instanceof Manager) {
            System.out.println("Department: " + ((Manager) e).getDepartment());
        } else if (e instanceof Developer) {
            System.out.println("Programming Language: " + ((Developer) e).getProgrammingLanguage());
        }
    }
}
