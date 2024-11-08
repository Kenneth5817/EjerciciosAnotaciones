package org.iesvdm.ej1.empresa;

import org.iesvdm.ej1.anotacion.Empleados;
import java.lang.reflect.Field;
import java.net.SocketImpl;

public class CargadorContexto {

    @Override
    public String toString() {
        return "CargadorContexto{}";
    }

    // Usamos método estático que procesa las anotaciones y carga los empleados en la empresa
    //Usamos generico ? para que pueda coger cualquier clase
    public static Empresa cargarEmpleadosDesdeAnotaciones(Class<?> clase) {
        Empresa empresa = new Empresa("Tecnologías de comunicación");

        try {
            Field[] campos = clase.getDeclaredFields();

            //Vamos recorriendo todos los campos
            for (Field campo : campos) {
                if (campo.isAnnotationPresent(Empleados.class)) {
                    Empleado anotacion = (Empleado) campo.getAnnotation(Empleados.class);
                    Empleado empleado = crearEmpleado((org.iesvdm.ej1.anotacion.Empleado) anotacion);
                    if (empleado != null) {
                        empresa.agregarEmpleado(empleado);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return empresa;
    }

    // Creamos un empleado según el tipo de anotación
    private static Empleado crearEmpleado(org.iesvdm.ej1.anotacion.Empleado anotacion) {
        switch (anotacion.clase()) {
            case "Directivo":
                return new Directivo(anotacion.nombre(), anotacion.apellidos(), anotacion.dni(),
                        anotacion.direccion(), anotacion.telefono(),
                        Integer.parseInt(anotacion.codigoDespacho()), "Directivo");
            case "Tecnico":
                return new Tecnico(anotacion.nombre(), anotacion.apellidos(), anotacion.dni(),
                        anotacion.direccion(), anotacion.telefono(),
                        Integer.parseInt(anotacion.codigoTaller()), anotacion.perfil());
            case "Oficial":
                return new Oficial(anotacion.nombre(), anotacion.apellidos(), anotacion.dni(),
                        anotacion.direccion(), anotacion.telefono(),
                        Integer.parseInt(anotacion.codigoTaller()), anotacion.categoria());
            default:
                return null;
        }
    }
}
