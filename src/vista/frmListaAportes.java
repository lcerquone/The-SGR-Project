package vista;

import controller.ControladorFDR;
import impl.Aporte;
import modelo.AporteTableModel;

import javax.swing.*;

public class frmListaAportes extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JTable tbAportes;
    private JButton cerrarButton;

    private final AporteTableModel modelo = new AporteTableModel();

    public frmListaAportes( String titulo, ControladorFDR CFDR) {

        super(titulo);
        //setear pantalla principal
        this.setContentPane(pnlPrincipal);
        //Embeber frame en la solapa
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);


        for (Aporte listado : CFDR.getListaAportes()) {
            modelo.add( listado.getCodigoAporte(),  listado.getCodigoSocio(), listado.getFecha(), listado.getEstado(), listado.getMonto());
        }
        tbAportes.setModel(modelo);
        tbAportes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


    }
}
