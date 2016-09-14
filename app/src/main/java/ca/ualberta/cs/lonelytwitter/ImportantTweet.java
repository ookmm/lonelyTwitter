package ca.ualberta.cs.lonelytwitter;

/**
 * Created by ookmm on 16-09-13.
 */
public class ImportantTweet extends Tweet {

    public ImportantTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

}
