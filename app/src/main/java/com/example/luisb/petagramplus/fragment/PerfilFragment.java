package com.example.luisb.petagramplus.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luisb.petagramplus.R;
import com.example.luisb.petagramplus.adaptador.MascotaAdaptador;
import com.example.luisb.petagramplus.adaptador.PerfilAdaptador;
import com.example.luisb.petagramplus.pojo.MascotaPerfil;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<MascotaPerfil> petPics;
    private RecyclerView rvPerfil;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvPerfil = (RecyclerView) v.findViewById(R.id.rvPetPerfil);//seteamos nuestro recycler view, ubicado en fragment_perfil

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvPerfil.setLayoutManager(glm);

        inicializarListaPetPics();
        inicializarPerfilAdaptador();

        return v;
    }

    public void inicializarListaPetPics(){

        petPics = new ArrayList<MascotaPerfil>();

        petPics.add(new MascotaPerfil(R.drawable.panda_pic1,5));
        petPics.add(new MascotaPerfil(R.drawable.panda_pic2,25));
        petPics.add(new MascotaPerfil(R.drawable.panda_pic3,10));
        petPics.add(new MascotaPerfil(R.drawable.panda_pic4,11));
        petPics.add(new MascotaPerfil(R.drawable.panda_pic5,50));
        petPics.add(new MascotaPerfil(R.drawable.panda_pic7,100));
        petPics.add(new MascotaPerfil(R.drawable.panda_pic8,30));
        petPics.add(new MascotaPerfil(R.drawable.panda_pic9,12));
        petPics.add(new MascotaPerfil(R.drawable.panda_pic10,112));
        petPics.add(new MascotaPerfil(R.drawable.panda_pic11,48));
    }

    public  void inicializarPerfilAdaptador(){
        PerfilAdaptador adaptador = new PerfilAdaptador(petPics);
        rvPerfil.setAdapter(adaptador);
    }

}
