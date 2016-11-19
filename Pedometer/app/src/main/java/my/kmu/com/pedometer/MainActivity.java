package my.kmu.com.pedometer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.attr.gravity;

public class MainActivity extends Activity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mAcce;
    TextView tv_count, tv_accel;
    double acceleration;
    int count;
    int dir_UP ,dir_DOWN;
    double gravity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAcce          = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        tv_count       = (TextView)findViewById(R.id.tv_count);
        tv_accel       = (TextView)findViewById(R.id.tv_accel);

        dir_UP = 0;
        dir_DOWN = 0;
        count = 0;
        gravity = 9.81;
    }

    @Override
    protected void onResume() {
        super.onResume();

        mSensorManager.registerListener(this, mAcce, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            acceleration = Math.sqrt(x * x + y * y + z * z);
            tv_accel.setText("Current Acceleration : " + acceleration);
        }

        if(acceleration - gravity > 5){
            dir_UP = 1;
        }
        if(dir_UP == 1 && gravity - acceleration > 5){
            dir_DOWN = 1;
        }
        if(dir_DOWN == 1){
            count++;
            tv_count.setText("Step Count : " + count);

            dir_UP = 0;
            dir_DOWN = 0;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
