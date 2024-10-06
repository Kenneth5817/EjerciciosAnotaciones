package org.iesvdm.ej5;


import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Publicacion {
    protected String titulo;

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

    protected String autor;

        public Publicacion(String titulo, String autor) {
            this.titulo = titulo;
            this.autor = autor;
        }

    }
