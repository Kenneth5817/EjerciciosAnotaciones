package org.iesvdm.empresa;

public class Directivo extends Empleado {
    private int codigoDespacho;

    public Directivo(String nombre, String apellidos, String dni, String direccion, String telefono, int codigoDespacho) {
        super(nombre, apellidos, dni, direccion, Integer.valueOf(telefono));
        this.codigoDespacho = codigoDespacho;
    }

    @Override
    public String toString() {
        return super.toString() + ", Código Despacho: " + codigoDespacho + " (Directivo)";
    }
}
