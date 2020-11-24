package modelo;


import impl.Aporte;
import impl.AporteDTO;
import impl.DateVO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class AporteTableModel extends AbstractTableModel {
    private final List<Aporte> lista = new ArrayList<Aporte>();
    private final String[] columnNames = new String[]{"Codigo Aporte","Codigo Socio", "Fecha","Estado", "Monto"};
    private final Class[] columnClass = new Class[]{int.class,int.class, String.class, String.class,double.class};


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
                return lista.get(rowIndex).getCodigoAporte();
            case 1:
                return lista.get(rowIndex).getCodigoSocio();
            case 2:
                return lista.get(rowIndex).getFecha();
            case 3:
                return lista.get(rowIndex).getEstado();
            case 4:
                return lista.get(rowIndex).getMonto();
            default:
                return null;
        }
    }

    public int add(int codigoaporte, int codigosocio, DateVO fecha, String estado, double monto) {
        AporteDTO aporte= new AporteDTO();
        aporte.setCodigoAporte(codigoaporte);
        aporte.setCodigoSocio(codigosocio);
        aporte.setEstado(estado);
        aporte.setFecha(fecha);
        aporte.setMonto(monto);

        lista.add(new Aporte( aporte));
        fireTableDataChanged();
        return lista.size() - 1;
    }


    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}