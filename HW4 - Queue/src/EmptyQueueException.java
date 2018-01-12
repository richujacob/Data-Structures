/**
 * Richu Jacob
 * ID:110257792
 * Homework #4
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
public class EmptyQueueException extends Exception {

    /**
     * This exception is thrown if the queue is empty
     */
    public EmptyQueueException(){
        super("The queue is empty");
    }
}
