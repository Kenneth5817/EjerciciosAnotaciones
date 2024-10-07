package org.iesvdm.ej5;

public class Main {
    public static void main(String[] args) {
        //Algunos libros de ej. para ver cómo quedaría implementado
        //Libro 1
        Libro libro = new LibroBuilder()
                .setTitulo("Orgullo y Prejuicio")
                .setAutor("Jane Austen")
                .setIsbn("93829503558")
                .build();

        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("ISBN: " + libro.getIsbn());
        System.out.println(" ");
        //Libro 2
        Libro libro2 = new LibroBuilder()
                .setTitulo("Cien años de soledad")
                .setAutor("Gabriel García Márquez")
                .setIsbn("978316484100")
                .build();
        System.out.println("Título: " + libro2.getTitulo());
        System.out.println("Autor: " + libro2.getAutor());
        System.out.println("ISBN: " + libro2.getIsbn());
        System.out.println(" ");

        //Libro 3
        Libro libro3 = new LibroBuilder()
                .setTitulo("1984")
                .setAutor("George Orwell")
                .setIsbn("9784528424")
                .build();
        System.out.println("Título: " + libro3.getTitulo());
        System.out.println("Autor: " + libro3.getAutor());
        System.out.println("ISBN: " + libro3.getIsbn());

    }
}
