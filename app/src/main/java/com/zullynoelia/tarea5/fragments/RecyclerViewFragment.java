package com.zullynoelia.tarea5.fragments;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zullynoelia.tarea5.R;
import com.zullynoelia.tarea5.adaptadores.MascotasAdaptador;
import com.zullynoelia.tarea5.db.BaseDatos;
import com.zullynoelia.tarea5.db.ConstructorMascotas;
import com.zullynoelia.tarea5.pojo.Mascotas;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView rv;
    private ArrayList<Mascotas> detalles;
    BaseDatos db;
    SQLiteDatabase auxiliardb;
    ConstructorMascotas cm;
    private Context context1;

    public String mascotaFavorita;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        cm = new ConstructorMascotas(getActivity());
        mascotaFavorita = cm.mostrarFavoritos(getActivity());

        if (mascotaFavorita == "NO"){
            db = new BaseDatos(getActivity());
            auxiliardb = db.getWritableDatabase();
            cm = new ConstructorMascotas(getActivity());
            cm.crearFavorito(getActivity());
            cm = new ConstructorMascotas(getActivity()).insertarMascotas(db);
        }else {

        }

        inicializarListaMascota();

        if (!detalles.isEmpty()){
            rv = (RecyclerView) view.findViewById(R.id.rvMascotas);
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);

            rv.setLayoutManager(llm);
            inicializarMascotasAdaptador();
        }

        return view;
    }

    public void inicializarMascotasAdaptador(){
        MascotasAdaptador adaptador = new MascotasAdaptador(detalles);
        rv.setAdapter(adaptador);

    }

    public void inicializarListaMascota(){
        db = new BaseDatos(getActivity());
        detalles = new ArrayList<Mascotas>();
        detalles = db.obtenerTodosLasMascotas();
    }

}

