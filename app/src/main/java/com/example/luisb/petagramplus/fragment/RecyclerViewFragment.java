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
import com.example.luisb.petagramplus.presentador.IRecyclerViewFragmentPresenter;
import com.example.luisb.petagramplus.presentador.RecyclerViewFragmentPresentador;

import java.util.ArrayList;

/**
 * Created by luisb on 27/07/2017.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment{

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Creamos un view y lo inflamos con nuestro fragment (se comportara como contenedor)
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);//ahora buscamos en esta vista

        //llamamos este metodo para poder ver las mascotas en nuestra pantalla
        presenter = new RecyclerViewFragmentPresentador(this,getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutV() {
        //lista vertical de cardviews
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);//le entrego el layout a mi lista

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this.getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
