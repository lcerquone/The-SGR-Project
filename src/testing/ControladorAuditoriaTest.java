package testing;

import controller.ControladorAuditoria;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorAuditoriaTest {

    ControladorAuditoria CA = new ControladorAuditoria();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void altaAuditoria() {
        CA.altaAuditoria("Prueba","Sin Datos","Con Datos","Test");
        assertNotNull(CA.getListaAuditorias());
    }

    @Test
    void mostrarAuditoria() {
        CA.MostrarAuditoria();
    }

    @Test
    void getListaAuditorias() {
        CA.altaAuditoria("Prueba","Sin Datos","Con Datos","Test");
        assertNotNull(CA.getListaAuditorias());
    }

    @Test
    void addListaAuditorias() {
    }
}