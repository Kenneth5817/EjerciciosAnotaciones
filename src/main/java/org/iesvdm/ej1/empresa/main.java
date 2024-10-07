package org.iesvdm.ej1.empresa;


public class main {
    public static void main(String[] args) {
        // Utilizamos el CargadorContexto para cargar la empresa con empleados desde las anotaciones
        Empresa empresa = CargadorContexto.cargarEmpleadosDesdeAnotaciones(Empresa.class);

        // Imprimimos la lista de empleados
        System.out.println(empresa);

        //Creamos algunos objetos para mostrar por pantalla
        Tecnico tecnico=new Tecnico("Juan","Martinez","39842930","Calle Rio Luz 13, 2º","493504592",2,"Tecnico");
        System.out.println(tecnico);

        Operario operario=new Operario("Lucas","Jiménez","029471390","Calle Rio Vélez 2, BajoºC","958294814",1);
        System.out.println(operario);

        Tecnico tecnico2=new Tecnico("Juan","Martinez","39842930","Calle Rio Campanillas 49, Atc.C ","49243582",2,"Tecnico");
        System.out.println(tecnico);

        Directivo directivo=new Directivo("Raquel","Sánchez","950359204","Avda. Mijas 24","95505914",3, "Directiva");
        System.out.println(operario);
    }
}



