package testing;

import controller.ControladorFDR;
import controller.ControladorSocio;
import impl.DateVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorFDRTest {

    ControladorFDR CFDR = new ControladorFDR();
    ControladorSocio CS = new ControladorSocio();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setObject() {
    }

    @Test
    void getObject() {
        assertNotNull(CFDR.getObject());
    }

    @Test
    void altaAporte() {
        try {
            DateVO fecha = new DateVO("01/01/2020");
            CS.MostrarSocios();
            CFDR.altaAporte(CS,1,fecha,"pendiente",10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(CFDR.getListaAportes());
    }

    @Test
    void getListaAportes() {
        CFDR.getListaAportes();
    }

    @Test
    void mostrarFondos() {
        CFDR.MostrarFondos();
    }

    @Test
    void mostrarAportes() {
        CFDR.MostrarAportes();
    }

    @Test
    void fondosDisponible() {
    }
}