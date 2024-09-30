package org.iesvdm.empresa;

public class Operario extends Tecnico{
    //Getters y Setters
    public Integer getCodigoTaller() {
        return codigoTaller;
    }

    public void setCodigoTaller(Integer codigoTaller) {
        this.codigoTaller = codigoTaller;
    }

    //Atributos
    public Integer codigoTaller;

    //Constructor
    public Operario(Integer codigoTaller) {
        super();
        this.codigoTaller = codigoTaller;
    }
}
