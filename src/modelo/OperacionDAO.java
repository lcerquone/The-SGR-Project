package modelo;

import impl.Operacion;
import utils.GenericDAO;

public class OperacionDAO extends GenericDAO {

    public OperacionDAO() throws Exception {
        super(Operacion.class,"./src/DataFiles/Operaciones.json");
    }

}

