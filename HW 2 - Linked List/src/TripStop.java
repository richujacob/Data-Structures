/**
 * Richu Jacob
 * ID:110257792
 * Homework #2
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
public class TripStop {
    /**
     * Declares Strings location and activity,
     * declares int distance.
     */
    private String location;
    private int distance;
    private String activity;

    /**
     * Empty constructor.
     */
    public TripStop(){

    }

    /**
     *Location holds location of a tripstop node,
     * distance holds distance of a tripstop node,
     * activity holds activty of a tirpstop node.
     * @param location used to set instance of location.
     * @param distance used to set instance of distance.
     * @param activity used to set instance of activity.
     */
    public TripStop(String location, int distance, String activity){
        this.location=location;
        this.distance=distance;
        this.activity=activity;
    }

    /**
     * Sets the location of a tripstop location.
     * @param location sets the location using instance of location.
     */
    public void setLocation(String location){
        this.location=location;
    }

    /**
     * Sets the distance of a tripstop distance.
     * @param distance sets the distance using instance of distance.
     * @throws IllegalArgumentException if distance is changed to a negative.
     */
    public void setDistance(int distance)throws IllegalArgumentException{
        if(distance<0){
            throw new IllegalArgumentException();
        }else{
            this.distance=distance;
        }
    }

    /**
     * Sets the activity of a tripstop activity.
     * @param activity sets the activity using the instance of acitivty.
     */
    public void setActivity(String activity){
        this.activity=activity;
    }

    /**
     * Gets location and returns it.
     * @return location
     */
    public String getLocation(){
        return location;
    }

    /**
     * Gets distance and returns it.
     * @return distance
     */
    public int getDistance(){
        return distance;
    }

    /**
     * Gets activity and returns it.
     * @return activity
     */
    public String getActivity(){
        return activity;
    }

    /**
     * Returns a description of the tripStop.
     * @return tripStop
     */
    public String toString(){
        String tripStop="";
        tripStop = tripStop + getLocation() + getDistance() + getActivity();
        return tripStop;
    }

    /**
     *Copies each tripstopnode by using the instances of tripstop
     * and returns the TripStop copy.
     * @return copy
     */
    public TripStop clone(){
        TripStop copy = new TripStop(this.location, this.distance, this.activity);
        return copy;
    }




}
