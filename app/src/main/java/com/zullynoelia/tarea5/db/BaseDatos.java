package com.zullynoelia.tarea5.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zullynoelia.tarea5.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Zully on 12/05/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    private ConstructorMascotas cm;
    private SQLiteDatabase db;
    private String [] arreglo;

    public BaseDatos(Context context) {

        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "("+
                                        ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY UNIQUE, " +
                                        ConstantesBaseDatos.TABLE_NOMBRE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_NUMERO_FAVORITOS + " INTEGER, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER " +
                                        ")";

        db.execSQL(queryCrearTablaMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascotas> obtenerTodosLasMascotas(){
        ArrayList<Mascotas> mascotasTodos = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setTvFavoritoCV(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));

            mascotasTodos.add(mascotaActual);
        }

        db.close();

        return mascotasTodos;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public ArrayList<Mascotas> obtenerMisFavoritos(){
        ArrayList<Mascotas> MisFavoritos = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS + " ORDER BY " + ConstantesBaseDatos.TABLE_NUMERO_FAVORITOS + " DESC LIMIT 5 ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setTvFavoritoCV(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));

            MisFavoritos.add(mascotaActual);
        }

        db.close();

        return MisFavoritos;
    }

    public void actualizarFavorito(Mascotas mascota) {
        SQLiteDatabase db = this.getWritableDatabase();
        arreglo = new String[]{String.valueOf(mascota.getId())};
        db.update(ConstantesBaseDatos.TABLE_MASCOTAS, obtenerFavoritoElegido(mascota), ConstantesBaseDatos.TABLE_MASCOTAS_ID + " = ? ", arreglo);

        db.close();
    }

    private ContentValues obtenerFavoritoElegido(Mascotas mascota){
        ContentValues favoritoElegido = new ContentValues();
        favoritoElegido.put(ConstantesBaseDatos.TABLE_NOMBRE, mascota.getNombre());
        favoritoElegido.put(ConstantesBaseDatos.TABLE_NUMERO_FAVORITOS, mascota.getTvFavoritoCV());
        favoritoElegido.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, mascota.getFoto());

        return favoritoElegido;
    }
}

