package org.iesvdm.ej2.anotacion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Directivo {
    String nombre();
    String apellidos();
    String dni();
    String direccion();
    String telefono();
    String codigoDespacho(); // Cambiado a String
}
