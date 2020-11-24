package modelo;

import impl.Auditoria;
import utils.GenericDAO;

public class AuditoriaDAO extends GenericDAO {

    public AuditoriaDAO() throws Exception {
        super(Auditoria.class,"./src/DataFiles/Auditorias.json");
    }

}

