package modelo;

import impl.Socio;
import utils.GenericDAO;

    public class SocioDAO extends GenericDAO {

        public SocioDAO() throws Exception {
            super(Socio.class,"./src/DataFiles/Socios.json");
        }

    }

