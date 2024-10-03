package org.iesvdm.ej1.empresa;


    public class Operario extends Empleado {
        //Atributo
        private int codigoTaller;

        //COnstructores
        public Operario(String nombre, String apellidos, String dni, String direccion, String telefono, int codigoTaller) {
            super(nombre, apellidos, dni, direccion, Integer.valueOf(telefono));
            this.codigoTaller = codigoTaller;
        }

        //Getters y Setters
        public int getCodigoTaller() {
            return codigoTaller;
        }

        public void setCodigoTaller(int codigoTaller) {
            this.codigoTaller = codigoTaller;
        }


        @Override
        public String toString() {
            return super.toString() + ", Código Taller: " + codigoTaller + " (Operario)";
        }
    }
