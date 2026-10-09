import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServicioDAO {

    // ==========================================
    // REGISTRAR SERVICIO
    // ==========================================
    public static boolean registrarServicio(Servicio servicio) {

        String sql = "INSERT INTO servicios " +
                     "(tipo_servicio, descripcion, fecha_servicio, costo, estado, id_cliente, id_empleado) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, servicio.getTipoServicio());
            ps.setString(2, servicio.getDescripcion());
            ps.setDate(3, java.sql.Date.valueOf(servicio.getFechaServicio()));
            ps.setDouble(4, servicio.getCosto());
            ps.setString(5, servicio.getEstado());
            ps.setInt(6, servicio.getIdCliente());
            ps.setInt(7, servicio.getIdEmpleado());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Error al registrar el servicio: " + e.getMessage());
            return false;
        }
    }


    // ==========================================
    // LISTAR SERVICIOS
    // ==========================================
    public static void listarServicios() {

        String sql = "SELECT * FROM servicios";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("             SERVICIOS");
            System.out.println("========================================");

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id_servicio"));
                System.out.println("Tipo: " + rs.getString("tipo_servicio"));
                System.out.println("Descripción: " + rs.getString("descripcion"));
                System.out.println("Fecha: " + rs.getDate("fecha_servicio"));
                System.out.println("Costo: $" + rs.getDouble("costo"));
                System.out.println("Estado: " + rs.getString("estado"));
                System.out.println("Cliente: " + rs.getInt("id_cliente"));
                System.out.println("Empleado: " + rs.getInt("id_empleado"));
                System.out.println("----------------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Error al consultar los servicios: " + e.getMessage());
        }
    }


    // ==========================================
    // BUSCAR SERVICIO POR ID
    // ==========================================
    public static void buscarServicioPorId(int id) {

        String sql = "SELECT * FROM servicios WHERE id_servicio = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println();
                System.out.println("========================================");
                System.out.println("          SERVICIO ENCONTRADO");
                System.out.println("========================================");

                System.out.println("ID: " + rs.getInt("id_servicio"));
                System.out.println("Tipo: " + rs.getString("tipo_servicio"));
                System.out.println("Descripción: " + rs.getString("descripcion"));
                System.out.println("Fecha: " + rs.getDate("fecha_servicio"));
                System.out.println("Costo: $" + rs.getDouble("costo"));
                System.out.println("Estado: " + rs.getString("estado"));
                System.out.println("Cliente: " + rs.getInt("id_cliente"));
                System.out.println("Empleado: " + rs.getInt("id_empleado"));

                System.out.println("========================================");

            } else {

                System.out.println();
                System.out.println("No se encontró ningún servicio con el ID: " + id);
            }

        } catch (Exception e) {
            System.out.println("Error al buscar el servicio: " + e.getMessage());
     
       }
     }
     }
     