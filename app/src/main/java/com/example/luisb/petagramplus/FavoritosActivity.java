package com.example.luisb.petagramplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/*
* Reutilziaremos el adaptador y la cardView, solo crearemos nuevos elementos
* y cambiaremos los nombres o id de los elementos de la vista*/
public class FavoritosActivity extends AppCompatActivity {

    ArrayList<Mascota> favMascotas;//crearemos solo 5 mascotas
    private RecyclerView rvFavMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        /*vamos a activar el funcionamiento del boton "atras"*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*nuestro recyclerView*/
        rvFavMascotas = (RecyclerView) findViewById(R.id.rvFavMascotas);//le paso mi nuevo recycler

        //mostramos elementos del recyclerview en una lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvFavMascotas.setLayoutManager(llm);//le entrego el layout a mi lista

        inicializarListaFavMascotas();

        inicializarAdapter();
    }

    /*Para inicializar nuestro adaptador
        * Tomara el menu que creamos y lo inflara en la vista*/
    public  void inicializarAdapter(){
        MascotaAdaptador adapter = new MascotaAdaptador(favMascotas);
        rvFavMascotas.setAdapter(adapter);
    }

    public void inicializarListaFavMascotas(){

        favMascotas = new ArrayList<Mascota>();

        favMascotas.add(new Mascota("Vaquishu","6",R.drawable.pet4));
        favMascotas.add(new Mascota("Maite","11",R.drawable.pet6));
        favMascotas.add(new Mascota("Pirlo","9",R.drawable.pet2));
        favMascotas.add(new Mascota("Dani","12",R.drawable.pet3));
        favMascotas.add(new Mascota("Yaya","28",R.drawable.pet11));

    }
}
