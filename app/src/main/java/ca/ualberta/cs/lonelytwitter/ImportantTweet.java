package ca.ualberta.cs.lonelytwitter;

/**
 * Implements important tweets
 */
public class ImportantTweet extends Tweet {

    /**
     * Instantiates a new Important tweet.
     *
     * @param message
     */
    public ImportantTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

}
