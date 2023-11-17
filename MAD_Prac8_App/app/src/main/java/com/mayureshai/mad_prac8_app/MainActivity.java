package com.mayureshai.mad_prac8_app;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorMgr;
    private TextView mLightTxt;
    private Sensor mLight;
    private ConstraintLayout mLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get an instance of the sensor service, and use that to get an instance of
        mSensorMgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorMgr.getDefaultSensor(Sensor.TYPE_LIGHT);
        // Get an instance of the layout view
        mLayout = (ConstraintLayout) findViewById(R.id.layout);
        mLightTxt = (TextView) findViewById(R.id.indicator);
        brightness(Color.BLACK, Color.WHITE, "0");
    }

    private void brightness(int bground, int txt, String lux) {
        mLayout.setBackgroundColor(bground);
        mLightTxt.setBackgroundColor(bground);
        mLightTxt.setTextColor(txt);
        mLightTxt.setText(lux);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // The light sensor returns one value, which is the ambient light level in SI lux units
        float lux = event.values[0];
        if (lux < 10) {
            brightness(Color.WHITE, Color.BLACK, "Light intensity is low: "+String.valueOf(lux));
        } else if (lux < 100) {
            brightness(Color.GRAY, Color.BLACK, "Light intensity is slightly medium: "+String.valueOf(lux));
        } else if (lux < 1000) {
            brightness(Color.DKGRAY, Color.WHITE, "Light intensity is nearly high: "+String.valueOf(lux));
        } else {
            brightness(Color.BLACK, Color.WHITE, "Light intensity is too high: "+String.valueOf(lux));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
            super.onResume();
            mSensorMgr.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
            }

    @Override
    protected void onPause() {
            super.onPause();
            mSensorMgr.unregisterListener(this);
    }
}