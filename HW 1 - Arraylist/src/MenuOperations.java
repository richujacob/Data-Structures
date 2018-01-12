/**
 * Richu Jacob
 * ID:110257792
 * Homework #1
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: not provided
 */
import java.util.Scanner;

public class MenuOperations extends Exception {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        Menu restaurant = new Menu();
        Menu order = new Menu();

        boolean done=true;
        while(done){
            System.out.println("Main Menu \n");
            System.out.println("A) Add Item");
            System.out.println("G) Get Item");
            System.out.println("R) Remove Item");
            System.out.println("P) Print All Items");
            System.out.println("S) Size");
            System.out.println("D) Update Description");
            System.out.println("C) Update Price");
            System.out.println("O) Add to Order");
            System.out.println("I) Remove from Order");
            System.out.println("V) View Order");
            System.out.println("Q) Quit \n");

            System.out.print("Select an Operation: ");
            String user=s.nextLine();

            while(user.equals(""))
                user = s.nextLine();

            if(user.equals("A")||(user.equals("a"))){
               try {
                   System.out.println("Enter the Name: ");
                   String name = s.nextLine();
                   System.out.println("Enter the Description: ");
                   String description = s.nextLine();
                   System.out.println("Enter the Price: ");
                   double price = s.nextDouble();
                   System.out.println("Enter the Position: ");
                   int position = s.nextInt();

                   MenuItem item = new MenuItem(name, description, price);
                   restaurant.addItem(item, position);

                   System.out.print("Added " + name + ": " + description + " for $" +
                           price + " at position " + position + "\n");
               }catch(IllegalArgumentException e){
                   System.out.print(" position is not within the valid range \n");
               }catch(FullListException e){
                   System.out.print("no more room inside of the Menu to store the new MenuItem object \n");
               }

            }else if(user.equals("G")||(user.equals("g"))){
                try {
                    System.out.println("Enter the Position: ");
                    int position = s.nextInt();
                    String notDynamic = "Menu \n#   Name                Description                                        Price \n" +
                            "--------------------------------------------------------------------------------- \n";
                    String var = String.format("%-4d%-20s%-51s%1.2f", position, restaurant.list[position - 1].getItemName(),
                            restaurant.list[position - 1].getDescription(),
                            restaurant.list[position - 1].getPrice()) + "\n";
                    System.out.print(notDynamic + var);
                }catch(IllegalArgumentException e){
                    System.out.print("position is out of valid range \n");
                }catch(NullPointerException e){
                    System.out.print("there is nothing in this position \n");
                }
            }else if(user.equals("R")||(user.equals("r"))){
                try {
                    System.out.println("Enter the Name: ");
                    String name = s.nextLine();

                    restaurant.removeItemByName(name);
                    System.out.print("Removed " + name + "\n");
                }catch(IllegalArgumentException e){
                    System.out.print("this item does not exist \n");
                }

            }else if(user.equals("P")||(user.equals("p"))){
                restaurant.printAllItems();
            }else if(user.equals("S")||(user.equals("s"))){

                System.out.print("There are " + restaurant.size() + " items \n");

            }else if(user.equals("D")||(user.equals("d"))){
                System.out.println("Enter the Position: ");
                int position = s.nextInt();
                System.out.println("Enter the new description: ");
                String description = s.next();

                restaurant.getItem(position).setDescription(description);
                System.out.print("New description set \n");

            }else if(user.equals("C")||user.equals("c")){
                try{System.out.println("Enter the name of the item: ");
                String name = s.nextLine();
                System.out.println("Enter the new price: ");
                double price = s.nextDouble();


                    restaurant.getItemByName(name).setPrice(price);
                    System.out.print("Changed the price of " + name + " to $" + price + "\n" );
                }catch(NegativeNumberException e){
                    System.out.print("Don't put a negative number \n");
                }catch(IllegalArgumentException e){
                    System.out.print("given item does not exist \n");
                }catch(NullPointerException e){
                    System.out.print("item does not exist \n");
                }

            }else if(user.equals("O")||user.equals("o")){
                try {
                    System.out.println("Enter position of item to add to order: ");
                    int position = s.nextInt();
                    MenuItem tempOrder = restaurant.getItem(position);
                    order.addItem(tempOrder, position);
                    System.out.print("added " + tempOrder.getItemName() + " to order \n");
                }catch(FullListException e){
                    System.out.print("no more room inside of the Menu to store the new MenuItem object \n");
                }



            }else if(user.equals("I")||user.equals("i")){
                System.out.print("Enter the position: ");
                int position  = s.nextInt();
                MenuItem tempOrder2 = restaurant.getItem(position);
                order.removeItem(position);

                System.out.print("Removed " + tempOrder2.getItemName() + " to order \n");

            }
            else if(user.equals("V")||user.equals("v")){
                order.printAllItems();
            }else if(user.equals("Q")||user.equals("q")){
                done=false;
                System.out.print("You have quit out of menu");
            }else{
                System.out.print("Put a correct command from the menu or press Q to quit");
            }

        }
    }
}