package vista;

import controller.ControladorAuditoria;
import controller.ControladorLineaDeCredito;
import impl.Comision;
import impl.Operacion;
import modelo.ComisionTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmFacturarComision extends JDialog{
    private JPanel pnlPrincipal;
    private JButton facturarButton;
    private JButton cancelarButton;
    private JTable tbComision;

    private final ComisionTableModel modelo = new ComisionTableModel();

    public frmFacturarComision(Window owner , String titulo, ControladorLineaDeCredito COl, ControladorAuditoria CA, String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        for (Operacion listado: COl.getListaOperaciones())
        {
            Comision aux= listado.getComision();
            if (aux!= null){
                if ( aux.getEstado().equals("Calculada"))
                modelo.add( aux.getCodigoOperacion(), aux.getCodigoSocio(), aux.getTipo(),aux.getEstado(),aux.getFechaEmision(),aux.getMonto());
            }
        }

        tbComision.setModel(modelo);
        tbComision.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.acciones(COl,CA,operador);

    }

    public void acciones(ControladorLineaDeCredito COl,ControladorAuditoria CA, String operador){

        facturarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tbComision.getSelectedRow() != -1){
                    Object[] options = {"Si", "No"};
                    int n = JOptionPane.showOptionDialog(null,
                            "¿Desea Facturar la comision?",
                            "Certificar Operacion",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, options, options[0]);
                    if (n == 0) {

                        int codigooperacion = (int) tbComision.getValueAt(tbComision.getSelectedRow(), 0);
                        int codigoSocio = (int) tbComision.getValueAt(tbComision.getSelectedRow(), 1);
                        COl.FacturarComision(codigooperacion,codigoSocio);
                        CA.altaAuditoria("Facturar Comision","Calculada","Facturada",operador);

                        modelo.resetModel();
                        tbComision.updateUI();

                        for (Operacion listado: COl.getListaOperaciones())
                        {
                            Comision aux= listado.getComision();
                            if (aux!= null){
                                if ( aux.getEstado().equals("Calculada"))
                                    modelo.add( aux.getCodigoOperacion(), aux.getCodigoSocio(), aux.getTipo(),aux.getEstado(),aux.getFechaEmision(),aux.getMonto());
                            }
                        }
                    }
                    }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            }
        });
    }

}
