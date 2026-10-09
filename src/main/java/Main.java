import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("          SISTEMA DE GESTIÓN TI");
        System.out.println("========================================");

        Connection conexion = ConexionBD.conectar();

        if (conexion == null) {
            System.out.println("No se pudo conectar con MySQL.");
            return;
        }

        try {
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión.");
        }

        menuPrincipal();
    }

    // ==========================================
    // MENÚ PRINCIPAL
    // ==========================================

    public static void menuPrincipal() {

        int opcion;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("          SISTEMA DE GESTIÓN TI");
            System.out.println("========================================");
            System.out.println("1. Gestionar clientes");
            System.out.println("2. Gestionar productos");
            System.out.println("3. Gestionar servicios técnicos");
            System.out.println("4. Gestionar licencias");
            System.out.println("5. Gestionar instalaciones TI");
            System.out.println("6. Gestionar ventas");
            System.out.println("0. Salir");
            System.out.println("========================================");

            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    menuClientes();
                    break;

                case 2:
                 menuProductos();
                 break;

                case 3:
                    menuServicios();
                    break;

                case 4:
                    menuLicencias();
                    break;

                case 5:
                    menuInstalaciones();
                    break;

                case 6:
                    System.out.println(
                            "Módulo de ventas próximamente."
                    );
                    break;

                case 0:
                    System.out.println(
                            "Programa finalizado."
                    );
                    break;

                default:
                    System.out.println(
                            "Opción no válida."
                    );
            }

        } while (opcion != 0);
    }

    // ==========================================
    // MENÚ DE CLIENTES
    // ==========================================

    public static void menuClientes() {

        int opcion;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("              CLIENTES");
            System.out.println("========================================");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Consultar clientes");
            System.out.println("0. Volver");
            System.out.println("========================================");

            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    registrarCliente();
                    break;

                case 2:
                    ClienteDAO.listarClientes();
                    break;

                case 0:
                    System.out.println(
                            "Volviendo al menú principal..."
                    );
                    break;

                default:
                    System.out.println(
                            "Opción no válida."
                    );
            }

        } while (opcion != 0);
    }

    // ==========================================
    // REGISTRAR CLIENTE
    // ==========================================

    public static void registrarCliente() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("          REGISTRAR CLIENTE");
        System.out.println("========================================");

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("Teléfono: ");
        String telefono = teclado.nextLine();

        System.out.print("Correo: ");
        String correo = teclado.nextLine();

        System.out.print("Dirección: ");
        String direccion = teclado.nextLine();

        System.out.print("Empresa: ");
        String empresa = teclado.nextLine();

        Cliente cliente = new Cliente(
                nombre,
                apellido,
                telefono,
                correo,
                direccion,
                empresa
        );

        boolean registrado =
                ClienteDAO.registrarCliente(cliente);

        if (registrado) {

            System.out.println();
            System.out.println(
                    "Cliente registrado correctamente."
            );

        } else {

            System.out.println();
            System.out.println(
                    "No fue posible registrar el cliente."
            );
        }
    }
    // ==========================================
// MENÚ DE PRODUCTOS
// ==========================================

public static void menuProductos() {

    int opcion;

    do {

        System.out.println();
        System.out.println("========================================");
        System.out.println("             PRODUCTOS");
        System.out.println("========================================");
        System.out.println("1. Registrar producto");
        System.out.println("2. Consultar productos");
        System.out.println("3. Buscar producto");
        System.out.println("0. Volver");
        System.out.println("========================================");

        System.out.print("Seleccione una opción: ");

        opcion = teclado.nextInt();
        teclado.nextLine();

        switch (opcion) {

            case 1:
                registrarProducto();
                break;

            case 2:
                ProductoDAO.listarProductos();

                System.out.println();
                System.out.println("Presione ENTER para continuar...");
                teclado.nextLine();
                break;

            case 0:
                System.out.println("Volviendo al menú principal...");
                break;

            case 3:
             menuServicios();
             break;

            default:
                System.out.println("Opción no válida.");
        }

    } while (opcion != 0);
}
// ==========================================
// MENÚ DE SERVICIOS
// ==========================================

public static void menuServicios() {

    int opcion;

    do {

        System.out.println();
        System.out.println("========================================");
        System.out.println("              SERVICIOS");
        System.out.println("========================================");
        System.out.println("1. Registrar servicio");
        System.out.println("2. Consultar servicios");
        System.out.println("3. Buscar servicio");
        System.out.println("0. Volver");
        System.out.println("========================================");
        System.out.print("Seleccione una opción: ");

        opcion = teclado.nextInt();
        teclado.nextLine();

        switch (opcion) {

            case 1:
                registrarServicio();
                break;

            case 2:
                ServicioDAO.listarServicios();

                System.out.println();
                System.out.println("Presione ENTER para continuar...");
                teclado.nextLine();
                break;

            case 3:
                buscarServicio();
                break;

            case 0:
                System.out.println("Volviendo al menú principal...");
                break;

            default:
                System.out.println("Opción no válida.");
        }

    } while (opcion != 0);
}
// =========================================
// MENÚ DE LICENCIAS
// =========================================

