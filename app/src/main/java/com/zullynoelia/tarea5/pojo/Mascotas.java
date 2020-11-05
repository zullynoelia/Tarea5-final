package com.zullynoelia.tarea5.pojo;

/**
 * Created by Zully on 12/05/2017.
 */

public class Mascotas {

    private String nombre;
    private int foto;
    private int tvFavoritoCV;
    private int id;

    public Mascotas() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getTvFavoritoCV() {
        return tvFavoritoCV;
    }

    public void setTvFavoritoCV(int tvFavoritoCV) {
        this.tvFavoritoCV = tvFavoritoCV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mascotas(String nombre, int foto, int tvFavoritoCV) {
        this.nombre = nombre;
        this.foto = foto;
        this.tvFavoritoCV = tvFavoritoCV;
    }
}

