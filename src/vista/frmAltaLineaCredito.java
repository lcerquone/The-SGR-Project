package vista;

import controller.ControladorAuditoria;
import controller.ControladorLineaDeCredito;
import controller.ControladorSocio;
import impl.DateVO;
import impl.Socio;
import modelo.SocioListModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class frmAltaLineaCredito extends JDialog {
    private JPanel pnlPrincipal;
    private JFormattedTextField txtVigencia;
    private JTextField txtMonto;
    private JTextField txtEstado;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JComboBox cbSocio;

    private final List<SocioListModel> socios = new ArrayList<>();
    private int codigosocio=-1;



    public frmAltaLineaCredito(Window owner, String titulo, ControladorSocio CS , ControladorLineaDeCredito COl, ControladorAuditoria CA, String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(800, 300);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        cbSocio.requestFocus();

        for( Socio listado: CS.getListaSocios()){
            if (listado.getTipo().equals("Partícipe")){
                socios.add(new SocioListModel(listado.getCodigoSocio(), listado.getCodigoSocio() + " - " + listado.getCuit() + " - " + listado.getRazonSocial() + " - " + listado.getTipo()));
            }
        }

        DefaultComboBoxModel modelsocios = new DefaultComboBoxModel();
        modelsocios.addAll(socios);
        cbSocio.setModel(modelsocios);

        MaskFormatter dateMask=null;
        try {
            dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            dateMask.setValidCharacters("0123456789");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateMask.install(txtVigencia);

        this.acciones(COl,CA,operador,CS);

    }

    public void acciones(ControladorLineaDeCredito COl, ControladorAuditoria CA, String operador, ControladorSocio CS) {

        cbSocio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                SocioListModel aux = (SocioListModel) cbSocio.getSelectedItem();
                codigosocio = aux.getCodigo();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Si", "No"};
                int n = JOptionPane.showOptionDialog(null,
                        "¿Desea dar de alta la linea de credito?",
                        "Alta de Lineas de Credito",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (n == 0) {

                    try {
                        DateVO fecha = new DateVO(txtVigencia.getText());
                        COl.altaLineaCredito(codigosocio,fecha , txtEstado.getText(), Double.parseDouble(txtMonto.getText()), CS);
                        COl.MostrarLineasCreditos();
                        CA.altaAuditoria("Alta Linea de Credito","","",operador);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                }
                dispose();
            }
        });
    }

}