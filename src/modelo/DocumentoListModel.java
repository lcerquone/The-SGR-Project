package modelo;


public class DocumentoListModel {

    private final int codigo;
    private final String descripcion;


    public DocumentoListModel(int codigo, String descripcion) {
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