/**
 * Richu Jacob
 * ID:110257792
 * Homework #7
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class MovieManager {
    /**
     * Field that holds all movies handled by this MovieManager.
     * Field that holds all actors handled by this MovieManager.
     */
    private List<Movie> movies = new ArrayList<Movie>();
    private List<Actor> actors = new ArrayList<Actor>();
    //MovieManager movieManager = new MovieManager();
    /**
     * Constructs a MovieManager object with an empty, non-null actors and movies list.
     */
    public MovieManager(){
        ArrayList<Actor> actor = new ArrayList<>();
    }

    /**
     * gets the movies list held by this MovieManager.
     * @return the movies
     */
    public List<Movie> getMovies(){
        return movies;
    }

    /**
     * gets the actors list held by this MovieManager.
     * @return the actors
     */
    public List<Actor> getActors(){
        return actors;
    }

    /**
     * gets a sorted list of movies using yearComparator
     * @param comp used to sort
     * @return the sorted movie list
     */
    public List<Movie> getSortedMovies(YearComparator comp){
        Collections.sort((List)movies, comp);
        return movies;
    }

    /**
     * Reverses the list of movies
     * gets a sorted list of movies using yearComparator
     * @param comp used to sort
     * @return the sorted movie list
     */
    public List<Movie> getSortedMoviesReverse(YearComparator comp){
        Collections.reverseOrder();
        Collections.sort((List)movies, comp);
        return movies;
    }

    /**
     * gets a sorted list of movies using titleComparator
     * @param comp used to sort
     * @return the sorted movie list
     */
    public List<Movie> getSortedMovies(TitleComparator comp){
        Collections.sort((List)movies, comp);
        return movies;
    }

    /**
     * Reverses the list of movies
     * gets a sorted list of movies using titleComparator
     * @param comp used to sort
     * @return the sorted movie list
     */
    public List<Movie> getSortedMoviesReverse(TitleComparator comp){
        Collections.reverseOrder();
        Collections.sort((List)movies, comp);
        return movies;
    }

    /**
     * gets a sorted list of actors using NameComparator
     * @param comp used to sort
     * @return the sorted actor list
     */
    public List<Actor> getSortedActors(NameComparator comp){
        Collections.sort((List)actors, comp);
        return actors;
    }

    /**
     * Reverses the list of actors
     * gets a sorted list of actors using NameComparator
     * @param comp used to sort
     * @return the sorted actor list
     */
    public List<Actor> getSortedActorsReverse(NameComparator comp){
        Collections.reverseOrder();
        Collections.sort((List)actors, comp);
        return actors;
    }

    /**
     * gets a sorted list of actors using CountComparator
     * @param comp used to sort
     * @return the sorted actor list
     */
    public List<Actor> getSortedActors(CountComparator comp){
        Collections.sort((List)actors, comp);
        return actors;
    }

    /**
     * Reverses the list of actors
     * gets a sorted list of actors using CountComparator
     * @param comp used to sort
     * @return the sorted actor list
     */
    public List<Actor> getSortedActorsReverse(CountComparator comp){
        Collections.reverseOrder();
        Collections.sort((List)actors, comp);
        return actors;
    }

    /**
     * checks if user input movie is already there in list
     * @param movie input of user
     * @return true if equal
     */
    public boolean equals(String movie) {
        for (int i = 0; i < movies.size(); i++) {
            if (movie.equals(movies.get(i).getTitle())) {
                return true;
            }
        }return false;
    }

    /**
     * adds a movie object to a arraylist
     * @param movie the object being added
     */
    public void addMovie(Movie movie){
        movies.add(movie);
    }

    /**
     * adds a actor object to a arraylist
     * @param actor the object being added
     */
    public void addActor(Actor actor){
        actors.add(actor);
    }

    /**
     * string method that returns the table of list of movieobjects
     * @return the string
     */
    public String toStringMovie(){
        String title = "";
        int year = 0;

        String notDynamic = "Title                           Year    Actors                        \n" +
                "----------------------------------------------------------------------------------------- \n";
        String var="";

        for(int i=0; i<movies.size(); i++){
            var += String.format("%-32s%-7d", movies.get(i).getTitle(), movies.get(i).getYear());
                //for(int j=0; j<actors.size(); j++){
                for(int j=0; j<movies.get(i).getActor().size(); j++) {
                    var += movies.get(i).getActor().get(j).getName() + ", ";

                }var+="\n";
                }

        return notDynamic+var;
    }

    /**
     * string method that returns the table of list of actorobjects
     * @return the string
     */
    public String toStringActor(){
        String actor = "";

        String notDynamic = "Actor                          Number of Movies                       \n" +
                "----------------------------------------------------------------------------------------- \n";
        String var="";
        for(int i=0; i<actors.size(); i++){
            var += String.format("%-30s%-27d", actors.get(i).getName(), actors.get(i).getCount());
            var+="\n";
        }return notDynamic+var;
    }

    /**
     * a contains to check if a actor object is in the arraylist
     * @param obj that is used to check
     * @return true if it does contain param
     */
    public boolean contains(Actor obj){
        for(int i=0; i<actors.size();i++){
            if(actors.get(i).getName().equals(obj.getName())) {
                return true;
            }
        }return false;
    }

    /**
     * gets the actor by name using a string actor
     * @param actor used to get the actor
     * @return returns actor object if it contains string
     */
    public Actor getActorByName(String actor){
        for(int i=0; i<actors.size();i++){
            if(this.getActors().get(i).getName().equals(actor)){
                return this.getActors().get(i);
            }
        }return null;
    }
}
