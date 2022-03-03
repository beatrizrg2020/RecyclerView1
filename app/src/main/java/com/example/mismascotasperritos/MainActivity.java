package com.example.mismascotasperritos;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity   {
    ArrayList<MascotasVo>mascotasVos;
    private RecyclerView rvMascotas;

    Activity activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotas=(RecyclerView)findViewById(R.id.rvMascotas);
       LinearLayoutManager llm=new LinearLayoutManager(this);
        rvMascotas.setLayoutManager(llm);
        llenarLista();
        inicializarAdaptador();




    }



    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
       inflater.inflate(R.menu.menu_opciones,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mContacto:

                Intent intent=new Intent(getApplicationContext(),Contacto.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), "menu contacto", LENGTH_SHORT).show();
                return true;

        }
        switch (item.getItemId()) {

            case R.id.mAcercaD:
                Intent i=new Intent(getApplicationContext(),AcercaD.class);
                startActivity(i);
                //Toast.makeText(getApplicationContext(), "menu Acerca d", LENGTH_SHORT).show();
              return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void inicializarAdaptador() {
        AdaptadorMascotas adaptadorMascotas=new AdaptadorMascotas(mascotasVos,this);
        rvMascotas.setAdapter(adaptadorMascotas);

    }

    private void llenarLista() { //metodo llenar lista

        mascotasVos=new ArrayList<MascotasVo>();

        mascotasVos.add(new MascotasVo("Toby",0,R.drawable.perrito1));
        mascotasVos.add(new MascotasVo("Sol",0,R.drawable.perrito2));
        mascotasVos.add(new MascotasVo("Zeus",0,R.drawable.perrito3));
        mascotasVos.add(new MascotasVo("Luna",0,R.drawable.perrito4));
        mascotasVos.add(new MascotasVo("Estrella",0,R.drawable.perrito5));
        mascotasVos.add(new MascotasVo("Tony",0,R.drawable.perrito6));
        mascotasVos.add(new MascotasVo("Ciprix",0,R.drawable.perrito7));
        mascotasVos.add(new MascotasVo("Yerry",0,R.drawable.perrito8));


    }

    public void mostrarFavoritos(View view){

        Intent intent=new Intent(MainActivity.this,MascotasFavoritas.class);
        startActivity(intent);

    }



    // private void ordenarLista(){

        //Toast.makeText(activity,"estrella", LENGTH_SHORT).show();

       /* Collections.sort(mascotasVos, new Comparator<MascotasVo>() {

            @Override
            public int compare(MascotasVo vo1, MascotasVo vo2) {
                return Integer.valueOf(vo2.getLikes()).compareTo(Integer.valueOf(vo1.getLikes()));
            }
        });


        ArrayList<MascotasVo> mascotasfavoritas = new ArrayList<>();


        for (MascotasVo elemento : mascotasVos) {

            System.out.println("hola" + elemento);

            mascotasfavoritas.add(elemento);
        }


            for (MascotasVo favoritas : mascotasfavoritas) {

            }*/
   // }//fin metodo ordenarLista





}