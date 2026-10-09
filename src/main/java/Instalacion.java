import java.time.LocalDate;

public class Instalacion {

    private int idInstalacion;
    private String tipoInstalacion;
    private String descripcion;
    private LocalDate fechaInstalacion;
    private double costo;
    private int idCliente;
    private int idEmpleado;

    public Instalacion(String tipoInstalacion, String descripcion,
                       LocalDate fechaInstalacion, double costo,
                       int idCliente, int idEmpleado) {

        this.tipoInstalacion = tipoInstalacion;
        this.descripcion = descripcion;
        this.fechaInstalacion = fechaInstalacion;
        this.costo = costo;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
    }

    public int getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(int idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getTipoInstalacion() {
        return tipoInstalacion;
    }

    public void setTipoInstalacion(String tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(LocalDate fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}