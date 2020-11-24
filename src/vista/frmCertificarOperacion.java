package vista;

import controller.ControladorAuditoria;
import controller.ControladorFDR;
import controller.ControladorLineaDeCredito;
import controller.ControladorSocio;
import impl.LineaCredito;
import impl.Operacion;
import modelo.OperacionTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frmCertificarOperacion extends JDialog {
    private JPanel pnlPrincipal;
    private JTable tbOperaciones;
    private JButton cerrarButton;
    private JButton certificarButton;
    private JTextField txtDisponible;


    private final OperacionTableModel modelo = new OperacionTableModel();

    public frmCertificarOperacion(Window owner , String titulo, ControladorLineaDeCredito COl, ControladorFDR CFDR,ControladorSocio CS,ControladorAuditoria CA, String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        for (Operacion listado : COl.getListaOperaciones()){
            if (listado.getEstado().equals("Pendiente"))
            modelo.add(listado.getCodigoOperacion(), listado.getCodigoSocio(), listado.getTipo(), listado.getFecha(),listado.getEstado(),listado.getMonto());
        }

        tbOperaciones.setModel(modelo);

        tbOperaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.acciones(COl,CFDR,CS,CA,operador);

    }

    public void acciones(ControladorLineaDeCredito COl, ControladorFDR CFDR, ControladorSocio CS, ControladorAuditoria CA, String operador){
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        certificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Custom button text
                if (tbOperaciones.getSelectedRow() != -1){
                Object[] options = {"Si", "No"};
                int n = JOptionPane.showOptionDialog(null,
                        "¿Desea certificar la operacion?",
                        "Certificar Operacion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (n == 0) {
                    int codigooperacion = (int) tbOperaciones.getValueAt(tbOperaciones.getSelectedRow(), 0);
                    int codigoSocio = (int) tbOperaciones.getValueAt(tbOperaciones.getSelectedRow(), 1);
                    System.out.println(codigoSocio);
                    COl.CertificarOperacion(CFDR, CS, codigooperacion,codigoSocio);
                    CA.altaAuditoria("Certificar Operacion","Pendiente","Con Certificado Emitido",operador);

                    modelo.resetModel();
                    tbOperaciones.updateUI();
                    for (LineaCredito lista : COl.getListaLineaCredito()) {
                        for (Operacion listado : lista.getListaOperaciones() ){
                            if (listado.getEstado().equals("Pendiente"))
                                modelo.add(listado.getCodigoOperacion(), listado.getCodigoSocio(), listado.getTipo(), listado.getFecha(),listado.getEstado(),listado.getMonto());
                        }

                    }
                    COl.MostrarCertificados();
                }
            }
            }
        });

    }

}
