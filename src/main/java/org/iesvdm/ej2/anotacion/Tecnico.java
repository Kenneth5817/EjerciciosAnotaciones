package org.iesvdm.ej2.anotacion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Tecnico {
    String nombre();
    String apellidos();
    String dni();
    String direccion();
    String telefono();
    String codigoTaller();
    String perfil();
}

