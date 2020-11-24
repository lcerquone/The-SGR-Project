package modelo;

import impl.Accionista;
import impl.AccionistaDTO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class AccionistaTableModel extends AbstractTableModel {
    private final List<Accionista> lista = new ArrayList<Accionista>();
    private final String[] columnNames = new String[]{"Codigo Accionista","Codigo Socio","Cuit", "RazonSocial", "Porcentaje"};
    private final Class[] columnClass = new Class[]{int.class,int.class,String.class, String.class, String.class};

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
                return lista.get(rowIndex).getCodigoAccionista();
            case 1:
                return lista.get(rowIndex).getCodigoSocio();
            case 2:
                return lista.get(rowIndex).getCuit();
            case 3:
                return lista.get(rowIndex).getRazonSocial();
            case 4:
                return lista.get(rowIndex).getPorcentaje();
            default:
                return null;
        }
    }

    public int add(int codigoaccionista,int codigosocio,String cuit, String razonsocial, String porcentaje) {

        AccionistaDTO accionista = new AccionistaDTO();
        accionista.setCodigoAccionista(codigoaccionista);
        accionista.setCodigoSocio(codigosocio);
        accionista.setCuit(cuit);
        accionista.setRazonSocial(razonsocial);
        accionista.setPorcentaje(porcentaje);

        lista.add(new Accionista(accionista));
        fireTableDataChanged();
        return lista.size() - 1;
    }


    public void remove(int rowIndex) {
        lista.remove(rowIndex);
        fireTableDataChanged();
    }

    public List<Accionista> getLista() {
        return lista;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Accionista row = lista.get(rowIndex);
        switch (columnIndex) {
            case 2:
                row.setCuit((String) aValue);
                break;
            case 3:
                row.setRazonSocial((String) aValue);
                break;
            case 4:
                row.setPorcentaje((String) aValue);
                break;
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }


    public void resetModel() {
        lista.clear();
        fireTableDataChanged();

    }
}
