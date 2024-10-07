package org.iesvdm.ej6;

public class main {
    public static void main(String[] args) {
        //Mostramos por pantalla las canciones disponibles
        System.out.println("Canciones disponibles: ");

        //Cada canción vendrá con el nombre del cantante y la duración que tenga
        //Ojo!! Duración lo pondré en segundos
        System.out.println("      ");
        CancionAutoData cancion = new CancionAutoData();
        cancion.setTitulo("mariposas");
        cancion.setArtista("Aitana");
        cancion.setDuracion(190);

        System.out.println(cancion.getTitulo() + " - " + cancion.getArtista());
        System.out.println("Duración: " + cancion.getDuracion() + " segundos");


        System.out.println("      ");

        CancionAutoData cancion2 = new CancionAutoData();
        cancion.setTitulo("Lineas Rojas");
        cancion.setArtista("Miriam Rodríguez");
        cancion.setDuracion(194);


        System.out.println(cancion.getTitulo() + " - " + cancion.getArtista());
        System.out.println("Duración: " + cancion.getDuracion() + " segundos");

        System.out.println("    ");
        CancionAutoData cancion3 = new CancionAutoData();
        cancion.setTitulo("Dont start now");
        cancion.setArtista("Dua Lipa");
        cancion.setDuracion(183);

        System.out.println(cancion.getTitulo() + " - " + cancion.getArtista());
        System.out.println("Duración: " + cancion.getDuracion() + " segundos");

        System.out.println("    ");
        CancionAutoData cancion4 = new CancionAutoData();
        cancion.setTitulo("SlowMo");
        cancion.setArtista("Chanel");
        cancion.setDuracion(208);

        System.out.println(cancion.getTitulo() + " - " + cancion.getArtista());
        System.out.println("Duración: " + cancion.getDuracion() + " segundos");

        System.out.println("    ");
        CancionAutoData cancion5 = new CancionAutoData();
        cancion.setTitulo("Las 12");
        cancion.setArtista("Ana Mena");
        cancion.setDuracion(197);

        System.out.println(cancion.getTitulo() + " - " + cancion.getArtista());
        System.out.println("Duración: " + cancion.getDuracion() + " segundos");
    }
}
