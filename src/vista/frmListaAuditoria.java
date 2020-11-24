package vista;

import controller.ControladorAuditoria;
import impl.Auditoria;
import modelo.AuditoriaTableModel;

import javax.swing.*;

public class frmListaAuditoria extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JTable tbAuditoria;
    private JButton cerrarButton;

    private final AuditoriaTableModel modelo = new AuditoriaTableModel();

    public frmListaAuditoria( String titulo, ControladorAuditoria CA) {

        super(titulo);
        //setear pantalla principal
        this.setContentPane(pnlPrincipal);
        //Embeber frame en la solapa
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);


        for (Auditoria listado : CA.getListaAuditorias()) {
            modelo.add( listado.getCodigoauditoria(),  listado.getTimestamp(), listado.getEvento(), listado.getEstadoanterior(), listado.getEstadoposterior(),listado.getUsuario());
        }
        tbAuditoria.setModel(modelo);
        tbAuditoria.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


    }
}
