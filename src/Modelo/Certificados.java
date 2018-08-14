package Modelo;

public class Certificados {

    private int id;
    private int ciudadano;
    private String fecha;
    private int estado;
    private int condicion;
    private String num;
    private String fechaRevision;
    private int userRegistro;

    public int getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(int userRegistro) {
        this.userRegistro = userRegistro;
    }

    public String getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(int ciudadano) {
        this.ciudadano = ciudadano;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

}
