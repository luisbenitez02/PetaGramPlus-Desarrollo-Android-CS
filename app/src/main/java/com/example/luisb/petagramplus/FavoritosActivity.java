package com.example.luisb.petagramplus;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.luisb.petagramplus.adaptador.MascotaAdaptador;
import com.example.luisb.petagramplus.db.BaseDatos;
import com.example.luisb.petagramplus.pojo.Mascota;

import java.util.ArrayList;

/*
* Reutilziaremos el adaptador y la cardView, solo crearemos nuevos elementos
* y cambiaremos los nombres o id de los elementos de la vista*/
public class FavoritosActivity extends AppCompatActivity {

    ArrayList<Mascota> favMascotas;//crearemos solo 5 mascotas
    private RecyclerView rvFavMascotas;
    private Toolbar miToolbar;
    public MascotaAdaptador adaptador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        miToolbar = (Toolbar) findViewById(R.id.miToolbar);
        setSupportActionBar(miToolbar);

        /*vamos a activar el funcionamiento del boton "atras"*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Activamos el Boton de subir

        getSupportActionBar().setTitle(getResources().getString(R.string.favoritos));

        //---------------------
        rvFavMascotas = (RecyclerView) findViewById(R.id.rvFavMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvFavMascotas.setLayoutManager(llm);//le entrego el layout a mi lista

        favMascotas = inicializarListaMascotasFav();

        inicializarAdaptador();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_activity_favoritos,menu);//le entregamos nuestro menu
        return true;
    }

        /*Revisamos las opciones pulsadas en nuestro menu*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){//preguntamos el ID

            case R.id.mAbout: //iniciaremos una actividad
                Intent intento = new Intent(this,PerfilActivity.class);
                startActivity(intento);
                break;

            case R.id.mContact:
                Intent i = new Intent(this,ContactoActivity.class);
                startActivity(i);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    /*Va a poner en orbita los fragments, vamos a asignarlos y añadirlos
* NOTA: debemos pasarle este arraylist al page adapter*/


    /*Para inicializar nuestro adaptador
        * Tomara el menu que creamos y lo inflara en la vista*/
    /*public  void inicializarAdapter(){
        MascotaAdaptador adapter = new MascotaAdaptador(favMascotas,this);
        rvFavMascotas.setAdapter(adapter);
    }*/

   /* public void inicializarListaFavMascotas(){

        favMascotas = new ArrayList<Mascota>();

        favMascotas.add(new Mascota("Vaquishu",6,R.drawable.pet4));
        favMascotas.add(new Mascota("Maite",11,R.drawable.pet6));
        favMascotas.add(new Mascota("Pirlo",9,R.drawable.pet2));
        favMascotas.add(new Mascota("Dani",12,R.drawable.pet3));
        favMascotas.add(new Mascota("Yaya",28,R.drawable.pet11));

    }*/
   public ArrayList<Mascota> inicializarListaMascotasFav(){
       BaseDatos db = new BaseDatos(this);
       return db.obtenerTopMascotas();

   }

    private void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(favMascotas, this);
        rvFavMascotas.setAdapter(adaptador);

    }

}
