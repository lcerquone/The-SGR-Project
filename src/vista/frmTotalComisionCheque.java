package vista;

import controller.ControladorAuditoria;
import controller.ControladorLineaDeCredito;
import impl.DateVO;
import modelo.OperacionTableModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class frmTotalComisionCheque extends  JDialog{
    private JPanel pnlPrincipal;
    private JFormattedTextField txtFecha;
    private JTextField txtTotalComision;
    private JButton cerrarButton;
    private JButton consultarButton;

    private final String pattern = "dd/MM/yyyy";

    private final OperacionTableModel modelo = new OperacionTableModel();

    public frmTotalComisionCheque(Window owner , String titulo, ControladorLineaDeCredito COl, ControladorAuditoria CA, String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(500, 400);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

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

        this.acciones(COl);

    }

    public void acciones( ControladorLineaDeCredito COl){

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DateVO  fecha = new DateVO(txtFecha.getText());
                    txtTotalComision.setText(String.valueOf(COl.comisionesCalculadasCheques(fecha)));

                } catch (Exception exception) {
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
