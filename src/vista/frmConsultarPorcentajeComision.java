package vista;

import controller.ControladorAuditoria;
import controller.ControladorLineaDeCredito;
import controller.ControladorSocio;
import modelo.tipoOperacionListModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmConsultarPorcentajeComision extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox cbtipoOperacion;
    private JTextField txtPorcentajeComision;
    private JButton cerrarButton;
    private JButton consultarButton;
    private final List<tipoOperacionListModel> tipoOperaciones = new ArrayList<tipoOperacionListModel>();


    public frmConsultarPorcentajeComision(Window owner, String titulo, ControladorSocio CS, ControladorLineaDeCredito COL, ControladorAuditoria CA, String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 350);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        tipoOperaciones.add(new tipoOperacionListModel(1, "1 - Cheques propios,Cheques de terceros,Pagaré Bursatil"));
        tipoOperaciones.add(new tipoOperacionListModel(2, "2 - Cuentas corrientes Comerciales,Tarjetas de crédito "));
        tipoOperaciones.add(new tipoOperacionListModel(3, "3 - Préstamos"));

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addAll(tipoOperaciones);
        cbtipoOperacion.setModel(model);


        this.acciones(COL);


    }

    public  void acciones(ControladorLineaDeCredito COL){

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tipoOperacionListModel aux = (tipoOperacionListModel) cbtipoOperacion.getSelectedItem();
                int tipooperacion= aux.getCodigo();

               txtPorcentajeComision.setText(COL.calcularPorcentaje(tipooperacion));

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
