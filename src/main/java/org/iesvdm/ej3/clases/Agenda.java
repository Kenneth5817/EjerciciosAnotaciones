package org.iesvdm.ej3.clases;
import org.iesvdm.ej3.anotacion.AgendaSemana;
import org.iesvdm.ej3.anotacion.Tarea;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
        //Creamos una lista donde almacenaremos todas las tareas que haya
        private List<Tarea> tareas;

        public Agenda() {
            this.tareas = new ArrayList<>();
        }

        //creamos un método para cargar las tareas por hacer usando las anotaciones correspondientes
        public void cargarTareasDesdeAnotaciones(Class agendaClase) {
            if(agendaClase.isAnnotationPresent(AgendaSemana.class)){
                AgendaSemana agendaSemana=AgendaSemana.class.getAnnotation(AgendaSemana.class);
                for(Tarea tarea:agendaSemana.value()){
                    tareas.add(tarea);
                }if(tareas.isEmpty()){
                    System.out.println("No se ha encontrado el archivo de tareas");
                }
            }
        }

        //Mostramos por pantalla las tareas que hay disponibles
        public void mostrarTareas() {
            System.out.println("Tareas de la Agenda:");
            for (Tarea tarea : tareas) {
                System.out.println("Título: " + tarea.título_tarea() +
                        ", Descripción: " + tarea.descripción() +
                        ", Día: " + tarea.dia_semana() +
                        ", Hora: " + tarea.hora());
            }
        }
    }
