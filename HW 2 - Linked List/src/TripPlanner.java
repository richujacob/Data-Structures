/**
 * Richu Jacob
 * ID:110257792
 * Homework #2
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
import java.util.InputMismatchException;
import java.util.Scanner;


public class TripPlanner  {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        Itinerary trip1 = new Itinerary();
        Itinerary trip2 = new Itinerary();

        boolean done=true;
        boolean isItinerary1=true;
        while(done) {
            System.out.println("Main Menu \n");
            System.out.println("F-Cursor forward");
            System.out.println("B-Cursor backward");
            System.out.println("I-Insert before Cursor");
            System.out.println("A-Append to tail");
            System.out.println("D-Delete and move forward");
            System.out.println("H-Cursor to head");
            System.out.println("T-Cursor to tail");
            System.out.println("E-Edit cursor");
            System.out.println("S-Swtich itinerary");
            System.out.println("O-Insert cursor from other itinerary before cursor from this itinerary");
            System.out.println("R-Replace this itinerary with a copy of the other itinerary");
            System.out.println("P-Print current itinerary, including summary");
            System.out.println("C-Clear current itinerary");
            System.out.println("Q-Quit \n");

            System.out.print("Select an Operation: \n");
            String user = s.nextLine();

            while (user.equals(""))
                user = s.nextLine();

            if (user.equals("F") || user.equals("f")) {
                try {
                    if (isItinerary1) {
                        if (trip1.getStopsCount()==0) {
                            System.out.print("Itinerary is empty\n");
                        }
                        trip1.cursorForward();
                        System.out.println("Moved cursor forward\n");
                    } else {
                        if (trip2.getStopsCount()==0) {
                            System.out.print("Itinerary is empty\n");
                        }
                        trip2.cursorForward();
                        System.out.println("Moved cursor forward\n");
                    }
                } catch (EndOfItineraryException e) {
                    System.out.print("Cant move cursor forward\n");
                } catch (NullPointerException e) {
                    System.out.print("cursor is null\n");
                }
            } else if (user.equals("B") || user.equals("b")) {
               try {
                    if (isItinerary1) {
                        if(trip1.getStopsCount()==0) {
                            System.out.print("Itinerary is empty\n");
                        }trip1.cursorBackward();
                        System.out.println("Moved cursor backward\n");
                    } else {
                        if(trip2.getStopsCount()==0) {
                            System.out.print("Itinerary is empty\n");
                        }
                        trip2.cursorBackward();
                        System.out.println("Moved cursor backward\n");
                    }
                } catch (EndOfItineraryException e) {
                    System.out.println("Cant move cursor backward\n");
                } catch (NullPointerException e) {
                    System.out.println("cursor is null\n");
                }
            } else if (user.equals("I") || user.equals("i")) {
                try {
                    if (isItinerary1) {
                        System.out.println("Enter location: ");
                        String location = s.nextLine();
                        System.out.println("Enter activity: ");
                        String activity = s.nextLine();
                        System.out.println("Enter distance");
                        int distance = s.nextInt();
                        if (distance < 1) {
                            System.out.println("Distance must be greater than 0, enter distance again");
                            distance = s.nextInt();
                        } else {
                            TripStop newStop = new TripStop(location, distance, activity);
                            trip1.insertBeforeCursor(newStop);
                            System.out.println("Added\n");
                        }
                    } else {
                        System.out.println("Enter location: ");
                        String location = s.nextLine();
                        System.out.println("Enter activity: ");
                        String activity = s.nextLine();
                        System.out.println("Enter distance");
                        int distance = s.nextInt();
                        if (distance < 1) {
                            System.out.println("Distance must be greater than 0");
                            distance = s.nextInt();
                        } else {
                            TripStop newStop = new TripStop(location, distance, activity);
                            trip2.insertBeforeCursor(newStop);
                            System.out.println("Added\n");
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("the new stop is null\n");
                } catch (InputMismatchException e) {
                    System.out.println("Input correct information\n");
                }
            } else if (user.equals("A") || user.equals("a")) {
                try {
                    if (isItinerary1) {
                        System.out.println("Enter location: ");
                        String location = s.nextLine();
                        System.out.println("Enter activity: ");
                        String activity = s.nextLine();
                        System.out.println("Enter distance");
                        int distance = s.nextInt();
                        if (distance < 1) {
                            System.out.println("Distance must be greater than 0");
                            distance = s.nextInt();
                        } else {
                            TripStop newStop = new TripStop(location, distance, activity);
                            trip1.appendToTail(newStop);
                            System.out.print("Added\n");
                        }
                    } else {
                        System.out.println("Enter location: ");
                        String location = s.nextLine();
                        System.out.println("Enter activity: ");
                        String activity = s.nextLine();
                        System.out.println("Enter distance");
                        int distance = s.nextInt();
                        if (distance < 1) {
                            System.out.println("Distance must be greater than 0");
                            distance = s.nextInt();
                        } else {
                            TripStop newStop = new TripStop(location, distance, activity);
                            trip2.appendToTail(newStop);
                            System.out.print("Added\n");
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("the new stop is null\n");
                } catch (InputMismatchException e) {
                    System.out.println("Input correct information\n");
                }
            } else if (user.equals("D") || user.equals("d")) {
                try {
                    if (isItinerary1) {
                        trip1.removeCursor();
                        System.out.println("Deleted cursor");
                    } else {
                        trip2.removeCursor();
                        System.out.println("Deleted cursor");
                    }
                } catch (EndOfListException e) {
                    System.out.println("The cursor is null\n");
                }
            } else if (user.equals("H") || user.equals("h")) {
                if (isItinerary1) {
                    trip1.resetCursorToHead();
                    System.out.println("set cursor to head");
                } else {
                    trip2.resetCursorToHead();
                    System.out.println("set cursor to head");
                }
            } else if (user.equals("T") || user.equals("t")) {
                if (isItinerary1) {
                    trip1.resetCursorToTail();
                    System.out.println("set cursor to tail");
                } else {
                    trip2.resetCursorToTail();
                    System.out.println("set cursor to tail");
                }
            } else if (user.equals("E") || user.equals("e")) {
                try {
                    if (isItinerary1) {
                        System.out.println("Edit Location, or press enter without typing anything to keep:");
                        String location = s.nextLine();
                        System.out.println("Edit Activity, or press enter without typing anything to keep: ");
                        String activity = s.nextLine();
                        System.out.println("Edit Distance, or press -1 without typing anything to keep");
                        int distance = s.nextInt();

                        if (location.equals("")) {

                        } else {
                            trip1.getCursor().getData().setLocation(location);
                        }
                        if (activity.equals("")) {

                        } else {
                            trip1.getCursor().getData().setActivity(activity);
                        }
                        if (distance == -1) {

                        } else {
//                            int originaldistance=trip1.getCursor().getData().getDistance();
//                            trip1.getCursor().getData().setDistance(distance);
//                            int diff=trip1.getCursor().getData().getDistance()
                            int origDist = trip1.getCursor().getData().getDistance();
                            int tripDist = trip1.getTotalDistance() - origDist;
                            trip1.getCursor().getData().setDistance(distance);
                            int newDist = trip1.getCursor().getData().getDistance();
                            trip1.setTotaldistance(tripDist + newDist);

                        }
                        System.out.println("Edits applied");
                    } else {

                        System.out.println("Edit Location, or press enter without typing anything to keep:");
                        String location = s.nextLine();
                        System.out.println("Edit Activity, or press enter without typing anything to keep: ");
                        String activity = s.nextLine();
                        System.out.println("Edit Distance, or press -1 without typing anything to keep");
                        int distance = s.nextInt();

                        if (location.equals("")) {

                        } else {
                            trip2.getCursor().getData().setLocation(location);
                        }
                        if (activity.equals("")) {

                        } else {
                            trip2.getCursor().getData().setActivity(activity);
                        }
                        if (distance == -1) {

                        } else {
                            int origDist = trip2.getCursor().getData().getDistance();
                            int tripDist = trip2.getTotalDistance() - origDist;
                            trip2.getCursor().getData().setDistance(distance);
                            int newDist = trip2.getCursor().getData().getDistance();
                            trip2.setTotaldistance(tripDist + newDist);

                        }
                        System.out.println("Edits applied");
                    }


                } catch (InputMismatchException e) {
                    System.out.println("Put right type of input");
                } catch (IllegalArgumentException e) {
                    System.out.println("Cant put negative number");
                }catch(NullPointerException e) {
                    System.out.println("Cursor is null");
                }
            } else if (user.equals("S") || user.equals("s")) {
                if (isItinerary1) {

                    isItinerary1 = false;


                    System.out.println("Itinerary swtiched\n");
                } else {

                    isItinerary1 = true;
                    System.out.println("Itinerary swtiched\n");

                }
                //Insert cursor from other itinerary before cursor from this itinerary
            } else if (user.equals("O") || user.equals("o")) {
                try{
                    if (isItinerary1) {
                        TripStop swap = trip2.getCursor().getData().clone();
                        trip1.insertBeforeCursor(swap);
                        System.out.println("Cursor inserted\n");
                    }else{
                        TripStop swap = trip1.getCursor().getData().clone();
                        trip2.insertBeforeCursor(swap);
                        System.out.println("Cursor inserted\n");
                    }
                }catch(NullPointerException e){
                    System.out.println("Cursor is null");
                }
            }else if(user.equals("R") || user.equals("r")) {
                    if(isItinerary1){
                        TripStopNode tempCursor=trip2.getCursor();
                        trip1 = trip1.clone(trip2);
                        trip2.setCursor(tempCursor);
                        System.out.println("Replaced\n");
                    }else{
                        TripStopNode tempCursor=trip1.getCursor();
                        trip2 = trip2.clone(trip1);
                        trip1.setCursor(tempCursor);
                        System.out.println("Replaced\n");
                    }

            }else if(user.equals("P")||user.equals("p")){

                    if(isItinerary1){
                        if(trip1.getStopsCount()==0) {

                        }System.out.println(trip1.toString());
                    }else{
                        if(trip2.getStopsCount()==0) {
                            System.out.println("The itinerary has nothing in it\n");
                        }System.out.println(trip2.toString());
                    }

            }else if(user.equals("C")||user.equals("c")){
                if(isItinerary1){
                    trip1.setHead(null);
                    trip1.setTail(null);
                    trip1.setCursor(null);
                    trip1.setSize(0);
                    trip1.setTotaldistance(0);
                    System.out.println("Cleared current itinerary");
                }else{
                    trip2.setHead(null);
                    trip2.setTail(null);
                    trip2.setCursor(null);
                    trip2.setSize(0);
                    trip2.setTotaldistance(0);
                    System.out.println("Cleared current itinerary");
                }

            }else if(user.equals("Q")||user.equals("q")){
                done=false;
                System.out.println("You have quit out of itinerary");
            }else{
                System.out.println("Please enter a valid command or press Q to quit");
            }


        }


    }
}
