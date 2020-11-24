package impl;

public class ComisionTable {
    public String calcularPorcentaje(int Tipo){
        String porcentaje = "";
        if (Tipo == 3){
            porcentaje = "4%";
        } else {
            porcentaje = "3%";
        }
        return porcentaje;
    }
}
