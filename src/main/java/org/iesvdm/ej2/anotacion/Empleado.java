package org.iesvdm.ej2.anotacion;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Anotaciones de empleados
@org.iesvdm.ej2.anotacion.Empleado(
        nombre = "Juan",
        apellidos = "Ortega",
        dni = "930195821P",
        direccion = "Calle Rio Sena, 24, 1ºC, Mijas",
        telefono = "981185596",
        clase = "Directivo",
        codigoDespacho = "1"
)

@org.iesvdm.ej2.anotacion.Empleado(
        nombre = "Lucas",
        apellidos = "García",
        dni = "938295037S",
        direccion = "Calle Sánchez 31,2º, Murcia",
        telefono = "912345678",
        clase = "Tecnico",
        codigoTaller = "2",
        perfil = "Informático"
)
@org.iesvdm.ej2.anotacion.Empleado(
        nombre = "Raquel",
        apellidos = "Pérez",
        dni = "87654321B",
        direccion = "Calle Luz 592, Mijas",
        telefono = "932165432",
        clase = "Oficial",
        codigoTaller = "3",
        categoria = "Electricista"
)

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
