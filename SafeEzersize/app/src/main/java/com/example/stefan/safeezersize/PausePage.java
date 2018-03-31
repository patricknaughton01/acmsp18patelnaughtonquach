package com.example.stefan.safeezersize;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PausePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause_page);

        Button resumeButton = findViewById(R.id.resume);
        Button stopButton = findViewById(R.id.stop);

        resumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resume();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchStopScreen();
            }
        });

    }

    private void resume(){
        finish();
    }

    private void launchStopScreen(){
        Intent intent = new Intent(this, StopPage.class);
        startActivity(intent);
        finish();
    }
}
