/**
 * Richu Jacob
 * ID:110257792
 * Homework #2
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
public class EndOfItineraryException extends Exception {

    /**
     * This exception is thrown when the end of itinerary
     * is reached and user tries to move forward or backward
     */
    public EndOfItineraryException(){
        super("End of itinerary");
    }

}
