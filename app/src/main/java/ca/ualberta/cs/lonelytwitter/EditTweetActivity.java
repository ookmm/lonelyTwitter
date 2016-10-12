package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        TextView passedTweetTView = (TextView) findViewById(R.id.passedTweetTextView);

        /*
        Intent intent = getIntent();
        String passedTweet = intent.getExtras().getString("Tweet clicked");

        passedTweetTView.setText(passedTweet);
        */
        Bundle bundle = getIntent().getExtras();
        String passedTweet = bundle.getString("Tweet clicked");
        passedTweetTView.setText(passedTweet);


    }
}
