package org.iesvdm.ej5;

@SuperBuilder
//Libro tiene en cuenta Publicacion
public class Libro extends org.iesvdm.ej5.Publicacion {
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    private String isbn;

    public Libro(String titulo, String autor, String isbn) {
        super(titulo, autor);
        this.isbn = isbn;
    }

}
