package com.example.luisb.petagramplus.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luisb.petagramplus.R;
import com.example.luisb.petagramplus.db.ConstructorMascotas;
import com.example.luisb.petagramplus.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by luisb on 17/07/2017.
 */

//Infla el layout y lo pasa al view holder para que obtenga las views
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;//array de nuestros datos
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //declaramos el cardview en una vista para inflarlo luego
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    /*vamos a pasar los elementos de nuestro objeto a la vista (los asocia a sus
    respectivos views nuestros elementos)*/
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {

        //se invoca uno a uno de los elementos u objetos
        final Mascota mascota = mascotas.get(position);

        //vamos a 'setear' los elementos
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        //click sobre el huesito
        mascotaViewHolder.imgHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "¡Un Like para " + mascota.getNombre() + "!", Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);

                mascotaViewHolder.tvLikes.setText(String.valueOf(constructorMascotas.obtenerLikesContacto(mascota)));
            }
        });

    }//---Fin onBindViewHolder

    @Override
    /*Cantidad de elementos que contiene nuestra lista*/
    public int getItemCount() {
        return mascotas.size();
    }

    /*crearemos un viewholder que ayudara a crear los objetos y asociarlos*/
    /*vamos a darle vida a nuestros views, para motrarlos*/
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvNombre;
        private TextView tvLikes;
        private ImageView imgHueso;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgMascota  = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombre);
            tvLikes  = (TextView) itemView.findViewById(R.id.tvLikes);
            imgHueso = (ImageView) itemView.findViewById(R.id.imgHueso);
        }

    }
}
