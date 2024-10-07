package org.iesvdm.ej6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Definimos la anotación @AutoData
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface AutoData {
}
