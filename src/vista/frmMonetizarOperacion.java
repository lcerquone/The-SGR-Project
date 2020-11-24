package vista;

import controller.ControladorAuditoria;
import controller.ControladorLineaDeCredito;
import impl.Operacion;
import modelo.OperacionTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMonetizarOperacion extends JDialog{
    private JPanel pnlPrincipal;
    private JTable tbOperaciones;
    private JButton monetizarButton;
    private JButton cerrarButton;

    private final OperacionTableModel modelo = new OperacionTableModel();

    public frmMonetizarOperacion(Window owner , String titulo,ControladorLineaDeCredito COl, ControladorAuditoria CA, String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);


        for (Operacion listado : COl.getListaOperaciones()) {
            if ( listado.getEstado().equals("Con certificado emitido")) {
                    modelo.add(listado.getCodigoOperacion(), listado.getCodigoSocio(), listado.getTipo(), listado.getFecha(), listado.getEstado(), listado.getMonto());
            }
        }


        tbOperaciones.setModel(modelo);
        tbOperaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.acciones(COl,CA,operador);


    }

    public void acciones (ControladorLineaDeCredito COl, ControladorAuditoria CA, String operador){

        monetizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Custom button text
                if (tbOperaciones.getSelectedRow() != -1) {
                Object[] options = {"Si", "No"};
                int n = JOptionPane.showOptionDialog(null,
                        "¿Desea monetizar la operacion?",
                        "Monetizar operacion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (n == 0) {
                    int codigooperacion = (int) tbOperaciones.getValueAt(tbOperaciones.getSelectedRow(), 0);
                    int codigoSocio = (int) tbOperaciones.getValueAt(tbOperaciones.getSelectedRow(), 1);
                    COl.MonetizarOperacion(codigooperacion, codigoSocio);
                    COl.MostrarOperaciones();
                    COl.MostrarComisiones();
                    CA.altaAuditoria("Monetizar Operacion", "Con Certificado Emitido", "Monetizado", operador);

                    modelo.resetModel();
                    tbOperaciones.updateUI();

                    for (Operacion listado : COl.getListaOperaciones()) {
                        if (listado.getEstado().equals("Con certificado emitido")) {
                            modelo.add(listado.getCodigoOperacion(), listado.getCodigoSocio(), listado.getTipo(), listado.getFecha(), listado.getEstado(), listado.getMonto());
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
