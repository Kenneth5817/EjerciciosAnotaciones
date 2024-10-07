package org.iesvdm.ej6;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementFilter;
import java.io.IOException;
import java.util.Set;
import java.io.Writer;

@SupportedAnnotationTypes("org.example.ej6.AutoData")
@SupportedSourceVersion(SourceVersion.RELEASE_8)

//El procesador de anotaciones AutoData hereda de Abstrat Processor
public class ProcesadorAutoData extends AbstractProcessor {

    @Override
    //Este es el método principal donde se lleva a cabo el procesamiento de las anotaciones.
    //annotations: Este conjunto contiene las anotaciones que han sido encontradas
    // durante el ciclo de compilación. Puede estar vacío si no hay anotaciones que procesar.
    //roundEnv: Este objeto proporciona información sobre el entorno de compilación
    // actual. Permite acceder a los elementos que tienen alguna anotación.

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //Este bucle itera sobre todos los elementos del código que están anotados con la
        // anotación @AutoData.
        for (Element element : roundEnv.getElementsAnnotatedWith(AutoData.class)) {
            if (element.getKind() == ElementKind.CLASS) {
                TypeElement classElement = (TypeElement) element;

                // Nombramos la nueva clase
                //Como?? Sacando el nombre a secas (sin el paquete) de la clase original que está
                //anotada con @AutoData
                String claseCanciones = classElement.getSimpleName() + "AutoData";
                //obtenemos el paquete en el que se encuentra la clase original.
                String nombrePaquete = processingEnv.getElementUtils().getPackageOf(classElement).getQualifiedName().toString();

                // Creamos el código fuente de la nueva clase
                StringBuilder classContent = new StringBuilder();
                classContent.append("package ").append(nombrePaquete).append(";\n\n");
                classContent.append("public class ").append(claseCanciones).append(" {\n");

                // Procesamos los atributos de la clase original
                for (VariableElement field : ElementFilter.fieldsIn(classElement.getEnclosedElements())) {
                    String fieldName = field.getSimpleName().toString();
                    String fieldType = field.asType().toString();

                    // Definimos el campo privado
                    classContent.append("    private ").append(fieldType).append(" ").append(fieldName).append(";\n");

                    // Creamos los famosos getters y setters
                    classContent.append("    public ").append(fieldType).append(" get")
                            .append(fieldName).append("() {\n")
                            .append("        return this.").append(fieldName).append(";\n")
                            .append("    }\n");

                    classContent.append("    public void set").append(fieldName)
                            .append("(").append(fieldType).append(" ").append(fieldName).append(") {\n")
                            .append("        this.").append(fieldName).append(" = ").append(fieldName).append(";\n")
                            .append("    }\n");
                }

                //método toString
                classContent.append("    @Override\n    public String toString() {\n")
                        .append("        return \"").append(claseCanciones).append("\";\n")
                        .append("    }\n");

                classContent.append("}\n");

                // Pasamos la clase generada a un archivo .java
                try {
                    // Nombre del archivo
                    String nombreArchivo = nombrePaquete + "." + claseCanciones + ".java";

                    // Escribimos el archivo
                    Writer writer = processingEnv.getFiler()
                            .createSourceFile(nombreArchivo)
                            .openWriter();
                    writer.write(classContent.toString());
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
