/**
 * Richu Jacob
 * ID:110257792
 * Homework #2
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
public class Itinerary {
    /**
     * Declares tripstopnode for head, tail and cursor.
     * Declares int for size and totaldistance.
     */
    private TripStopNode head;
    private TripStopNode tail;
    private TripStopNode cursor;
    private int size;
    private int totaldistance;

    /**
     * initializes an empty constructor with no elements,
     * head, tail, and cursor are set to null.
     */
    public Itinerary(){
        head=null;
        tail=null;
        cursor=null;
        size=0;
        totaldistance=0;
    }

    /**
     * Sets head using the instance for head.
     * @param head is used the set the head
     */
    public void setHead(TripStopNode head){
        this.head=head;
    }

    /**
     * Sets the tail using the instance for tail.
     * @param tail is used the set the tail.
     */
    public void setTail(TripStopNode tail){
        this.tail=tail;
    }

    /**
     * Sets the cursor using the instance for cursor.
     * @param cursor is used the set the cursor.
     */
    public void setCursor(TripStopNode cursor){
        this.cursor=cursor;
    }

    /**
     * Sets the size using the instance for size.
     * @param size is used the set the size.
     */
    public void setSize(int size){
        this.size=size;
    }

    /**
     * Sets the total distance using the distance.
     * @param totaldistance is used to set the total distance.
     */
    public void setTotaldistance(int totaldistance){
        this.totaldistance=totaldistance;
    }

    /**
     * Gets the cursor.
     * @return the cursor.
     */
    public TripStopNode getCursor(){
        return cursor;
    }

    /**
     * Returns the total number of TripStopNodes in the Itinerary.
     * @return size which is added or subtracted in other methods
     */
    public int getStopsCount(){
        return size;
    }

    /**
     * Returns the sum of distances over all TripStopNodes.
     * @return the total distance which is added or subtracted in other methods.
     */
    public int getTotalDistance(){
        if(totaldistance<0){
            return totaldistance;
        }
        return totaldistance;
    }

    /**
     * Returns a reference to the TripStop
     * wrapped by the TripStopNode that cursor points to.
     * @return reference to data.
     */
    public TripStop getCursorStop(){
        if(cursor.getData()==null){
            return null;
        }else{
           return cursor.getData();
        }
    }

    /**
     * Returns the cursor to the start of the list.
     * Postconditions:
     * If head is not null, the cursor now references the first TripStopNode in this list.
     * If head is null, the cursor is set to null as well.
     */
    public void resetCursorToHead(){
        if(head==null){
            cursor=null;
        }else{
            cursor=head;
        }
    }

    /**
     * Returns the cursor to the end of the list.
     * Postconditions:
     * If tail is not null, the cursor now references the last TripStopNode in this list.
     * If tail is null, the cursor is set to null as well.
     */
   public void resetCursorToTail(){
       if(tail==null){
           cursor=null;
       }else{
           cursor=tail;
       }
   }

    /**
     * Moves the cursor to select the next TripStopNode in this list.
     * @throws EndOfItineraryException If cursor == tail, throw an exception.
     * @throws NullPointerException if cursor == null, throw an exception.
     */
    public void cursorForward()throws EndOfItineraryException, NullPointerException{
        if(cursor==tail){
            throw new EndOfItineraryException();
        }else if(cursor==null){
            throw new NullPointerException();
        }else{
            cursor=cursor.getNext();
        }
    }

    /**
     * Moves the cursor to select the previous TripStopNode in this list.
     * @throws EndOfItineraryException If cursor == head, throw this exception.
     * @throws NullPointerException If cursor == null, throw this exception.
     */
    public void cursorBackward()throws EndOfItineraryException, NullPointerException{
        if(cursor==head){
            throw new EndOfItineraryException();
        }else if(cursor==null){
            throw new NullPointerException();
        }else{
            cursor=cursor.getPrev();
        }
    }

    /**
     * Inserts the indicated TripStop before the cursor.
     * @param newStop TripStop object to be wrapped and
     * inserted into the list before the cursor.
     * Preconditions: newStop is not null.
     * Postconditions: newStop has been wrapped in a new TripStopNode object
     * If cursor was previously not null, the newly created TripStopNode
     * has been inserted into the list before the cursor.
     * If cursor was previously null, the newly created TripStopNode
     * has been set as the new head of the list.
     * The cursor now references the newly created TripStopNode .
     * @throws IllegalArgumentException Thrown if newStop is null.
     */
    public void insertBeforeCursor(TripStop newStop)throws IllegalArgumentException{
        TripStopNode nextStop1 = new TripStopNode(newStop);

        if(newStop==null){
            throw new IllegalArgumentException();
        }else if(cursor==null){
            cursor=nextStop1;
            head=nextStop1;
            tail=nextStop1;

            size++;
            totaldistance+=nextStop1.getData().getDistance();

        }else if(cursor==head){
            nextStop1.setNext(cursor);
            cursor.setPrev(nextStop1);
            head=nextStop1;
            cursor=nextStop1;
            size++;
            nextStop1.getData().getDistance();
            totaldistance+=nextStop1.getData().getDistance();
        }else{
            TripStopNode holder = new TripStopNode(newStop);
            holder = cursor.getPrev();
            nextStop1.setNext(cursor);
            nextStop1.setPrev(cursor.getPrev());
            cursor.setPrev(nextStop1);
            holder.setNext(nextStop1);
            cursor=nextStop1;
            size++;
            totaldistance+=nextStop1.getData().getDistance();
        }
    }


    /**
     * Inserts the indicated TripStop after the tail of the list.
     * @param newStop The TripStop object to be wrapped
     * and inserted into the list after the tail of the list.
     * Preconditions: newStop is not null.
     * Postconditions: newStop has been wrapped in a new TripStopNode object.
     * If tail was previously not null, the newly created TripStopNode
     * has been inserted into the list after the tail.
     * If tail was previously null, the newly created TripStopNode has
     * been set as the new head of the list.
     * The tail now references the newly created TripStopNode..
     * @throws IllegalArgumentException Thrown if newStop is null.
     */
    public void appendToTail(TripStop newStop)throws IllegalArgumentException{
        TripStopNode append = new TripStopNode(newStop);
        TripStopNode pointer=cursor;
        if(newStop==null){
            throw new IllegalArgumentException();
        }else if(tail==null){
            head=append;
            tail=append;
            cursor=append;
            size++;
            totaldistance+=append.getData().getDistance();
        }else{
            cursor=tail;
            cursor.setNext(append);
            append.setPrev(cursor);
            tail=append;
            cursor=pointer;
            totaldistance+=append.getData().getDistance();
            size++;
        }
    }

    /**
     * Removes the TripStopNode referenced by cursor and returns the TripStop inside.
     * PreConditions: cursor != null
     * Postconditions: The TripStopNode referenced by cursor has been removed from the list.
     * All other TripStopNodes in the list exist in the same order as before.
     * The cursor now references the next TripStopNode.*
     * @return the TripStop taht was removed
     * @throws EndOfListException EndOfListException if cursor is null.
     */
    public TripStop removeCursor()throws EndOfListException{

        TripStopNode removedCursor = cursor;
        if(cursor==null){
            throw new EndOfListException();
        }//else if (size==1){
           // cursor=null;
            //size--;
            //totaldistance-=removedCursor.getData().getDistance();
            //return removedCursor.getData();
        //}
        else if(cursor==head){
            TripStopNode cursor2 = cursor.getNext();
            if(cursor2==null){

                cursor=head;
                cursor=cursor.getNext();
                head=cursor;
                cursor=cursor2;
                size--;
                totaldistance-=removedCursor.getData().getDistance();
                return removedCursor.getData();
            }else {
                head = cursor.getNext();
                cursor.getNext().setPrev(null);
                cursor = cursor.getNext();
                size--;
                totaldistance -= removedCursor.getData().getDistance();
                return removedCursor.getData();
            }
        }
        else if(cursor==tail){
            TripStopNode cursor1 = cursor.getPrev();
            cursor.getPrev().setNext(null);
            cursor.setPrev(null);
            cursor=cursor1;

            size--;
            totaldistance-=removedCursor.getData().getDistance();
            return removedCursor.getData();
        }else{
            TripStopNode cursor1 = cursor.getPrev();
            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());
            cursor=cursor1.getNext();
            size--;
            totaldistance-=removedCursor.getData().getDistance();
            return removedCursor.getData();
        }
    }

    /**
     * Prints the tripstopnodes in a table format.
     * Has a arrow to point to where the cursor is.
     * This is done by traversing through the linked list.
     * Also prints out the summary detailing size, distance and
     * stops before and after cursor.
     * @return var, summary and stops.
     */
    public String toString(){
        String location = "location";
        String activity = "activity";
        String distance = "distance";

        TripStopNode temp=cursor;
        cursor=head;
        String var="";
        String summary="";
        int beforeCursor=0;
        int afterCursor=0;

        while (cursor != null) {
            if (cursor == temp) {
                var += ">";
            } else {
                var += " ";
            }
            var += String.format("%-25s%-25s%-35d", cursor.getData().getLocation(),
                    cursor.getData().getActivity(), cursor.getData().getDistance()) + "\n";
            cursor = cursor.getNext();
        }

        cursor=temp;
        summary+= "This trip has " + getStopsCount() + " stops, totaling " + getTotalDistance()
                + " miles. \n";
       if(cursor!=null) {
           while (temp.getPrev() != null) {
               temp = temp.getPrev();
               beforeCursor++;
           }
           temp = cursor;
           while (temp.getNext() != null) {
               temp = temp.getNext();
               afterCursor++;
           }
       }else{

       }

            String stops = "There are " + beforeCursor + " stops before the cursor and " + afterCursor
        + " stops after the cursor\n";
        return var+summary+stops;
    }

    /**
     * Clones an entire itinerary, supplements clone method in TripStop
     * Traverses through entire list and checks if each node is equal
     * and makes deep copy.
     * @param copyTripPlanner The object you are copying
     * @return the clone
     */
    public Itinerary clone(Itinerary copyTripPlanner){
        TripStop copy;
        Itinerary clone = new Itinerary();
        copyTripPlanner.cursor = copyTripPlanner.head;
        while(copyTripPlanner.getCursor()!=null){

            TripStop temp = new TripStop();
            temp=copyTripPlanner.getCursor().getData().clone();
            //TripStopNode temp2 = new TripStopNode(temp);
            clone.appendToTail(temp);

            copyTripPlanner.cursor =copyTripPlanner.getCursor().getNext();
        }
        return clone;
    }


}
