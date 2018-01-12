/**
 * Richu Jacob
 * ID:110257792
 * Homework #4
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */

import java.util.ArrayList;

public class DownloadQueue extends ArrayList {

    /**
     * default constructor for the queue
     */
    public DownloadQueue(){
        super();
    }

    /**
     * adds d to the end of the queue. You may use either void or boolean for this method.
     * @param d is the object that is added to the queue
     */
    public void enqueue(DownloadJob d){
        super.add(d);

    }

    /**
     *  takes the DownloadJob that is at the front of the queue,
     *  saves the value, removes the DownloadJob from the queue.
     * @return returns the Value.
     * @throws EmptyQueueException If the queue was empty, throw an EmptyQueueException.
     */
    public DownloadJob dequeue() throws EmptyQueueException{
        if(super.isEmpty()){
            throw new EmptyQueueException();
        }else{
            DownloadJob temp;
            temp = (DownloadJob) super.remove(0);
            return temp;
        }
    }

    /**
     * takes the DownloadJob that is at the front of the queue.
     * @return that value to the caller.
     * @throws EmptyQueueException  If the queue was empty, throw an EmptyQueueException.
     */
    public DownloadJob  peek() throws EmptyQueueException{
        if(super.isEmpty()){
            throw new EmptyQueueException();
        }else {
            return (DownloadJob) super.get(super.size() - 1);
        }
    }

    /**
     * returns true if queue is empty, false otherwise.
     * @return true or false
     */
    public boolean isEmpty(){
        if(super.isEmpty()){
            return true;
        }else{
            return false;
        }
    }


}
