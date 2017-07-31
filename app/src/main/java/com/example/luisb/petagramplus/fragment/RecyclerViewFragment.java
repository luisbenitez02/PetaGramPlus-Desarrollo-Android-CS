package com.example.luisb.petagramplus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luisb.petagramplus.R;
import com.example.luisb.petagramplus.adaptador.MascotaAdaptador;
import com.example.luisb.petagramplus.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by luisb on 27/07/2017.
 */

public class RecyclerViewFragment extends Fragment{

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Creamos un view y lo inflamos con nuestro fragment (se comportara como contenedor)
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);//ahora buscamos en esta vista

        //mostramos elementos del recyclerview en una lista
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);//le entrego el layout a mi lista

        inicializarListaMascotas();

        inicializarAdaptador();

        return v;
    }

    public  void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(adaptador);
    }

    /*llenado de nuestros objetos mascota*/
    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Katty","5",R.drawable.pet1));
        mascotas.add(new Mascota("Lola","4",R.drawable.pet9));
        mascotas.add(new Mascota("Pepita","10",R.drawable.pet7));
        mascotas.add(new Mascota("Paco","2",R.drawable.pet5));
        mascotas.add(new Mascota("Redd","15",R.drawable.pet10));
        mascotas.add(new Mascota("Max","8",R.drawable.pet8));
        mascotas.add(new Mascota("Vaquishu","6",R.drawable.pet4));
        mascotas.add(new Mascota("Maite","11",R.drawable.pet6));
        mascotas.add(new Mascota("Pirlo","9",R.drawable.pet2));
        mascotas.add(new Mascota("Dani","12",R.drawable.pet3));
        mascotas.add(new Mascota("Yaya","28",R.drawable.pet11));

    }
}
