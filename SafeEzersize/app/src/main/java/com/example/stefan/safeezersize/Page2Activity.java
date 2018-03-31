package vppatel.wustl.edu.acm18uiexperiment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Page2Activity extends AppCompatActivity {

    // A key to use for defining variables we'll pass into this Activity when we create it
    public static String EXTRA_VALUE_TO_SHOW = "EXTRA_VALUE_TO_SHOW";

    private TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        // Bind this text view with the text view found in activity_page2.xml with android:id="@+id/responseText"

        responseTextView = findViewById(R.id.responseText);
    }

    // onResume is an entry point that gets called by the Android framework any time this activity
    // newly becomes visible to the user.  Look up Android Activity Lifecycle for more info

    @Override
    public void onResume() {
        super.onResume();

        // get the intent used to start this activity and grab the parameter that was passed in

        Intent ourIntent = getIntent();
        // we knew this value was a string so we have to use getStringExtra, if it weren't a string
        // it'd throw an exception and crash the app
        String valueToShow = ourIntent.getStringExtra(EXTRA_VALUE_TO_SHOW);

        // now that we've plucked the value out, tell the text view to show it
        responseTextView.setText(valueToShow);
    }
}