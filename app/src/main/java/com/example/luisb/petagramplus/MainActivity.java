package com.example.luisb.petagramplus;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.luisb.petagramplus.adaptador.PageAdapter;
import com.example.luisb.petagramplus.fragment.PerfilFragment;
import com.example.luisb.petagramplus.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar miToolbar;
    private TabLayout miTabLayout;
    private ViewPager miViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relacionamos nuestros elementos de la vista con las variables
        miToolbar = (Toolbar) findViewById(R.id.miToolbar);
        setSupportActionBar(miToolbar);
        getSupportActionBar().setLogo(R.drawable.huella);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        miTabLayout = (TabLayout) findViewById(R.id.miTabLayout);
        miViewPager = (ViewPager) findViewById(R.id.miViewPager);

        setUpViewPager();

        if (miToolbar != null){
            setSupportActionBar(miToolbar);
        }

        //boton camarita
        FloatingActionButton pic = (FloatingActionButton) findViewById(R.id.picFlotante);

        /*
        * Al boton ser pulsado llamara a este metodo
        * */

        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Me toco",Toast.LENGTH_SHORT).show();

            }
        });

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
                Intent intento = new Intent(this,PerfilActivity.class);
                startActivity(intento);
                break;

            case R.id.mContact:
                Intent i = new Intent(this,ContactoActivity.class);
                startActivity(i);
                break;

            //Prguntemos si toca nuestro action view
            case R.id.mFavs: //arranco la actividad
                Intent i2 = new Intent(this, FavoritosActivity.class);
                startActivity(i2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /*Va a poner en orbita los fragments, vamos a asignarlos y añadirlos
    * NOTA: debemos pasarle este arraylist al page adapter*/
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        //vamos a agregar el fragmetn recycler view
        fragments.add(new RecyclerViewFragment());//primer tab
        fragments.add(new PerfilFragment());//segundo tab

        return fragments;
    }

    private void setUpViewPager(){
        //aqui le vamos a pasar la lista de fragments al page adapter
        miViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));

        //agregamos el viewpager al tablayout
        miTabLayout.setupWithViewPager(miViewPager);

        miTabLayout.getTabAt(0).setIcon(R.drawable.ic_action_name);//icono de tab1
        miTabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);

    }

}
