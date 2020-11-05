package com.zullynoelia.tarea5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.zullynoelia.tarea5.adaptadores.MascotasAdaptador;
import com.zullynoelia.tarea5.db.BaseDatos;
import com.zullynoelia.tarea5.pojo.Mascotas;

import java.util.ArrayList;

public class DetalleMascota extends AppCompatActivity {

    private ImageView imgFavoritoAB;
    private RecyclerView rv;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager llm;
    private ArrayList<Mascotas> detalles;
    private BaseDatos db;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        Toolbar ActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(ActionBar);

        imgFavoritoAB = (ImageView) findViewById(R.id.imgFavoritoAB);
        imgFavoritoAB.setVisibility(View.INVISIBLE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setLogo(R.drawable.dog_footprint_filled);

        inicializarListaMascota();

        rv = (RecyclerView) findViewById(R.id.rvDetalle);
        rv.setHasFixedSize(true);
        rv.setClickable(false);
        rv.setEnabled(false);

        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        inicializarMascotasAdaptador();

    }

    private void inicializarMascotasAdaptador() {

        adaptador = new MascotasAdaptador(detalles);
        rv.setAdapter(adaptador);

    }

    private void inicializarListaMascota() {

        db = new BaseDatos(DetalleMascota.this);
        detalles = new ArrayList<Mascotas>();
        detalles = db.obtenerMisFavoritos();
    }
}

