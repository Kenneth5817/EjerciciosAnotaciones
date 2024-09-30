package org.iesvdm.empresa;

import org.iesvdm.anotacion.Empleados;

import java.util.List;

public class main {

    public static void main(String[] args) {

        System.out.println("Mostraremos la información");
        System.out.println("Cargando contexto de aplicación...");

        List<Empresa> empleados = CargadorContexto.cargadorContexto();


        System.out.println("Clases cargadas:");

        for (Empleados Empleados : Empleado) {
            System.out.println(empleados);
        }


    }
}
