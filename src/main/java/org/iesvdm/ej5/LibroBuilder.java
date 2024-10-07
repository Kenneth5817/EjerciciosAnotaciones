package org.iesvdm.ej5;

public class LibroBuilder {
    //Atributos de libro builder
    private String titulo;
    private String autor;
    private String isbn;

    //  GETTERS y setters
    public LibroBuilder setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LibroBuilder setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public LibroBuilder setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public Libro build() {
        return new Libro(titulo, autor, isbn);
    }
}
