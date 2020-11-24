package modelo;


import impl.Certificado;
import impl.CertificadoDTO;
import impl.DateVO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class CertificadoTableModel extends AbstractTableModel {
    private final List<Certificado> lista = new ArrayList<>();
    private final String[] columnNames = new String[]{"Codigo Certificado","Codigo Operacion","Codigo Socio", "Fecha Emision"};
    private final Class[] columnClass = new Class[]{int.class,int.class,int.class, String.class};


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
                return lista.get(rowIndex).getCodigoCertificado();
            case 1:
                return lista.get(rowIndex).getCodigoOperacion();
            case 2:
                return lista.get(rowIndex).getCodigoSocio();
            case 3:
                return lista.get(rowIndex).getFechaEmision().toString();
            default:
                return null;
        }
    }

    public int add(int codigocertificado, int codigooperacion, int codigosocio, DateVO fechaemision) {
        CertificadoDTO certificado = new CertificadoDTO();
        certificado.setCodigoCertificado(codigocertificado);
        certificado.setCodigoOperacion(codigooperacion);
        certificado.setCodigoSocio(codigosocio);
        certificado.setFechaEmision(fechaemision);

        lista.add(new Certificado(certificado));
        fireTableDataChanged();
        return lista.size() - 1;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}