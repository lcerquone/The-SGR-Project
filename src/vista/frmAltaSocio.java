package vista;

import controller.ControladorAuditoria;
import controller.ControladorSocio;
import impl.DateVO;
import impl.EmailVO;
import modelo.sizeSocioListModel;
import modelo.tipoSocioListModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class frmAltaSocio extends JDialog {
    private JPanel pnlPrincipal;
    private JFormattedTextField txtCuit;
    private JTextField txtRSocial;
    private JFormattedTextField txtIActividad;
    private JComboBox cbSizeSocio;
    private JTextField txtActividad;
    private JTextField txtDomicilio;
    private JFormattedTextField txtTelefono;
    private JTextField txtEmail;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JComboBox cbTipoSocio;
    private JTextField txtEstado;

    private final List<sizeSocioListModel> sizeSocios = new ArrayList<sizeSocioListModel>();
    private final List<tipoSocioListModel> tipoSocios = new ArrayList<tipoSocioListModel>();


    public frmAltaSocio(Window owner, String titulo, ControladorSocio CS, ControladorAuditoria CA,String operador) {

        super(owner, titulo);
        //Setea el panel principal
        this.setContentPane(pnlPrincipal);
        //Setea el tamaño de la ventana
        this.setSize(400, 400);
        //No permite interactuar con otras ventanas
        this.setModal(true);
        //Terminar al cerrar
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Centrar la ventana
        this.setLocationRelativeTo(null);

        txtCuit.requestFocus();

        sizeSocios.add(new sizeSocioListModel("Pequeña"));
        sizeSocios.add(new sizeSocioListModel("Mediana"));
        sizeSocios.add(new sizeSocioListModel("Grande"));

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addAll(sizeSocios);
        cbSizeSocio.setModel(model);


        tipoSocios.add(new tipoSocioListModel("Partícipe"));
        tipoSocios.add(new tipoSocioListModel("Protector"));

        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        model1.addAll(tipoSocios);
        cbTipoSocio.setModel(model1);


        try {
            MaskFormatter maskCuit = new MaskFormatter("##-########-#");
            maskCuit.setPlaceholderCharacter('_');
            maskCuit.setValidCharacters("0123456789");
            maskCuit.install(txtCuit);

            MaskFormatter maskTelefono = new MaskFormatter("(##)-####-####");
            maskTelefono.setPlaceholderCharacter('_');
            maskTelefono.setValidCharacters("0123456789");
            maskTelefono.install(txtTelefono);

            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            dateMask.setValidCharacters("0123456789");
            dateMask.install(txtIActividad);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.acciones(CS,CA,operador);
    }

    public void acciones (ControladorSocio CS,ControladorAuditoria CA,String operador){
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Custom button text
                Object[] options = {"Si", "No"};
                int n = JOptionPane.showOptionDialog(null,
                        "¿Desea dar de alta Socio Nuevo?",
                        "Alta de Socios",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,options,options[0]);
                if (n == 0) {

                    try {
                        DateVO fecha = new DateVO(txtIActividad.getText());
                        EmailVO   mail = new EmailVO(txtEmail.getText());

                        CS.altaSocio( cbTipoSocio.getSelectedItem().toString(),txtEstado.getText(),
                                txtCuit.getText(),
                                txtRSocial.getText(),
                                fecha,
                                cbSizeSocio.getSelectedItem().toString(),
                                txtActividad.getText(),
                                txtDomicilio.getText(),
                                txtTelefono.getText(),
                                mail);

                        CA.altaAuditoria("Alta Socio","","",operador);

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    CS.MostrarSocios();
                }
                dispose();
            }
        });
    }
}