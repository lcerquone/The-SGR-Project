package vista;

import controller.ControladorAuditoria;
import controller.ControladorSocio;
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

public class frmAltaAccionista extends JDialog {
    private JPanel pnlPrincipal;
    private JButton salirButton;
    private JTable tbAccionistas;
    private JButton quitarButton;
    private JButton nuevoButton;
    private JButton guardarButton;
    private JComboBox cbSocio;
    private JFormattedTextField txtCuit;
    private JTextField txtRazonSocial;
    private JFormattedTextField txtParticipacion;

    private final List<SocioListModel> socios = new ArrayList<SocioListModel>();
    private int codigosocio=-1;


    public frmAltaAccionista(Window owner, String titulo,ControladorSocio CS,ControladorAuditoria CA, String operador) {
        super(owner, titulo);
        //Setea el panel principal
        this.setContentPane(pnlPrincipal);
        //Setea el tamaño de la ventana
        this.setSize(600, 350);
        //No permite interactuar con otras ventanas
        this.setModal(true);
        //Terminar al cerrar
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Centrar la ventana
        this.setLocationRelativeTo(null);

        for( Socio listado: CS.getListaSocios()){
            socios.add(new SocioListModel(listado.getCodigoSocio() , listado.getCodigoSocio() + " - " + listado.getCuit() + " - " + listado.getRazonSocial() + " - " + listado.getTipo()) );
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addAll(socios);
        cbSocio.setModel(model);


        try {
            MaskFormatter maskCuit = new MaskFormatter("##-########-#");
            maskCuit.setPlaceholderCharacter('_');
            maskCuit.setValidCharacters("0123456789");
            maskCuit.install(txtCuit);


        } catch (ParseException e) {
            e.printStackTrace();
        }


        this.acciones(CS,CA,operador);

    }
public void acciones (ControladorSocio CS, ControladorAuditoria CA, String operador){

    cbSocio.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            SocioListModel aux= (SocioListModel) cbSocio.getSelectedItem();
            codigosocio= aux.getCodigo();
        }
    });


    guardarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object[] options = {"Si", "No"};
            int n = JOptionPane.showOptionDialog(null,
                    "¿Desea dar de alta al accionista?",
                    "Alta de Accionista",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
            if (n == 0) {
                    try {
                        CS.altaAccionista(codigosocio, txtCuit.getText(), txtRazonSocial.getText(), txtParticipacion.getText());
                        CS.MostrarAccionistas();

                        CA.altaAuditoria("Alta Accionista","","",operador);

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            dispose();
        }

        });

    salirButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        dispose();
        }
    });


}
    }
