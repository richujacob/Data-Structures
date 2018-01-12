/**
 * Richu Jacob
 * ID:110257792
 * Homework #1
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: not provided
 */
public class NegativeNumberException extends Exception{

    /**
     * This exception returns the message to let usesr know price can't be negative.
     */
    public NegativeNumberException(){
        super("Price cannot be negative");
    }

}
