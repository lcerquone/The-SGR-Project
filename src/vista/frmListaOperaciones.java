package vista;

import controller.ControladorLineaDeCredito;
import impl.Operacion;
import modelo.OperacionTableModel;

import javax.swing.*;

public class frmListaOperaciones extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JTable tbOperaciones;

    private final OperacionTableModel modelo = new OperacionTableModel();

    public frmListaOperaciones( String titulo, ControladorLineaDeCredito COl) {

        super(titulo);
        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        for (Operacion listado : COl.getListaOperaciones()) {
                    modelo.add(listado.getCodigoOperacion(), listado.getCodigoSocio(), listado.getTipo(), listado.getFecha(), listado.getEstado(), listado.getMonto());
        }

        tbOperaciones.setModel(modelo);
        tbOperaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


    }
}