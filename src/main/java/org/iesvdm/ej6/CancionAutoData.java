package org.iesvdm.ej6;

public class CancionAutoData {
    //Atributos de cancion teniendo en cuenta AutoData
    private String titulo;
    private String artista;
    private int duracion;

    //Getters & Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "AutoData: Cancion";
    }
}
