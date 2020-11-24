package vista;

import controller.ControladorLineaDeCredito;
import impl.Certificado;
import modelo.CertificadoTableModel;


import javax.swing.*;

public class frmListaCertificados extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JTable tbCertificados;

    private final CertificadoTableModel modelo = new CertificadoTableModel();

    public frmListaCertificados(String titulo, ControladorLineaDeCredito COl) {

        super(titulo);
        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        for (Certificado listado : COl.getListaCertificados()) {
                modelo.add(listado.getCodigoCertificado(), listado.getCodigoOperacion(),listado.getCodigoSocio(), listado.getFechaEmision());
        }
        tbCertificados.setModel(modelo);
        tbCertificados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }
}
