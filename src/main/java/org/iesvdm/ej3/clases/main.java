package org.iesvdm.ej3.clases;

public class main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.cargarTareasDesdeAnotaciones(MisTareas.class);
        agenda.mostrarTareas();
    }
}
