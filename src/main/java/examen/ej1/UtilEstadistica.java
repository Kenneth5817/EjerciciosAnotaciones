package examen.ej1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UtilEstadistica {

    // Método estático para calcular la media
    public static BigDecimal media(double[] x, int escala, RoundingMode redondeo) {
        if (x == null || x.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío o ser nulo");
        }

        // Sumar los valores del arreglo
        BigDecimal suma = BigDecimal.ZERO;
        for (double valor : x) {
            suma = suma.add(BigDecimal.valueOf(valor));
        }

        // Calcular la media
        BigDecimal media = suma.divide(BigDecimal.valueOf(x.length), escala, redondeo);

        return media;
    }
}
