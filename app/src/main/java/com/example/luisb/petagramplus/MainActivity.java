package com.example.luisb.petagramplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        //mostramos elementos del recyclerview en una lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);//le entrego el layout a mi lista

        inicializarListaMascotas();

        inicializarAdaptador();

    }

    /*Para inicializar nuestro adaptador*/
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

    }
}
