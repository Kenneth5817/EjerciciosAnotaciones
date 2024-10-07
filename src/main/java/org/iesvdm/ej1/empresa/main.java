package org.iesvdm.ej1.empresa;


public class main {
    public static void main(String[] args) {
        // Utilizamos el CargadorContexto para cargar la empresa con empleados desde las anotaciones
        Empresa empresa = CargadorContexto.cargarEmpleadosDesdeAnotaciones(Empresa.class);

        // Imprimiremos la lista de empleados
        System.out.println(empresa);
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        //Creamos diferentes objetos
        //Imprimimos la lista de empleados
        Tecnico ejemploTecnico=new Tecnico("Juan","Bermudez","249503940","Calle Rio Agua","628193713",2,"Técnico");
        System.out.println(ejemploTecnico);

        Oficial ejemploOficial=new Oficial("Pepe","Sanchez", "194035290", "Calle Rio Azucena 39,5º4","044860304",1,"Oficial");
        System.out.println(ejemploOficial);

        Tecnico ejemploTecnico2= new Tecnico("Raquel", "Luque", "93021940", "Calle Manzanilla 3º1", "9305930",3,"Técnico");
        System.out.println(ejemploTecnico2);

        Directivo ejemploDirectivo= new Directivo("Lucas", "Ramirez", "204352422", "Avda. Mijas 43. Bajo B", "492010490",1);
        System.out.println(ejemploDirectivo);

    }
}


