package modelo;

import impl.FDR;
import utils.GenericDAO;

public class FdrDAO extends GenericDAO {

    public FdrDAO() throws Exception {
        super(FDR.class,"./src/DataFiles/FDR.json");
    }

}
