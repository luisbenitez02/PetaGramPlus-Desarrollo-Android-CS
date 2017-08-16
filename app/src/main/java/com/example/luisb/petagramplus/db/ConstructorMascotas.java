package com.example.luisb.petagramplus.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.luisb.petagramplus.R;
import com.example.luisb.petagramplus.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by luisb on 13/08/2017.
 */

/*Es llamado el interactor: un intermediario entre la vista y la clase que consulta la BD*/
public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {

        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarMisMascotas(db);
        return db.obtenerTodasMascotas();
    }


    public void insertarMisMascotas(BaseDatos db){

            /*Quiza podamos optimizar este metodo creando una nueva clase que reciba el nombre y la imagen de la mascota y cree y devuelva el content value (la llamaremos en una espie de bucle)*/

            /*Los likes no estan por que se ejecutaran dinamicamente (empiezan en 0)*/
        ContentValues cV = new ContentValues();

        cV.put(ConstantesBD.TB_PET_NAME,"Katty");
        cV.put(ConstantesBD.TB_PET_PHOTO,R.drawable.pet1);

        db.insertarMascotas(cV);

        cV = new ContentValues();
        cV.put(ConstantesBD.TB_PET_NAME,"Lola");
        cV.put(ConstantesBD.TB_PET_PHOTO,R.drawable.pet9);

        db.insertarMascotas(cV);

        cV = new ContentValues();
        cV.put(ConstantesBD.TB_PET_NAME,"Pepita");
        cV.put(ConstantesBD.TB_PET_PHOTO,R.drawable.pet7);

        db.insertarMascotas(cV);

        cV = new ContentValues();
        cV.put(ConstantesBD.TB_PET_NAME,"Paco");
        cV.put(ConstantesBD.TB_PET_PHOTO,R.drawable.pet5);

        db.insertarMascotas(cV);

        cV = new ContentValues();
        cV.put(ConstantesBD.TB_PET_NAME,"Redd");
        cV.put(ConstantesBD.TB_PET_PHOTO,R.drawable.pet10);

        db.insertarMascotas(cV);

        cV = new ContentValues();
        cV.put(ConstantesBD.TB_PET_NAME,"Max");
        cV.put(ConstantesBD.TB_PET_PHOTO,R.drawable.pet8);

        db.insertarMascotas(cV);

        cV = new ContentValues();
        cV.put(ConstantesBD.TB_PET_NAME,"Vaquishu");
        cV.put(ConstantesBD.TB_PET_PHOTO,R.drawable.pet4);

        db.insertarMascotas(cV);

        cV = new ContentValues();
        cV.put(ConstantesBD.TB_PET_NAME,"Maite");
        cV.put(ConstantesBD.TB_PET_PHOTO,R.drawable.pet6);

        db.insertarMascotas(cV);

        cV = new ContentValues();
        cV.put(ConstantesBD.TB_PET_NAME,"Pirlo");
        cV.put(ConstantesBD.TB_PET_PHOTO,R.drawable.pet2);

        db.insertarMascotas(cV);

        cV = new ContentValues();
        cV.put(ConstantesBD.TB_PET_NAME,"Dani");
        cV.put(ConstantesBD.TB_PET_PHOTO,R.drawable.pet3);

        db.insertarMascotas(cV);

        cV = new ContentValues();
        cV.put(ConstantesBD.TB_PET_NAME,"Yaya");
        cV.put(ConstantesBD.TB_PET_PHOTO,R.drawable.pet11);

        db.insertarMascotas(cV);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues cv = new ContentValues();
        //necesitamos obtener el like del contacto, el objeto mascota me da el id que he pulsado
        cv.put(ConstantesBD.TB_LIKE_PET_ID_PET, mascota.getId());
        cv.put(ConstantesBD.TB_LIKE_PET_NUM_LIKES, LIKE);

        db.insertarLikeMascota(cv);
    }

    public int obtenerLikesContacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

}
