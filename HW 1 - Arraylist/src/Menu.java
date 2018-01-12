/**
 * Richu Jacob
 * ID:110257792
 * Homework #1
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: not provided
 */
public class Menu extends Exception  {
    /**
     * Declares menuitem list array, sets maxitems to 50 and declares sizecounter.
     */
    protected MenuItem list [];
    private final int MAX_ITEMS=50;
    private int sizeCounter;

    /**
     * Constructor, initializes menuitem array to maxitems which is 50,
     * also sets sizeCounter to 0.
     * Post Condition: This Menu has been initialized to an empty list of MenuItems.
     */
    public Menu(){
        list = new MenuItem [MAX_ITEMS];
        sizeCounter=0;
    }

    /**
     *  Method that sets the value of list.
     * @param list, used to set the list
     */
    public void setList(MenuItem [] list){
        this.list=list;
    }

    /**
     * Menuitem method that returns the list.
     * @return list
     */
    public MenuItem [] getList(){
        return list;
    }

    /**
     * The return value of the clone method is copy of the menu.
     * @return a copy of menu called clone
     */
    public Object clone(){
        MenuItem copy;
        Menu clone = new Menu();
        for(int i=0; i<MAX_ITEMS;i++){
            copy = this.list[i].clone();
            clone.getList()[i] = copy;

        }
        return clone;
    }

    /**
     * Returns true or false depending on if the obj compared to menu is equal to it.
     * @param obj, used to compare to see if its equals
     * @return boolean value true or false
     */
    public boolean equals (Object obj){
        int sameCounter=0;
        Menu compare = new Menu();
        for(int i=0; i<sizeCounter;i++){
            if(this.list[i].equals(compare.list[i])){
                sameCounter++;
            }
        }if(sameCounter==sizeCounter){
            return true;
        }else
            return false;
    }

    /**
     * Provides the size of menu or number of items in menu.
     * Precondition: This Menu object has been instantiated.
     * @return sizecounter
     */
    public int size(){

        return sizeCounter;
    }

    /**
     * Add items to the menu and throws exception if the list is full
     * or if the position the user inputs is not within the valid range.
     * Adds to sizecounter.
     * @param item is the new MenuItem object to add to this Menu
     * @param position is the position in the Menu where item will be inserted
     * Precondtions: This Menu object has been instantiated and 1 < position < items_currently_in_list + 1.
     * The number of MenuItem objects in this Menu is less than MAX_ITEMS.
     * PostCondition:  All MenuItems that were originally in positions greater than or equal to
     * position are moved back one position
     * @throws IllegalArgumentException occurs when position is not within the valid range.
     * @throws FullListException occurs when there is no more room inside of the Menu to store the new MenuItem object.
     */
    public void addItem(MenuItem item, int position)throws IllegalArgumentException, FullListException{

            if(list.length<MAX_ITEMS||position<50){
                for(int i=sizeCounter;i>=position-1 ; i--){
                    list[i+1]=list[i];
                }list[position-1]=item;
                sizeCounter++;
            }else if(list.length>MAX_ITEMS||position>=50){
                throw new IllegalArgumentException();
            }else
                for(int i=0;i<list.length;i++){
                    if(list[i]!=null){

                    }throw new FullListException();
                }


    }

    /**
     * removes an item and shifts remaining items to the left
     * throws exception if position is not within the valid range
     * decreases sizecounter
     * @param position is ued to remove the item in that specific position and refers to position in menu
     * Precondition: This Menu object has been instantiated and 1 < position < items_currently_in_list.
     * Post Condition: All MenuItems that were originally in positions greater than or equal to
     * position are moved forward one position.
     * @throws IllegalArgumentException occurs to ndicate that position is not within the valid range.
     */
    public void removeItem(int position){
        try{
            for(int i=position-1; i<sizeCounter; i++){
                list[i]=list[i+1];

            }sizeCounter--;

        }catch(IllegalArgumentException e){
            System.out.print("The position is not within the valid range");
        }
    }

    /**
     * gets the item from menu using position and returns it
     * throws exception if position is not within the valid range
     * and returns nothing if exception is thrown
     * @param position is position of the MenuItem to retrieve.
     * Precondition: This Menu object has been instantiated and 1 < position < items_currently_in_list.
     * @return the item at the specifc position
     * @throws IllegalArgumentException indicates that position is not within the valid range.
     */
    public MenuItem getItem(int position) throws IllegalArgumentException, IllegalArgumentException{

        if(position > sizeCounter){
            throw new IllegalArgumentException();
        }
        return list[position-1];


    }

    /**
     * gets the item from menu using name and returns it
     *throws excpetion if the given item does not exist in the menu
     * and returns nothing if exception is thrown
     * @param name is name of the item to retrieve
     * Precondition: This Menu object has been instantiated.
     * @return item at that specific index
     * @throws IllegalArgumentException Indicates that the given item does not exist in this Menu.
     */
    public MenuItem getItemByName(String name) throws IllegalArgumentException{
            int index=0;
            for(int i=0; i<sizeCounter;i++){
                if(list[i].getItemName().equals(name)){
                    index=i;
                }else
                    throw new IllegalArgumentException();
            }return list[index];

        }

    /**
     * removes item by name using name instead of position
     * decreases sizecounter
     * @param name is used to remove the specific name form the menu
     * Precondition: This Menu object has been instantiated.
     * PostCondition: removes an item by using name
     * @throws IllegalArgumentException Indicates that the given item does not exist in this Menu.
     */
    public void removeItemByName(String name)throws IllegalArgumentException{
               int index = 0;
               for(int i = 0; i < sizeCounter; i++){
                   if (list[i].getItemName().equalsIgnoreCase(name)){
                       index = i;
                   }else{
                       throw new IllegalArgumentException();
                   }
               }

               for(int i = index; i < sizeCounter; i++){
                   list[i] = list[i+1];
               }
               sizeCounter--;
    }

    /**
     * prints all items implementing the tostring method
     * Preconditions: This Menu object has been instantiated.
     * PostConditions: A neatly formatted table of each MenuItem in the Menu on its own line
     * with its position number has been displayed to the user.
     */
    public void printAllItems(){

        System.out.print(toString());
    }

    /**
     * returns the string that is then used in printAllItems to print the menu
     * @return string notdynamic+var
     */
    public String toString(){
        String position = "Position";
        String name = "name";
        String description  = "description";
        String price = "price";

        String notDynamic = "#   Name                Description                                        Price \n" +
                "--------------------------------------------------------------------------------- \n";
        String var = "";
        for(int i=0; i<sizeCounter; i++) {
            var += String.format("%-4d%-20s%-51s%1.2f", i+1, list[i].getItemName(), list[i].getDescription(),
                    list[i].getPrice()) +"\n";
        }
        return notDynamic+var;

    }

}
