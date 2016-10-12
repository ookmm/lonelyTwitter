/*
Copyright (c) 2016 CMPUT 301, University of Alberta - All Rights Reserved.
You may use, distribute, and copy all parts of this code under terms and conditions of
University of Alberta and the Code of Student Behaviour.
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This is the main view class of LonelyTwitter project. <p> It handles all user interactions
 * as well as file manipulations. </p>
 * <pre> All the files are stored in the form of "json" files stored in Emulator,
 * accessible from Android Device Monitor. </pre>
 * @since 1.0
 * @see NormalTweet
 * @author watts1
 */

public class LonelyTwitterActivity extends Activity {

    /**
     * This is the file that is being saved / loaded and contains all the tweets.
     * @see #loadFromFile()
     * @see #saveInFile()
     */
	private Activity activity = this;

	private static final String FILE_NAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	public ListView getOldTweetsList() {
		return oldTweetsList;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        // Implement Save button
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet newTweet = new NormalTweet(text);

				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});

        // Implement Clear button
        clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                setResult(RESULT_OK);
                tweetList.clear();
                adapter.notifyDataSetChanged();

                saveInFile();

            }

        });

        oldTweetsList.setOnItemClickListener(new
                         AdapterView.OnItemClickListener(){
                             public void onItemClick(AdapterView<?> parent, View view,
                                                     int position ,long id){
                                 Intent intent = new Intent(activity, EditTweetActivity.class);
                                 Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(position);
                                 intent.putExtra("Tweet clicked", tweet.getMessage() );
                                 startActivity(intent);
                             }

                         });
	}

    /**
     * Set up ArrayAdapter to display tweets
     */
	@Override
	protected void onStart() {

		super.onStart();
        loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * Loads the tweets from FILE_NAME (file.sav)
     * @throws FileNotFoundException
     * @exception RuntimeException
     */
    private void loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILE_NAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

            tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
            tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
            throw  new RuntimeException();
		}

	}

    /**
     * Saves tweets to FILE_NAME (file.sav)
     */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILE_NAME, 0);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();;

			fos.close();
		} catch (FileNotFoundException e) {
			throw  new RuntimeException();
		} catch (IOException e) {
            throw  new RuntimeException();
		}
	}

}