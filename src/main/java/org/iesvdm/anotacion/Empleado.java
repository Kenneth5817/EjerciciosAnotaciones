package org.iesvdm.anotacion;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
package org.iesvdm.empresa;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // Hacer la anotación disponible en tiempo de ejecución
public @interface Empleado {
        String nombre();
        String apellidos();
        String dni();
        String direccion();
        String telefono();
        String clase();
        String codigoDespacho() default ""; // Opcional, solo para Directivo
        String codigoTaller() default "";   // Opcional, solo para Técnico y Oficial
        String perfil() default "";         // Opcional, solo para Técnico
        String categoria() default "";      // Opcional, solo para Oficial
}
