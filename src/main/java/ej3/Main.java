package ej3;
public class Main {
    public static void main(String[] args) {
        // Cargar las credenciales de la clase Login
        Login.cargarCredenciales();

        // Crear una instancia de Login y ejecutar el login
        Login login = new Login();
        login.login();
    }
}
