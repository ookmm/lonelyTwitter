package ca.ualberta.cs.lonelytwitter;

/**
 * The type Normal tweet.
 */
public class NormalTweet extends Tweet implements Tweetable {

    /**
     * This constructor makes a normalTweet with given string parameter.
     *
     * @param message this parameter is the given string for the tweet.
     */
    public NormalTweet(String message){
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
