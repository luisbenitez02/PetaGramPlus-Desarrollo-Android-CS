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
        //insertarMisMascotas(db);
        return db.obtenerTodasMascotas();
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
