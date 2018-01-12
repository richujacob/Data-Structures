/**
 * Created by Richu on 11/11/2016.
 */
import java.io.Serializable;

public class Classroom implements Serializable{
    /**
     * hasWhiteboard is true if the classroom has a whiteboard, false otherwise.
     * hasChalkboard is true if the classroom has a chalkboard, false otherwise.
     * numSeats holds the number of seats the classroom has.
     * AVEquimpmentList holds the names of the AV Equipment that are supported in the room.
     */
    private boolean hasWhiteboard;
    private boolean hasChalkboard;
    private int numSeats;
    private String[] AVEquipmentList;

    /**
     * default constructor
     */
    public Classroom(){

    }

    /**
     * constructor that sets the values for these parameters
     * @param hasWhiteboard
     * @param hasChalkboard
     * @param numSeats
     * @param AVEquipmentList
     */
    public Classroom(boolean hasWhiteboard, boolean hasChalkboard,
                     int numSeats, String [] AVEquipmentList){
        this.hasWhiteboard=hasWhiteboard;
        this.hasChalkboard=hasChalkboard;
        this.numSeats=numSeats;
        this.AVEquipmentList=AVEquipmentList;

    }

    /**
     * gets thehasWhiteboard data variable
     * @return true or false depending on whether the room as a whiteboard
     */
    public boolean getHasWhiteboard() {
        if(hasWhiteboard==true) {
            //System.out.println("Has whiteboard");
            return hasWhiteboard;
        }else{
            //System.out.println("Doesn't have whiteboard");
            return hasWhiteboard;
        }
    }

    /**
     * sets whether there is a whiteboard depending on param value
     * @param hasWhiteboard is true or false
     */
    public void setHasWhiteboard(boolean hasWhiteboard) {
        this.hasWhiteboard = hasWhiteboard;
    }

    /**
     * gets thehasChalkboard data variable
     * @return true or false depending on whether the room as a chalkboard
     * @return
     */
    public boolean getHasChalkboard() {
        if(hasChalkboard==true) {
            //System.out.println("Has chalkboard");
            return hasChalkboard;
        }else{
            //System.out.println("Doesn't have chalkboard");
            return hasChalkboard;
        }
    }

    /**
     * sets whether there is a chalkboard depending on param value
     * @param hasChalkboard is true or false
     */
    public void setHasChalkboard(boolean hasChalkboard) {
        this.hasChalkboard = hasChalkboard;
    }

    /**
     * gets the number of seats
     * @return the number of seats
     */
    public int getNumSeats() {
        return numSeats;
    }

    /**
     * sets the num of seats depending on param value
     * @param numSeats sets value of seats
     */
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    /**
     * gets the list of equipment
     * @return the list containing equipments
     */
    public String[] getAVEquipmentList() {
        return AVEquipmentList;
    }

    /**
     * sets the equiptment list of the class
     * @param AVEquipmentList used to set the equipment
     */
    public void setAVEquipmentList(String[] AVEquipmentList) {
        this.AVEquipmentList = AVEquipmentList;
    }
}
