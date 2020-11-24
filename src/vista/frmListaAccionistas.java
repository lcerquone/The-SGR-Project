package vista;

import controller.ControladorSocio;
import impl.Accionista;
import impl.Socio;
import modelo.AccionistaTableModel;

import javax.swing.*;

public class frmListaAccionistas extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JButton cerrarButton;
    private JTable tbAccionistas;


    private final AccionistaTableModel modelo = new AccionistaTableModel();

    public frmListaAccionistas( String titulo, ControladorSocio CS) {

        super(titulo);
        //setear pantalla principal
        this.setContentPane(pnlPrincipal);
        //Embeber frame en la solapa
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);


        for (Socio listasocios : CS.getListaSocios()) {
            for (Accionista listaaccionistas : listasocios.getListaAccionistas()) {
                modelo.add(listaaccionistas.getCodigoAccionista(),listaaccionistas.getCodigoSocio(),listaaccionistas.getCuit(), listaaccionistas.getRazonSocial(), listaaccionistas.getPorcentaje());
            }
        }

        tbAccionistas.setModel(modelo);
        tbAccionistas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }
}
