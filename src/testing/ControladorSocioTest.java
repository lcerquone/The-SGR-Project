package testing;

import controller.ControladorSocio;
import impl.DateVO;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ControladorSocioTest {

    ControladorSocio CS = new ControladorSocio();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addLista() {
    }

    @Test
    void getListaSocios() {
    }

    @Test
    void altaSocio() {
        CS.altaSocio("participe","pendiente","20-1232131-0","Test",null,"mediano","Prensa","CAA","11-2321-2415",null);
        assertThat(CS.getListaSocios(), not(IsEmptyCollection.empty()));
    }

    @Test
    void altaAccionista() {
        CS.altaSocio("participe","pendiente","20-1232131-0","Test",null,"mediano","Prensa","CAA","11-2321-2415",null);
        try {
            CS.altaAccionista(1,"23-23232323-0","Testing","100");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(CS.getListaAccionista(), not(IsEmptyCollection.empty()));
    }

    @Test
    void getListaDeSociosComunes() {
    }

    @Test
    void mostrarSocios() {
        CS.MostrarSocios();
    }

    @Test
    void mostrarAccionistas() {
        CS.MostrarAccionistas();
    }

    @Test
    void estadoSocio() {
        CS.altaSocio("participe","pendiente","20-1232131-0","Test",null,"mediano","Prensa","CAA","11-2321-2415",null);
        assertNotNull(CS.estadoSocio(1));
    }

    @Test
    void altaDocumento() {
        CS.altaSocio("participe","pendiente","20-1232131-0","Test",null,"mediano","Prensa","CAA","11-2321-2415",null);
        try {
            CS.altaDocumento(1,"boleto","Pendiente","Tester",null,"SI");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(CS.getListaDocumento(), not(IsEmptyCollection.empty()));
    }

    @Test
    void mostrarDocumentos() {
        CS.MostrarDocumentos();
    }

    @Test
    void aprobarSocio() {
        try {
            DateVO fecha = new DateVO("01/01/2020");
            CS.altaSocio("participe","pendiente","20-202020202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(1,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,1);
            CS.altaAccionista(1,"20-1232133-2","Test Srl","10");
            CS.AprobarSocio(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(CS.getListaSocios().get(0).getEstado(), equalTo("Socio pleno"));

    }

    @Test
    void aprobarDocumento() {
        try {
            DateVO fecha = new DateVO("01/01/2020");
            CS.altaSocio("participe","pendiente","20-202020202-3","Test SRL",fecha,"mediano","TEST","CABA","11-2312-1232",null);
            CS.altaDocumento(1,"boleto","Ingresado","Test",fecha,"SI");
            CS.AprobarDocumento(1,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(CS.getListaDocumento().get(0).getEstado(), equalTo("Aprobado"));

    }

    @Test
    void documentosAprobados() {
    }
}