package modelo;


import impl.Comision;
import impl.ComisionDTO;
import impl.DateVO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class ComisionTableModel extends AbstractTableModel {
    private final List<Comision> lista = new ArrayList<Comision>();
    private final String[] columnNames = new String[]{"Codigo Operacion","Codigo Socio","Tipo","Estado","Fecha Emision","Monto"};
    private final Class[] columnClass = new Class[]{int.class,int.class, int.class,String.class,String.class,double.class};


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
                return lista.get(rowIndex).getEstado();
            case 4:
                return lista.get(rowIndex).getFechaEmision().toString();
            case 5:
                return lista.get(rowIndex).getMonto();
            default:
                return null;
        }
    }

    public int add(int codigooperacion, int codigosocio, int tipo, String estado, DateVO fechaemision, double monto) {
        ComisionDTO comision = new ComisionDTO();
        comision.setCodigoOperacion(codigooperacion);
        comision.setCodigoSocio(codigosocio);
        comision.setEstado(estado);
        comision.setTipo(tipo);
        comision.setFechaEmision(fechaemision);
        comision.setMonto(monto);

        lista.add(new Comision(comision));
        fireTableDataChanged();
        return lista.size() - 1;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public void resetModel(){
        lista.clear();
    }

}