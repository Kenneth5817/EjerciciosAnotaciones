package org.iesvdm.ej3.anotacion;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(AgendaSemana.class)
public @interface Tarea {
     String título_tarea();
     String descripción();
     String dia_semana();
     String hora();

}
