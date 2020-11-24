package modelo;

import impl.Certificado;
import utils.GenericDAO;

public class CertificadoDAO extends GenericDAO {

    public CertificadoDAO() throws Exception {
        super(Certificado.class,"./src/DataFiles/Certificados.json");
    }

}

