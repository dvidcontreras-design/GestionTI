import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LicenciaDAO {

    public static boolean registrarLicencia(Licencia licencia) {

        String sql = "INSERT INTO licencias "
                + "(software, tipo_licencia, fecha_inicio, fecha_fin, precio, id_cliente) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, licencia.getSoftware());
            ps.setString(2, licencia.getTipoLicencia());
            ps.setDate(3, java.sql.Date.valueOf(licencia.getFechaInicio()));
            ps.setDate(4, java.sql.Date.valueOf(licencia.getFechaFin()));
            ps.setDouble(5, licencia.getPrecio());
            ps.setInt(6, licencia.getIdCliente());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Error al registrar la licencia: "
                    + e.getMessage());
            return false;
        }
    }

    public static void listarLicencias() {

        String sql = "SELECT * FROM licencias";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println();
            System.out.println("==========================================");
            System.out.println("          LISTADO DE LICENCIAS");
            System.out.println("==========================================");

            boolean hayLicencias = false;

            while (rs.next()) {

                hayLicencias = true;

                System.out.println("ID licencia: " + rs.getInt("id_licencia"));
                System.out.println("Software: " + rs.getString("software"));
                System.out.println("Tipo de licencia: " + rs.getString("tipo_licencia"));
                System.out.println("Fecha inicio: " + rs.getDate("fecha_inicio"));
                System.out.println("Fecha fin: " + rs.getDate("fecha_fin"));
                System.out.println("Precio: $" + rs.getDouble("precio"));
                System.out.println("ID cliente: " + rs.getInt("id_cliente"));
                System.out.println("------------------------------------------");
            }

            if (!hayLicencias) {
                System.out.println("No hay licencias registradas.");
            }

        } catch (Exception e) {
            System.out.println("Error al consultar las licencias: "
                    + e.getMessage());
        }
    }

    public static void buscarLicenciaPorId(int id) {

        String sql = "SELECT * FROM licencias WHERE id_licencia = ?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println();
                    System.out.println("==========================================");
                    System.out.println("           LICENCIA ENCONTRADA");
                    System.out.println("==========================================");

                    System.out.println("ID licencia: " + rs.getInt("id_licencia"));
                    System.out.println("Software: " + rs.getString("software"));
                    System.out.println("Tipo de licencia: "
                            + rs.getString("tipo_licencia"));
                    System.out.println("Fecha inicio: "
                            + rs.getDate("fecha_inicio"));
                    System.out.println("Fecha fin: "
                            + rs.getDate("fecha_fin"));
                    System.out.println("Precio: $" + rs.getDouble("precio"));
                    System.out.println("ID cliente: "
                            + rs.getInt("id_cliente"));

                } else {

                    System.out.println();
                    System.out.println("No se encontró ninguna licencia "
                            + "con el ID " + id);
                }
            }

        } catch (Exception e) {
            System.out.println("Error al buscar la licencia: "
                    + e.getMessage());
        }
    }
}