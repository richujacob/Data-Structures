/**
 * Richu Jacob
 * ID:110257792
 * Homework #5
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
import sun.reflect.generics.tree.Tree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DecisionTreeClassifier {
    public static void main(String [] args){

        Scanner s = new Scanner(System.in);
        TreeNavigator test = new TreeNavigator();
        //TreeNavigator test;
        TreeNode node = new TreeNode();

        boolean done=true;
        boolean edit=false;
        //System.out.print(test.getRoot().getRight().getRight().getKeywords()[0]);

        while(done){
            System.out.println("Menu:\n");
            System.out.println("I)Import a tree from a file");
            System.out.println("E)Edit current tree");
            System.out.println("C)Classify a Description");
            System.out.println("P)Show decision path for a Description");
            System.out.println("Q) Quit");


            System.out.print("Select an Operation: ");
            String user=s.nextLine();

            while(user.equals(""))
                user = s.nextLine();

            if(user.equals("E")||user.equals("e")){
                edit=true;
                while(edit){
                    System.out.println("\nPlease select an option:");
                    System.out.println("E)Edit Keywords");
                    System.out.println("C)Add Children");
                    System.out.println("D)Delete Children, and Make Leaf");
                    System.out.println("N)Cursor to No Child");
                    System.out.println("Y)Cursor to Yes Child");
                    System.out.println("R)Cursor to Root");
                    System.out.println("P)Cursor to Parent");
                    System.out.println("M)Main Menu\n");

                    System.out.print("Select an Operation: ");
                    user=s.nextLine();
                    if(user.equals("M")||user.equals("m")){
                        edit=false;
                    }else if(user.equals("E")||user.equals("e")){
                        System.out.println("Please enter keywords for this node, separated by a comma: ");
                        String input = s.nextLine();
                        test.editCursor(input);
                        System.out.println("Keywords updated to: " + input);
                    }else if(user.equals("C")||user.equals("c")){
                        System.out.println("Please enter terminal text for the no leaf: ");
                        String noLeaf = s.nextLine();
                        String[] noLeafArr = noLeaf.split("//,");
                        TreeNode left = new TreeNode(noLeafArr);
                        test.getCursor().setLeft(left);
                        System.out.println("Please enter terminal text for the yes leaf: ");
                        String yesLeaf = s.nextLine();
                        String[] yesLeafArr = yesLeaf.split("//,");
                        TreeNode right = new TreeNode(yesLeafArr);
                        test.getCursor().setRight(right);

                        System.out.println("Children are yes - " + yesLeaf+ " and no - " + noLeaf);

                    }else if(user.equals("D")||user.equals("d")){
                       System.out.println("Please enter a terminal text for this node: ");
                        String terminal = s.nextLine();
                        test.getCursor().setLeft(null);
                        test.getCursor().setRight(null);
                        String [] terminalARR = terminal.split(" ");
                        //TreeNode term = new TreeNode(terminalARR);
                        test.getCursor().setKeywords(terminalARR);

                        System.out.println("Your request is classified as: " + terminal);

                    }else if(user.equals("N")||user.equals("n")){
                        test.setCursor(test.getCursor().getLeft());
                         //TreeNode store = new TreeNode();
                        System.out.println("Cursor moved. message is " );
                        for(int i=0; i<test.getCursor().getKeywords().length; i++){
                            System.out.print(test.getCursor().getKeywords()[i] +" ");
                        }


                    }else if(user.equals("Y")||user.equals("y")){
                        test.setCursor(test.getCursor().getRight());
                        System.out.print("Cursor moved. message is " );
                        for(int i=0; i<test.getCursor().getKeywords().length; i++){
                            System.out.print(test.getCursor().getKeywords()[i] +" ");
                        }
                    }else if(user.equals("R")||user.equals("r")){
                        test.setCursor(test.getRoot());
                        System.out.print("Cursor moved. Cursor is at root.\n " +
                                "Current node keywords:" + test.getCursor().getKeywords()[0]);
                    }else if(user.equals("P")||user.equals("p")){
                        //extra credit
                    }else{
                        System.out.println("Please enter a valid command");
                        user=s.nextLine();
                    }
                }
            }else if (user.equals("I")|| user.equals("i")){

                    System.out.println("Please enter some text: ");
                    String importFile = s.nextLine();
                    test = test.buildTree(importFile);
                    test.getRoot();
                    System.out.println("Tree loaded");
                    test.setCursor(test.getRoot());

            }else if(user.equals(("C"))||(user.equals("c"))){
                System.out.println("Please enter some text: ");
                String classify = s.nextLine();
                String fix = classify.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");

                //test.classify(fix);
                System.out.println("Your request is classified as: " + test.classify(fix));

            }else if(user.equals("P")||(user.equals("p"))){
                System.out.println("Please enter some text: ");
                String path = s.nextLine();
                String fix = path.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
                test.getPath(fix);
                System.out.println("Decision path: " + test.getPath(fix));
            }else if(user.equals("Q")||(user.equals("q"))){
                System.out.println("Goodbye!");
                done=false;
            }
            else{
                System.out.println("Please enter an valid input");
                user=s.nextLine();
            }

        }
    }
}
