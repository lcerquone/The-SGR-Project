package vista;

import controller.ControladorFDR;
import controller.ControladorLineaDeCredito;
import impl.LineaCredito;
import modelo.LineaCreditoTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmAprobarLineaCredito extends JDialog {
    private JPanel pnlPrincipal;
    private JTable tbLineasCredito;
    private JButton aprobarButton;
    private JButton cerrarButton;


    private final LineaCreditoTableModel modelo = new LineaCreditoTableModel();

    public frmAprobarLineaCredito(Window owner , String titulo, ControladorFDR CFDR, ControladorLineaDeCredito COl) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);


        for (LineaCredito listado : COl.getListaLineaCredito()) {
            if (listado.getEstado().equals("Pendiente"))
            modelo.add(listado.getCodigoLineaCredito(), listado.getCodigoSocio(), listado.getVigencia(),listado.getEstado(),listado.getMonto());
        }
        tbLineasCredito.setModel(modelo);
        tbLineasCredito.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.acciones(CFDR, COl);


    }

    public void acciones (ControladorFDR CFDR, ControladorLineaDeCredito COl){

        aprobarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Custom button text
                Object[] options = {"Si", "No"};
                int n = JOptionPane.showOptionDialog(null,
                        "¿Desea Aprobar la linea de credito?",
                        "Aprobar Linea de Credito",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (n == 0) {

                    int codigolineacredito = (int) tbLineasCredito.getValueAt(tbLineasCredito.getSelectedRow(), 0);
                    System.out.println(codigolineacredito);
                    COl.AprobarLineaCredito(codigolineacredito,CFDR);
                    modelo.resetModel();
                    tbLineasCredito.updateUI();

                    for (LineaCredito listado : COl.getListaLineaCredito()) {
                        if (listado.getEstado().equals("Pendiente"))
                            modelo.add(listado.getCodigoLineaCredito(), listado.getCodigoSocio(), listado.getVigencia(),listado.getEstado(),listado.getMonto());
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
