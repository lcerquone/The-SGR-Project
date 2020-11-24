package modelo;

public class tipoAmortizacionListModel {
    private final int codigo;
    private final String descripcion;

    public tipoAmortizacionListModel(int codigo, String descripcion){
        this.codigo= codigo;
        this.descripcion=descripcion;
    }
    public String toString(){
        return this.descripcion;
    }

}

