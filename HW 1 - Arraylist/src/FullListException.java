/**
 * Richu Jacob
 * ID:110257792
 * Homework #1
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: not provided
 */
public class FullListException extends Exception{

    /**
     * This exception returns the message to let user know that the list is already full.
     */
    public FullListException() {
        super("The list is full");
    }
}