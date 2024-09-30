package org.iesvdm.empresa;

public class Directivo {

    //Getters y Setters
    public Integer getCodigoDespacho() {
        return codigoDespacho;
    }

    public void setCodigoDespacho(Integer codigoDespacho) {
        this.codigoDespacho = codigoDespacho;
    }

    //Constructor
    public Directivo(Integer codigoDespacho) {
        this.codigoDespacho = codigoDespacho;
    }

    //ATRIBUTO
    public Integer codigoDespacho;

}
