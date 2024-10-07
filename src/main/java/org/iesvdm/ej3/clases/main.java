package org.iesvdm.ej3.clases;

public class main {
    public static void main(String[] args) {
        //Cargamos una nueva agenda
        Agenda agenda = new Agenda();
        //Accedemos para cargar la info a la agenda
        agenda.cargarTareasDesdeAnotaciones(MisTareas.class);
        //Las mostramos por pantalla
        agenda.mostrarTareas();
    }
}
