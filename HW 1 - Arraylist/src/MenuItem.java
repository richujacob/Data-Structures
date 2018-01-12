/**
 * Richu Jacob
 * ID:110257792
 * Homework #1
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: not provided
 */
public class MenuItem  {
    /**
     * declares two strings, itemName and description.
     * declares a double, price.
     */
    private String itemName;
    private String description;
    private double price;

    /**
     * itemName holds name of item, description holds description of item
     * price holds the price of item.
     * @param itemName used to sets instance for item name.
     * @param description used to set instance for description.
     * @param price used to set instance for price.
     */
    public MenuItem(String itemName, String description, double price){
        this.itemName=itemName;
        this.description=description;
        this.price=price;
    }

    /**
     * Sets the name of item menu name.
     * @param itemName sets item name by using the instance of itemName.
     */
    public void setItemName(String itemName){
        this.itemName=itemName;
    }

    /**
     * Sets the description of the menu item.
     * @param description sets description by using instance of description
     */
    public void setDescription(String description){
        this.description=description;
    }

    /**
     * Sets the price for the menu item.
     * @param price sets the price by using instance of price
     * @throws NegativeNumberException is ued when user sets price to a negative number
     */
    public void setPrice(double price) throws NegativeNumberException{
        if(price<0) {
            throw new NegativeNumberException();
        }

        else
            this.price=price;
    }

    /**
     * Gets itemName and returns it.
     * @return itemName
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * Gets description and returns it.
     * @return description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Gets price and returns it.
     * @return price
     */
    public double getPrice(){
        return price;
    }

    /**
     * Copies each menuitem by using the instances of menu item and returns the MenuItem copy,
     * done in menu class to copy an entire menu.
     * @return copy
     */
    public MenuItem clone(){
        MenuItem copy  = new MenuItem(this.itemName, this.description, this.price);
        return copy;

    }

    /**
     * a boolean that checks whether the instances of MenuItem is equal,
     * done in menu class to check menu with another menu.
     * @param name used to getItemName to check if individual variable is equal
     * @return true/false depending on if a MenuItem is equal to another MenuItem
     */
    public boolean equals(MenuItem name){
        if(this.itemName.equals(name.getItemName())&&this.description.equals(name.getClass())&&
                this.price==name.getPrice()){
            return true;
        }else
            return false;
    }

}