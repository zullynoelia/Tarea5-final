package com.zullynoelia.tarea5.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.zullynoelia.tarea5.R;
import com.zullynoelia.tarea5.fragments.RecyclerViewFragment;
import com.zullynoelia.tarea5.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Zully on 12/05/2017.
 */

public class ConstructorMascotas extends AppCompatActivity {

    private Context context;
    BaseDatos db;
    private ContentValues contentValues;
    private Boolean mascotaFavorita;

    public ConstructorMascotas (Context context){
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerTodosLasMascotas();

    }

    public ConstructorMascotas insertarMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_NOMBRE, "Shaggy");
        contentValues.put(ConstantesBaseDatos.TABLE_NUMERO_FAVORITOS, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro_6_shaggy);
        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_NOMBRE, "Winnie");
        contentValues.put(ConstantesBaseDatos.TABLE_NUMERO_FAVORITOS, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro_1_winnie);
        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_NOMBRE, "Leto");
        contentValues.put(ConstantesBaseDatos.TABLE_NUMERO_FAVORITOS, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro_2_leto);
        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_NOMBRE, "Dalton");
        contentValues.put(ConstantesBaseDatos.TABLE_NUMERO_FAVORITOS, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro_3_dalton);
        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_NOMBRE, "Truman");
        contentValues.put(ConstantesBaseDatos.TABLE_NUMERO_FAVORITOS, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro_5_truman);
        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_NOMBRE, "Minnie");
        contentValues.put(ConstantesBaseDatos.TABLE_NUMERO_FAVORITOS, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro_4_minnie);
        db.insertarMascotas(contentValues);

        return null;
    }

    public void crearFavorito(Context context1){
        SharedPreferences MascotasFavoritas = context1.getSharedPreferences("MASCOTASFAVORITASDB", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = MascotasFavoritas.edit();
        String valor = "SI";
        editor.putString("DB", valor);
    }

    public String mostrarFavoritos (Context context1){
        RecyclerViewFragment rvf = new RecyclerViewFragment();
        SharedPreferences MascotasFavoritas = context1.getSharedPreferences("MASCOTASFAVORITASDB", Context.MODE_PRIVATE);
        rvf.mascotaFavorita = MascotasFavoritas.getString("DB", "NO");

        String var = rvf.mascotaFavorita;

        return var;
    }
}

