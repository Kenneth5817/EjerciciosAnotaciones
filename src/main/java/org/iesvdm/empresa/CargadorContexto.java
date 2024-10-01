package org.iesvdm.empresa;

import org.iesvdm.anotacion.Empleados;

import java.lang.reflect.Field;

public class CargadorContexto {

    // Método estático que procesa las anotaciones y carga los empleados en la empresa
    public static Empresa cargarEmpleadosDesdeAnotaciones(Class<?> clase) {
        Empresa empresa = new Empresa("Mi Empresa");

        try {
            Field[] campos = clase.getDeclaredFields();

            for (Field campo : campos) {
                if (campo.isAnnotationPresent(Empleados.class)) {
                    Empleado anotacion = (Empleado) campo.getAnnotation(Empleados.class);
                    Empleado empleado = crearEmpleado(anotacion);
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

    // Crea un empleado según el tipo de anotación
    private static Empleado crearEmpleado(Empleado anotacion) {
        switch (anotacion.clase()) {
            case "Directivo":
                return new Directivo(anotacion.nombre(), anotacion.apellidos(), anotacion.dni(),
                        anotacion.direccion(), anotacion.telefono(),
                        Integer.parseInt(anotacion.codigoDespacho()));
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
