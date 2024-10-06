package org.iesvdm.ej2.empresa;
public class Tecnico extends Empleado {
    private int codigoTaller;
    private String perfil;

    public Tecnico(String nombre, String apellidos, String dni, String direccion, String telefono, int codigoTaller, String perfil) {
        super(nombre, apellidos, dni, direccion, telefono);
        this.codigoTaller = codigoTaller;
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Técnico{" + super.toString() + ", codigoTaller=" + codigoTaller + ", perfil='" + perfil + '\'' + '}';
    }
}