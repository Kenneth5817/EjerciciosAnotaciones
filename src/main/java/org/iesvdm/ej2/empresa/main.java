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
    private static Directivo directivo;
    @Tecnico(
            nombre = "Lucas",
            apellidos = "García",
            dni = "938295037S",
            direccion = "Calle Sánchez 31, 2º, Murcia",
            telefono = "912345678",
            codigoTaller = "2",
            perfil = "Informático"
    )
    private static Tecnico tecnico;
    @Oficial(
            nombre = "Raquel",
            apellidos = "Pérez",
            dni = "87654321B",
            direccion = "Calle Luz 592, Mijas",
            telefono = "932165432",
            codigoTaller = 3,
            categoria = "Electricista"
    )
    private static Oficial oficial;

    public static void main(String[] args) {
        // Cargamos la empresa con los empleados anotados
        Empresa empresa = CargadorContexto.cargarEmpleadosDesdeAnotaciones(main.class);

        // Mostramos los diferentes empleados que hay
        System.out.println(empresa);
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        org.iesvdm.ej1.empresa.Tecnico ejemploTecnico=new org.iesvdm.ej1.empresa.Tecnico("Juan","Bermudez","249503940","Calle Rio Agua","628193713",2,"Técnico");
        System.out.println(ejemploTecnico);

        org.iesvdm.ej1.empresa.Oficial ejemploOficial=new org.iesvdm.ej1.empresa.Oficial("Pepe","Sanchez", "194035290", "Calle Rio Azucena 39,5º4","044860304",1,"Oficial");
        System.out.println(ejemploOficial);

        org.iesvdm.ej1.empresa.Tecnico ejemploTecnico2= new org.iesvdm.ej1.empresa.Tecnico("Raquel", "Luque", "93021940", "Calle Manzanilla 3º1", "9305930",3,"Técnico");
        System.out.println(ejemploTecnico2);

        org.iesvdm.ej1.empresa.Directivo ejemploDirectivo= new org.iesvdm.ej1.empresa.Directivo("Lucas", "Ramirez", "204352422", "Avda. Mijas 43. Bajo B", "492010490",1);
        System.out.println(ejemploDirectivo);
    }
}

