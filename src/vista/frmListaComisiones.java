package vista;

import controller.ControladorLineaDeCredito;
import impl.Comision;
import impl.Operacion;
import modelo.ComisionTableModel;

import javax.swing.*;

public class frmListaComisiones extends JInternalFrame{
    private JPanel pnlPrincipal;
    private JTable tbComisiones;

    private final ComisionTableModel modelo = new ComisionTableModel();

    public frmListaComisiones( String titulo, ControladorLineaDeCredito COl) {

        super(titulo);
        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        for (Operacion listado: COl.getListaOperaciones())
        {
            Comision aux= listado.getComision();
            if (aux!= null){
                modelo.add( aux.getCodigoOperacion(), aux.getCodigoSocio(), aux.getTipo(),aux.getEstado(),aux.getFechaEmision(),aux.getMonto());
            }
        }

        tbComisiones.setModel(modelo);
        tbComisiones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }
}
