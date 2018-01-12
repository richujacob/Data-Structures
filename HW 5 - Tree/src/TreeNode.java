/**
 * Richu Jacob
 * ID:110257792
 * Homework #5
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
public class TreeNode {
    /**
     * The array holds This field holds the message only if it is a leaf,
     * otherwise this is a list of words to trigger going down this path.
     * left and right hold the left and right subtrees respectively.
     */
    private String [] keywords;
    private TreeNode left;
    private TreeNode right;

    /**
     * default constructor
     */
    public TreeNode(){

    }

    /**
     * default constructor that returns keywords
     * @param keywords the array that holds the keywords
     */
    public TreeNode(String [] keywords){
        this.keywords=keywords;
    }

    /**
     *gets the keywords
     * @return the keywords
     */
    public String[] getKeywords() {
        return keywords;
    }

    /**
     * sets keywords to a parameter of keywords
     * @param keywords that holds new value of keywords
     */
    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    /**
     * gets the left tree
     * @return the left tree
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * sets the left tree
     * @param left that holds new left
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * gets the right tree
     * @return the right tree
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * sets the right tree to param value
     * @param right the new value of right
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * checks if its a leaf by check left and right
     * returns true if its left and right are both null
     */
    public Boolean isLeaf(){
        if(left==null && right==null){
            return true;
        }else{
            return false;
        }
    }
}
