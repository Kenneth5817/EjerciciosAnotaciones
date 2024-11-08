package org.iesvdm.ej1.anotacion;

import java.lang.annotation.*;

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Empleados {

        Empleado[] value();
    }


