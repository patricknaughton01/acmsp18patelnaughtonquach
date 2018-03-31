package com.example.stefan.safeezersize;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class TrackingPage extends AppCompatActivity {
    private SensorManager mSensorManager;
    private Sensor accel;
    Chronometer chronometer;
    private long stopTime=0;

//    LocationManager locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//
//    LocationListener locListener = new LocationListener() {
//        @Override
//        public void onLocationChanged(Location location) {
//            makeUseOfNewLocation(location);
//        }
//
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras) {}
//
//        @Override
//        public void onProviderEnabled(String provider) {}
//
//        @Override
//        public void onProviderDisabled(String provider) {}
//    };
//    locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locListener);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_page);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accel = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        Intent mServiceIntent = new Intent(TrackingPage.this
                , AccelListener.class);
        startService(mServiceIntent);
  
        Button pauseButton = findViewById(R.id.pause);
        Button stopButton = findViewById(R.id.stop);

        chronometer = (Chronometer)findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime()+stopTime);
        chronometer.start();
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                stopTime = SystemClock.elapsedRealtime();
                launchPauseScreen();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                stopTime = SystemClock.elapsedRealtime();
                launchStopScreen();
            }
        });
    }

    private void launchPauseScreen(){
        Intent intent = new Intent(this, PausePage.class);
        startActivity(intent);
    }

    private void launchStopScreen(){
        Intent intent = new Intent(this, StopPage.class);
        startActivity(intent);
        finish();
    }

    public long getStopTime() {
        return stopTime;
    }

}