package org.iesvdm.ej5;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;

@SupportedAnnotationTypes("com.miempresa.annotation.SuperBuilder")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
    //El procesadorDeAnotaciones hereda de AbstractProccesor
    public class ProcesadorAnotaciones extends AbstractProcessor {

    @Override
    //Set puede contener cualquier tipo que sea un subtipo de TypeElement
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // Itera sobre cada elemento anotado con la anotación @SuperBuilder
        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(SuperBuilder.class)) {
            // Comprobamos si el elemento anotado es de tipo TypeElement (es decir, una clase)
            if (annotatedElement instanceof TypeElement) {
                TypeElement classElement = (TypeElement) annotatedElement;
                //genera el Builder para la clase anotada llamando al método
                generadorBuilder(classElement);
            }
        }
        return true;
    }

    //Método que genera el builder a la clase asociada
    private void generadorBuilder(TypeElement claseAsociada) {
        //Para generar el builder tendremos que tener por nombre las clases, paquetes....
        String nombreClase = claseAsociada.getSimpleName().toString();
        String nombrePaquete = processingEnv.getElementUtils().getPackageOf(claseAsociada).toString();
        String nombreBuilder = nombreClase + "Builder";

        try {
            //obtiene un objeto que permite crear nuevos archivos de código fuente, se utiliza para crear un nuevo archivo de código fuente con el nombre especificado.
            JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(nombrePaquete + "." + nombreBuilder);
            //abre un Writer para el archivo que acabamos de crear. Usar el bloque try-with-resources asegura
            //que el Writer se cierre automáticamente al final del bloque, evitando fallos y fugas.
            try (Writer writer = builderFile.openWriter()) {
                    writer.write("paquete " + nombrePaquete + ";\n\n");
                writer.write("clase " + nombreBuilder + " {\n");

                // Incluimos los campos de la clase actual y su clase padre (si los tiene)
                writeFields(claseAsociada, writer);
                writer.write("\n");

                // Creamos métodos "setter" estilo builder para cada campo
                escribirSetters(claseAsociada, nombreBuilder, writer);

                // Método build
                escribirMetodoBuild(claseAsociada, nombreBuilder, writer);

                writer.write("}\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFields(TypeElement classElement, Writer writer) throws IOException {
        // Incluimos campos de la clase actual y su padre
        TypeElement superclassElement = (TypeElement) processingEnv.getTypeUtils().asElement(classElement.getSuperclass());

        if (superclassElement != null) {
            writeFields(superclassElement, writer);
        }

        // Filtramos los campos no privados de la clase actual
        List<? extends Element> campos = ElementFilter.fieldsIn(classElement.getEnclosedElements());
        //Vamos recorriendo campo a campo
        for (Element field : campos) {
            if (!field.getModifiers().contains(Modifier.PRIVATE)) {
                writer.write("    private " + field.asType() + " " + field.getSimpleName() + ";\n");
            }
        }
    }

    private void escribirSetters(TypeElement classElement, String builderClassName, Writer writer) throws IOException {
        // Incluimos setters para la clase actual y su padre
        TypeElement superclassElement = (TypeElement) processingEnv.getTypeUtils().asElement(classElement.getSuperclass());

        if (superclassElement != null) {
            // Hacemos que sea recursiva la clase padre
            escribirSetters(superclassElement, builderClassName, writer);
        }

        // Filtramos los campos no privados de la clase actual
        List<? extends Element> fields = ElementFilter.fieldsIn(classElement.getEnclosedElements());
        //Para ello, con el bucle for each, iremos recorriendo campo a campo
        for (Element field : fields) {
            //Si no se encuentra el campo se añade con write
            if (!field.getModifiers().contains(Modifier.PRIVATE)) {
                String tipoCampo = field.asType().toString();
                String tipoNombre = field.getSimpleName().toString();
                writer.write("    public " + builderClassName + " set" + (tipoNombre) + "(" + tipoCampo + " " + tipoNombre + ") {\n");
                writer.write("        this." + tipoNombre + " = " + tipoNombre + ";\n");
                writer.write("        return this;\n");
                writer.write("    }\n");
            }
        }
    }

    //Método para escribir el build
    private void escribirMetodoBuild(TypeElement classElement, String builderClassName, Writer writer) throws IOException {
        String className = classElement.getSimpleName().toString();
        writer.write("    public " + className + " build() {\n");
        writer.write("        return new " + className + "(");

        // Añadir los campos al constructor
        List<? extends Element> fields = ElementFilter.fieldsIn(classElement.getEnclosedElements());
        //Vamos recorriendo campo a campo
        for (int i = 0; i < fields.size(); i++) {
            Element field = fields.get(i);
            if (!field.getModifiers().contains(Modifier.PRIVATE)) {
                if (i > 0) {
                    writer.write(", ");
                }
                writer.write(field.getSimpleName().toString());
            }
        }
        //Cerramos el cierre de una declaración
        writer.write(");\n");
        writer.write("    }\n");
    }

}
