package br.edu.utfpr.listasensores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterSensor extends ArrayAdapter<MySensor> {

    private List<MySensor> mySensorList;

    public AdapterSensor(@NonNull Context context, List<MySensor> sensores) {
        super(context, -1, sensores);
        this.mySensorList = sensores;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext(
            ).getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.card_sensor, parent, false);

        TextView txtDescricaoSensor = row.findViewById(R.id.txt_Descricao);
        ImageView imgSensor = row.findViewById(R.id.img_Imagem);

        txtDescricaoSensor.setText(mySensorList.get(position).getDescricao());
        imgSensor.setImageResource(getImagem(mySensorList.get(position)));

        return row;
    }

    private int getImagem(MySensor mySensor) {
        switch (mySensor.getNomeImage()) {
           case "magnometro" : return R.drawable.magnometro;
           case "giroscopio" : return R.drawable.giroscopio;
           case "acelerometro" : return R.drawable.acelerometro;
           default: return R.drawable.cam;
        }
    }


}
