package vista;

import controller.*;
import impl.FDR;
import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmPrincipal extends JFrame {

    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JButton listaOperacionesButton;
    private JButton ListaSociosButton;
    private JButton consultaGeneralButton;
    private JButton AporteButton;
    private JButton altaSocioButton;
    private JButton altaAccionistaButton;
    private JButton altaLineaCreditoButton;
    private JButton altaOperacionButton;
    private JButton cargarBaseDeDatosButton;
    private JButton guardarBaseDeDatosButton;
    private JButton altaDocumentoButton;
    private JButton sociosButton;
    private JPanel pnlSocios;
    private JPanel pnlFDR;
    private JButton FDRButton;
    private JPanel pnlOperacion;
    private JButton operacionesButton;
    private JPanel pnlMenu;
    private JButton certificarOperacionButton;
    private JButton monetizarOperacionButton;
    private JButton aprobarLineaCreditoButton;
    private JButton aprobarSocioButton;
    private JButton aprobarDocumentoButton;
    private JButton comisionesButton;
    private JButton consultarComisionButton;
    private JButton facturarComisionButton;
    private JPanel pnlComision;
    private JButton consultarDisponibleButton;
    private JButton consultarOperacionButton;
    private JButton consultarTotalComisionChequesButton;
    private JButton consultarPromedioTasaDeButton;
    private JButton listaAccionistasButton;

    private final frmPrincipal self;
    ControladorSocio CS = new ControladorSocio();
    ControladorFDR CFDR = new ControladorFDR();
    ControladorLineaDeCredito COl = new ControladorLineaDeCredito();
    ControladorAuditoria CA = new ControladorAuditoria();


    public frmPrincipal(String titulo, String operador){
        //setea titulo
        super(titulo);
        //utilizar look and feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.setContentPane(this.pnlPrincipal);
        this.setSize(950,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resource/The_SGR_Project.png"));
        this.setIconImage(icon);
        this.self= this;

        pnlSocios.setVisible(false);
        pnlFDR.setVisible(false);
        pnlOperacion.setVisible(false);
        pnlComision.setVisible(false);

        CA.altaAuditoria("Pantalla Inicial","","",operador);
        this.eventos(operador);



    }

    private void eventos (String operador) {

        consultarPromedioTasaDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmConsultarTasaDescuento frame = new  frmConsultarTasaDescuento(self,"Consultar Promedio Tasa de Descuento",CS,COl,CA,operador);
                frame.setVisible(true);
            }
        });

        consultarTotalComisionChequesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmTotalComisionCheque frame = new frmTotalComisionCheque(self,"Consultar Total Comision Cheque",COl,CA,operador);
                frame.setVisible(true);
            }
        });

        consultarComisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmConsultarPorcentajeComision frame = new frmConsultarPorcentajeComision(self,"Consultar Comision",CS,COl,CA,operador);
                frame.setVisible(true);
            }
        });

        consultarOperacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmConsultarOperacionMonetizada frame = new frmConsultarOperacionMonetizada(self,"Consultar Operaciones Monetizadas",CS,COl,CA,operador);
                frame.setVisible(true);
            }
        });

        consultarDisponibleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmConsultarDisponibleRiesgovivo frame = new frmConsultarDisponibleRiesgovivo(self,"Consultar Disponible y Riesgo vivo",CS,COl,CA,operador);
                frame.setVisible(true);
            }
        });


        facturarComisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmFacturarComision frame = new frmFacturarComision(self,"Facturar Comisiones",COl,CA,operador);
                frame.setVisible(true);
            }
        });



        consultarComisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        aprobarDocumentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAprobarDocumento frame = new frmAprobarDocumento(self,"Aprobar Documentos",CS,CA,operador);
                frame.setVisible(true);
            }
        });


        aprobarSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAprobarSocio frame = new frmAprobarSocio(self,"Aprobar Socios",CS,CA,operador);
                frame.setVisible(true);
            }
        });

        monetizarOperacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmMonetizarOperacion frame = new frmMonetizarOperacion(self,"Monetizar Operaciones",COl,CA,operador);
                frame.setVisible(true);
            }
        });

        aprobarLineaCreditoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAprobarLineaCredito frame = new frmAprobarLineaCredito(self,"Aprobar Lineas de Credito",CFDR,COl);
                frame.setVisible(true);

            }
        });

        certificarOperacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmCertificarOperacion frame = new frmCertificarOperacion(self,"Certificar Operaciones",COl,CFDR,CS, CA,operador);
                frame.setVisible(true);
            }
        });


        comisionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlOperacion.setVisible(false);
                pnlSocios.setVisible(false);
                pnlFDR.setVisible(false);
                pnlComision.setVisible(true);

            }
        });

        operacionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlOperacion.setVisible(true);
                pnlSocios.setVisible(false);
                pnlFDR.setVisible(false);
                pnlComision.setVisible(false);
            }
        });
        FDRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlFDR.setVisible(true);
                pnlSocios.setVisible(false);
                pnlOperacion.setVisible(false);
                pnlComision.setVisible(false);
            }
        });

        sociosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlSocios.setVisible(true);
                pnlFDR.setVisible(false);
                pnlOperacion.setVisible(false);
                pnlComision.setVisible(false);
            }
        });

        altaDocumentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAltaDocumento frame = new frmAltaDocumento(self,"Alta de Documentacion",CS, CA,operador);
                frame.setVisible(true);

            }
        });

        cargarBaseDeDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Si", "No"};
                int n = JOptionPane.showOptionDialog(null,
                        "¿Desea cargar la Base de Datos?",
                        "Alta de Accionista",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (n == 0) {
                    try {
                        FdrDAO fdrdao = new FdrDAO();
                        CFDR.setObject((FDR) fdrdao.getObject());

                        SocioDAO sociodao = new SocioDAO();
                        CS.addLista(sociodao.getAll());

                        LineaCreditoDAO lineaCreditoDAO = new LineaCreditoDAO();
                        COl.addLista(lineaCreditoDAO.getAll());

                        OperacionDAO operaciondao = new OperacionDAO();
                        COl.addListaOperaciones(operaciondao.getAll());

                        CertificadoDAO certificadodao = new CertificadoDAO();
                        COl.addListaCertificados(certificadodao.getAll());

                        AuditoriaDAO auditoriaDAO = new AuditoriaDAO();
                        CA.addListaAuditorias(auditoriaDAO.getAll());

                        System.out.println("Los Datos se cargaron exitosamente.");

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

        guardarBaseDeDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object[] options = {"Si", "No"};
                int n = JOptionPane.showOptionDialog(null,
                        "¿Desea guardar los cambios en la Base de Datos?",
                        "Alta de Accionista",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (n == 0) {
                    try {

                        FdrDAO fdrdao = new FdrDAO();
                        fdrdao.saveObject(CFDR.getObject());

                        SocioDAO sociodao = new SocioDAO();
                        sociodao.saveAll(CS.getListaSocios());

                        LineaCreditoDAO lineaCreditoDAO = new LineaCreditoDAO();
                        lineaCreditoDAO.saveAll(COl.getListaLineaCredito());

                        OperacionDAO operaciondao = new OperacionDAO();
                        operaciondao.saveAll(COl.getListaOperaciones());

                        CertificadoDAO certificadodao = new CertificadoDAO();
                        certificadodao.saveAll(COl.getListaCertificados());

                        AuditoriaDAO auditoriaDAO = new AuditoriaDAO();
                        auditoriaDAO.saveAll(CA.getListaAuditorias());

                        System.out.println("Los Datos se guardaron exitosamente.");


                    } catch (Exception exception) {

                        exception.printStackTrace();
                    }
                }
            }
        });


        altaOperacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAltaOperacion frame = new frmAltaOperacion(self,"Alta de Operaciones",CS,COl,CA,operador);
                frame.setVisible(true);
            }
        });

        altaLineaCreditoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAltaLineaCredito frame = new frmAltaLineaCredito(self,"Alta de Lineas de Credito",CS,COl,CA,operador);
                frame.setVisible(true);
            }
        });

        altaAccionistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAltaAccionista frame = new frmAltaAccionista(self,"Alta de Accionistas",CS, CA,operador);
                frame.setVisible(true);
            }
        });

        altaSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAltaSocio frame = new frmAltaSocio(self,"Alta de Socios",CS,CA,operador);
                frame.setVisible(true);
            }
        });

        consultaGeneralButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                frmConsultaGeneral frame = new frmConsultaGeneral(self,"Consultas Generales",CS,CFDR,COl,CA);
                frame.setVisible(true);

            }
        });
        AporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            frmAltaAporte frame=new frmAltaAporte(self,"Alta de Aporte de Capital",CS,CFDR,CA,operador);
            frame.setVisible(true);
            }
        });


    }


}
