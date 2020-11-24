package vista;

import controller.ControladorAuditoria;
import controller.ControladorLineaDeCredito;
import controller.ControladorSocio;
import impl.DateVO;
import modelo.sizeSocioListModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class frmConsultarTasaDescuento extends  JDialog{
    private JPanel pnlPrincipal;
    private JComboBox cbSizeSocio;
    private JFormattedTextField txtFechaDesde;
    private JFormattedTextField txtFechaHasta;
    private JTextField txtPromedioTasa;
    private JButton consultarButton;
    private JButton cerrarButton;
    private JTextField txtTotalOperado;
    private final String pattern = "dd/MM/yyyy";

    private final List<sizeSocioListModel> sizeSocios = new ArrayList<sizeSocioListModel>();


    public frmConsultarTasaDescuento(Window owner, String titulo, ControladorSocio CS, ControladorLineaDeCredito COL, ControladorAuditoria CA, String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 350);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        sizeSocios.add(new sizeSocioListModel("Pequeña"));
        sizeSocios.add(new sizeSocioListModel("Mediana"));
        sizeSocios.add(new sizeSocioListModel("Grande"));

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addAll(sizeSocios);
        cbSizeSocio.setModel(model);

        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            dateMask.setValidCharacters("0123456789");
            dateMask.install(txtFechaDesde);
            dateMask.install(txtFechaHasta);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dateInString =new SimpleDateFormat(pattern).format(new Date());
        txtFechaDesde.setText(dateInString);
        txtFechaHasta.setText(dateInString);

        this.acciones(CS,COL);


    }

    public void acciones(ControladorSocio CS, ControladorLineaDeCredito COL){
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose();
            }
        });


        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPromedioTasa.setText("0.0");
                txtTotalOperado.setText("0.0");

                try {
                    String tamaño = cbSizeSocio.getSelectedItem().toString();
                    DateVO fechadesde = new DateVO(txtFechaDesde.getText());
                    DateVO fechahasta = new DateVO(txtFechaHasta.getText());
                    List<Double> aux = COL.operacionesCHTipoEmpresaYTasaDescuento(CS,tamaño,fechadesde,fechahasta);
                    if (!aux.isEmpty()) {
                        txtPromedioTasa.setText(String.valueOf(aux.get(0)));
                        txtTotalOperado.setText(String.valueOf(aux.get(1)));
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
    }
}
