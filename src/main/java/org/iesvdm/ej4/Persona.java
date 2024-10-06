package org.iesvdm.ej4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Clase que representa una Persona.
 * Se utilizan las siguientes anotaciones de Lombok:
 *
 * @Data: Genera automáticamente métodos getter, setter, toString, equals y hashCode
 * para todos los campos de la clase.
 *
 * @Builder: Permite crear instancias de Persona utilizando el patrón Builder,
 * lo que facilita la construcción de objetos de manera más legible.
 *
 * @AllArgsConstructor: Genera un constructor con todos los atributos de la clase.
 *
 * @NoArgsConstructor: Genera un constructor vacío que no acepta parámetros.
 *
 * @NonNull: Indica que el campo no puede ser nulo. Si se intenta establecer como nulo,
 * se lanzará una NullPointerException.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @NonNull // Este campo no puede ser nulo
    private String nombre;

    @NonNull // Este campo no puede ser nulo
    private String apellido;

    private int edad;
    private String sexo;
    private String correo;
    private String telefono;
    private String direccion;
    private String email;
}
