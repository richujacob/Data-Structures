/**
 * Richu Jacob
 * ID:110257792
 * Homework #4
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
import java.util.Scanner;

public class DownloadManager {
    public static void main(String [] args){

        Scanner s = new Scanner(System.in);
        DownloadScheduler print = new DownloadScheduler();
        //boolean done=true;

        System.out.println("Hello and welcome to the Download Scheduler.");
        System.out.println("Please enter a number of servers: ");
        int server = s.nextInt();
        print.setCurrentJobSize(server);
        System.out.println("Please enter a download speed :");
        int download = s.nextInt();
        print.setDownloadSpeed(download);
        System.out.println("Please enter a length of time: ");
        int length = s.nextInt();
        print.setSimulationEndTime(length);
        while(true) {
            System.out.println("Please enter a probability of new premium job per timestep: ");
            double premiumProb = s.nextDouble();
            if (premiumProb >= 0 && premiumProb <= 1) {
                print.setPremium(premiumProb);
                break;
            }
            System.out.println("The probability has to be between 0 and 1");
        }
        while(true) {
            System.out.println("Please enter a probability of new regular job per timestep: ");
           double regularProb = s.nextDouble();
           if(regularProb >= 0 && regularProb <= 1){
               print.setRegular(regularProb);
               break;
           }
            System.out.println("The probability has to be between 0 and 1");
        }

        System.out.println("--------------------------Simulation Starting--------------------------");
        try {
           System.out.println(print.simulate());
       }catch(EmptyQueueException e){
           System.out.println("Queue is empty");
       }

       System.out.println("------------------Thank you for running the simulator-------------------");

    }
}