public static void menuLicencias() {

    int opcion;

    do {

        System.out.println();
        System.out.println("========================================");
        System.out.println("              LICENCIAS");
        System.out.println("========================================");
        System.out.println("1. Registrar licencia");
        System.out.println("2. Consultar licencias");
        System.out.println("3. Buscar licencia");
        System.out.println("0. Volver");
        System.out.println("========================================");
        System.out.print("Seleccione una opción: ");

        opcion = teclado.nextInt();
        teclado.nextLine();

        switch (opcion) {

            case 1:
                registrarLicencia();
                break;

            case 2:
                LicenciaDAO.listarLicencias();

                System.out.println();
                System.out.println("Presione ENTER para continuar...");
                teclado.nextLine();
                break;

            case 3:
                buscarLicencia();
                break;

            case 0:
                System.out.println("Volviendo al menú principal...");
                break;

            default:
                System.out.println("Opción no válida.");
        }

    } while (opcion != 0);
}
// ==========================================
// REGISTRAR PRODUCTO
// ==========================================

public static void registrarProducto() {

    System.out.println();
    System.out.println("========================================");
    System.out.println("          REGISTRAR PRODUCTO");
    System.out.println("========================================");

    System.out.print("Nombre del producto: ");
    String nombre = teclado.nextLine();

    System.out.print("Descripción: ");
    String descripcion = teclado.nextLine();

    System.out.print("Precio: ");
    double precio = teclado.nextDouble();

    System.out.print("Stock: ");
    int stock = teclado.nextInt();

    System.out.print("ID de categoría: ");
    int idCategoria = teclado.nextInt();

    System.out.print("ID de proveedor: ");
    int idProveedor = teclado.nextInt();

    teclado.nextLine();

    Producto producto = new Producto(
            nombre,
            descripcion,
            precio,
            stock,
            idCategoria,
            idProveedor
    );

    boolean registrado = ProductoDAO.registrarProducto(producto);

    System.out.println();

    if (registrado) {
        System.out.println("PRODUCTO REGISTRADO CORRECTAMENTE.");
    } else {
        System.out.println("NO FUE POSIBLE REGISTRAR EL PRODUCTO.");
    }

    System.out.println();
    System.out.println("Presione ENTER para continuar...");
    teclado.nextLine();
}
public static void registrarServicio() {

    System.out.println();
    System.out.println("==========================================");
    System.out.println("          REGISTRAR SERVICIO");
    System.out.println("==========================================");

    System.out.print("Tipo de servicio: ");
    String tipoServicio = teclado.nextLine();

    System.out.print("Descripción: ");
    String descripcion = teclado.nextLine();

    System.out.print("Fecha del servicio (AAAA-MM-DD): ");
    LocalDate fechaServicio = LocalDate.parse(teclado.nextLine());

    System.out.print("Costo: ");
    double costo = teclado.nextDouble();
    teclado.nextLine();

    System.out.print("Estado: ");
    String estado = teclado.nextLine();

    System.out.print("ID del cliente: ");
    int idCliente = teclado.nextInt();

    System.out.print("ID del empleado: ");
    int idEmpleado = teclado.nextInt();
    teclado.nextLine();

    Servicio servicio = new Servicio(
        tipoServicio,
        descripcion,
        fechaServicio,
        costo,
        estado,
        idCliente,
        idEmpleado
    );

    boolean registrado = ServicioDAO.registrarServicio(servicio);

    if (registrado) {
        System.out.println();
        System.out.println("SERVICIO REGISTRADO CORRECTAMENTE.");
    } else {
        System.out.println();
        System.out.println("NO SE PUDO REGISTRAR EL SERVICIO.");
    }

    System.out.println();
    System.out.println("Presione ENTER para continuar...");
    teclado.nextLine();
}
public static void registrarLicencia() {

    System.out.println();
    System.out.println("==========================================");
    System.out.println("          REGISTRAR LICENCIA");
    System.out.println("==========================================");

    System.out.print("Software: ");
    String software = teclado.nextLine();

    System.out.print("Tipo de licencia: ");
    String tipoLicencia = teclado.nextLine();

    System.out.print("Fecha de inicio (AAAA-MM-DD): ");
    LocalDate fechaInicio = LocalDate.parse(teclado.nextLine());

    System.out.print("Fecha de fin (AAAA-MM-DD): ");
    LocalDate fechaFin = LocalDate.parse(teclado.nextLine());

    System.out.print("Precio: ");
    double precio = teclado.nextDouble();
    teclado.nextLine();

    System.out.print("ID del cliente: ");
    int idCliente = teclado.nextInt();
    teclado.nextLine();

    Licencia licencia = new Licencia(
        software,
        tipoLicencia,
        fechaInicio,
        fechaFin,
        precio,
        idCliente
    );

    boolean registrado = LicenciaDAO.registrarLicencia(licencia);

    if (registrado) {
        System.out.println();
        System.out.println("LICENCIA REGISTRADA CORRECTAMENTE.");
    } else {
        System.out.println();
        System.out.println("NO SE PUDO REGISTRAR LA LICENCIA.");
    }

    System.out.println();
    System.out.println("Presione ENTER para continuar...");
    teclado.nextLine();
}
public static void buscarServicio() {

    System.out.println();
    System.out.println("==========================================");
    System.out.println("          BUSCAR SERVICIO");
    System.out.println("==========================================");

    System.out.print("Ingrese el ID del servicio: ");
    int id = teclado.nextInt();
    teclado.nextLine();

    ServicioDAO.buscarServicioPorId(id);

    System.out.println();
    System.out.println("Presione ENTER para continuar...");
    teclado.nextLine();
}
public static void buscarLicencia() {

    System.out.println();
    System.out.println("==========================================");
    System.out.println("           BUSCAR LICENCIA");
    System.out.println("==========================================");

    System.out.print("Ingrese el ID de la licencia: ");
    int id = teclado.nextInt();
    teclado.nextLine();

    LicenciaDAO.buscarLicenciaPorId(id);

    System.out.println();
    System.out.println("Presione ENTER para continuar...");
    teclado.nextLine();
}
public static void buscarProducto() {

    System.out.println();
    System.out.println("========================================");
    System.out.println("          BUSCAR PRODUCTO");
    System.out.println("========================================");

    System.out.print("Ingrese el ID del producto: ");

    int id = teclado.nextInt();
    teclado.nextLine();

    ProductoDAO.buscarProductoPorId(id);

    System.out.println();
    System.out.println("Presione ENTER para continuar...");
    teclado.nextLine();
}
public static void menuInstalaciones() {

    int opcion;

    do {
        System.out.println();
        System.out.println("========================================");
        System.out.println("          INSTALACIONES TI");
        System.out.println("========================================");
        System.out.println("1. Registrar instalación");
        System.out.println("2. Consultar instalaciones");
        System.out.println("3. Buscar instalación por ID");
        System.out.println("0. Volver al menú principal");
        System.out.println("========================================");
        System.out.print("Seleccione una opción: ");

        opcion = teclado.nextInt();
        teclado.nextLine();

        switch (opcion) {
            case 1:
                registrarInstalacion();
                break;

            case 2:
                InstalacionDAO.listarInstalaciones();
                System.out.println();
                System.out.println("Presione ENTER para continuar...");
                teclado.nextLine();
                break;

            case 3:
                buscarInstalacion();
                break;

            case 0:
                System.out.println("Volviendo al menú principal...");
                break;

            default:
                System.out.println("Opción no válida.");
        }

    } while (opcion != 0);
}

