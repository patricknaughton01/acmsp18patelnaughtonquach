package com.example.stefan.safeezersize;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.Nullable;

public class AccelListener extends IntentService implements SensorEventListener {
    private Sensor accel;
    private SensorManager mSensorManager;
    private final float thresholdValue = 10;
    private boolean isAbove = false;


    public AccelListener() {
        super("Accel Listener");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accel = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this,accel,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        for(int i=0; i<3; i++) {
            if(Math.abs(event.values[i]-9.8)>thresholdValue) {
                //Send request to SafeTrek
                isAbove = true;
                new AlertRequest().execute();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public boolean getIsAbove() {
        return isAbove;
    }

    public void resetIsAbove() {
        isAbove = false;
    }
}
