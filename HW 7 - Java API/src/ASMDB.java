/**
 * Richu Jacob
 * ID:110257792
 * Homework #7
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
import java.util.Scanner;
import big.data.*;

public class ASMDB {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        boolean done = true;

        MovieManager movieManager  = new MovieManager();
        Movie movie = new Movie();
        Actor actor = new Actor();
        int actorCounter=1;

        while (done) {
            System.out.println("Main Menu: ");
            System.out.println("\tI) Import a Movie ");
            System.out.println("\tD) Delete a Movie ");
            System.out.println("\tA) Sort Actors ");
            System.out.println("\tM) Sort Movies ");
            System.out.println("\tQ) Quit ");

            System.out.print("Please enter a operation: ");
            String user = s.nextLine();

            while (user.equals(""))
                user = s.nextLine();

            if (user.equals("I") || user.equals("i")) {
                try {
                    System.out.println("Please enter a movie title: ");
                    String movieName = s.nextLine();
                    if (movieManager.equals(movieName)) {
                        System.out.println("Movie was already entered");
                    } else {
                        String prefix = "http://www.omdbapi.com/?t=";
                        ///title=sc.nextLine();
                        String postfix = "&y=&plot=short&r=xml";
                        if (movieName.length() > 0) {
                            DataSource ds = DataSource.connectXML(prefix +
                                    movieName.replace(' ', '+') + postfix);
                            ds.load();

                            Movie movieObj = new Movie(ds.fetchString(("movie/title")), ds.fetchInt("movie/year"));
                            System.out.println("true title: " + ds.fetchString("movie/title"));
                            System.out.println("actors: " + ds.fetchString("movie/actors"));
                            System.out.println("year: " + ds.fetchInt("movie/year"));
                            //movieObj.setActor(ds.fetchString("movie/actors"));
                            movieManager.addMovie(movieObj);
                            String trim = ds.fetchString("movie/actors").trim();
                            String  splitting [] = ds.fetchString("movie/actors").split(", ");
                            for(int j=0; j<splitting.length; j++){
                                Actor actor3 = new Actor(splitting[j]);

                                if(movieManager.contains(actor3)){
                                    movieManager.getActorByName(actor3.getName()).setCount(actorCounter+1);

                                }else {
                                    movieManager.addActor(actor3);
                                    actorCounter=1;
                                    actor3.setCount(1);
                                }


                            }

                            System.out.println("Movie added: " + movieObj.getTitle());
                            //for(int j=0; j<movieObj.getActor().size(); j++){
                                //movieManager.addActor(movieObj.getActor().get(j));
                            //}

                        }
                    }
                }catch(big.data.DataInstantiationException e){
                    System.out.println("Movie not found");
                }
            }else if (user.equals("D") || user.equals("d")) {
                try {
                    System.out.println("Please enter the movie title to be deleted: ");
                    String movieName = s.nextLine();
                    String prefix = "http://www.omdbapi.com/?t=";
                    ///title=sc.nextLine();
                    String postfix = "&y=&plot=short&r=xml";
                    if (movieName.length() > 0) {
                        DataSource ds = DataSource.connectXML(prefix +
                                movieName.replace(' ', '+') + postfix);
                        ds.load();
                        Movie movieObj = new Movie(ds.fetchString(("movie/title")), ds.fetchInt("movie/year"));
                        String delMovie = movieObj.getTitle();
                        for (int i = 0; i < movieManager.getMovies().size(); i++) {
                            if (delMovie.equals(movieManager.getMovies().get(i).getTitle())) {
                                movieManager.getMovies().remove(i);
                            }
                        }
                        String trim = ds.fetchString("movie/actors").trim();
                        String splitting[] = ds.fetchString("movie/actors").split(", ");
                        for (int j = 0; j < splitting.length; j++) {
                            Actor actor3 = new Actor(splitting[j]);
                            if (movieManager.getActors().size() > 0) {
                                int sizeCounter = movieManager.getActors().size();
                                for (int k = 0; k < sizeCounter; k++) {
                                    if (movieManager.getActors().get(k).getName()
                                            .equals(actor3.getName())) {
                                        if (actor3.getCount() == 1) {
                                            movieManager.getActors().remove(k);
                                        } else {
                                            movieManager.getActors().get(k).setCount(actorCounter - 1);
                                        }
                                    }
                                }

                            }
                        }System.out.println(movieName + " deleted");
                    }
                }catch(big.data.DataInstantiationException e){
                    System.out.println("Movie not found");
                }
                } else if (user.equals("A") || user.equals("a")) {
                    System.out.println("Actor Sorting Options:\n");
                    System.out.println("\tAA) Alphabetically Ascending");
                    System.out.println("\tAD) Alphabetically Descending");
                    System.out.println("\tNA) By Number of Movies They Are In Ascending");
                    System.out.println("\tND) By Number of Movies They Are In");

                    System.out.println("Please Select A Sort Method: ");
                    user = s.nextLine();

                    if (user.equals("AA") || user.equals("aa")) {
                        movieManager.getSortedActors(new NameComparator());
                        System.out.println(movieManager.toStringActor());
                    } else if (user.equals("AD") || user.equals("ad")) {
                        movieManager.getSortedActorsReverse(new NameComparator());
                        System.out.println(movieManager.toStringActor());
                    } else if (user.equals("NA") || user.equals("na")) {
                        movieManager.getSortedActors(new CountComparator());
                        System.out.println(movieManager.toStringActor());
                    } else if (user.equals("ND") || user.equals("nd")) {
                        movieManager.getSortedActorsReverse(new CountComparator());
                        System.out.println(movieManager.toStringActor());
                    } else {
                        System.out.println("please enter a valid input");
                        user = s.nextLine();
                    }

                } else if (user.equals("M") || user.equals("m")) {
                    System.out.println("Movie Sorting Options:\n");
                    System.out.println("\tTA) Title Ascending (A-Z)");
                    System.out.println("\tTD) Title Descending (Z-A)");
                    System.out.println("\tYA) Year Ascending");
                    System.out.println("\tYD) Year Descending");

                    System.out.println("Please Select A Sort Method: ");
                    user = s.nextLine();

                    if (user.equals("TA") || user.equals("ta")) {
                        movieManager.getSortedMovies(new TitleComparator());

                        System.out.println(movieManager.toStringMovie());
                    }else if (user.equals("TD") || user.equals("td")) {
                        movieManager.getSortedMoviesReverse(new TitleComparator());
                        System.out.println(movieManager.toStringMovie());
                    }else if (user.equals("YA") || user.equals("ya")) {
                        movieManager.getSortedMovies(new YearComparator());
                        System.out.println(movieManager.toStringMovie());
                    }else if (user.equals("YD") || user.equals("yd")) {
                        movieManager.getSortedMoviesReverse(new YearComparator());
                        System.out.println(movieManager.toStringMovie());
                    }else {
                        System.out.println("please enter a valid input");
                        user = s.nextLine();
                    }

                } else if (user.equals("Q") || user.equals("q")) {
                    System.out.println("Thanks for using");
                    done=false;
                } else {
                    System.out.println("please enter a valid input");
                    user = s.nextLine();
                }

        }

    }
}
