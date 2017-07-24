package com.example.luisb.petagramplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.luisb.petagramplus.pojo.Mascota;

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

    /*Vamos a crear el menu de opciones (los tres puntitos)*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones,menu);//le entregamos nuestro menu
        return true;
    }

    /*Revisamos las opciones pulsadas en nuestro menu*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){//preguntamos el ID

            case R.id.mAbout: //iniciaremos una actividad
                //Intent intento = new Intent(this,FavoritosActivity.class);
                //startActivity(intento);

                Toast.makeText(this, getResources().getString(R.string.updates), Toast.LENGTH_SHORT).show();//mensaje de opcion proximamente disponible
                break;

            case R.id.mContact:
                Intent i = new Intent(this,ContactoActivity.class);
                startActivity(i);
                break;

            //Prguntemos si toca nuestro action view
            case R.id.mFavs: //arranco la actividad
                Intent intento = new Intent(this, FavoritosActivity.class);
                startActivity(intento);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /*Para inicializar nuestro adaptador
        * Tomara el menu que creamos y lo inflara en la vista*/
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
