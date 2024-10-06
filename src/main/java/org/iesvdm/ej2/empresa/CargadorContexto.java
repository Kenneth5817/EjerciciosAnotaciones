package org.iesvdm.ej2.empresa;

import org.iesvdm.ej2.anotacion.Empleado;
import java.lang.reflect.Field;

public class CargadorContexto {

    public static Empresa cargarEmpleadosDesdeAnotaciones(Class<?> clase) {
        Empresa empresa = new Empresa("Tecnologías de comunicación");

        try {
            Field[] campos = clase.getDeclaredFields();

            for (Field campo : campos) {
                if (campo.isAnnotationPresent(Empleado.class)) {
                    Empleado anotacion = campo.getAnnotation(Empleado.class);
                    // Creamos el empleado usando los datos de la anotación
                    org.iesvdm.ej2.empresa.Empleado empleado = crearEmpleado(anotacion);
                    if (empleado != null) {
                        empresa.agregarEmpleado((Tecnico) empleado);  // Agregamos el empleado a la empresa
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return empresa;
    }

    // Crea un empleado según el tipo de anotación
    private static org.iesvdm.ej2.empresa.Empleado crearEmpleado(Empleado anotacion) {
        switch (anotacion.clase()) {
            case "Directivo":
                // Crear y devolver una instancia de Directivo
                return new org.iesvdm.ej2.empresa.Directivo(
                        anotacion.nombre(),
                        anotacion.apellidos(),
                        anotacion.dni(),
                        anotacion.direccion(),
                        anotacion.telefono(),
                        Integer.parseInt(anotacion.codigoDespacho())
                );

            case "Tecnico":
                // Crear y devolver una instancia de Técnico
                return new org.iesvdm.ej2.empresa.Tecnico(
                        anotacion.nombre(),
                        anotacion.apellidos(),
                        anotacion.dni(),
                        anotacion.direccion(),
                        anotacion.telefono(),
                        Integer.parseInt(anotacion.codigoTaller()),
                        anotacion.perfil()
                );

            case "Oficial":
                // Crear y devolver una instancia de Oficial
                return new org.iesvdm.ej2.empresa.Oficial(
                        anotacion.nombre(),
                        anotacion.apellidos(),
                        anotacion.dni(),
                        anotacion.direccion(),
                        anotacion.telefono(),
                        Integer.parseInt(anotacion.codigoTaller()),
                        anotacion.categoria()
                );


            default:
                return null;  // Si no es un tipo válido, devolvemos null


        }
    }
}
