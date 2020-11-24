package vista;

import controller.ControladorAuditoria;
import controller.ControladorFDR;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class frmAltaAporte extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox cbSocio;
    private JFormattedTextField txtFecha;
    private JFormattedTextField txtMonto;
    private JTextField txtEstado;
    private JButton cancelarButton;
    private JButton aceptarButton;


    private final List<SocioListModel> socios = new ArrayList<SocioListModel>();
    private int codigosocio = -1;
    private final String pattern = "dd/MM/yyyy";


    public frmAltaAporte(Window owner, String titulo, ControladorSocio CS, ControladorFDR CFDR,ControladorAuditoria CA,String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(500, 300);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        cbSocio.requestFocus();

        for( Socio listado: CS.getListaSocios()){
            if (listado.getTipo().equals("Protector")){
                socios.add(new SocioListModel(listado.getCodigoSocio(), listado.getCodigoSocio() + " - " + listado.getCuit() + " - " + listado.getRazonSocial() + " - " + listado.getTipo()));
            }
        }

        DefaultComboBoxModel modelsocios = new DefaultComboBoxModel();
        modelsocios.addAll(socios);
        cbSocio.setModel(modelsocios);

        try {
            MaskFormatter  dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            dateMask.setValidCharacters("0123456789");
            dateMask.install(txtFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dateInString =new SimpleDateFormat(pattern).format(new Date());
        txtFecha.setText(dateInString);

        this.acciones(CFDR,CA,CS,operador);


    }

    public void acciones (ControladorFDR CFDR, ControladorAuditoria CA,ControladorSocio CS, String operador){

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        cbSocio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                SocioListModel aux = (SocioListModel) cbSocio.getSelectedItem();
                codigosocio = aux.getCodigo();
            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (codigosocio != -1) {
                    Object[] options = {"Si", "No"};
                    int n = JOptionPane.showOptionDialog(null,
                            "¿Desea dar de alta el aporte?",
                            "Alta de Aportes de Capital",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, options, options[0]);
                    if (n == 0) {

                        try {
                            DateVO fecha = new DateVO(txtFecha.getText());
                            CFDR.altaAporte(CS, codigosocio, fecha, txtEstado.getText(), Double.parseDouble(txtMonto.getText()));
                            CFDR.MostrarFondos();
                            CFDR.MostrarAportes();
                            CA.altaAuditoria("Alta Aporte","","",operador);


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