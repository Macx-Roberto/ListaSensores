package br.edu.utfpr.listasensores;

import android.os.Parcel;
import android.os.Parcelable;

public class MySensor implements Parcelable {

    private String descricao;
    private String nomeImage;
    private int typeSensor;

    public MySensor(String descricao, String nomeImage, int typeSensor) {
        this.descricao = descricao;
        this.nomeImage = nomeImage;
        this.typeSensor = typeSensor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTypeSensor() {
        return typeSensor;
    }

    public void setTypeSensor(int typeSensor) {
        this.typeSensor = typeSensor;
    }

    public String getNomeImage() {
        return nomeImage;
    }

    public void setNomeImage(String nomeImage) {
        this.nomeImage = nomeImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(typeSensor);
        parcel.writeString(descricao);
        parcel.writeString(nomeImage);
    }
}
