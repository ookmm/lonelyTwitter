package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Implements Tweet list class.
 */
public class TweetList {
    /**
     * Create a list to contain all the tweets.
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Add tweet to tweet list if it is not already there.
     *
     * @param tweet the tweet
     */
    public void add(Tweet tweet) {
        if(!tweets.contains(tweet)) {
            tweets.add(tweet);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Has tweet boolean.
     *
     * @param tweet the tweet
     * @return the boolean if it contains or not
     */
    public boolean hasTweet(Tweet tweet) {

        return tweets.contains(tweet);
    }

    /**
     * Gets tweet.
     *
     * @param i the location of the tweet
     * @return the tweet
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Gets tweets from tweet list
     *
     * @return the tweets in order by date
     */
    public TweetList getTweets() {

        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t1.getDate().compareTo(t2.getDate());
            }
        });

        return this;
    }

    /**
     * Gets the number of tweets inside the tweet list
     *
     * @return the count
     */
    public int getCount() {

        return tweets.size();
    }

}
