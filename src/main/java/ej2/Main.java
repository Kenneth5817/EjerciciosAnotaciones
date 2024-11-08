package ej2;
public class Main {
    public static void main(String[] args) {
        BiMap<Integer, String> biMap = new BiMap<>();

        // Añadir pares
        biMap.put(1, "1").put(2, "2").put(3, "3");

        // Comprobaciones básicas
        System.out.println("Valor asociado a la clave 1: " + biMap.get(1)); // "1"
        System.out.println("Clave asociada al valor '2': " + biMap.getByValue("2")); // 2

        // Prueba de inv()
        BiMap<String, Integer> inverse = biMap.inv();
        System.out.println("Valor asociado a la clave '1' en el BiMap invertido: " + inverse.get("1")); // 1
        System.out.println("Clave asociada al valor 3 en el BiMap invertido: " + inverse.getByValue(3)); // 3

        // Prueba de forcePut()
        biMap.forcePut(4, "4"); // Añade el par (4, "4")
        System.out.println("Valor asociado a la clave 4: " + biMap.get(4)); // "4"
        biMap.forcePut(1, "5"); // Elimina (1, "1") y añade (1, "5")
        System.out.println("Valor asociado a la clave 1: " + biMap.get(1)); // "5"

        // Prueba de put() con conflicto
        try {
            biMap.put(2, "5"); // Lanza una excepción ya que "5" ya está en el BiMap
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // "El valor '5' ya está asociado con otra clave."
        }
    }
}
