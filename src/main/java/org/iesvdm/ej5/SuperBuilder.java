package org.iesvdm.ej5;

import lombok.experimental.SuperBuilder;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

    @SupportedAnnotationTypes("org.biblioteca.annotation.SuperBuilder")
    @SupportedSourceVersion(SourceVersion.RELEASE_8) // Cambia esto según tu versión de Java
    public class SuperBuilderProcessor extends AbstractProcessor {

        @Override
        public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
            for (Element element : roundEnv.getElementsAnnotatedWith(SuperBuilder.class)) {
                TypeElement classElement = (TypeElement) element;
                String className = classElement.getSimpleName().toString();
                String packageName = processingEnv.getElementUtils().getPackageOf(classElement).toString();
                String builderName = className + "$" + classElement.getAnnotation(SuperBuilder.class).builderName();

                String builderClass = generateBuilderClass(className, builderName, classElement);
                writeBuilderToFile(packageName, builderName, builderClass);
            }
            return true;
        }

        private String generateBuilderClass(String className, String builderName, TypeElement classElement) {
            StringBuilder builderCode = new StringBuilder();
            builderCode.append("package ").append(classElement.getQualifiedName()).append(";\n\n");
            builderCode.append("public class ").append(builderName).append(" {\n");

            // Obtener la clase padre
            TypeElement superclass = (TypeElement) processingEnv.getTypeUtils().asElement(classElement.getSuperclass());

            if (superclass != null) {
                // Añadir los campos no privados de la clase padre
                superclass.getEnclosedElements().forEach(field -> {
                    if (field.getModifiers().contains(javax.lang.model.element.Modifier.PUBLIC) ||
                            field.getModifiers().contains(javax.lang.model.element.Modifier.PROTECTED)) {
                        builderCode.append("    private ").append(field.asType().toString()).append(" ")
                                .append(field.getSimpleName()).append(";\n");
                        builderCode.append("    public ").append(builderName).append(" set").append(field.getSimpleName()).append("(")
                                .append(field.asType()).append(" ").append(field.getSimpleName()).append(") {\n");
                        builderCode.append("        this.").append(field.getSimpleName()).append(" = ").append(field.getSimpleName()).append(";\n");
                        builderCode.append("        return this;\n");
                        builderCode.append("    }\n");
                    }
                });
            }

            // Añadir métodos de construcción para los campos de la clase hija
            builderCode.append("    public ").append(className).append(" build() {\n");
            builderCode.append("        return new ").append(className).append("(");

            // Aquí se puede añadir lógica para recoger los campos de la clase hija (si es necesario)
            builderCode.append(");\n");
            builderCode.append("    }\n");
            builderCode.append("}\n");

            return builderCode.toString();
        }

        private void writeBuilderToFile(String packageName, String builderName, String builderClass) {
            try {
                JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(packageName + "." + builderName);
                Writer writer = builderFile.openWriter();
                writer.write(builderClass);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
