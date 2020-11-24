package vista;

import controller.ControladorAuditoria;
import controller.ControladorLineaDeCredito;
import controller.ControladorSocio;
import impl.DateVO;
import impl.Operacion;
import impl.Socio;
import modelo.OperacionTableModel;
import modelo.SocioListModel;

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

public class frmConsultarOperacionMonetizada extends JDialog{
    private JPanel pnlPrincipal;
    private JComboBox cbSocio;
    private JFormattedTextField txtFechaDesde;
    private JFormattedTextField txtFechaHasta;
    private JTable tbOperacion;
    private JButton cerrarButton;
    private JButton consultarButton;

    private final List<SocioListModel> socios = new ArrayList<SocioListModel>();
    private int codigosocio = -1;
    private final String pattern = "dd/MM/yyyy";
    private final OperacionTableModel modelo = new OperacionTableModel();


    public frmConsultarOperacionMonetizada(Window owner, String titulo, ControladorSocio CS, ControladorLineaDeCredito COL, ControladorAuditoria CA, String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(500, 400);
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

        this.acciones(COL);

    }

    public void acciones(ControladorLineaDeCredito COL){

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modelo.resetModel();
                    SocioListModel aux = (SocioListModel) cbSocio.getSelectedItem();
                    if (aux != null) {
                        codigosocio = aux.getCodigo();

                        DateVO fechadesde = new DateVO(txtFechaDesde.getText());
                        DateVO fechahasta = new DateVO(txtFechaHasta.getText());

                        List<Operacion> operaciones = COL.operacionesSocioMonetizadas(fechadesde, fechahasta, codigosocio);

                        for (Operacion listado : operaciones) {
                            modelo.add(listado.getCodigoOperacion(), listado.getCodigoSocio(), listado.getTipo(), listado.getFecha(), listado.getEstado(), listado.getMonto());
                        }

                        tbOperacion.setModel(modelo);
                        tbOperacion.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    }
                    } catch(Exception exception){
                        exception.printStackTrace();
                    }

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
