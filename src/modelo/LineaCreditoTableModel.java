package modelo;


import impl.DateVO;
import impl.LineaCredito;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class LineaCreditoTableModel extends AbstractTableModel {
    private final List<LineaCredito> lista = new ArrayList<LineaCredito>();
    private final String[] columnNames = new String[]{"Codigo Linea Credito","Codigo Socio","Vigencia","Estado", "Monto"};
    private final Class[] columnClass = new Class[]{int.class, int.class, String.class, String.class,String.class,double.class};


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
                return lista.get(rowIndex).getCodigoLineaCredito();
            case 1:
                return lista.get(rowIndex).getCodigoSocio();
            case 2:
                return lista.get(rowIndex).getVigencia().toString();
            case 3:
                return lista.get(rowIndex).getEstado();
            case 4:
                return lista.get(rowIndex).getMonto();
            default:
                return null;
        }
    }

    public int add(int codigolineacredito, int codigosocio,DateVO vigencia, String estado, double monto) {
        lista.add(new LineaCredito(codigolineacredito,codigosocio,vigencia, estado, monto));
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