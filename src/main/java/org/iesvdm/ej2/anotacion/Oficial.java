package org.iesvdm.ej2.anotacion;

public @interface Oficial {

    public @interface Directivo {
        Empleado empleado();

        int codDespacho();
    }
}

