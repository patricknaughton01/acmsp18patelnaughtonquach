package com.example.stefan.safeezersize;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TrackingPage extends AppCompatActivity implements SensorEventListener{
    private SensorManager mSensorManager;
    private Sensor accel;
    private final float thresholdValue = 10;

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
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        boolean sendRequestAccel = false;
        for(int i=0 ; i<3; i++) {
            if (event.values[i] > this.thresholdValue){
                sendRequestAccel = true;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //do something when accuracy changes
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }