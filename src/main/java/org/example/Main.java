package org.example;

public class Main {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;
    public static double calculateFare(double distanceKm, int timeMinutes) {
        double fare = distanceKm * COST_PER_KM + timeMinutes * COST_PER_MINUTE;
        fare = Math.max(fare, MINIMUM_FARE);
        return fare;
    }
    public static void main(String[] args) {
        double distance = 0.5;
        int time = 1;
        double totalFare = calculateFare(distance, time);
        System.out.println("Total fare: Rs " + totalFare);
    }
}
