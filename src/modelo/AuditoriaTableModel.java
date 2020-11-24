package modelo;

import impl.Auditoria;
import impl.AuditoriaDTO;

import javax.swing.table.AbstractTableModel;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AuditoriaTableModel extends AbstractTableModel {
    private final List<Auditoria> lista = new ArrayList<>();
    private final String[] columnNames = new String[]{"Codigo Auditoria","TimeStamp","Operacion", "Estado Anterior", "Estado Posterior","Usuario"};
    private final Class[] columnClass = new Class[]{int.class, Timestamp.class,String.class, String.class, String.class, String.class};

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
                return lista.get(rowIndex).getCodigoauditoria();
            case 1:
                return lista.get(rowIndex).getTimestamp();
            case 2:
                return lista.get(rowIndex).getEvento();
            case 3:
                return lista.get(rowIndex).getEstadoanterior();
            case 4:
                return lista.get(rowIndex).getEstadoposterior();
            case 5:
                return lista.get(rowIndex).getUsuario();
            default:
                return null;
        }
    }

    public int add(int codigoauditoria,Timestamp timestamp, String evento, String estadoanterior, String estadoposterior,String usuario) {

        AuditoriaDTO auditoria = new AuditoriaDTO();
        auditoria.setCodigoAuditoria(codigoauditoria);
        auditoria.setTimestamp(timestamp);
        auditoria.setEvento(evento);
        auditoria.setEstadoAnterior(estadoanterior);
        auditoria.setEstadoPosterior(estadoposterior);
        auditoria.setUsuario(usuario);

        lista.add(new Auditoria(auditoria));
        fireTableDataChanged();
        return lista.size() - 1;
    }


    public void remove(int rowIndex) {
        lista.remove(rowIndex);
        fireTableDataChanged();
    }

    public List<Auditoria> getLista() {
        return lista;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

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
