package modelo;


import impl.DateVO;
import impl.Documento;
import impl.DocumentoDTO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class DocumentoTableModel extends AbstractTableModel {
    private final List<Documento> lista = new ArrayList<Documento>();
    private final String[] columnNames = new String[]{"Codigo Documento","Codigo Socio", "Tipo","Estado", "Usuario","Fecha Recepcion","Obligatorio"};
    private final Class[] columnClass = new Class[]{int.class,int.class, String.class, String.class,String.class,String.class,String.class};


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
                return lista.get(rowIndex).getCodigoDocumento();
            case 1:
                return lista.get(rowIndex).getCodigoSocio();
            case 2:
                return lista.get(rowIndex).getTipo();
            case 3:
                return lista.get(rowIndex).getEstado();
            case 4:
                return lista.get(rowIndex).getUsuario();
            case 5:
                return lista.get(rowIndex).getFechaRecepcion();
            case 6:
                return lista.get(rowIndex).getObligatorio();
            default:
                return null;
        }
    }

    public int add(int codigodocumento, int codigosocio, String tipo, String estado, String usuario, DateVO fecharecepcion, String obligatorio) {

        DocumentoDTO documento = new DocumentoDTO();
        documento.setCodigoDocumento(codigodocumento);
        documento.setCodigoSocio(codigosocio);
        documento.setEstado(estado);
        documento.setTipo(tipo);
        documento.setUsuario(usuario);
        documento.setFechaRecepcion(fecharecepcion);
        documento.setObligatorio(obligatorio);

        lista.add(new Documento(documento));
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