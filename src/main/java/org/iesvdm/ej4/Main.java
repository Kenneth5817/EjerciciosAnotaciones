package org.iesvdm.ej4;

public class Main {
    public static void main(String[] args) {
        // Creamos una instancia de Persona utilizando el constructor vacío
        Persona persona = new Persona();
        persona.setNombre("Jose");
        persona.setApellido("Martín");
        System.out.println(persona); // Imprime la representación de la persona

        // Creamos una instancia de Persona utilizando el patrón Builder
        Persona persona1 = Persona.builder()
                .nombre("María")
                .apellido("Gómez")
                .edad(30)
                .sexo("Femenino")
                .correo("maria@example.com")
                .telefono("123456789")
                .direccion("Calle Ejemplo 123")
                .email("maria@gmail.com")
                .build(); // Crea una nueva persona con el constructor Builder

        System.out.println(persona1); // Imprime la representación de persona1

        // Intentar crear una persona con nombre nulo para mostrar la funcionalidad de @NonNull
        try {
            Persona persona2 = Persona.builder()
                    .apellido("Pérez")
                    .build();
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
