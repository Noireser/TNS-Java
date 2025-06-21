package indigo;

import airfare.Airfare;

public class Indigo implements Airfare {
    private int hours;
    private double costPerHour;

    // Default constructor
    public Indigo() {
    }

    // Parameterized constructor
    public Indigo(int hours, double costPerHour) {
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

    // Method to calculate amount (multiplied by 8)
    @Override
    public double calculateAmount() {
        return Math.round(hours * costPerHour * 8 * 100.0) / 100.0;
    }
}