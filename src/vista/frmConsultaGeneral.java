package vista;

import controller.ControladorFDR;
import controller.ControladorLineaDeCredito;
import controller.ControladorSocio;
import controller.ControladorAuditoria;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmConsultaGeneral extends JDialog {

    private JPanel pnlPrincipal;
    private JTabbedPane tabbedPane1;
    private JDesktopPane jdSocios;
    private JDesktopPane jdAccionistas;
    private JDesktopPane jdAportes;
    private JButton cerrarButton;
    private JDesktopPane jdOperaciones;
    private JDesktopPane jdLineasCredito;
    private JDesktopPane jdDocumentos;
    private JDesktopPane jdCertificados;
    private JDesktopPane jdComisiones;
    private JDesktopPane jdAuditoria;


    public frmConsultaGeneral (Window owner, String titulo, ControladorSocio CS, ControladorFDR CFDR,ControladorLineaDeCredito COl, ControladorAuditoria CA){
        super(owner,titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(700,400);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        frmListaSocios frameSocios = new frmListaSocios("Listado de Socios",CS);
        frameSocios.setVisible(true);
        jdSocios.add(frameSocios) ;

        frmListaAccionistas frameAccionistas = new frmListaAccionistas("Listado de Accionistas",CS);
        frameAccionistas.setVisible(true);
        jdAccionistas.add(frameAccionistas) ;

        frmListaAportes frameAportes = new frmListaAportes("Listado de Aportes",CFDR);
        frameAportes.setVisible(true);
        jdAportes.add(frameAportes) ;

        frmListaOperaciones frameOperaciones = new frmListaOperaciones("Listado de Operaciones",COl);
        frameOperaciones.setVisible(true);
        jdOperaciones.add(frameOperaciones) ;

        frmListaLineasCredito frameLineasCredito = new frmListaLineasCredito("Listado de Lineas Credito",COl);
        frameLineasCredito.setVisible(true);
        jdLineasCredito.add(frameLineasCredito) ;

        frmListaDocumento frameDocumento = new frmListaDocumento("Listado de Documentos",CS);
        frameDocumento.setVisible(true);
        jdDocumentos.add(frameDocumento) ;

        frmListaCertificados frameCertificado = new frmListaCertificados("Listado de Certificados",COl);
        frameDocumento.setVisible(true);
        jdCertificados.add(frameCertificado) ;

        frmListaComisiones frameComision = new frmListaComisiones("Listado de Comisiones",COl);
        frameComision.setVisible(true);
        jdComisiones.add(frameComision) ;

        frmListaAuditoria frameAuditoria = new frmListaAuditoria("Listado de Auditorias",CA);
        frameComision.setVisible(true);
        jdAuditoria.add(frameAuditoria) ;


        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
