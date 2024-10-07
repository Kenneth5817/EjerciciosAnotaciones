package org.iesvdm.ej4;

public class Main {
    public static void main(String[] args) {
        // Creamos una instancia de Persona indicando solo nombre y apellido
        Persona persona = new Persona();
        persona.setNombre("Kenneth");
        persona.setApellido("Jensen");
        //Imprimos a la persona
        System.out.println(persona); //

        // Creamos una instancia de Persona usando el patrón Builder
        Persona persona1 = Persona.builder()
                .nombre("Juan")
                .apellido("Bermúdez")
                .edad(24)
                .sexo("Masculino")
                .correo("juanbermudez@gmail.com")
                .telefono("192837467")
                .direccion("Calle Rosa 123")
                .email("juanete@gmail.com")
                .build();
        System.out.println(persona1);

        // Crearemos una persona con nombre nulo y veremos la funcionalidad de @NonNull
        try {
            Persona persona2 = Persona.builder()
                    .apellido("Pérez")
                    .build();
        } catch (NullPointerException e) {
            //Mostramos que se ha producido un error por pantalla
            System.out.println("Error: " + e.getMessage());
        }
    }
}
