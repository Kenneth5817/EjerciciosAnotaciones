package org.iesvdm.empresa;

import org.iesvdm.anotacion.Empleados;

import java.util.List;


public class main {
    public static void main(String[] args) {
        // Utilizamos el CargadorContexto para cargar la empresa con empleados desde las anotaciones
        Empresa empresa = CargadorContexto.cargarEmpleadosDesdeAnotaciones(Empresa.class);
        // Imprimimos la lista de empleados
        System.out.println(empresa);
    }
}



