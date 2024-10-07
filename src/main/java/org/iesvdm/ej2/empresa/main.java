package org.iesvdm.ej2.empresa;

import org.iesvdm.ej1.empresa.Operario;
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

        // Mostramos los diferentes empleados
        System.out.println(empresa);

        //Creamos algunos objetos para mostrar por pantalla
        org.iesvdm.ej1.empresa.Tecnico tecnico=new org.iesvdm.ej1.empresa.Tecnico("Rocio","Alvarado","39842930","Calle Rio Dilar 3,1º","493504592",2,"Tecnica");
        System.out.println(tecnico);

        org.iesvdm.ej1.empresa.Operario operario=new Operario("Manuel","Vidal","029471390","Calle Rio Guadiato 23, BajoºC","958294814",3);
        System.out.println(operario);

        org.iesvdm.ej1.empresa.Tecnico tecnico2=new org.iesvdm.ej1.empresa.Tecnico("Kenneth","Jensen","39842930","Calle Rio Campanillas 31, Atc.A ","49243582",1,"Tecnico");
        System.out.println(tecnico);

        org.iesvdm.ej1.empresa.Directivo directivo=new org.iesvdm.ej1.empresa.Directivo("Pablo","Vega","950359204","Avda. Mijas 24","95505914",1, "Directivo");
        System.out.println(operario);
    }
}
