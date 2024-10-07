package org.iesvdm.ej2.empresa;

import org.iesvdm.ej2.anotacion.Directivo;
import org.iesvdm.ej2.anotacion.Oficial;
import org.iesvdm.ej2.anotacion.Tecnico;

public class main {

    @Directivo(
            nombre = "Juan",
            apellidos = "Ortega",
            dni = "930195821P",
            direccion = "Calle Rio Sena, 24, 1ºC, Mijas",
            telefono = "981185596",
            codigoDespacho = "1"
    )
    private static Directivo directivo1; // Directivo anotado

    @Tecnico(
            nombre = "Lucas",
            apellidos = "García",
            dni = "938295037S",
            direccion = "Calle Sánchez 31, 2º, Murcia",
            telefono = "912345678",
            codigoTaller = "2",
            perfil = "Informático"
    )
    private static Tecnico tecnico1; // Técnico anotado

    @Oficial(
            nombre = "Raquel",
            apellidos = "Pérez",
            dni = "87654321B",
            direccion = "Calle Luz 592, Mijas",
            telefono = "932165432",
            codigoTaller = 3,
            categoria = "Electricista"
    )
    private static Oficial oficial1; // Oficial anotado

    public static void main(String[] args) {
        // Cargar la empresa con los empleados anotados
        Empresa empresa = CargadorContexto.cargarEmpleadosDesdeAnotaciones(main.class);

        // Mostrar empleados
        System.out.println(empresa); // Esto imprimirá la lista de empleados en consola
    }
}
