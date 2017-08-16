package com.example.luisb.petagramplus.presentador;

import android.content.Context;

import com.example.luisb.petagramplus.db.ConstructorMascotas;
import com.example.luisb.petagramplus.fragment.IRecyclerViewFragment;
import com.example.luisb.petagramplus.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by luisb on 13/08/2017.
 */

public class RecyclerViewFragmentPresentador implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresentador(IRecyclerViewFragment iRecyclerViewFragment, Context context) {

        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenerMascotasBD();
    }

    @Override
    /*En este metodo separamos la fuente de los datos con la presentacion*/
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();//obtenemos array de mascostas
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));

        iRecyclerViewFragment.generarLinearLayoutV();
    }

}
