/**
 * Created by Richu on 11/14/2016.
 */

import java.io.*;

import java.util.*;

public class Driver implements Serializable{
    public static void main(String [] args){

        Scanner s = new Scanner(System.in);
        Building building; //= new Building();
        Campus campus = new Campus();
        Classroom classroom;

        boolean done=true;
        //boolean editBuilding=false;
        try{
            FileInputStream file = new FileInputStream("storage.obj");
            ObjectInputStream inStream = new ObjectInputStream(file);

            campus = (Campus) inStream.readObject();
            inStream.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch(IOException e){
            System.out.println("There is an io exception");
        } catch (ClassNotFoundException e) {
            System.out.print("Class not found");
        }

        while(done){
            System.out.println("Menu: \n");
                System.out.println("A) Add a building: ");
                System.out.println("D) Delete a building ");
                System.out.println("E) Edit a building: ");
                System.out.println("F) Find a room: ");
                System.out.println("S) Search for rooms ");
                System.out.println("C) List all buildings on Campus: ");
                System.out.println("L) List building details: ");
                System.out.println("Q) Quit: ");

                System.out.print("Please enter a operation: ");
                String user=s.nextLine();

            while(user.equals(""))
                user = s.nextLine();

            if(user.equals("A")||user.equals("a")){
                try {
                    System.out.print("Please enter a building name:");
                    String name = s.nextLine();
                    building=new Building();
                    campus.addBuilding(name, building);
                    System.out.println("Building " + name + " added");
                }catch(IllegalArgumentException e){
                    System.out.println("key is either null or already exists\n");
                }
            }
            else if (user.equals("D") || user.equals("d")) {
                    try {
                        System.out.print("Please enter a building name:");
                        String name = s.nextLine();
                        campus.removeBuilding(name);
                        System.out.println("Building " + name + " deleted");

                    }catch(IllegalArgumentException e){
                        System.out.println("Key is either null or doesn't exist\n");
                    }
            }else if(user.equals("E")||user.equals("e")){
                try {
                    System.out.print("Please enter a building name:");
                    String name = s.nextLine();
                    building=campus.getBuilding(name);
                    if(building==null){
                        continue;
                    }System.out.println("Building " + name + " selected\n");

                    //while(editBuilding){
                    System.out.println("Options: \n");
                    System.out.println("A) Add room: ");
                    System.out.println("D) Delete room: ");
                    System.out.println("E) Edit room: ");

                    System.out.print("Please enter a option: ");
                    user=s.nextLine();

                    if(user.equals("A")||user.equals("a")){
                        System.out.println("Please enter room number: ");
                        int room = s.nextInt();
                        classroom=new Classroom();
                        try {

                            building.addClassroom(room, classroom);
                        }catch(IllegalArgumentException e){
                            System.out.println("Room not found");
                        }
                        System.out.println("Please enter number of seats: ");
                        int seats = s.nextInt();
                        s.nextLine();
                        classroom.setNumSeats(seats);
                        System.out.println("Please enter AV Equipment (separated by commas): ");
                        //s.nextLine();
                        String av = s.nextLine();
                        String [] AV = av.split(",");
                        classroom.setAVEquipmentList(AV);
                        System.out.println("Does it have a whiteboard?(Y/n): ");
                        String whiteboard = s.next();
                        if(whiteboard.equalsIgnoreCase("Y")){
                            classroom.setHasWhiteboard(true);
                        }else if(whiteboard.equalsIgnoreCase("N")){
                            classroom.setHasWhiteboard(false);
                        }else{
                            System.out.println("Enter y or n please: ");
                            whiteboard = s.next();
                        }
                        System.out.println("Does it have a chalk?(Y/n): ");
                        String chalkboard = s.next();
                        if(chalkboard.equalsIgnoreCase("Y")){
                            classroom.setHasChalkboard(true);
                        }else if(chalkboard.equalsIgnoreCase("N")){
                            classroom.setHasChalkboard(false);
                        }else{
                            System.out.println("Enter y or n please: ");
                            chalkboard = s.next();
                        }


                        //classroom.setHasWhiteboard(whiteboard);
                        //classroom.setHasChalkboard(chalkboard);

                    }else if(user.equals("D")||user.equals("d")){
                        try {
                            System.out.println("Please enter room number: ");
                            int room = s.nextInt();
                            building.removeClassroom(room);
                            System.out.println("Room " + room + " deleted");
                        }catch(IllegalArgumentException e){
                            System.out.println("Key is invalid or null");
                        }
                    }else if(user.equals("E")||user.equals("e")){
                        try {
                            System.out.println("Please enter room number: ");
                            int room = s.nextInt();

                            classroom = building.getClassroom(room);
                            if(classroom==null){
                                continue;
                            }
                            System.out.println("Old number of seats: " + classroom.getNumSeats());
                            System.out.println("Please enter number of seats or press enter to skip: ");
                            s.nextLine();
                            String seats = s.nextLine();
                            if(seats.equals("")){

                            }else {
                                int seatnum = Integer.parseInt(seats);
                                classroom.setNumSeats(seatnum);
                                System.out.println("Seats updated");
                            }

                            System.out.print("Old AV equipment: ");
                            for(int i=0; i<classroom.getAVEquipmentList().length; i++){
                                System.out.print(classroom.getAVEquipmentList()[i] + ",");
                            }
                            System.out.println();
                            System.out.println("Please enter newAV Equipment (separated by commas) or press enter to skip: ");
                            //s.nextLine();
                            String av = s.nextLine();
                            if(av.equals("")){

                            }
                           else {
                                String[] AV = av.split(",");
                                classroom.setAVEquipmentList(AV);
                                System.out.println("AV Equipment Updated\n");
                            }
                            //System.out.println("AV Equipment Updated");
                            System.out.println("Does it have a whiteboard?(Y/n) or press enter to skip: ");
                            String whiteboard = s.nextLine();
                            if (whiteboard.equalsIgnoreCase("Y")) {
                                classroom.setHasWhiteboard(true);
                                System.out.println("Whiteboard status updated");
                            }else if (whiteboard.equalsIgnoreCase("N")) {
                                classroom.setHasWhiteboard(false);
                                System.out.println("Whiteboard status updated");
                            }else if(whiteboard.equals("")){

                            }
                            else {
                                System.out.println("Enter y or n please: ");
                                whiteboard = s.nextLine();
                            }
                            System.out.println("Does it have a chalk?(Y/n) or press enter to skip: ");
                            String chalkboard = s.nextLine();
                            if (chalkboard.equalsIgnoreCase("Y")) {
                                classroom.setHasChalkboard(true);
                                System.out.println("Chalkboard status updated");
                            } else if (chalkboard.equalsIgnoreCase("N")) {
                                classroom.setHasChalkboard(false);
                                System.out.println("Chalkboard status updated");
                            } else if(chalkboard.equals("")){

                            }
                            else {
                                System.out.println("Enter y or n please: ");
                                chalkboard = s.nextLine();
                            }
                            System.out.println(room + " updated");
                        }catch(IllegalArgumentException e){
                            System.out.println("Key is invalid");
                        }


                    }else{
                        System.out.println("please enter valid input: ");
                        user=s.nextLine();
                    }


                    //System.out.println("Building " + name + " selected" );
                    //editBuilding=true;
                }catch(IllegalArgumentException e) {
                    System.out.println("Requested building does not exist ");
                }catch(NullPointerException e){
                        System.out.println("Building not found");
                        continue;
                }


                //}
            }else if(user.equals("F")||user.equals("f")){
                System.out.println("Please enter a room name: ");
                user=s.nextLine();
                String buildingName = user.split(" ")[0];
                String roomName = user.split(" ")[1];
                int room = Integer.parseInt(roomName);
                building=campus.getBuilding(buildingName);
                classroom=building.getClassroom(room);
                System.out.println("Room Details: ");
                System.out.println("\tSeats: "+ classroom.getNumSeats());
                //System.out.println("\t" + classroom.getHasWhiteboard());
                System.out.print("\tAV Amenities: ");
                for(int i=0; i<classroom.getAVEquipmentList().length; i++){
                    System.out.print(classroom.getAVEquipmentList()[i] + ",");
                }System.out.println();
                if(classroom.getHasWhiteboard()==true){
                    System.out.println("\tHas whiteboard");
                }else{
                    System.out.println("\tDoesn't have whiteboard");
                }
                //System.out.println("\t" + classroom.getHasChalkboard());
                if(classroom.getHasChalkboard()==true){
                    System.out.println("\tHas chalkboard");
                }else{
                    System.out.println("\tDoesn't have chalkboard");
                }
            }else if(user.equals("S")||user.equals("s")){
                System.out.println("Option:");

                System.out.println("B) Chalkboard: ");
                System.out.println("W) Whiteboard: ");
                System.out.println("A) AV Equipment: ");
                user=s.nextLine();

                if(user.equals("B")||user.equals("b")){
                    try {
                        String key = "";
                        Map<String, Building> map = campus.getHash();

                        for (Map.Entry<String, Building> getBuilding : map.entrySet()) {

                            key = getBuilding.getKey();
                            building=campus.getBuilding(key);
                            System.out.print("\t"+key+": ");
                            Map<Integer, Classroom> map1 = building.getHash();
                            for(Map.Entry<Integer, Classroom> getRoom : map1.entrySet()){
                                int roomKey = getRoom.getKey();
                                if(map1.get(roomKey).getHasChalkboard()==true){
                                    System.out.print(roomKey + ", ");
                                }else{

                                }

                            System.out.println();
                            }
                            //System.out.print("\t"+ key + ": ");
                        }System.out.println();
                    }catch(IllegalArgumentException e){
                        System.out.println("Invalid key");
                    }
                }
                else if(user.equals("W")||user.equals("w")){
                    try {
                        String key = "";
                        Map<String, Building> map = campus.getHash();

                        for (Map.Entry<String, Building> getBuilding : map.entrySet()) {

                            key = getBuilding.getKey();
                            building=campus.getBuilding(key);
                            System.out.print("\t"+key+": ");
                            Map<Integer, Classroom> map1 = building.getHash();
                            for(Map.Entry<Integer, Classroom> getRoom : map1.entrySet()){
                                int roomKey = getRoom.getKey();
                                if(map1.get(roomKey).getHasWhiteboard()==true){
                                    System.out.print(roomKey + ", ");
                                }else{

                                }

                                System.out.println();
                            }
                            //System.out.print("\t"+ key + ": ");
                        }System.out.println();
                    }catch(IllegalArgumentException e){
                        System.out.println("Invalid key");
                    }
                }else if(user.equals("A")||user.equals("a")){
                    try {
                        System.out.println("Please enter a keyword: ");
                        String keyword=s.nextLine();
                        String key = "";
                        Map<String, Building> map = campus.getHash();

                        for (Map.Entry<String, Building> getBuilding : map.entrySet()) {

                            key = getBuilding.getKey();
                            building=campus.getBuilding(key);
                            System.out.print("\t"+key+": ");
                            Map<Integer, Classroom> map1 = building.getHash();
                            for(Map.Entry<Integer, Classroom> getRoom : map1.entrySet()){
                                int roomKey = getRoom.getKey();
                                for(int i=0; i<map1.get(roomKey).getAVEquipmentList().length;i++){
                                    if(map1.get(roomKey).getAVEquipmentList()[i].equals(keyword)){
                                        System.out.print(roomKey + ", ");
                                    }else{

                                    }
                                }
                            }
                            //System.out.print("\t"+ key + ": ");
                        }System.out.println();
                    }catch(IllegalArgumentException e){
                        System.out.println("Invalid key");
                    }
                }else{
                    System.out.println("Please enter valid input: ");
                    user=s.nextLine();
                }
            }else if(user.equals("C")||user.equals("c")){
                try {
                    String key = "";
                    Map<String, Building> map = campus.getHash();

                    for (Map.Entry<String, Building> getBuilding : map.entrySet()) {

                        key = getBuilding.getKey();
                        building=campus.getBuilding(key);
                        System.out.print("\t"+key+": ");
                        Map<Integer, Classroom> map1 = building.getHash();
                        for(Map.Entry<Integer, Classroom> getRoom : map1.entrySet()){
                            int roomKey = getRoom.getKey();
                            System.out.print(roomKey + ", ");

                        }
                        //System.out.print("\t"+ key + ": ");
                    }System.out.println();
                }catch(IllegalArgumentException e){
                    System.out.println("Invalid key");
                }
            }else if(user.equals("L")||user.equals("l")){
                try {
                    System.out.println("Please enter a building name: ");
                    user = s.nextLine();
                    building = campus.getBuilding(user);
                    if (building == null) {
                        continue;
                    } else {
                        System.out.println("Details: ");
                        System.out.print("\tRooms: ");
                        int roomCounter=0;
                        int whiteBoard=0;
                        int chalkBoard=0;
                        int totalSeats=0;
                        int key=0;
                        ArrayList<String > equipment = new ArrayList<>();
                        Map<Integer, Classroom> map = building.getHash();
                        for (Map.Entry<Integer, Classroom> getRoom : map.entrySet()) {
                            key = getRoom.getKey();
                            roomCounter++;
                            System.out.print(key + ", ");
                            totalSeats += map.get(key).getNumSeats();
                            if(map.get(key).getHasWhiteboard()==true){
                                whiteBoard++;
                            }

                            if(map.get(key).getHasChalkboard()==true){
                                chalkBoard++;
                            }else{

                            }
                            //map.get(key).getAVEquipmentList();
                            //System.out.println();
                            //System.out.print(" AV Equipment present: ");
                            //
                            for(int i=0; i<map.get(key).getAVEquipmentList().length; i++){
                                equipment.add(map.get(key).getAVEquipmentList()[i]);
                            }
                        }
                        System.out.println();
                        System.out.println("\tTotal seats: " + totalSeats);
                        System.out.print("\tAV Equiptment present: ");
                        Set<String> remove = new HashSet<>();
                        remove.addAll(equipment);
                        equipment.clear();
                        equipment.addAll(remove);
                        Arrays.toString(equipment.toArray());

                        for(int i=0; i<equipment.size(); i++){
                            System.out.print(equipment.get(i).toString() + ", ");
                        }
                        System.out.println();
                        double whiteBoardPer= ((double)whiteBoard/(double)roomCounter)*100;
                        double chalkBoardPer = ((double)chalkBoard/(double)roomCounter)*100;
                        System.out.println("\t"+whiteBoardPer+"% of rooms have whiteboards");
                        System.out.println("\t"+chalkBoardPer+"% of rooms have chalkboards");
                        //System.out.println(equipment);
                        //for(int i=0; i<equipment.size(); i++){
                          //  System.out.print(equipment.get(i).toString());
                        //}
                        //Arrays.toString(equipment.toArray());

                        System.out.println();
                        //for(int i=0; i<map.get(key).getAVEquipmentList())
                    }
                }catch(IllegalArgumentException e) {
                    System.out.println("Invalid key");
                }
            }else if(user.equals("Q")||user.equals("q")){
                System.out.println("\tS - Save: ");
                System.out.println("\tD - Don't Save: ");
                user=s.nextLine();
                if(user.equals("S")||user.equals("s")){
                    try {
                        FileOutputStream file = new FileOutputStream("storage.obj");
                        ObjectOutputStream outStream = new ObjectOutputStream(file);
                        // the following line will save the object in the file
                        outStream.writeObject(campus);
                        outStream.close();
                    } catch (FileNotFoundException e) {
                        System.out.print("file not found");
                    } catch (IOException e) {
                        System.out.print("IO Exception");
                    }
                    done = false;
                }else if(user.equals("D")||user.equals("d")){
                    done = false;
                }else{
                    System.out.println("Please enter valid input: ");
                    user=s.nextLine();
                }
                //done=false;
            }else{
                System.out.println("Please enter valid input: ");
                    user=s.nextLine();
                }
            }


        }

    }

