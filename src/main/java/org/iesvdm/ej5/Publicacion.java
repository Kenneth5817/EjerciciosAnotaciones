package org.iesvdm.ej5;

@SuperBuilder
//Clase publicación
public class Publicacion {
    //Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    //Atributos
    protected String titulo;
    protected String autor;

    //Constructor
    public Publicacion(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
}
