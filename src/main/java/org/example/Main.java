package org.example;
import java.util.ArrayList;

public class Main {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;

    ArrayList<Double> arr = new ArrayList<>();
    double avg;
    int Total;
    public static double calculateFare(double distanceKm, int timeMinutes) {
        double fare = distanceKm * COST_PER_KM + timeMinutes * COST_PER_MINUTE;
        fare = Math.max(fare, MINIMUM_FARE);
        return fare;
    }
    public String Invoice(double [] distance, int [] time){
        int n = Math.max(distance.length, time.length);
        for(int i=0;i<n;i++) {
            if(distance[i] == 0 || time[i] == 0){
                return "Failed";
            }
            double totalFare = calculateFare(distance[i], time[i]);
            arr.add(totalFare);
        }
        for (Double tot : arr) {
            Total += tot;
        }

        avg = (double) Total/arr.size();

        System.out.println("\n\n_____________________________________________________________________\n");
        System.out.println("\t\t\t\t\t** Invoice Generator **\t\t");
        System.out.println("______________________________________________________________________");
        System.out.println("\nTotal Number of rides is " +n);
        System.out.println("Total Fare is " +Total);
        System.out.println("Average Fare per Ride is " +avg);
        System.out.println("\n_______________________________________________________________________\n");

        return "Success";
    }
}