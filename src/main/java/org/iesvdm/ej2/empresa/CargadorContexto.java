package org.iesvdm.ej2.empresa;
import org.iesvdm.ej2.anotacion.Empleado;
import java.lang.reflect.Field;
public class CargadorContexto {

    //Usamos generico ? para poder hacer referencia a cualquier clase
    public static Empresa cargarEmpleadosDesdeAnotaciones(Class<?> clase) {
        Empresa empresa = new Empresa("Tecnologías de comunicación");

        try {
            Field[] campos = clase.getDeclaredFields();

            //Recorreremos campo a campo
            for (Field campo : campos) {
                if (campo.isAnnotationPresent(Empleado.class)) {
                    Empleado anotacion = campo.getAnnotation(Empleado.class);
                    // Creamos el empleado usando los datos de la anotación
                    org.iesvdm.ej2.empresa.Empleado empleado = crearEmpleado(anotacion);
                    // Si no se encuentra, agregamos el empleado a la empresa
                    if (empleado != null) {
                        empresa.agregarEmpleado((Tecnico) empleado);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return empresa;
    }

    // Crearemos un empleado según el tipo de anotación
    private static org.iesvdm.ej2.empresa.Empleado crearEmpleado(Empleado anotacion) {
        switch(anotacion.clase()){
            case "Directivo":
                return new org.iesvdm.ej2.empresa.Directivo(
                        anotacion.nombre(),
                        anotacion.apellidos(),
                        anotacion.dni(),
                        anotacion.direccion(),
                        anotacion.telefono(),
                        Integer.parseInt(anotacion.codigoDespacho())
                );

            case "Tecnico":
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
                return null;  // Si no es un tipo válido, se devolverá null;
        }
    }
}
