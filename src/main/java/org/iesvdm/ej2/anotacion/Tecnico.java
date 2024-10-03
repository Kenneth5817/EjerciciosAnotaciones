package org.iesvdm.ej2.anotacion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Tecnico {
        Empleado empleado();
        int codDespacho();
    }

