package org.iesvdm.ej4;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String correo;
    private String telefono;
    private String direccion;
    private String email;

}
