/**
 * Richu Jacob
 * ID:110257792
 * Homework #7
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
import java.util.Comparator;

public class CountComparator implements Comparator {

    /**
     * method compares the objects and checks if count
     * is greater than, less than and or equal
     * @param o1 the first actor object
     * @param o2 the second actor object
     * @return 0, 1, or -1 depend on comparison value
     */
    public int compare(Object o1, Object o2){
        Actor a1 = (Actor) o1;
        Actor a2 = (Actor) o2;
        if(a1.getCount()==a2.getCount()){
            return 0;
        }else if(a1.getCount()>a2.getCount()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
