package org.iesvdm.ej1.empresa;


    public class Oficial extends Operario {
        private String categoria;

        public Oficial(String nombre, String apellidos, String dni, String direccion, String telefono, int codigoTaller, String categoria) {
            super(nombre, apellidos, dni, direccion, telefono, codigoTaller);
            this.categoria = categoria;
        }

        @Override
        public String toString() {
            return super.toString() + ", Categoría: " + categoria + " (Oficial)";
        }
    }
