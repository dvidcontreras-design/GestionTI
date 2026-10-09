import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {

    // ==========================================
    // REGISTRAR PRODUCTO
    // ==========================================

    public static boolean registrarProducto(Producto producto) {

        String sql = """
                INSERT INTO productos
                (nombre_producto, descripcion, precio, stock, id_categoria, id_proveedor)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, producto.getNombreProducto());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setDouble(3, producto.getPrecio());
            sentencia.setInt(4, producto.getStock());
            sentencia.setInt(5, producto.getIdCategoria());
            sentencia.setInt(6, producto.getIdProveedor());

            int filas = sentencia.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println("Error al registrar producto: "
                    + e.getMessage());

            return false;
        }
    }

    // ==========================================
    // CONSULTAR PRODUCTOS
    // ==========================================

    public static void listarProductos() {

        String sql = """
                SELECT id_producto, nombre_producto, descripcion,
                       precio, stock, id_categoria, id_proveedor
                FROM productos
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("             PRODUCTOS");
            System.out.println("========================================");

            boolean hayProductos = false;

            while (resultado.next()) {

                hayProductos = true;

                System.out.println("----------------------------------------");
                System.out.println("ID: "
                        + resultado.getInt("id_producto"));

                System.out.println("Nombre: "
                        + resultado.getString("nombre_producto"));

                System.out.println("Descripción: "
                        + resultado.getString("descripcion"));

                System.out.println("Precio: $"
                        + resultado.getDouble("precio"));

                System.out.println("Stock: "
                        + resultado.getInt("stock"));

                System.out.println("Categoría: "
                        + resultado.getInt("id_categoria"));

                System.out.println("Proveedor: "
                        + resultado.getInt("id_proveedor"));
            }

            if (!hayProductos) {
                System.out.println("No hay productos registrados.");
            }

            System.out.println("----------------------------------------");

        } catch (SQLException e) {

            System.out.println("Error al consultar productos: "
                    + e.getMessage());
        }
    }
    public static void buscarProductoPorId(int id) {

    String sql = "SELECT * FROM productos WHERE id_producto = ?";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentencia = conexion.prepareStatement(sql)) {

        sentencia.setInt(1, id);

        ResultSet resultado = sentencia.executeQuery();

        if (resultado.next()) {

            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("          PRODUCTO ENCONTRADO");
            System.out.println("----------------------------------------");

            System.out.println("ID: " +
                    resultado.getInt("id_producto"));

            System.out.println("Nombre: " +
                    resultado.getString("nombre_producto"));

            System.out.println("Descripción: " +
                    resultado.getString("descripcion"));

            System.out.println("Precio: $" +
                    resultado.getDouble("precio"));

            System.out.println("Stock: " +
                    resultado.getInt("stock"));

            System.out.println("Categoría: " +
                    resultado.getInt("id_categoria"));

            System.out.println("Proveedor: " +
                    resultado.getInt("id_proveedor"));

            System.out.println("----------------------------------------");

        } else {

            System.out.println();
            System.out.println(
                    "No se encontró ningún producto con el ID: " + id
            );
        }

    } catch (Exception e) {

        System.out.println();
        System.out.println("Error al buscar el producto.");
        System.out.println("Detalle: " + e.getMessage());
    }
}
}