package vista;

import controller.ControladorLineaDeCredito;
import impl.LineaCredito;
import modelo.LineaCreditoTableModel;

import javax.swing.*;

public class frmListaLineasCredito extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JTable tbLineasCredito;


    private final LineaCreditoTableModel modelo = new LineaCreditoTableModel();

    public frmListaLineasCredito(String titulo, ControladorLineaDeCredito COl) {

        super(titulo);
        //setear pantalla principal
        this.setContentPane(pnlPrincipal);
        //Embeber frame en la solapa
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        for (LineaCredito listado : COl.getListaLineaCredito() ) {
            modelo.add(listado.getCodigoLineaCredito(), listado.getCodigoSocio(), listado.getVigencia(), listado.getEstado(), listado.getMonto());
        }
        tbLineasCredito.setModel(modelo);
        tbLineasCredito.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }


}
