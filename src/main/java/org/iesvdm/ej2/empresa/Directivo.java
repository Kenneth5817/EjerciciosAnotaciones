package org.iesvdm.ej2.empresa;


public class Directivo extends Empleado {
    //Atributo
    private int codigoDespacho;

    //Constructor
    public Directivo(String nombre, String apellidos, String dni, String direccion, String telefono, int codigoDespacho) {
        super(nombre, apellidos, dni, direccion, telefono);
        this.codigoDespacho = codigoDespacho;
    }

    @Override
    public String toString() {
        return "Directivo{" + super.toString() + ", codigoDespacho=" + codigoDespacho + '}';
    }
}