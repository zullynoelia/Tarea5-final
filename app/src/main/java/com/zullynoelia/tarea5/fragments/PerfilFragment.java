package com.zullynoelia.tarea5.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zullynoelia.tarea5.R;
import com.zullynoelia.tarea5.adaptadores.MascotasAdaptador;
import com.zullynoelia.tarea5.pojo.Mascotas;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private RecyclerView rv;
    private ArrayList<Mascotas> detalles;
    private TextView tvPerfil;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rvPerfil);

        final GridLayoutManager glm = new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(glm);

        tvPerfil = (TextView) view.findViewById(R.id.tvPerfil);
        tvPerfil.setText("Shaggy");

        inicializarListaMascota();
        inicializarMascotasAdaptador();

        return view;
    }

    public void inicializarMascotasAdaptador(){

        MascotasAdaptador adaptador = new MascotasAdaptador(detalles);
        rv.setAdapter(adaptador);
    }

    public void inicializarListaMascota(){

        int contador = 1;
        detalles = new ArrayList<>();

        for (int i = 0; i<=4; i++){
            detalles.add(new Mascotas("Shaggy", R.drawable.perro_6_shaggy, contador));
            contador*=2;
        }

    }

}

