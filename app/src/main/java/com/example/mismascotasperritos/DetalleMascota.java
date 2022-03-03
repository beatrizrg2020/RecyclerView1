package com.example.mismascotasperritos;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetalleMascota extends AppCompatActivity {
    TextView tvnombre,tvLikesCv;
    ImageView tvfoto;
    ImageButton btnAumentarLikes;
    Toolbar miactionBar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_mascotas);

       // Toolbar miactionBar1=(Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miactionBar1);



        Bundle parametros=getIntent().getExtras();

        String nombre=parametros.getString("nombre");
        int foto=parametros.getInt("foto");
        int likes=parametros.getInt("likes");

        tvfoto=(ImageView)findViewById(R.id.imgFotoCV);
        tvnombre=(TextView) findViewById(R.id.tvNombreCV);
        btnAumentarLikes=(ImageButton) findViewById(R.id.btnAumentarLikes);
        tvLikesCv=(TextView)findViewById(R.id.tvLikesCv);


        tvnombre.setText(nombre);
        tvfoto.setImageResource(foto);
        tvLikesCv.setText(""+likes);


    }




}