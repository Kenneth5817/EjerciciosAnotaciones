package org.iesvdm.ej5;

import lombok.experimental.SuperBuilder;

    @SuperBuilder
    public class Libro extends Publicacion {
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

        public static Publicacion Builder() {
        builder();
            return null;
        }
    }