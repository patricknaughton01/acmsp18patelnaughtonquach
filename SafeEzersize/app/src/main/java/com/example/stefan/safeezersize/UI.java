package vppatel.wustl.edu.acm18uiexperiment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class UI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        // Bind this button with the button found in activity_ui.xml with android:id="@+id/clickMe"
        Button clickMeButton = findViewById(R.id.clickMe);

        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Intent is how you create an Android activity since you can't just "new" one up
                Intent nextPageIntent = new Intent(UI.this, Page2Activity.class);
                // pass in a String parameter using a public static variable on the Page2Activity class
                nextPageIntent.putExtra(Page2Activity.EXTRA_VALUE_TO_SHOW, "This value came from UI");

                // kick off the activity
                startActivity(nextPageIntent);
            }
        });
    }
}
