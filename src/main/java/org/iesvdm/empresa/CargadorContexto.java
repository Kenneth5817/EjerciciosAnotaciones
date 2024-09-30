package org.iesvdm.empresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CargadorContexto {

    public static List<Empresa> cargadorContexto() {

        Empleado[] estudiantesAnnotation = Empresa.class.getAnnotationsByType(Estudiante.class);

        Map<Integer, Empresa> integerClaseMap = new HashMap<>();


        for (Empleado estudianteAnnotation : estudiantesAnnotation) {

            System.out.println(estudianteAnnotation);

            int infoEmpleados = EmpleadosAnnotation.Empresa();
            Empleado empleado = integerClaseMap.get(info);

            if (empleado == null) {
                //Clase no existe en el mapa, luego la creo
                empleado = new Empleado(infoEmpleados);
                integerClaseMap.put(infoEmpleados, empleado);

            }

            empleado.getEmpleados().add(new org.iesvdm.empresa.Empleado(
                    Empleado.nombre(),
                    LocalDate.now(),
                    100,
                    estudianteAnnotation.direccion()
            ));

        }

        return new ArrayList<>(integerClaseMap.values());
    }

}