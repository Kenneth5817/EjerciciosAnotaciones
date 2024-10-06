package org.iesvdm.ej3.clases;

import org.iesvdm.ej3.anotacion.AgendaSemana;
import org.iesvdm.ej3.anotacion.Tarea;

@AgendaSemana({
        @Tarea(
                título_tarea = "Estudiar programación",
                descripción = "Repasar colecciones",
                dia_semana = "Martes y Jueves",
                hora = "de 6 a 8"
        ),
        @Tarea(
                título_tarea = "Entregar proyecto",
                descripción = "Por Classroom",
                dia_semana = "Viernes",
                hora = "Antes de las 5"
        )
})
public class MisTareas {
}
