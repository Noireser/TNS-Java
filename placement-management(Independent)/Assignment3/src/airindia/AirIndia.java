package airindia;

import airfare.Airfare;

public class AirIndia implements Airfare {
    private int hours;
    private double costPerHour;

    // Default constructor
    public AirIndia() {
    }

    // Parameterized constructor
    public AirIndia(int hours, double costPerHour) {
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    // Getters and setters
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    // Method to calculate amount
    @Override
    public double calculateAmount() {
        return Math.round(hours * costPerHour * 100.0) / 100.0;
    }
}