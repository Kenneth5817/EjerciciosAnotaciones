package examen.ej1;

import examen.ej1.UtilEstadistica;
import org.testng.Assert; // Importa la clase Assert de TestNG
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Teste {

    @Test
    public void testMediaConEscalaYRedondeo() {
        // Caso de prueba 1: Redondeo hacia arriba (HALF_UP) con 2 decimales
        double[] valores1 = {1.5, 2.5, 3.5};
        BigDecimal media1 = UtilEstadistica.media(valores1, 2, RoundingMode.HALF_UP);
        Assert.assertEquals(media1, new BigDecimal("2.50")); // Usar Assert.assertEquals()

        // Caso de prueba 2: Redondeo hacia abajo (DOWN) con 1 decimal
        double[] valores2 = {2.1, 3.2, 4.3};
        BigDecimal media2 = UtilEstadistica.media(valores2, 1, RoundingMode.DOWN);
        Assert.assertEquals(media2, new BigDecimal("3.2"));

        // Caso de prueba 3: Redondeo hacia el infinito más cercano (CEILING) con 1 decimal
        double[] valores3 = {1.2, 3.7, 5.5};
        BigDecimal media3 = UtilEstadistica.media(valores3, 1, RoundingMode.CEILING);
        Assert.assertEquals(media3, new BigDecimal("3.8"));

        // Caso de prueba 4: Redondeo hacia el cero (FLOOR) con 3 decimales
        double[] valores4 = {5.654, 3.123, 2.89};
        BigDecimal media4 = UtilEstadistica.media(valores4, 3, RoundingMode.FLOOR);
        Assert.assertEquals(media4, new BigDecimal("3.889"));
    }

    @Test
    public void testMediaConArregloVacio() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            double[] valores = {};
            UtilEstadistica.media(valores, 2, RoundingMode.HALF_UP);
        });
    }

    @Test
    public void testMediaConArregloNulo() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            double[] valores = null;
            UtilEstadistica.media(valores, 2, RoundingMode.HALF_UP);
        });
    }
}
