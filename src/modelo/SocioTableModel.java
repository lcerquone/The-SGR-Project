package modelo;


import impl.DateVO;
import impl.EmailVO;
import impl.Socio;
import impl.SocioDTO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class SocioTableModel extends AbstractTableModel {
    private final List<Socio> lista = new ArrayList<Socio>();
    private final String[] columnNames = new String[]{"Codigo Socio", "Tipo","Estado", "Cuit", "Razon Social","Inicio Actividad",
    "Tamaño","Actividad Principal","Domicilio","Telefono","Email"};
    private final Class[] columnClass = new Class[]{int.class, String.class, String.class,String.class, String.class,String.class, String.class,String.class, String.class};


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
                return lista.get(rowIndex).getCodigoSocio();
            case 1:
                return lista.get(rowIndex).getTipo();
            case 2:
                return lista.get(rowIndex).getEstado();
            case 3:
                return lista.get(rowIndex).getCuit();
            case 4:
                return lista.get(rowIndex).getRazonSocial();
            case 5:
                return lista.get(rowIndex).getInicioActividad().toString();
            case 6:
                return lista.get(rowIndex).getTamaño();
            case 7:
                return lista.get(rowIndex).getActividadPrincipal();
            case 8:
                return lista.get(rowIndex).getDomicilio();
            case 9:
                return lista.get(rowIndex).getTelefono();
            case 10:
                return lista.get(rowIndex).getEmail().toString();
            default:
                return null;
        }
    }

    public int add(int codigosocio, String tipo, String estado, String cuit, String razonsocial, DateVO inicioactividad,
                   String tamaño, String actividadprincipal, String domicilio, String telefono, EmailVO email) {

        SocioDTO socio = new SocioDTO();
        socio.setCodigoSocio(codigosocio);
        socio.setTipo(tipo);
        socio.setEstado(estado);
        socio.setCuit(cuit);
        socio.setRazonSocial(razonsocial);
        socio.setInicioActividad(inicioactividad);
        socio.setTamaño(tamaño);
        socio.setActividadPrincipal(actividadprincipal);
        socio.setDomicilio(domicilio);
        socio.setTelefono(telefono);
        socio.setEmail(email);

        lista.add(new Socio( socio));

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