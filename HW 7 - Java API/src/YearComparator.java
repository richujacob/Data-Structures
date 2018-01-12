/**
 * Richu Jacob
 * ID:110257792
 * Homework #7
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */

import java.util.Comparator;

public class YearComparator implements Comparator {

    /**
     * method compares the objects and checks if year
     * is greater than, less than and or equal
     * @param o1 the first movie object
     * @param o2 the second movie object
     * @return 0, 1, or -1 depend on comparison value
     */
    public int compare(Object o1, Object o2){
        Movie m1 = (Movie) o1;
        Movie m2 = (Movie) o2;
        if(m1.getYear()==m2.getYear()){
            return 0;
        }else if(m1.getYear()>m2.getYear()){
            return 1;
        }else{
            return -1;
        }
    }

}
