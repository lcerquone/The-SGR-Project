package vista;

import controller.ControladorAuditoria;
import controller.ControladorSocio;
import impl.DateVO;
import impl.Socio;
import modelo.DocumentoListModel;
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

public class frmAltaDocumento extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox cbSocio;
    private JFormattedTextField txtFecha;
    private JTextField txtUsuario;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JTextField txtEstado;
    private JComboBox cbDocumento;
    private JCheckBox ckObligatorio;

    private final List<SocioListModel> socios = new ArrayList<SocioListModel>();
    private final List<DocumentoListModel> documentos = new ArrayList<DocumentoListModel>();
    private int codigosocio=-1;
    private String tipodocumento="";

    private final String pattern = "dd/MM/yyyy";


    public frmAltaDocumento(Window owner, String titulo, ControladorSocio CS, ControladorAuditoria CA, String operador) {
        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 300);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        for( Socio listado: CS.getListaSocios()){
            socios.add(new SocioListModel(listado.getCodigoSocio() , listado.getCodigoSocio() + " - " + listado.getCuit() + " - " + listado.getRazonSocial() + " - " + listado.getTipo()) );
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addAll(socios);
        cbSocio.setModel(model);

        documentos.add(new DocumentoListModel(1, "1 - Estatuto/Contrato Social"));
        documentos.add(new DocumentoListModel(2, "2 - Balances Certificados"));
        documentos.add(new DocumentoListModel(3, "3 - Manifestación de Bienes"));

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(documentos);
        cbDocumento.setModel(modelo);

        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            dateMask.setValidCharacters("0123456789");
            dateMask.install(txtFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dateInString =new SimpleDateFormat(pattern).format(new Date());
        txtFecha.setText(dateInString);
        txtUsuario.setText(operador);

        this.acciones(CS,CA,operador);


    }

public void acciones(ControladorSocio CS,ControladorAuditoria CA, String operador){

    cbSocio.addItemListener(new ItemListener() {
                                @Override
                                public void itemStateChanged(ItemEvent e) {
                                    SocioListModel aux = (SocioListModel) cbSocio.getSelectedItem();
                                    codigosocio = aux.getCodigo();
                                }
                            });
    cbDocumento.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            DocumentoListModel aux = (DocumentoListModel) cbDocumento.getSelectedItem();
            tipodocumento = aux.getDescripcion();
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
            if (codigosocio != -1 && !tipodocumento.equals("")){
            Object[] options = {"Si", "No"};
            int n = JOptionPane.showOptionDialog(null,
                    "¿Desea dar de alta el documento?",
                    "Alta de Accionista",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);

            String obligatorio="NO";

            if (ckObligatorio.isSelected()){ obligatorio = "SI"; }

            if (n == 0) {
                try {
                    DateVO fecha = new DateVO(txtFecha.getText());
                    CS.altaDocumento(codigosocio, tipodocumento, txtEstado.getText(), txtUsuario.getText(), fecha, obligatorio);
                    CS.MostrarDocumentos();
                    CA.altaAuditoria("Alta Documento","","",operador);

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
