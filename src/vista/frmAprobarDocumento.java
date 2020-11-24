package vista;

import controller.ControladorAuditoria;
import controller.ControladorSocio;
import impl.Documento;
import impl.Socio;
import modelo.DocumentoTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmAprobarDocumento extends JDialog{
    private JPanel pnlPrincipal;
    private JTable tbDocumentos;
    private JButton aprobarButton;
    private JButton cerrarButton;


    private final DocumentoTableModel modelo = new DocumentoTableModel();

    public frmAprobarDocumento(Window owner , String titulo, ControladorSocio CS,ControladorAuditoria CA,String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);


        for (Socio listasocios : CS.getListaSocios()) {
            for (Documento listadocumento : listasocios.getListaDocumentos()) {
                if (listadocumento.getEstado().equals("Ingresado"))
                modelo.add(listadocumento.getCodigoDocumento(), listadocumento.getCodigoSocio(), listadocumento.getTipo(), listadocumento.getEstado(), listadocumento.getUsuario(), listadocumento.getFechaRecepcion(), listadocumento.getObligatorio());
            }
        }
        tbDocumentos.setModel(modelo);
        tbDocumentos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.acciones(CS,CA,operador);
    }

    public void acciones (ControladorSocio CS, ControladorAuditoria CA, String operador){

        aprobarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Custom button text
                if (tbDocumentos.getSelectedRow() != -1){

                    Object[] options = {"Si", "No"};
                int n = JOptionPane.showOptionDialog(null,
                        "¿Desea Aprobar el Documento?",
                        "Aprobar Documento",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (n == 0) {

                    int codigodocumento = (int) tbDocumentos.getValueAt(tbDocumentos.getSelectedRow(), 0);
                    int codigosocio = (int) tbDocumentos.getValueAt(tbDocumentos.getSelectedRow(), 1);

                    CS.AprobarDocumento(codigodocumento,codigosocio);
                    CA.altaAuditoria("Aprobar Documento","Ingresado","Aprobado",operador);

                    modelo.resetModel();
                    tbDocumentos.updateUI();
                    for (Socio listasocios : CS.getListaSocios()) {
                        for (Documento listadocumento : listasocios.getListaDocumentos()) {
                            if (listadocumento.getEstado().equals("Ingresado"))
                                modelo.add(listadocumento.getCodigoDocumento(), listadocumento.getCodigoSocio(), listadocumento.getTipo(), listadocumento.getEstado(), listadocumento.getUsuario(), listadocumento.getFechaRecepcion(), listadocumento.getObligatorio());
                        }
                    }
                }
                }
            }
        });

        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}

