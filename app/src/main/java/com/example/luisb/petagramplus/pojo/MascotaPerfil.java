package com.example.luisb.petagramplus.pojo;

/**
 * Created by luisb on 30/07/2017.
 */

public class MascotaPerfil {
    private int foto;
    private int likes;

    public MascotaPerfil(int foto, int likes) {
        this.foto = foto;
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
