package org.iesvdm.anotacion;

import java.lang.annotation.*;

//Meta-Anotaciones!!
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Empleados.class)
@Documented
public @interface Empleado {


    String nombre();
            String fechaNacimiento();
            String dni ();
            String direccion ();
            String telefono ();
            String clase();
            String codigoDespacho ();


}