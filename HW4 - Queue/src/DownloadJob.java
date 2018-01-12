/**
 * Richu Jacob
 * ID:110257792
 * Homework #4
 * Recitation 01
 * TA: Charles Chen
 * Grading TA: Shilpi Bhattacharyya
 */
public class DownloadJob {
    /**
     * declares int downloadsize, downloadsizeremaining, timerequested,
     *  boolean ispremium and int id
     */
    private int downloadSize;
    private int downloadSizeRemaining;
    private int timeRequested;
    private boolean isPremium;
    private int id=1;

    /**
     * holds the value for each of the parameters
     * @param downloadSize has downloasize
     * @param downloadSizeRemaining has download size remaining
     * @param timeRequested has the time the job was requested
     * @param isPremium checks whether it is a premiuim or regular object
     * @param id checks the id of it
     */
    public DownloadJob(int downloadSize, int downloadSizeRemaining,
                       int timeRequested, boolean isPremium, int id){
        this.downloadSize=downloadSize;
        this.downloadSizeRemaining=downloadSizeRemaining;
        this.timeRequested=timeRequested;
        this.isPremium=isPremium;
        this.id=id;

    }

    /**
     * gets the downloadsize
     * @return downloadsize
     */
    public int getDownloadSize() {
        return downloadSize;
    }

    /**
     * sets the downloadsize
     * @param downloadSize can be set to something else
     */
    public void setDownloadSize(int downloadSize) {
        this.downloadSize = downloadSize;
    }

    /**
     * gets the downloadsize reamaining
     * @return download size remaining
     */
    public int getDownloadSizeRemaining() {
        return downloadSizeRemaining;
    }

    /**
     * sets the download size remaining
     * @param downloadSizeRemaining used to set the downloadsize remaining
     */
    public void setDownloadSizeRemaining(int downloadSizeRemaining) {
        this.downloadSizeRemaining = downloadSizeRemaining;
    }

    /**
     * gets the time requested
     * @return the time requested
     */
    public int getTimeRequested() {
        return timeRequested;
    }

    /**
     * sets the time requested
     * @param timeRequested used to set the time requested
     */
    public void setTimeRequested(int timeRequested) {
        this.timeRequested = timeRequested;
    }

    /**
     * checks if its premium or regular
     * @return true if premium false otherwise
     */
    public boolean isPremium() {
        return isPremium;
    }

    /**
     * sets the whether its premiuim or regular
     * @param premium used to set the download job object
     */
    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    /**
     * gets the id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id
     * @param id is used to set the id
     */
    public void setId(int id) {
        this.id = id;
    }
}
