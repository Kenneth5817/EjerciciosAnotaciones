package org.iesvdm.ej3.clases;

import org.iesvdm.ej3.anotacion.AgendaSemana;
import org.iesvdm.ej3.anotacion.Tarea;

//Usando anotaciones, creamos las tareas que queramos. Yo puse 3 pero pueden ser las que quieras
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
        ),
        @Tarea(
                título_tarea="Hacer la comida",
                descripción = "Preparar la cena",
                dia_semana="Mañana viernes",
                hora="Empezar sobre las 7"
        )
})
public class MisTareas {
}
