package ca.ualberta.cs.lonelytwitter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


/**
 *
 */

public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        if(!tweets.contains(tweet)) {
            tweets.add(tweet);
        }
        else {
            throw new IllegalArgumentException();
        }

    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public TweetList getTweets() {

        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t1.getDate().compareTo(t2.getDate());
            }
        });

        return this;
    }

    public int getCount() {
        return tweets.size();
    }

}
