package com.example.luisb.petagramplus.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.luisb.petagramplus.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by luisb on 13/08/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBD.DB_NAME, null, ConstantesBD.DB_V);
        this.context = context;
    }

    @Override
    /*Creamos la estructura de la base de datos (utilizando codigo SQL)*/
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBD.TB_PET + "(" +
                ConstantesBD.TB_PET_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBD.TB_PET_NAME    + " TEXT, " +
                ConstantesBD.TB_PET_PHOTO   + " INTEGER"+
                ")";

        String queryCrearTablaLikes = "CREATE TABLE " + ConstantesBD.TB_LIKE_PET + "(" +
                ConstantesBD.TB_LIKE_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBD.TB_LIKE_PET_ID_PET + " INTEGER, "+
                ConstantesBD.TB_LIKE_PET_NUM_LIKES + " INTEGER, "+

                "FOREIGN KEY("+ ConstantesBD.TB_LIKE_PET_ID_PET +") " +
                "REFERENCES "+ ConstantesBD.TB_PET + "(" + ConstantesBD.TB_PET_ID +")"+
                ")";

        db.execSQL(queryCrearTablaMascota);//ejecutamos consulta

        db.execSQL(queryCrearTablaLikes);//ejecutamos consulta

    }

    @Override
    /*Por si necesitamos reestructurar la base de datos*/
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TB_PET);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TB_LIKE_PET);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TB_PET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);//retorna el resultado

        //recorrer los registros
        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();

            mascotaActual.setId(registros.getInt(0));//obten el id dando el indice de la columna
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ ConstantesBD.TB_LIKE_PET_NUM_LIKES + ") as likes " + "FROM " + ConstantesBD.TB_LIKE_PET + " WHERE " + ConstantesBD.TB_LIKE_PET_ID_PET + " = " + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes,null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            } else{
                mascotaActual.setLikes(0);//pone 0 likes si no hay nada
            }

            mascotas.add(mascotaActual);

        }//----Fin del while

        db.close();

        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TB_PET, null, contentValues);
        db.close();
    }

    /*Este metodo va a estar insertando un contacto en la tabla likes*/
    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TB_LIKE_PET, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;//variable que devolveremos

        String query = "SELECT COUNT(" + ConstantesBD.TB_LIKE_PET_NUM_LIKES+")" +
                "FROM " + ConstantesBD.TB_LIKE_PET +
                " WHERE " + ConstantesBD.TB_LIKE_PET_ID_PET + " = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
