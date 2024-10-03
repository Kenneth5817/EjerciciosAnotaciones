package org.iesvdm.ej2.anotacion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface Directivo {
        Empleado empleado();
        int codDespacho();
    }

