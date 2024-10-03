package org.iesvdm.ej1.empresa;

public final class Tecnico extends Operario {
    //Getters y Setters
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    private String perfil;

    public Tecnico(String nombre, String apellidos, String dni, String direccion, String telefono, int codigoTaller, String perfil) {
        super(nombre, apellidos, dni, direccion, telefono, codigoTaller);
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return super.toString() + ", Perfil: " + perfil + " (Técnico)";
    }

    public static void main(String[]args){
        System.out.println("CADENA VACIA");
    }

}
