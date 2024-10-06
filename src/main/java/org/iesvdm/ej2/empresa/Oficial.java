package org.iesvdm.ej2.empresa;


public class Oficial extends Empleado {
    private int codigoTaller;
    private String categoria;

    public Oficial(String nombre, String apellidos, String dni, String direccion, String telefono, int codigoTaller, String categoria) {
        super(nombre, apellidos, dni, direccion, telefono);
        this.codigoTaller = codigoTaller;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Oficial{" + super.toString() + ", codigoTaller=" + codigoTaller + ", categoria='" + categoria + '\'' + '}';
    }
}
