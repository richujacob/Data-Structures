/**
 * Created by Richu on 11/11/2016.
 */
import java.util.HashMap;
import java.io.Serializable;
//import java.util.IllegalFormatCodePointException;

public class Building implements Serializable{
    /**
     * declares a hashmap used to add, get or remove classrooms
     */
    private HashMap hash;

    /**
     * default constructor that initializes the hashmap
     */
    public Building(){
        hash=new HashMap();
    }

    /**
     * adds a classroom using the roomnumber as a key
     * @param roomNumber is used to add the classroom
     * @param classroom the object the key is added to
     * @throws IllegalArgumentException is thrown if roomnumber is null or
     * there is already a roomnumber in the hash
     */
    public void addClassroom (int roomNumber, Classroom classroom)throws IllegalArgumentException{
        if(roomNumber==-1){
            throw new IllegalArgumentException();
        }else if(hash.containsKey(roomNumber)){
            throw new IllegalArgumentException();
        }
        else{
            hash.put(roomNumber, classroom);
        }
    }

    /**
     * gets the classroom depending on the key(roomnumber)
     * @param roomNumber is the key used to access the classroom
     * @return the classroom that has the key
     */
    public Classroom getClassroom(int roomNumber){
       if(hash.get(roomNumber)==null){
           System.out.println("Room is null");
           return null;
       }else{
           System.out.println("Room " + roomNumber + " selected");
           return (Classroom)hash.get(roomNumber);
       }
    }

    /**
     * removes a classroom based on the key(roomnumber)
     * @param roomNumber is used to remove the specific classroom
     * @throws IllegalArgumentException if roomnumber inputted is null or
     * if the key does not exist in the building
     */
    public void removeClassroom(int roomNumber)throws IllegalArgumentException{
        if(roomNumber==-1){
            throw new IllegalArgumentException();
        }else if(!hash.containsKey(roomNumber)){
            throw new IllegalArgumentException();
        }else{
            hash.remove(roomNumber);
        }
    }

    /**
     * gets the hash
     * @return the hash
     */
    public HashMap getHash(){
        return hash;
    }


}
