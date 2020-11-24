package modelo;

import impl.LineaCredito;
import utils.GenericDAO;

public class LineaCreditoDAO extends GenericDAO {

    public LineaCreditoDAO() throws Exception {
        super(LineaCredito.class,"./src/DataFiles/LineaCredito.json");
    }

}

