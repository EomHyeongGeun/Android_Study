package my.kmu.com.sensors;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener{

    private SensorManager sm;
    private Sensor sensor_gravity, sensor_accelerometer, sensor_linear_acceleration, sensor_gyroscope;
    TextView gravityText, accelText, linearText, gyroText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        sensor_gravity             = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensor_accelerometer       = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor_linear_acceleration = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensor_gyroscope           = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        gravityText                = (TextView)findViewById(R.id.gravityText);
        accelText                  = (TextView)findViewById(R.id.accelText);
        linearText                 = (TextView)findViewById(R.id.linearText);
        gyroText                   = (TextView)findViewById(R.id.gyroText);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 센서 리스너에 등록
        sm.registerListener(this, sensor_gravity, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_linear_acceleration, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // 센서 리스너 해제
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch(event.sensor.getType()){
            case Sensor.TYPE_GRAVITY:
                gravityText.setText("X: "+ event.values[0]+ " Y: "+event.values[1]+" Z: "+event.values[2]);
                break;
            case Sensor.TYPE_ACCELEROMETER:
                accelText.setText("X: "+ event.values[0]+ " Y: "+event.values[1]+" Z: "+event.values[2]);
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                linearText.setText("X: "+ event.values[0]+ " Y: "+event.values[1]+" Z: "+event.values[2]);
                break;
            case Sensor.TYPE_GYROSCOPE:
                gyroText.setText("X: "+ event.values[0]+ " Y: "+event.values[1]+" Z: "+event.values[2]);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
