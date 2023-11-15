package PruebaBD;

import java.sql.*;

public class EstudiantesFormato {
    public static void main(String[] args) {
        // Datos de conexión a la base de datos (ajusta estos valores según tu configuración)
        String url = "jdbc:mysql://localhost:3306/universidad";
        String usuario = "root";
        String pass = "";

        try {
            // Establecer la conexión a la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, pass);

            // Crear una declaración SQL
            Statement statement = conexion.createStatement();

            // Ejecutar una consulta para obtener todos los datos de estudiantes
            String consulta = "SELECT * FROM estudiantes";
            ResultSet resultado = statement.executeQuery(consulta);

            // Imprimir los resultados con el formato del código del hospital
            imprimirEstudiantes(resultado);

            // Cerrar la conexión y recursos
            resultado.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para imprimir los resultados con el formato del código del hospital
    private static void imprimirEstudiantes(ResultSet resultado) {
        if (resultado != null) {
            try {
                System.out.println("Lista de Estudiantes:");
                System.out.printf("%-10s %-15s %-15s %-10s %-10s\n", "ID", "Nombre", "Apellido", "Legajo", "DNI");

                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nombre = resultado.getString("nombre");
                    String apellido = resultado.getString("apellido");
                    String legajo = resultado.getString("legajo");
                    String dni = resultado.getString("dni");

                    System.out.printf("%-10d %-15s %-15s %-10s %-10s\n", id, nombre, apellido, legajo, dni);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
