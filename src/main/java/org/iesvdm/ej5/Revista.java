package org.iesvdm.ej5;

import lombok.experimental.SuperBuilder;


    @SuperBuilder
    public class Revista extends Publicacion {
        public String getPeriodicidad() {
            return periodicidad;
        }

        public void setPeriodicidad(String periodicidad) {
            this.periodicidad = periodicidad;
        }

        private String periodicidad;

        public Revista(String titulo, String autor, String periodicidad) {
            super(titulo, autor);
            this.periodicidad = periodicidad;
        }

        // Getters y Setters

}
