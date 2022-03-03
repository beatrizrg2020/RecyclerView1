 package com.example.mismascotasperritos;

import android.app.Activity;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

 public class AdaptadorMascotas extends
        RecyclerView.Adapter<AdaptadorMascotas.ViewHolderMascotas> {

    ArrayList<MascotasVo>mascotasVos;
    Menu menu;
    Activity activity;


    public AdaptadorMascotas(ArrayList<MascotasVo> mascotasVos,Activity activity) {
        this.mascotasVos = mascotasVos;
        this.activity=activity;


    }

     public AdaptadorMascotas() {

     }

     public static class ViewHolderMascotas extends RecyclerView.ViewHolder {
       private TextView tvNombreCV;
        ImageView imgFotoCV;
        ImageButton btnAumentarLikes;
        TextView tvLikesCv;



        public ViewHolderMascotas(@NonNull View itemView) {
            super(itemView);
            tvNombreCV=(TextView)itemView.findViewById(R.id.tvNombreCV);
            imgFotoCV=(ImageView)itemView.findViewById(R.id.imgFotoCV);
            btnAumentarLikes=(ImageButton)itemView.findViewById(R.id.btnAumentarLikes);
            tvLikesCv=(TextView)itemView.findViewById(R.id.tvLikesCv);



        }
    }

    @NonNull
    @Override
    public ViewHolderMascotas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascotas,parent,false);

        return new ViewHolderMascotas(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMascotas viewHolderMascotas, int position) {

        final MascotasVo mascotasVo = mascotasVos.get(position);

        viewHolderMascotas.imgFotoCV.setImageResource(mascotasVo.getFoto());
        viewHolderMascotas.tvNombreCV.setText(mascotasVo.getNombre());
        viewHolderMascotas.btnAumentarLikes.setImageResource(mascotasVo.getLikes());
        viewHolderMascotas.tvLikesCv.setText("" + mascotasVo.getLikes());


        viewHolderMascotas.btnAumentarLikes.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                int contarLikes = mascotasVo.getLikes();
                ++contarLikes;
                mascotasVo.setLikes(contarLikes);
                mascotasVos.get(position).setLikes(contarLikes);
                viewHolderMascotas.tvLikesCv.setText("" + mascotasVo.getLikes());//muestra el numero de likes en el textView


                Toast.makeText(activity, "DISTE LIKE  " + mascotasVo.getNombre() + mascotasVo.getLikes(), Toast.LENGTH_SHORT).show();


            }
        });

        viewHolderMascotas.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(activity, mascotasVo.getNombre(), Toast.LENGTH_SHORT).show();

                  Intent intent = new Intent(activity, DetalleMascota.class);//mejora intent

                    intent.putExtra("nombre", mascotasVo.getNombre());
                    intent.putExtra("foto", mascotasVo.getFoto());
                    intent.putExtra("likes", mascotasVo.getLikes());

                    activity.startActivity(intent);


            }
        });





        //NUEVO CODIGO

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




        }


    @Override
    public int getItemCount() {
        return mascotasVos.size();
    }



    
}
