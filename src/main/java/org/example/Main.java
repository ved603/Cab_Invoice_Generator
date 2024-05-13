package org.example;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    HashMap<Integer,Generator> hm = new HashMap<>();
    public String method(int id,double [] distance,int [] time){
        try {
            hm.put(id, new Generator(distance, time));
            return "Bill Generated";
        }
        catch(Exception e){
            return "Bill not Generated";
        }
    }
    public String printmethod(int id){
        try{
            if(hm.containsKey(id)){
                System.out.println("\n\n_____________________________________________________________________\n");
                System.out.println("\t\t\t\t\t** Invoice Generator **\t\t");
                System.out.println("______________________________________________________________________");
                System.out.println("\nThe Id of the person is  " + id);
                System.out.println("Total Number of rides is " +hm.get(id).getRides());
                System.out.println("Total Fare is " + hm.get(id).getTotal());
                System.out.println("Average Fare per Ride is " + hm.get(id).getAvg());
                System.out.println("\n_______________________________________________________________________\n");

                return "Success";
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());

        }
        return "Failed";
        }

}


class Generator{

    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;

    ArrayList<Double> arr = new ArrayList<>();
    double total =0.0;
    double avg = 0.0;
    int rides = 0;

    public Generator(double[] distance, int[] time) {
        int n = Math.max(distance.length, time.length);
        for (int i = 0; i < n; i++) {
            double totalFare = calculateFare(distance[i], time[i]);
            arr.add(totalFare);
        }
        double Total=0.0;
        for (Double tot : arr) {
            Total += tot;
        }
        avg = Total / arr.size();
        setAvg(avg);
        setTotal(Total);
        setRides(n);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public void setRides(int rides) {
        this.rides = rides;
    }

    public double getTotal() {
        return total;
    }

    public double getAvg() {
        return avg;
    }

    public int getRides() {
        return rides;
    }
    public static double calculateFare(double distanceKm, int timeMinutes) {
        double fare = distanceKm * COST_PER_KM + timeMinutes * COST_PER_MINUTE;
        fare = Math.max(fare, MINIMUM_FARE);
        return fare;
    }
}