/**
 * Richu Jacob
 * ID:110257792
 * Homework #7
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */

public class Actor {
    /**
     * Field that holds the name of the Actor
     * Field that represents the number of movies this actor is in.
     */
    private String name;
    private int count;

    /**
     * default constructor with count set to 0
     */
    public Actor(){
        count=0;
    }

    /**
     * Overloaded constructor for creating a new Actor object with the specified name.
     * @param name the specified name
     */
    public Actor(String name){
        this.name=name;
    }

    /**
     * gets the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name to param
     * @param name used to set the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the count
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * sets the count to param
     * @param count used to set the count
     */
    public void setCount(int count) {
        this.count = count;
    }
}
