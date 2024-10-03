package org.iesvdm.ej2.anotacion;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Empleados.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Empleado {
        String nombre();
        String apellidos();
        String dni();
        String direccion();
        String telefono();
        String clase();
        String codigoDespacho() default ""; // solo para directivo
        String codigoTaller() default "";// solo para técnico y oficial
        String perfil() default ""; // solo para técnico
        String categoria() default "";  // solo para oficial
}
