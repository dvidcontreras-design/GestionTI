import java.time.LocalDate;

public class Servicio {

    private int idServicio;
    private String tipoServicio;
    private String descripcion;
    private LocalDate fechaServicio;
    private double costo;
    private String estado;
    private int idCliente;
    private int idEmpleado;

    public Servicio(String tipoServicio, String descripcion,
                    LocalDate fechaServicio, double costo,
                    String estado, int idCliente, int idEmpleado) {

        this.tipoServicio = tipoServicio;
        this.descripcion = descripcion;
        this.fechaServicio = fechaServicio;
        this.costo = costo;
        this.estado = estado;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaServicio() {
        return fechaServicio;
    }

    public double getCosto() {
        return costo;
    }

    public String getEstado() {
        return estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }
}