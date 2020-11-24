package vista;

import controller.ControladorAuditoria;
import controller.ControladorSocio;
import impl.Socio;
import modelo.SocioTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmAprobarSocio extends JDialog {
    private JPanel pnlPrincipal;
    private JTable tbSocios;
    private JButton aprobarButton;
    private JButton cerrarButton;


    private final SocioTableModel modelo = new SocioTableModel();

    public frmAprobarSocio(Window owner , String titulo, ControladorSocio CS,ControladorAuditoria CA,String operador) {

        super(owner, titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);


        for( Socio listado: CS.getListaSocios()){
            if (listado.getEstado().equals("Postulante"))
            modelo.add(listado.getCodigoSocio(),listado.getTipo(), listado.getEstado(),listado.getCuit(),listado.getRazonSocial(),listado.getInicioActividad(),
                    listado.getTamaño(),listado.getActividadPrincipal(),listado.getDomicilio(),listado.getTelefono(),listado.getEmail());
        }

        tbSocios.setModel(modelo);
        tbSocios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.acciones(CS,CA,operador);


    }

    public void acciones (ControladorSocio CS, ControladorAuditoria CA,String operador){

        aprobarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tbSocios.getSelectedRow() != -1){
                int codigosocio = (int) tbSocios.getValueAt(tbSocios.getSelectedRow(), 0);

                Object[] options = {"Si", "No"};
                int n = JOptionPane.showOptionDialog(null,
                        "¿Desea Aprobar Socio?",
                        "Aprobar Socio",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (n == 0) {
                    CS.AprobarSocio(codigosocio);
                    CA.altaAuditoria("Aprobar Socio","Postulante","Socio Pleno",operador);
                    modelo.resetModel();
                    tbSocios.updateUI();

                    for( Socio listado: CS.getListaSocios()){
                        if (listado.getEstado().equals("Postulante"))
                            modelo.add(listado.getCodigoSocio() , listado.getTipo(), listado.getEstado(),listado.getCuit(),listado.getRazonSocial(),listado.getInicioActividad(),
                                listado.getTamaño(),listado.getActividadPrincipal(),listado.getDomicilio(),listado.getTelefono(),listado.getEmail());
                    }

                }
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
