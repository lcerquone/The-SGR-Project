package modelo;


public class SocioListModel {

    private final int codigo;
    private final String descripcion;


    public SocioListModel(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }


    public String toString() {
        return this.descripcion;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}