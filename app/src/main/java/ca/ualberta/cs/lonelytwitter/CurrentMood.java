package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

/**
 * Created by ookmm on 16-09-13.
 */
public abstract class CurrentMood {

    private String mood;
    private Date date;

    public CurrentMood(String mood) {
        this.mood = mood;
        this.date = new Date();
    }

    public CurrentMood (String mood, Date date) {
        this.mood = mood;
        this.date = date;
    }

    public String getMood() {
        return mood;
    }

    public Date getDate() {
        return date;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String formatMood();
}
