package vista;

import controller.ControladorSocio;
import impl.Socio;
import modelo.SocioTableModel;

import javax.swing.*;

public class frmListaSocios extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JButton cerrarButton;
    private JTable tbSocios;

    private final SocioTableModel modelo = new SocioTableModel();


    public frmListaSocios( String titulo,ControladorSocio CS) {

        super(titulo);
        //setear pantalla principal
        this.setContentPane(pnlPrincipal);
        //Embeber frame en la solapa
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        for( Socio listado: CS.getListaSocios()){
            modelo.add(listado.getCodigoSocio() , listado.getTipo(), listado.getEstado(),listado.getCuit(),listado.getRazonSocial(),listado.getInicioActividad(), listado.getTamaño(),listado.getActividadPrincipal(),listado.getDomicilio(),listado.getTelefono(),listado.getEmail());
        }

        tbSocios.setModel(modelo);
        tbSocios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);



    }
}
