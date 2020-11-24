package vista;

import controller.ControladorAuditoria;
import controller.ControladorLineaDeCredito;
import controller.ControladorSocio;
import impl.LineaCredito;
import impl.Socio;
import modelo.LineaCreditoListModel;
import modelo.SocioListModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class frmConsultarDisponibleRiesgovivo extends  JDialog{
    private JPanel pnlPrincipal;
    private JComboBox cbSocio;
    private JButton cerrarButton;
    private JTextField txtDisponible;
    private JButton consultarButton;
    private JComboBox cbLineaCredito;
    private JTextField txtRiesgoVivo;

    private final List<SocioListModel> socios = new ArrayList<SocioListModel>();
    private final List<LineaCreditoListModel> lineascredito = new ArrayList<LineaCreditoListModel>();

    private int codigosocio = -1;
    private int codigolineacredito = -1;

    private final String pattern = "dd/MM/yyyy";


    public frmConsultarDisponibleRiesgovivo(Window owner, String titulo, ControladorSocio CS, ControladorLineaDeCredito COL, ControladorAuditoria CA, String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(450, 350);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        cbSocio.requestFocus();

        for (Socio listado : CS.getListaSocios()) {
            if (listado.getTipo().equals("Partícipe")) {
                socios.add(new SocioListModel(listado.getCodigoSocio(), listado.getCodigoSocio() + " - " + listado.getCuit() + " - " + listado.getRazonSocial() + " - " + listado.getTipo()));
            }
        }

        DefaultComboBoxModel modelsocios = new DefaultComboBoxModel();
        modelsocios.addAll(socios);
        cbSocio.setModel(modelsocios);

      this.acciones(COL);

    }

    public void acciones(ControladorLineaDeCredito COL){

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LineaCreditoListModel aux = (LineaCreditoListModel) cbLineaCredito.getSelectedItem();
                if (aux != null) {
                    codigolineacredito = aux.getCodigo();
                    txtDisponible.setText(String.valueOf(COL.getDisponibleLineaCredito(codigosocio, codigolineacredito)));
                    txtRiesgoVivo.setText(String.valueOf(COL.getRiesgoVivo(codigosocio, codigolineacredito)));
                }
            }
        });

        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        cbSocio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lineascredito.clear();
                SocioListModel aux = (SocioListModel) cbSocio.getSelectedItem();
                codigosocio= aux.getCodigo();
                for (LineaCredito listado : COL.getListaLineaCredito()) {
                    if (listado.getCodigoSocio()== codigosocio) {
                        lineascredito.add(new LineaCreditoListModel(listado.getCodigoLineaCredito(),listado.getCodigoLineaCredito() + " - " + listado.getVigencia() + " - "  + listado.getEstado() + " - " + listado.getMonto()));
                    }
                }

                DefaultComboBoxModel modellineacredito = new DefaultComboBoxModel();
                modellineacredito.addAll(lineascredito);
                cbLineaCredito.setModel(modellineacredito);

            }
        });
    }

    }
