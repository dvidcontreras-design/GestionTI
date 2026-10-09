import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InstalacionDAO {

    public static boolean registrarInstalacion(Instalacion instalacion) {

        String sql = "INSERT INTO instalaciones "
                + "(tipo_instalacion, descripcion, fecha_instalacion, costo, id_cliente, id_empleado) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, instalacion.getTipoInstalacion());
            ps.setString(2, instalacion.getDescripcion());
            ps.setDate(3, java.sql.Date.valueOf(
                    instalacion.getFechaInstalacion()));
            ps.setDouble(4, instalacion.getCosto());
            ps.setInt(5, instalacion.getIdCliente());
            ps.setInt(6, instalacion.getIdEmpleado());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Error al registrar la instalación: "
                    + e.getMessage());
            return false;
        }
    }

    public static void listarInstalaciones() {

        String sql = "SELECT * FROM instalaciones";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println();
            System.out.println("==========================================");
            System.out.println("        LISTADO DE INSTALACIONES");
            System.out.println("==========================================");

            boolean hayInstalaciones = false;

            while (rs.next()) {

                hayInstalaciones = true;

                System.out.println("ID instalación: "
                        + rs.getInt("id_instalacion"));
                System.out.println("Tipo de instalación: "
                        + rs.getString("tipo_instalacion"));
                System.out.println("Descripción: "
                        + rs.getString("descripcion"));
                System.out.println("Fecha de instalación: "
                        + rs.getDate("fecha_instalacion"));
                System.out.println("Costo: $"
                        + rs.getDouble("costo"));
                System.out.println("ID cliente: "
                        + rs.getInt("id_cliente"));
                System.out.println("ID empleado: "
                        + rs.getInt("id_empleado"));

                System.out.println("------------------------------------------");
            }

            if (!hayInstalaciones) {
                System.out.println("No hay instalaciones registradas.");
            }

        } catch (Exception e) {
            System.out.println("Error al consultar las instalaciones: "
                    + e.getMessage());
        }
    }

    public static void buscarInstalacionPorId(int id) {

        String sql = "SELECT * FROM instalaciones "
                + "WHERE id_instalacion = ?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println();
                    System.out.println("==========================================");
                    System.out.println("       INSTALACIÓN ENCONTRADA");
                    System.out.println("==========================================");

                    System.out.println("ID instalación: "
                            + rs.getInt("id_instalacion"));
                    System.out.println("Tipo de instalación: "
                            + rs.getString("tipo_instalacion"));
                    System.out.println("Descripción: "
                            + rs.getString("descripcion"));
                    System.out.println("Fecha de instalación: "
                            + rs.getDate("fecha_instalacion"));
                    System.out.println("Costo: $"
                            + rs.getDouble("costo"));
                    System.out.println("ID cliente: "
                            + rs.getInt("id_cliente"));
                    System.out.println("ID empleado: "
                            + rs.getInt("id_empleado"));

                } else {

                    System.out.println();
                    System.out.println("No se encontró ninguna instalación "
                            + "con el ID " + id);
                }
            }

        } catch (Exception e) {
            System.out.println("Error al buscar la instalación: "
                    + e.getMessage());
        }
    }
}