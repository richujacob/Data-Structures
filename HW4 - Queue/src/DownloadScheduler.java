/**
 * Richu Jacob
 * ID:110257792
 * Homework #4
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
public class DownloadScheduler {
    /**
     * declares downloadQueues regularQ and premiumQ
     * declares int currentTime, simulationend time and download speed
     * declares download randomizer object random
     * declares donwload job array current jobs
     */
    private DownloadQueue regularQ;
    private DownloadQueue premiumQ;
    private int currentTime;
    private int simulationEndTime;
    private DownloadRandomizer random;
    private DownloadJob []  CurrentJobs;
    private int downloadSpeed;

    /**
     * gets the premium object
     * @return the premium object
     */
    public double getPremium() {
        return premium;
    }

    /**
     * sets the premium object
     * @param premium set as the new premium
     */
    public void setPremium(double premium) {
        this.premium = premium;
    }

    /**
     * sets the regular object
     * @return the regular object
     */
    public double getRegular() {
        return regular;
    }

    /**
     * sets the regular object
     * @param regular set as the new regular
     */
    public void setRegular(double regular) {
        this.regular = regular;
    }

    /**
     * declares a double premium and regular(for probability)
     */
    private double premium;
    private double regular;

    /**
     * an empty constructor
     */
    public DownloadScheduler(){

    }

    /**
     * gets the regular Queue
     * @return the regular queue
     */
    public DownloadQueue getRegularQ() {
        return regularQ;
    }

    /**
     * sets the regular queue
     * @param regularQ set as the new regular queue
     */
    public void setRegularQ(DownloadQueue regularQ) {
        this.regularQ = regularQ;
    }

    /**
     * gets the premium queue
     * @return the premium Queue
     */
    public DownloadQueue getPremiumQ() {
        return premiumQ;
    }

    /**
     * sets the premium queue
     * @param premiumQ set as the new premium queue
     */
    public void setPremiumQ(DownloadQueue premiumQ) {
        this.premiumQ = premiumQ;
    }

    /**
     * gets the current time
     * @return the current time
     */
    public int getCurrentTime() {
        return currentTime;
    }

    /**
     * sets the current time
     * @param currentTime is set as the new currentTime
     */
    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * gets the simulation end time
     * @return the simulation end time
     */
    public int getSimulationEndTime() {
        return simulationEndTime;
    }

    /**
     * sets the simulation ent time
     * @param simulationEndTime set as the new simulaiton end time
     */
    public void setSimulationEndTime(int simulationEndTime) {
        this.simulationEndTime = simulationEndTime;
    }

    /**
     * gets a random object
     * @return returns a random object
     */
    public DownloadRandomizer getRandom() {
        return random;
    }

    /**
     * sets the random ogject to parameter
     * @param random set as the new random
     */
    public void setRandom(DownloadRandomizer random) {
        this.random = random;
    }

    /**
     * sets the current size of jobs
     * @param size sest as the new current size if jobs
     */
    public void setCurrentJobSize(int size) {

        CurrentJobs = new DownloadJob[size];
    }

    /**
     * gets the download speed
     * @return the download speed
     */
    public int getDownloadSpeed() {
        return downloadSpeed;
    }

    /**
     * sets the download speed to parameter
     * @param downloadSpeed set as the new download speed
     */
    public void setDownloadSpeed(int downloadSpeed) {
        this.downloadSpeed = downloadSpeed;
    }

    /**
     * checks whether the new job is regular or premium
     * adds the premium first if there is one to a server
     * if servers are full then premium and regular objects are added corresponding queue
     * if one of the jobs finishes and server empties then a premium object from
     * the queue is added before the object from the regular queue
     * but if there is nothing the queues and server is open then the new job object
     * is added and premium is added first if there is one
     * @return the String that has each individual time step, summary at each timestep
     * if a job finishes and the summary at the end of the simulation
     * @throws EmptyQueueException if the queue is empty
     */
    public String simulate () throws EmptyQueueException {
        /*
        Average Premium Wait Time: 5
        Average Regular Wait Time: 8
        */

        random= new DownloadRandomizer(premium, regular);

        String nullServer="";
        int jobID=1;
        int totalJobs=0;
        int premiumJobs=0;
        int regularJobs=0;
        int dataServed=0;
        int premiumData=0;
        int regularData=0;

        int avgPremiumTime=0;
        int avgRegularTime=0;
        int totalTimePre=0;
        int totalTimeReg=0;

        /*New Regular Job: Job#1: Size: 150Mb
        New Premium Job: n/a
        RegularQueue:empty
        PremiumQueue:empty
        Server 1*/

        String timeStepSummary="";
        String regularJob="";
        String premiumJob="";
        String regularQueue="";
        String premiumQueue="";
        String server="";
        String timeStop="";
        String timetitle="";

        DownloadQueue premium = new DownloadQueue();
        DownloadQueue regular = new DownloadQueue();
        DownloadQueue summary = new DownloadQueue();
        for (int i = 0; i <= simulationEndTime; i++) {


            for(int k=0; k<CurrentJobs.length; k++){
                if (CurrentJobs[k]!=null) {
                    CurrentJobs[k].setDownloadSizeRemaining(CurrentJobs[k].getDownloadSizeRemaining() - downloadSpeed);
                    if(CurrentJobs[k].getDownloadSizeRemaining()<=0){
                        summary.enqueue(CurrentJobs[k]);

                        if(CurrentJobs[k].isPremium()){
                            totalJobs+=1;
                            premiumJobs+=1;
                            //dataServed+=CurrentJobs[k].getDownloadSize();
                            premiumData+=CurrentJobs[k].getDownloadSize();
                            avgPremiumTime=i-CurrentJobs[k].getTimeRequested();
                            totalTimePre+=avgPremiumTime;
                            timeStepSummary+= "Job " + CurrentJobs[k].getId() + " finished, Premium job. "
                                    + CurrentJobs[k].getDownloadSize() + "Mb served , Total wait time: " +
                                    avgPremiumTime + "\n\n";


                        }else {
                            totalJobs+=1;
                            regularJobs+=1;
                            //dataServed+=CurrentJobs[k].getDownloadSize();
                            regularData+=CurrentJobs[k].getDownloadSize();
                            avgRegularTime=i-CurrentJobs[k].getTimeRequested();
                            totalTimeReg+=avgRegularTime;
                            timeStepSummary+= "Job " + CurrentJobs[k].getId() + " finished, Regular job."
                                    + CurrentJobs[k].getDownloadSize() + "Mb served, Total wait time: "
                                    + avgRegularTime + "\n\n";
                        }
                        CurrentJobs[k]=null;
                    }
                }
            }
            int premiumSize = random.getPremium();
            if (premiumSize != -1) {

                DownloadJob add = new DownloadJob(premiumSize, premiumSize,
                        i, true, jobID);
                jobID++;
                premiumJob = " New Premium Job: Job#" + add.getId() + ":" + "Size: " + premiumSize;

                for (int j = 0; j < CurrentJobs.length; j++) {
                    if (CurrentJobs[j] == null) {
                        if(premium.isEmpty()) {
                            CurrentJobs[j] = add;
                            //server = "Server " + j + ":" +  "[#" + add.getId() + " " +
                            //add.getDownloadSize()+ "MB, " +
                            //add.getDownloadSizeRemaining() +  " remaining, Request Time: " + i +
                            //"," + "Premium]\n";
                            break;
                        }
                            else{
                               CurrentJobs[j]=premium.dequeue();
                            }
                    }else if (j==CurrentJobs.length-1) {
                        premium.enqueue(add);
                        dataServed += CurrentJobs[j].getDownloadSize();
                        premiumQueue+= " [#" + add.getId() + ":" + premiumSize+"]";
                    }else {

                    }
                }
            }
                 else {
                premiumJob = " New Premium Job: n/a";
                premiumQueue = " empty";


            }
            int regularSize = random.getRegular();
            if(regularSize !=-1){


                DownloadJob add2 = new DownloadJob(regularSize, regularSize,
                        i, false, jobID);
                jobID++;
                regularJob=" New Regular Job: Job#"+add2.getId() + ":" + "Size: " + regularSize;

                for(int j=0; j< CurrentJobs.length; j++){
                    if(CurrentJobs[j]==null){
                        if(regular.isEmpty()) {
                            CurrentJobs[j] = add2;
                            //server = "Server " + j + ":" + "[#" + add2.getId() + ":"+ add2.getDownloadSize()+ "MB, " +
                            //add2.getDownloadSizeRemaining() +  "MB remaining, Request Time: " + i +
                            //"," + "Regular]\n";
                            break;
                        }else{
                            CurrentJobs[j]=regular.dequeue();
                        }
                    }else if(j==CurrentJobs.length-1){
                        regular.enqueue(add2);
                        dataServed+=CurrentJobs[j].getDownloadSize();
                        regularQueue+=" [#" + add2.getId()+ ":" + regularSize+"]";

                    }else{

                    }
                }

            }else{
                regularJob = " New Regular Job: n/a";
                regularQueue = " empty";


            }


            for(int l=0; l<CurrentJobs.length; l++){
                if(CurrentJobs[l]==null){
                    nullServer  += "\n\t Server " + (l+1) + ": Empty";
                }else {
                    nullServer += "\n\t Server " + (l + 1) + ":"
                            + "[#" + CurrentJobs[l].getId() + ":" + CurrentJobs[l].getDownloadSize() + "MB total, " +
                            CurrentJobs[l].getDownloadSizeRemaining() + "MB remaining, Request Time: " +
                            CurrentJobs[l].getTimeRequested() + ",";
                    if (CurrentJobs[l].isPremium()) {
                        nullServer += "Premium]";
                    } else {
                        nullServer += "Regular]";
                    }
                }
            }//queue finishjobs


            timeStop += " TimeStep " + i + ":\n" + "\t" + regularJob + "\n" + "\t" + premiumJob + "\n" + "\t" +
                    " RegularQueue: "+ regularQueue + "\n" + "\t" + " PremiumQueue:" +
                    premiumQueue + "\t" + nullServer + "\n\n" + timeStepSummary ;

            nullServer="";

            timeStepSummary="";



        }
        int avgPre = 0;
        int avgReg = 0;
        try {
            avgPre = totalTimePre / premiumJobs;
        }
        catch(ArithmeticException e){
            avgPre = 0;
        }
        try {
            avgReg = totalTimeReg / regularJobs;
        }
        catch(ArithmeticException e){
            avgReg = 0;
        }
        String simulation="";
        int totalData= premiumData+regularData;
        simulation += "Simulation Ended: \n \tTotal Jobs served: " + totalJobs + "\n \tTotal Premium Jobs Served: "
                + premiumJobs + "\n \tTotal Regular Jobs Served: " +
                regularJobs + "\n \tTotal Data Served: " + totalData + "Mb" + "\n \tTotal Premium Data Served: " +
                premiumData + "Mb" +  "\n \tTotal Regular Data Served: " + regularData + "Mb" +
                " \n\tAverage Premium Wait Time: " + avgPre + " \n\tAverage Regular Wait Time: " + avgReg +
                "\n";
        return timeStop+simulation;




    }

}
