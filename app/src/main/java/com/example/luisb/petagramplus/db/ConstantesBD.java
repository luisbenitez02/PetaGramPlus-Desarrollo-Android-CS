package com.example.luisb.petagramplus.db;

/**
 * Created by luisb on 13/08/2017.
 */

public class ConstantesBD {

    public static final String DB_NAME = "mascotas";
    public static int DB_V = 1;//version base de datos

    //constantes de tablas y sus campos
    //TB= tabla, Pet= mascota
    public static final String TB_PET = "mascota";
    public static final String TB_PET_ID = "id";
    public static final String TB_PET_NAME = "nombre";
    public static final String TB_PET_PHOTO = "foto";

    public static final String TB_LIKE_PET = "mascota_likes";
    public static final String TB_LIKE_PET_ID = "id";
    public static final String TB_LIKE_PET_ID_PET = "id_mascota";
    public static final String TB_LIKE_PET_NUM_LIKES = "numero_likes";




}
