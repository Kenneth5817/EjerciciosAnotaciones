package org.iesvdm.ej2.empresa;

import org.iesvdm.ej2.anotacion.Directivo;
import org.iesvdm.ej2.anotacion.Tecnico;
import org.iesvdm.ej2.anotacion.Oficial;
import org.iesvdm.ej2.anotacion.Empleado;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    // Atributos
    private String nombre;
    private List<org.iesvdm.ej2.empresa.Tecnico> empleados;

    // Constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<org.iesvdm.ej2.empresa.Tecnico>();
    }

    // Anotaciones en los campos
    @Empleado(
            nombre = "Juan",
            apellidos = "Ortega",
            dni = "930195821P",
            direccion = "Calle Rio Sena, 24, 1ºC, Mijas",
            telefono = "981185596",
            clase = "Directivo",
            codigoDespacho = "1"
    )
    private Directivo directivo1;  // Nombre único

    @Empleado(
            nombre = "Lucas",
            apellidos = "García",
            dni = "938295037S",
            direccion = "Calle Sánchez 31, 2º, Murcia",
            telefono = "912345678",
            clase = "Tecnico",
            codigoTaller = "2",
            perfil = "Informático"
    )
    private Tecnico tecnico1;  // Otro campo diferente

    @Empleado(
            nombre = "Raquel",
            apellidos = "Pérez",
            dni = "87654321B",
            direccion = "Calle Luz 592, Mijas",
            telefono = "932165432",
            clase = "Oficial",
            codigoTaller = "3",
            categoria = "Electricista"
    )
    private Oficial oficial1;  // Nombre único

    public void agregarEmpleado(org.iesvdm.ej2.empresa.Tecnico empleado) {
        this.empleados.add(empleado);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Empleados de la Empresa " + nombre + ":\n");
        for (org.iesvdm.ej2.empresa.Tecnico empleado : empleados) {
            sb.append(empleado.toString()).append("\n");
        }
        return sb.toString();
    }
}
