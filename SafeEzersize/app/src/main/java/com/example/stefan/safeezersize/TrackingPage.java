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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TrackingPage extends AppCompatActivity {
    private SensorManager mSensorManager;
    private Sensor accel;

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
    }



}