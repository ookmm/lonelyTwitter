package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ookmm on 16-09-13.
 */
public class Happy extends CurrentMood {

    public Happy(String mood) {
        super(mood);
    }

    public Happy(String mood, Date date) {
        super(mood, date);
    }

    public String formatMood () {
        return "Smiley face";
    }
}
