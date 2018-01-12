/**
 * Richu Jacob
 * ID:110257792
 * Homework #2
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
public class TripStopNode {
    /**
     * Declares TripStop data,
     * declares TripStopNode next and prev.
     */
    private TripStop data;
    private TripStopNode next;
    private TripStopNode prev;

    /**
     *Initialize data, prev and null.
     * @param initData is set to data if initial isn't null.
     * Precondition: initData is not null.
     * Postcondition: This TripStopNode has been initialized to wrap the
     * indicated TripStop, and prev and next have been set to null.
     * @throws IllegalArgumentException if initData is null.
     */
    public TripStopNode(TripStop initData)throws IllegalArgumentException{
        if(initData==null){
            throw new IllegalArgumentException();
        }else{
            data=initData;
            prev=null;
            next=null;
        }
    }

    /**
     * Gets the data and returns it.
     * @return data
     */
    public TripStop getData(){
        return data;
    }

    /**
     * Sets the data to newdata.
     * @param newData is used to set to newdata.
     * Precondition: NewData is not null.
     * @throws IllegalArgumentException throws an exception if newData is null.
     */
    public void setData(TripStop newData)throws IllegalArgumentException{
        if(newData==null){
            throw new IllegalArgumentException();
        }else{
            data=newData;
        }
    }

    /**
     * Returns the reference to the next member variable of the list node.
     * Can be null, means there's no next TripStopNode.
     * @return next
     */
    public TripStopNode getNext(){
        return next;
    }

    /**
     * Updates the next member variable with a new TripStopNode reference.
     * @param newNext eferences to a new TripStopNode object
     * to update the next member variable.
     */
    public void setNext(TripStopNode newNext){
        next=newNext;
    }

    /**
     * Gets the reference to the prev member variable of the list node.
     * @return prev
     */
    public TripStopNode getPrev(){
        return prev;
    }

    /**
     * Updates the prev member variable with a new TripStopNode reference.
     * @param newPrev references to a new TripStopNode object
     * to update the prev member variable.
     */
    public void setPrev(TripStopNode newPrev){
        prev=newPrev;
    }
}
