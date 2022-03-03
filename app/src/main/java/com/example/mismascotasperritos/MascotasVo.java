package com.example.mismascotasperritos;

import java.util.Comparator;

public class MascotasVo implements Comparator<MascotasVo> {

    private String nombre;
    private int foto;
    private int likes=0;


    public MascotasVo(String nombre, int likes, int foto) {
        this.nombre = nombre;
        this.likes = likes;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


    @Override
    public int compare(MascotasVo o1, MascotasVo o2) {
        return 0;
    }
}
