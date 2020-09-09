package br.edu.utfpr.listasensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ExibirSensorActivity extends AppCompatActivity
implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;

    private TextView tvx;
    private TextView tvY;
    private TextView tvZ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_sensor);
        tvx = findViewById(R.id.tvX);
        tvY = findViewById(R.id.tvY);
        tvZ = findViewById(R.id.tvZ);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(getIntent().getExtras().getInt("id"));

        sensorManager.registerListener(
                this, sensor, SensorManager.SENSOR_DELAY_NORMAL
        );
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        double x = event.values[0];
        double y = event.values[1];
        double z = event.values[2];

        tvx.setText(String.valueOf(x));
        tvY.setText(String.valueOf(y));
        tvZ.setText(String.valueOf(z));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
