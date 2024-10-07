package org.iesvdm.ej1.empresa;

public class Directivo extends Empleado {
    private int codigoDespacho;

    //Constructor de directivo
    public Directivo(String nombre, String apellidos, String dni, String direccion, String telefono, int codigoDespacho, String directivo) {
        super(nombre, apellidos, dni, direccion, Integer.valueOf(telefono));
        this.codigoDespacho = codigoDespacho;
    }

    @Override
    public String toString() {
        return super.toString() + ", Código Despacho: " + codigoDespacho + " (Directivo)";
    }
}
