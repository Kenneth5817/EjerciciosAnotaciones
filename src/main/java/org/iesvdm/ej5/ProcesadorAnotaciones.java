package org.iesvdm.ej5;

public class ProcesadorAnotaciones {


    public class main {
        public static void main(String[] args) {
            Libro libro = Libro.Builder()
                    .setTitulo("El Quijote")
                    .setAutor("Miguel de Cervantes")
                    .setIsbn("978-3-16-148410-0")
                    .build();

            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("ISBN: " + libro.getIsbn());
        }
    }

}
