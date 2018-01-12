/**
 * Richu Jacob
 * ID:110257792
 * Homework #7
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */

import java.util.Comparator;

public class NameComparator implements Comparator {

    /**
     * method compares the objects and checks names
     * @param o1 the first actor object
     * @param o2 the second actor object
     * @return the compareTo value
     */
    public int compare(Object o1, Object o2){
        Actor a1 = (Actor) o1;
        Actor a2 = (Actor) o2;
       return a1.getName().compareTo(a2.getName());

    }
}
