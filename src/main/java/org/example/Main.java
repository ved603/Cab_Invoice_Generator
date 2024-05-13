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
                System.out.println("\nTotal Number of rides is " +hm.get(id).getRides());
                System.out.println("Total Fare for Premium Rides is " + hm.get(id).getnormalTotal());
                System.out.println("Average Fare for Premium per Ride is " + hm.get(id).getnormalAvg());

                System.out.println("\nTotal Number of rides is " +hm.get(id).getRides());
                System.out.println("Total Fare for Normal Rides is " + hm.get(id).getPremium_total());
                System.out.println("Average Fare for Normal per Ride is " + hm.get(id).getPremium_avg());
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

    private static final int COST_PER_KM_pre = 15;
    private static final int COST_PER_MINUTE_pre = 2;
    private static final int MINIMUM_FARE_pre = 20;

    ArrayList<Double> arr = new ArrayList<>();
    ArrayList<Double> pre_arr = new ArrayList<>();
    double normal_total =0.0;
    double normal_avg = 0.0;

    double premium_total = 0.0;
    double premium_avg = 0.0;
    int rides = 0;

    public Generator(double[] distance, int[] time) {
        int n = Math.max(distance.length, time.length);
        for (int i = 0; i < n; i++) {
            double totalFare = calculateFareNormal(distance[i], time[i]);
            arr.add(totalFare);
        }
        double Total=0.0;
        for (Double tot : arr) {
            Total += tot;
        }
        normal_avg = Total / arr.size();
        setnormalAvg(normal_avg);
        setnormalTotal(Total);
        setRides(n);



        for (int i = 0; i < n; i++) {
            double totalFare = calculateFarePremium(distance[i], time[i]);
            pre_arr.add(totalFare);
        }
        double total_pre = 0.0;
        for (Double tot : pre_arr) {
           total_pre = tot;
        }
        premium_avg = total_pre / pre_arr.size();
        setPremium_avg(premium_avg);
        setPremium_total(total_pre);
    }

    public void setnormalTotal(double total) {
        this.normal_total = total;
    }

    public void setnormalAvg(double avg) {
        this.normal_avg = avg;
    }

    public void setRides(int rides) {
        this.rides = rides;
    }

    public void setPremium_avg(double avg){
        this.premium_avg = avg;
    }
    public void setPremium_total(double total){
        this.premium_total = total;
    }
    public double getnormalTotal() {
        return normal_total;
    }

    public double getnormalAvg() {
        return normal_avg;
    }

    public double getPremium_total(){
        return premium_total;
    }

    public double getPremium_avg(){
        return premium_avg;
    }
    public int getRides() {
        return rides;
    }
    public static double calculateFareNormal(double distanceKm, int timeMinutes) {
        double fare = distanceKm * COST_PER_KM + timeMinutes * COST_PER_MINUTE;
        fare = Math.max(fare, MINIMUM_FARE);
        return fare;
    }

    public static double calculateFarePremium(double distanceKm, int timeMinutes) {
        double fare = distanceKm * COST_PER_KM_pre + timeMinutes * COST_PER_MINUTE_pre;
        fare = Math.max(fare, MINIMUM_FARE_pre);
        return fare;
    }

}