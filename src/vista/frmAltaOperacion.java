package vista;

import controller.ControladorAuditoria;
import controller.ControladorLineaDeCredito;
import controller.ControladorSocio;
import impl.DateVO;
import impl.Socio;
import modelo.SocioListModel;
import modelo.tipoAmortizacionListModel;
import modelo.tipoOperacionListModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class frmAltaOperacion extends JDialog{
    private JPanel pnlPrincipal;
    private JTextField txtCodigoSocio;
    private JComboBox cbtipoOperacion;
    private JTextField txtMonto;
    private JTextField txtEstado;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JComboBox cbSocio;
    private JTextField txtBancoEmisorCHQ;
    private JTextField txtNumeroCheque;
    private JFormattedTextField txtFechaVencimientoCHQ;
    private JFormattedTextField txtCuitFirmante;
    private JLabel lblBancoEmisor;
    private JLabel lblNumeroCheque;
    private JLabel lblFechaVencimiento;
    private JLabel lblCuitFirmante;
    private JPanel pnlCheque;
    private JTextField txtEmpresa;
    private JTextField txtImporteCC;
    private JFormattedTextField txtFechaVencimientoCC;
    private JPanel pnlCC;
    private JTextField txtBancoEmisorPR;
    private JTextField txtImportePR;
    private JTextField txtTasa;
    private JFormattedTextField txtFechaAcreditacion;
    private JTextField txtCuotas;
    private JPanel pnlPrestamo;
    private JComboBox cbTipoAmortizacion;
    private JTextField txtImporteCHQ;
    private JFormattedTextField txtFecha;


    private final List<tipoOperacionListModel> tipoOperaciones = new ArrayList<tipoOperacionListModel>();
    private final List<tipoAmortizacionListModel> tipoAmortizaciones = new ArrayList<tipoAmortizacionListModel>();

    private final List<SocioListModel> socios = new ArrayList<SocioListModel>();
    private int codigosocio=-1;
    private int tipooperacion=-1;
    private final String pattern = "dd/MM/yyyy";


    public frmAltaOperacion(Window owner, String titulo, ControladorSocio CS, ControladorLineaDeCredito COl , ControladorAuditoria CA, String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 450);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        cbSocio.requestFocus();

        tipoOperaciones.add(new tipoOperacionListModel(1, "1 - Cheques propios,Cheques de terceros,Pagaré Bursatil"));
        tipoOperaciones.add(new tipoOperacionListModel(2, "2 - Cuentas corrientes Comerciales,Tarjetas de crédito "));
        tipoOperaciones.add(new tipoOperacionListModel(3, "3 - Préstamos"));

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addAll(tipoOperaciones);
        cbtipoOperacion.setModel(model);

        for( Socio listado: CS.getListaSocios()){
            if (listado.getTipo().equals("Partícipe") && listado.getEstado().equals("Socio pleno"))
            socios.add(new SocioListModel(listado.getCodigoSocio() , listado.getCodigoSocio() + " - " + listado.getCuit() + " - " + listado.getRazonSocial() + " - " + listado.getTipo()) );
        }

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(socios);
        cbSocio.setModel(modelo);

        pnlCheque.setVisible(false);
        pnlCC.setVisible(false);
        pnlPrestamo.setVisible(false);

        tipoAmortizaciones.add(new tipoAmortizacionListModel(1, "Francés"));
        tipoAmortizaciones.add(new tipoAmortizacionListModel(2, "Alemán"));
        tipoAmortizaciones.add(new tipoAmortizacionListModel(3, "Americano"));

        DefaultComboBoxModel modelAmortizacion = new DefaultComboBoxModel();
        modelAmortizacion.addAll(tipoAmortizaciones);
        cbTipoAmortizacion.setModel(modelAmortizacion);

        try {
            MaskFormatter maskCuit = new MaskFormatter("##-########-#");
            maskCuit.setPlaceholderCharacter('_');
            maskCuit.setValidCharacters("0123456789");
            maskCuit.install(txtCuitFirmante);

            MaskFormatter dateMask1 = new MaskFormatter("##/##/####");
            dateMask1.setPlaceholderCharacter('_');
            dateMask1.setValidCharacters("0123456789");
            dateMask1.install(txtFechaVencimientoCHQ);

            MaskFormatter  dateMask2 = new MaskFormatter("##/##/####");
            dateMask2.setPlaceholderCharacter('_');
            dateMask2.setValidCharacters("0123456789");
            dateMask2.install(txtFechaAcreditacion);

            MaskFormatter dateMask3 = new MaskFormatter("##/##/####");
            dateMask3.setPlaceholderCharacter('_');
            dateMask3.setValidCharacters("0123456789");
            dateMask3.install(txtFechaVencimientoCC);

            MaskFormatter dateMask4 = new MaskFormatter("##/##/####");
            dateMask4.setPlaceholderCharacter('_');
            dateMask4.setValidCharacters("0123456789");
            dateMask4.install(txtFecha);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dateInString =new SimpleDateFormat(pattern).format(new Date());
        txtFecha.setText(dateInString);

        this.acciones(COl,CA,operador);


    }

    public void acciones(ControladorLineaDeCredito COl, ControladorAuditoria CA, String operador){

        cbtipoOperacion.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                tipoOperacionListModel aux = (tipoOperacionListModel) cbtipoOperacion.getSelectedItem();
                tipooperacion = aux.getCodigo();

                pnlCheque.setVisible(false);
                pnlCC.setVisible(false);
                pnlPrestamo.setVisible(false);

                switch (tipooperacion) {
                    case 1:
                        pnlCheque.setVisible(true);
                        break;
                    case 2:
                        pnlCC.setVisible(true);
                        break;
                    case 3:
                        pnlPrestamo.setVisible(true);
                        break;
                }
            }
        });

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
                if (codigosocio != -1  && tipooperacion != -1) {
                    Object[] options = {"Si", "No"};
                    int n = JOptionPane.showOptionDialog(null,
                            "¿Desea dar de alta la operacion?",
                            "Alta de Operaciones",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, options, options[0]);
                    if (n == 0) {
                        try {
                            DateVO fecha = new DateVO(txtFecha.getText());

                            switch (tipooperacion) {
                                case 1:
                                    DateVO fechavencimientoCHQ = new DateVO(txtFechaVencimientoCHQ.getText());
                                    COl.altaOperacionTipo1(codigosocio, fecha, txtEstado.getText(), txtBancoEmisorCHQ.getText(), txtNumeroCheque.getText(), fechavencimientoCHQ, txtCuitFirmante.getText(), Double.parseDouble(txtImporteCHQ.getText()));
                                    break;
                                case 2:
                                    DateVO fechavencimientoCC = new DateVO(txtFechaVencimientoCC.getText());
                                    COl.altaOperacionTipo2(codigosocio, fecha, txtEstado.getText(), txtEmpresa.getText(), Double.parseDouble(txtImporteCC.getText()), fechavencimientoCC);
                                    break;
                                case 3:
                                    DateVO fechaacreditacionCC = new DateVO(txtFechaAcreditacion.getText());
                                    COl.altaOperacionTipo3(codigosocio, fecha, txtEstado.getText(), txtBancoEmisorPR.getText(), Double.parseDouble(txtImportePR.getText()), txtTasa.getText(), fechaacreditacionCC, Integer.parseInt(txtCuotas.getText()), cbTipoAmortizacion.getSelectedItem().toString());
                                    break;
                            }
                            COl.MostrarOperaciones();
                            CA.altaAuditoria("Alta Operacion","","",operador);

                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                    dispose();
                }
            }
        });
    }

    }
