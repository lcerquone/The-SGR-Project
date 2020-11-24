package vista;

import controller.ControladorSocio;
import impl.Documento;
import impl.Socio;
import modelo.DocumentoTableModel;

import javax.swing.*;

public class frmListaDocumento extends JInternalFrame {


    private final DocumentoTableModel modelo = new DocumentoTableModel();
    private JPanel pnlPrincipal;
    private JTable tbDocumentos;


    public frmListaDocumento(String titulo, ControladorSocio CS) {

        super(titulo);
        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        for (Socio listasocios : CS.getListaSocios()) {
            for (Documento listadocumento : listasocios.getListaDocumentos()) {
                modelo.add(listadocumento.getCodigoDocumento(), listadocumento.getCodigoSocio(), listadocumento.getTipo(), listadocumento.getEstado(), listadocumento.getUsuario(), listadocumento.getFechaRecepcion(), listadocumento.getObligatorio());
            }
        }

        tbDocumentos.setModel(modelo);
        tbDocumentos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }
}