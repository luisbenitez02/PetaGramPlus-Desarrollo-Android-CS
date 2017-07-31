package com.example.luisb.petagramplus.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luisb.petagramplus.R;
import com.example.luisb.petagramplus.pojo.MascotaPerfil;

import java.util.ArrayList;

/**
 * Created by luisb on 30/07/2017.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList<MascotaPerfil> perfilpet;

    public PerfilAdaptador(ArrayList<MascotaPerfil> perfilpet) {
        this.perfilpet = perfilpet;
    }


    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //declaramos el cardview en una vista para inflarlo luego
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pics_perfil, parent, false);

        return new PerfilViewHolder(v);
    }

    /*vamos a pasar los elementos de nuestro objeto a la vista (los asocia a sus
respectivos views nuestros elementos)*/
    @Override
    public void onBindViewHolder(PerfilViewHolder perfilViewHolder, int position) {
        //se invoca uno a uno de los elementos u objetos
        MascotaPerfil mipet = perfilpet.get(position);

        //vamos a setear nuestros items
        perfilViewHolder.imgPerfilMascota.setImageResource(mipet.getFoto());
        perfilViewHolder.tvPerfilContador.setText(String.valueOf(mipet.getLikes()));

    }


    @Override
    public int getItemCount() {
        return perfilpet.size();
    }

    /*crearemos un viewholder que ayudara a crear los objetos y asociarlos*/
    /*vamos a darle vida a nuestros views, para motrarlos*/
    public static class PerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPerfilMascota;
        private TextView tvPerfilContador;

        public PerfilViewHolder(View itemView) {
            super(itemView);

            imgPerfilMascota  = (ImageView) itemView.findViewById(R.id.imgPerfilPic);
            tvPerfilContador  = (TextView) itemView.findViewById(R.id.tvPerfilContador);
        }

    }

}
