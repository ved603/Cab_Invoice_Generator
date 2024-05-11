package org.example;

import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter How Many Rides : ");
        int n = sc.nextInt();
        double total = 0.0;
        for(int i=0;i<n;i++) {
            System.out.print("Enter distance for ride " +i+ "  : ");
            double distance = sc.nextDouble();
            System.out.print("Enter Time for ride " +i+" : ");
            int time = sc.nextInt();
            double totalFare = calculateFare(distance, time);
            total += totalFare;
        }
        System.out.println("Total fare of "+n+" rides is : Rs " + total);

    }
}