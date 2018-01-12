/**
 * Richu Jacob
 * ID:110257792
 * Homework #7
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
import java.util.ArrayList;
import java.util.List;
import big.data.*;


public class Movie {
    /**
     * Field that holds the title of the movie.
     * Field that holds the year the movie was released.
     * Field that holds the list of actors who were in the movie, represented as actors.
     */
    private String title;
    private int year;
    private List<Actor> actor = new ArrayList<Actor>();

    /**
     * default constructor
     */
    public Movie(){

    }

    /**
     * Overloaded constructor for creating a
     * new movie with given details and an empty, non-null actors list.
     * @param title the title of movie
     * @param year year of the movie
     */
    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
        ArrayList<Actor> actor = new ArrayList<>();
        //System.out.print("Enter a movie title: ");
        //generate the webaddress for the movie
        String url = "http://www.omdbapi.com/?t=";
    }

    /**
     * Loads a movie from the passed URL
     * and makes a new Movieobject from it.
     * @param url url used to get movie from datasource
     */
    public Movie(String url){
        String postfix = "&y=&plot=short&r=xml";
        if (title.length() > 0) {
            DataSource ds = DataSource.connectXML(url + title.
                    replace(' ', '+') + postfix);
            ds.load();
        Movie movie = new Movie(ds.fetchString(("movie/title")), ds.fetchInt("movie/year"));
        }
    }

    /**
     * gets the title of the movie
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets the title of movie using param
     * @param title used to set title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * gets the year of movie
     * @return the movie
     */
    public int getYear() {
        return year;
    }

    /**
     * sets the year of movie using param
     * @param year used to set year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * gets the arraylist of actors
     * @return the actors list
     */
    public List<Actor> getActor() {
        return actor;
    }

    /**
     * sets the actors using param
     * @param actor used to value of actors
     */
    public void setActor(List<Actor> actor) {
        this.actor = actor;
    }








}
