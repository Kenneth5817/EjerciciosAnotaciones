package org.iesvdm.ej3.clases;
import org.iesvdm.ej3.anotacion.AgendaSemana;
import org.iesvdm.ej3.anotacion.Tarea;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
        private List<Tarea> tareas;

        public Agenda() {
            this.tareas = new ArrayList<>();
        }

        public void cargarTareasDesdeAnotaciones(Class agendaClase) { // Se eliminó <?>
            if (agendaClase.isAnnotationPresent(AgendaSemana.class)) {
                AgendaSemana agendaSemana = (AgendaSemana) agendaClase.getAnnotation(AgendaSemana.class);
                for (Tarea tarea : agendaSemana.value()) {
                    tareas.add(tarea);
                }
            }
        }

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
