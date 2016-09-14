package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ookmm on 16-09-13.
 */
public class Thoughtful extends CurrentMood {

    public Thoughtful(String mood) {
        super(mood);
    }

    public Thoughtful(String mood, Date date) {
        super(mood, date);
    }

    public String formatMood () {
        return "Thoughtful face";
    }
}
