package org.iesvdm.empresa;

public class Oficial {

    //Constructor
    public Oficial(String categoria) {
        this.categoria = categoria;
    }

    //to String
    @Override
    public String toString() {
        return "Oficial{" +
                "categoria='" + categoria + '\'' +
                '}';
    }

    //Getters y Setters
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //Atributos
    public String categoria;
}
