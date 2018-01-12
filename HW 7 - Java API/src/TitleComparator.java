/**
 * Richu Jacob
 * ID:110257792
 * Homework #7
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
import java.util.Comparator;

public class TitleComparator implements Comparator {

    /**
     * method compares the objects and checks titles
     * @param o1 the first movie object
     * @param o2 the second movie object
     * @return the compareTo value
     */
    public int compare(Object o1, Object o2){
        Movie m1 = (Movie) o1;
        Movie m2 = (Movie) o2;
        return m1.getTitle().compareTo(m2.getTitle());
    }

}
