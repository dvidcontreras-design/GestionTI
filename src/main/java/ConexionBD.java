
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class ConexionBD {

    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    private static final String URL = dotenv.get(
            "DB_URL", "jdbc:mysql://localhost:3306/gestion_ti");

    private static final String USUARIO = dotenv.get(
            "DB_USER", "root");

    private static final String PASSWORD = dotenv.get(
            "DB_PASSWORD", "");

    public static Connection conectar() {

        try {
            Connection conexion = DriverManager.getConnection(
                    URL,
                    USUARIO,
                    PASSWORD
            );

            System.out.println("Conexión exitosa con MySQL.");
            return conexion;

        } catch (SQLException e) {
            System.out.println("Error al conectar con MySQL: "
                    + e.getMessage());
            return null;
        }
    }
}
