package org.iesvdm.empresa;
import org.iesvdm.empresa.Empleado;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<Empleado> empleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Empleados de la Empresa " + nombre + ":\n");
        for (Empleado e : empleados) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }

    // Anotaciones de empleados
    @Empleado(
            nombre = "Amancio", apellidos = "Ortega", dni = "66554433F",
            direccion = "AV.DIPUTACION S/N, ARTEIXO", telefono = "981185596",
            clase = "Directivo", codigoDespacho = "1"
    )
    private static Empleado directivo;

    @Empleado(
            nombre = "Carlos", apellidos = "García", dni = "12345678A",
            direccion = "Calle Falsa 123, Madrid", telefono = "912345678",
            clase = "Tecnico", codigoTaller = "2", perfil = "Informático"
    )
    private static Empleado tecnico;

    @Empleado(
            nombre = "María", apellidos = "Pérez", dni = "87654321B",
            direccion = "Calle Verdadera 456, Barcelona", telefono = "932165432",
            clase = "Oficial", codigoTaller = "3", categoria = "Electricista"
    )
    private static Empleado oficial;
}

