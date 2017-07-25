package com.example.rafaelsmartin.listview;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Rafael S Martin on 27/05/2017.
 * La clase itemLista crea un objeto con una immagen (entero para recogerlo con R.drawable)
 * y con un titulo en string con sus respectivos getters.
 */

public class ItemLista extends AppCompatActivity {

    private String titulo;
    private int imagen;

    public ItemLista(String tit, int img){
        titulo = tit;
        imagen = img;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getImagen(){
        return imagen;
    }

}
