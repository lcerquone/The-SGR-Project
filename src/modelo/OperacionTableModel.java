package modelo;


import impl.*;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class OperacionTableModel extends AbstractTableModel {
    private final List<Operacion> lista = new ArrayList<Operacion>();
    private final String[] columnNames = new String[]{"Codigo Operacion","Codigo Socio", "Tipo","Fecha","Estado", "Monto"};
    private final Class[] columnClass = new Class[]{int.class, int.class,String.class,String.class, String.class,double.class};


    public String getcolumnNames(int col) {
        return columnNames[col];
    }
    public Class getcolumnClass(int col) {
        return columnClass[col];
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lista.get(rowIndex).getCodigoOperacion();
            case 1:
                return lista.get(rowIndex).getCodigoSocio();
            case 2:
                return lista.get(rowIndex).getTipo();
            case 3:
                return lista.get(rowIndex).getFecha().toString();
            case 4:
                return lista.get(rowIndex).getEstado();
            case 5:
                return lista.get(rowIndex).getMonto();

            default:
                return null;
        }
    }

    public int add(int codigooperacion, int codigosocio, int tipo, DateVO fecha, String estado, double monto) {
        OperacionDTO operacion = new OperacionDTO();

        operacion.setCodigoOperacion(codigooperacion);
        operacion.setCodigoSocio(codigosocio);
        operacion.setTipo(tipo);
        operacion.setEstado(estado);
        operacion.setMonto(monto);
        operacion.setFecha(fecha);

        lista.add(new Operacion(operacion));
        fireTableDataChanged();
        return lista.size() - 1;
    }

    public void resetModel(){
        lista.clear();
    }
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}