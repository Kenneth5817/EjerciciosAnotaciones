package ej3;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  // La anotación se aplica a clases
@Retention(RetentionPolicy.RUNTIME)  // La anotación estará disponible en tiempo de ejecución
public @interface Credential {
    String usuario();
    String hashPasswd();
}