public static void registrarInstalacion() {

    System.out.println();
    System.out.println("========================================");
    System.out.println("         REGISTRAR INSTALACION");
    System.out.println("========================================");

    System.out.print("Tipo de instalación: ");
    String tipoInstalacion = teclado.nextLine();

    System.out.print("Descripción: ");
    String descripcion = teclado.nextLine();

    System.out.print("Fecha (AAAA-MM-DD): ");
    LocalDate fechaInstalacion = LocalDate.parse(teclado.nextLine());

    System.out.print("Costo: ");
    double costo = teclado.nextDouble();
    teclado.nextLine();

    System.out.print("ID del cliente: ");
    int idCliente = teclado.nextInt();
    teclado.nextLine();

    System.out.print("ID del empleado: ");
    int idEmpleado = teclado.nextInt();
    teclado.nextLine();

    Instalacion instalacion = new Instalacion(
        tipoInstalacion,
        descripcion,
        fechaInstalacion,
        costo,
        idCliente,
        idEmpleado
    );

    boolean registrado =
        InstalacionDAO.registrarInstalacion(instalacion);

    if (registrado) {
        System.out.println();
        System.out.println("INSTALACION REGISTRADA CORRECTAMENTE.");
    } else {
        System.out.println();
        System.out.println("NO SE PUDO REGISTRAR LA INSTALACION.");
    }

    System.out.println();
    System.out.println("Presione ENTER para continuar...");
    teclado.nextLine();
}

public static void buscarInstalacion() {

    System.out.println();
    System.out.println("========================================");
    System.out.println("          BUSCAR INSTALACION");
    System.out.println("========================================");

    System.out.print("Ingrese el ID de la instalación: ");
    int id = teclado.nextInt();
    teclado.nextLine();

    InstalacionDAO.buscarInstalacionPorId(id);

    System.out.println();
    System.out.println("Presione ENTER para continuar...");
    teclado.nextLine();
}
}