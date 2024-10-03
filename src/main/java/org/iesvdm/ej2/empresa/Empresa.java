package org.iesvdm.ej2.empresa;

import java.util.ArrayList;
import java.util.List;


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

public class Empresa{
    private String nombre;
    private List<Empleado> empleados;
    private static Empleado directivo;
    private static Empleado oficial;
    private static Empleado operario;
    private static Empleado tecnico;
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
        for (Empleado empleados : empleados) {
            sb.append(empleados.toString()).append("\n");
        }
        return sb.toString();
    }


}

