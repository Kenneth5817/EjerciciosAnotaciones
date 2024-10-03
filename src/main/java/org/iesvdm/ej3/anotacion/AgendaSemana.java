package org.iesvdm.ej3.anotacion;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)

public @interface AgendaSemana {
    Tarea[] value();
}
