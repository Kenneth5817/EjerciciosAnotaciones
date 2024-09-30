package org.iesvdm.empresa;

public class Tecnico {
    //Constructor
    public Tecnico() {
        this.perfil = perfil;
    }

    //Atributo
    private String perfil;

    //Getters y Setters
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    //To String
    @Override
    public String toString() {
        return "Tecnico{" +
                "perfil='" + perfil + '\'' +
                '}';
    }

}
