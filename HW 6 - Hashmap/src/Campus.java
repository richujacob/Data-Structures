/**
 * Created by Richu on 11/11/2016.
 */
import java.util.HashMap;
import java.io.Serializable;

public class Campus implements Serializable{
    /**
     * declares a hashmap used to add, get or remove buildings
     */
    private HashMap hash;

    /**
     * default constructor that initializes the hashmap
     */
    public Campus(){
        hash = new HashMap();
    }

    /**
     * adds a building using building name as a key
     * @param buildingName is the key used to add the building
     * @param building the object building is added to
     * @throws IllegalArgumentException is thrown if buildingname is null or
     * there is already a buildingname in the hash
     */
    public void addBuilding(String buildingName, Building building)throws IllegalArgumentException{
        if(buildingName==null){
            throw new IllegalArgumentException();
        }else if(hash.containsKey(buildingName)){
            throw new IllegalArgumentException();
        }else{
            hash.put(buildingName, building);
        }
    }

    /**
     * gets the building depending on the key(buildingname)
     * @param buildingName is the key used to access the building
     * @return the building that has the key
     */
    public Building getBuilding(String buildingName){
        if(hash.get(buildingName)==null){
            System.out.println("Building is not found");
            return null;
        }else{
            //System.out.println("Building " + buildingName + " selected");
            return (Building) hash.get(buildingName);
        }
    }

    /**
     * removes a building based on the key(buildingname)
     * @param buildingName is used to remove the specific building
     * @throws IllegalArgumentException if buildingname inputted is null or
     * if the key does not exist in the campus
     */
    public void removeBuilding(String buildingName)throws IllegalArgumentException{
        if(buildingName==null){
            throw new IllegalArgumentException();
        }else if(!hash.containsKey(buildingName)){
            throw new IllegalArgumentException();
        }else{
            hash.remove(buildingName);
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
