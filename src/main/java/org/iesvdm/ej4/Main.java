package org.iesvdm.ej4;

public class Main {
    public static void main(String[] args) {
        Persona persona= new Persona();
        persona.setNombre("Jose");
        persona.setApellido("Martín");
        System.out.println(persona);

        //El builder acaba al final con un build
        Persona persona1= Persona.builder().
                nombre("María").
                apellido("Gómez").
                build();
    }
}
