import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    // ==========================================
    // REGISTRAR CLIENTE
    // ==========================================

    public static boolean registrarCliente(Cliente cliente) {

        System.out.println();
        System.out.println("Iniciando registro del cliente...");

        String sql = "INSERT INTO clientes "
                + "(nombre, apellido, telefono, correo, direccion, empresa) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            System.out.println("Conectando con MySQL...");

            Connection conexion = ConexionBD.conectar();

            if (conexion == null) {

                System.out.println(
                        "ERROR: No se pudo establecer la conexión."
                );

                return false;
            }

            System.out.println("Conexión establecida.");

            PreparedStatement sentencia =
                    conexion.prepareStatement(sql);

            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getApellido());
            sentencia.setString(3, cliente.getTelefono());
            sentencia.setString(4, cliente.getCorreo());
            sentencia.setString(5, cliente.getDireccion());
            sentencia.setString(6, cliente.getEmpresa());

            System.out.println("Enviando datos a MySQL...");

            int filas = sentencia.executeUpdate();

            System.out.println(
                    "Filas afectadas: " + filas
            );

            sentencia.close();
            conexion.close();

            if (filas > 0) {

                System.out.println();
                System.out.println(
                        "========================================"
                );
                System.out.println(
                        "   CLIENTE REGISTRADO CORRECTAMENTE"
                );
                System.out.println(
                        "========================================"
                );

                return true;
            }

            return false;

        } catch (SQLException e) {

            System.out.println();
            System.out.println(
                    "========================================"
            );
            System.out.println(
                    "       ERROR AL REGISTRAR CLIENTE"
            );
            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "Mensaje: " + e.getMessage()
            );

            System.out.println(
                    "Código MySQL: " + e.getErrorCode()
            );

            return false;
        }
    }

    // ==========================================
    // CONSULTAR CLIENTES
    // ==========================================

    public static void listarClientes() {

        String sql = "SELECT id_cliente, nombre, apellido, "
                + "telefono, correo, direccion, empresa "
                + "FROM clientes ORDER BY id_cliente";

        try {

            Connection conexion = ConexionBD.conectar();

            if (conexion == null) {
                System.out.println(
                        "No se pudo conectar con MySQL."
                );
                return;
            }

            PreparedStatement sentencia =
                    conexion.prepareStatement(sql);

            ResultSet resultado =
                    sentencia.executeQuery();

            System.out.println();
            System.out.println(
                    "=============================================="
            );
            System.out.println(
                    "              LISTA DE CLIENTES"
            );
            System.out.println(
                    "=============================================="
            );

            boolean hayClientes = false;

            while (resultado.next()) {

                hayClientes = true;

                System.out.println(
                        "ID: "
                        + resultado.getInt("id_cliente")
                );

                System.out.println(
                        "Nombre: "
                        + resultado.getString("nombre")
                        + " "
                        + resultado.getString("apellido")
                );

                System.out.println(
                        "Teléfono: "
                        + resultado.getString("telefono")
                );

                System.out.println(
                        "Correo: "
                        + resultado.getString("correo")
                );

                System.out.println(
                        "Dirección: "
                        + resultado.getString("direccion")
                );

                System.out.println(
                        "Empresa: "
                        + resultado.getString("empresa")
                );

                System.out.println(
                        "----------------------------------------------"
                );
            }

            if (!hayClientes) {

                System.out.println(
                        "No hay clientes registrados."
                );
            }

            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println(
                    "Error al consultar clientes:"
            );

            System.out.println(
                    e.getMessage()
            );
        }
    }
}