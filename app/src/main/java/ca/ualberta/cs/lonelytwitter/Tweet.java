package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by grandmanitou on 16-09-13.
 */
public abstract class Tweet {
    private String message;
    private Date date;

    // Constructor
    public Tweet(String message) {
         this.message = message;
    }

    //Constructor
    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant();

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            // Do something
            throw new TweetTooLongException();

        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
