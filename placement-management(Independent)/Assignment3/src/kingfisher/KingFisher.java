package kingfisher;

import airfare.Airfare;

public class KingFisher implements Airfare {
    private int hours;
    private double costPerHour;

    // Default constructor
    public KingFisher() {
    }

    // Parameterized constructor
    public KingFisher(int hours, double costPerHour) {
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

    // Method to calculate amount (multiplied by 4)
    @Override
    public double calculateAmount() {
        return Math.round(hours * costPerHour * 4 * 100.0) / 100.0;
    }
}