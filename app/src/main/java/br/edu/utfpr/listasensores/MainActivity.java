package br.edu.utfpr.listasensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvSensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSensores = findViewById(R.id.lvSensores);
        AdapterSensor adapter = new AdapterSensor(getApplicationContext(), getSensores());
        lvSensores.setAdapter(adapter);

        lvSensores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            getSensores().get(i);
            Intent intent = new Intent(MainActivity.this, ExibirSensorActivity.class);
            intent.putExtra("id", getSensores().get(i).getTypeSensor());
            startActivity(intent);
            }
        });
    }

    private List<MySensor> getSensores() {
        List<MySensor> sensores = new ArrayList<>();
        sensores.add(new MySensor("Magnetômetro", "magnometro", android.hardware.Sensor.TYPE_MAGNETIC_FIELD));
        sensores.add(new MySensor("Giroscópio", "giroscopio", android.hardware.Sensor.TYPE_GYROSCOPE));
        sensores.add(new MySensor("Acelerômetro", "acelerometro", android.hardware.Sensor.TYPE_ACCELEROMETER));
        return sensores;
    }


}
