package testing;

import controller.ControladorFDR;
import controller.ControladorLineaDeCredito;
import controller.ControladorSocio;
import impl.DateVO;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class ControladorLineaDeCreditoTest {

    ControladorLineaDeCredito COl = new ControladorLineaDeCredito();
    ControladorSocio CS = new ControladorSocio();
    ControladorFDR CFDR = new ControladorFDR();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void altaLineaCredito() {

        try {
            DateVO fecha = new DateVO("01/01/2020");
            CS.altaSocio("participe","pendiente","20-202020202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(1,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,1);
            CS.altaAccionista(1,"20-1232133-2","Test Srl","10");
            CS.AprobarSocio(1);
            COl.altaLineaCredito(1,fecha,"pendiente",1000,CS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(COl.getListaLineaCredito(), not(IsEmptyCollection.empty()));
    }


    @Test
    void addLista() {
    }

    @Test
    void addListaCertificados() {
    }

    @Test
    void addListaOperaciones() {
    }

    @Test
    void getListaOperaciones() {
        try {
            DateVO fecha = new DateVO("01/01/2020");
            CS.altaSocio("participe","pendiente","20-202020202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(1,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,1);
            CS.altaAccionista(1,"20-1232133-2","Test Srl","10");
            CS.AprobarSocio(1);
            COl.altaLineaCredito(1,fecha,"pendiente",1000,CS);
            COl.altaOperacionTipo1(1,fecha,"pendiente","ICBC","21323",fecha,"20-23131123-2",1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(COl.getListaOperaciones(), not(IsEmptyCollection.empty()));

    }

    @Test
    void getListaCertificados() {
    }

    @Test
    void altaOperacionTipo1() {
        try {
            DateVO fecha = new DateVO("01/01/2020");
            CS.altaSocio("participe","pendiente","20-202020202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(1,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,1);
            CS.altaAccionista(1,"20-1232133-2","Test Srl","10");
            CS.AprobarSocio(1);
            COl.altaLineaCredito(1,fecha,"pendiente",1000,CS);
            COl.altaOperacionTipo1(1,fecha,"pendiente","ICBC","21323",fecha,"20-23131123-2",1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(COl.getListaOperaciones(), not(IsEmptyCollection.empty()));

    }

    @Test
    void altaOperacionTipo2() {

        try {
            DateVO fecha = new DateVO("01/01/2020");
            CS.altaSocio("participe","pendiente","20-202020202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(1,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,1);
            CS.altaAccionista(1,"20-1232133-2","Test Srl","10");
            CS.AprobarSocio(1);
            COl.altaLineaCredito(1,fecha,"pendiente",1000,CS);
            COl.altaOperacionTipo2(1,fecha,"pendiente","ICBC",1000,fecha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(COl.getListaOperaciones(), not(IsEmptyCollection.empty()));
    }

    @Test
    void altaOperacionTipo3()  {

        try {
            DateVO fecha = new DateVO("01/01/2020");
            CS.altaSocio("participe","pendiente","20-202020202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(1,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,1);
            CS.altaAccionista(1,"20-1232133-2","Test Srl","10");
            CS.AprobarSocio(1);
            COl.altaLineaCredito(1,fecha,"pendiente",1000,CS);
            COl.altaOperacionTipo3(1,fecha,"pendiente","ICBC",2000,"10",fecha,3,"Aleman");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(COl.getListaOperaciones(), not(IsEmptyCollection.empty()));
    }

    @Test
    void mostrarLineasCreditos() {
        COl.MostrarLineasCreditos();
    }

    @Test
    void getDisponibleLineaCredito() {
    }

    @Test
    void getEstadoLineaCredito() {
    }

    @Test
    void aprobarLineaCredito() {
        try {
            DateVO fecha = new DateVO("01/01/2020");
            CS.altaSocio("participe","pendiente","20-202020202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(1,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,1);
            CS.altaAccionista(1,"20-1232133-2","Test Srl","10");
            CS.AprobarSocio(1);

            CS.altaSocio("Protector","pendiente","20-2023210202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(2,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,2);
            CS.altaAccionista(2,"20-12999133-2","Test Srl","10");
            CS.AprobarSocio(2);

            CFDR.altaAporte(CS,2,fecha,"Vigente",1000);
            COl.altaLineaCredito(1,fecha,"pendiente",1000,CS);
            COl.AprobarLineaCredito(1,CFDR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(COl.getListaLineaCredito().get(0).getEstado(), equalTo("Aprobada"));
    }

    @Test
    void mostrarOperaciones() {
        COl.MostrarOperaciones();
    }

    @Test
    void certificarOperacion() {
        try {
            DateVO fecha = new DateVO("01/01/2020");
            CS.altaSocio("participe","pendiente","20-202020202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(1,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,1);
            CS.altaAccionista(1,"20-1232133-2","Test Srl","10");
            CS.AprobarSocio(1);

            CS.altaSocio("Protector","pendiente","20-2023210202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(2,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,2);
            CS.altaAccionista(2,"20-12999133-2","Test Srl","10");
            CS.AprobarSocio(2);
            CFDR.altaAporte(CS,2,fecha,"Vigente",10000);

            COl.altaLineaCredito(1,fecha,"pendiente",10000,CS);
            COl.AprobarLineaCredito(1,CFDR);
            COl.altaOperacionTipo3(1,fecha,"pendiente","ICBC",2000,"10",fecha,3,"Aleman");
            COl.CertificarOperacion(CFDR,CS,1,1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(COl.getListaOperaciones().get(0).getEstado(), equalTo("Con certificado emitido"));
    }

    @Test
    void calcularRiesgoVivo() {
    }

    @Test
    void mostrarCertificados() {
        COl.MostrarCertificados();
    }

    @Test
    void monetizarOperacion() {
        try {
            DateVO fecha = new DateVO("01/01/2020");
            CS.altaSocio("participe","pendiente","20-202020202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(1,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,1);
            CS.altaAccionista(1,"20-1232133-2","Test Srl","10");
            CS.AprobarSocio(1);

            CS.altaSocio("protector","pendiente","20-2023210202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(2,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,2);
            CS.altaAccionista(2,"20-12999133-2","Test Srl","10");
            CS.AprobarSocio(2);
            CFDR.altaAporte(CS,2,fecha,"Vigente",10000);

            COl.altaLineaCredito(1,fecha,"pendiente",10000,CS);
            COl.AprobarLineaCredito(1,CFDR);
            COl.altaOperacionTipo3(1,fecha,"pendiente","ICBC",2000,"10",fecha,3,"Aleman");
            COl.CertificarOperacion(CFDR,CS,1,1);
            COl.MonetizarOperacion(1,1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(COl.getListaOperaciones().get(0).getEstado(), equalTo("Monetizado"));
    }

    @Test
    void mostrarComisiones() {
        COl.MostrarComisiones();
    }
}