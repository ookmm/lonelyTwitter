package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import java.util.concurrent.TimeUnit;
/**
 *
 */

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();

        //assertTrue(false);

        Tweet tweet = new NormalTweet("Hello!");
        list.add(tweet);

        try {
            list.add(tweet);
            fail();
        }
        catch(IllegalArgumentException e){
            System.out.println("Tweet already added");
        }
        assertTrue(list.hasTweet(tweet));

    }

    public void testHasTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello");
        Tweet b = new NormalTweet("Hi");

        list.add(a);
        list.add(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    public void testGetTweets() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Tweet b = new NormalTweet("Hi");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Tweet c = new NormalTweet("Goodbye!");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list.add(a);
        list.add(c);
        list.add(b);

        TweetList orderedList = new TweetList();

        orderedList = list.getTweets();

        assertTrue("Not the same", orderedList.getTweet(0) == a);
        assertTrue("Not the same", orderedList.getTweet(1) == b);
        assertTrue("Not the same", orderedList.getTweet(2) == c);
    }

    public void testGetCount() {

        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello");
        Tweet b = new NormalTweet("Hi");
        Tweet c = new NormalTweet("Bye!");

        list.add(a);
        list.add(b);
        list.add(c);

        assertTrue(list.getCount() == 3);

    }
}
