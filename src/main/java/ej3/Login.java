package ej3;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class Login {
        private static final List<CredencialInfo> credenciales = new ArrayList<>();

        // Método cargador de contexto que procesa las anotaciones
        public static void cargarCredenciales() {
            // Obtener las clases que contienen la anotación @Credencial
            Class<Login> loginClass = Login.class;
            if (loginClass.isAnnotationPresent(Credenciales.class)) {
                Credenciales credencial = loginClass.getAnnotation(Credenciales.class);
                credenciales.add(new CredencialInfo(credencial.usuario(), credencial.hashPasswd()));
            }
        }

        // Método de login que pide usuario y contraseña
        public void login() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();

            // Verificar si el usuario y la contraseña coinciden
            if (verificarCredenciales(usuario, contrasena)) {
                System.out.println("ACCESO CONCEDIDO");
            } else {
                System.out.println("ACCESO DENEGADO");
            }
        }

        // Método que verifica si las credenciales existen y son correctas
        private boolean verificarCredenciales(String usuario, String contrasena) {
            // Buscar en la lista de credenciales
            for (CredencialInfo cred : credenciales) {
                if (cred.getUsuario().equals(usuario)) {
                    // Compara los hashes de las contraseñas
                    if (validarHash(contrasena, cred.getHashPasswd())) {
                        return true;
                    }
                }
            }
            return false;
        }

        // Método para comparar contraseñas usando hash
        private boolean validarHash(String contrasena, String hashEsperado) {
            String hashContrasena = hashContrasena(contrasena);
            return hashContrasena.equals(hashEsperado);
        }

        // Método para hacer un hash de la contraseña usando SHA-256
        private String hashContrasena(String contrasena) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hashBytes = md.digest(contrasena.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : hashBytes) {
                    sb.append(String.format("%02x", b));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Error al generar el hash de la contraseña", e);
            }
        }

        // Clase interna para almacenar las credenciales de usuario
        private static class CredencialInfo {
            private final String usuario;
            private final String hashPasswd;

            public CredencialInfo(String usuario, String hashPasswd) {
                this.usuario = usuario;
                this.hashPasswd = hashPasswd;
            }

            public String getUsuario() {
                return usuario;
            }

            public String getHashPasswd() {
                return hashPasswd;
            }
        }
    }

