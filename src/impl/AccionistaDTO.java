package impl;

public class AccionistaDTO {

	private int codigoaccionista;
	private int codigosocio;
	private String cuit;
	private String razonsocial;
	private String porcentaje;


	public AccionistaDTO()	{}

	public void setCodigoAccionista(int codigoaccionista) {	this.codigoaccionista=codigoaccionista;	}
	public void setCodigoSocio(int codigosocio) {
		this.codigosocio = codigosocio;
	}
	public void setCuit(String cuit ) {
		this.cuit= cuit;
	}
	public void setRazonSocial(String razonsocial) {
		this.razonsocial=razonsocial;
	}
	public void setPorcentaje(String porcentaje ) {
		this.porcentaje= porcentaje;
	}

	public int getCodigoSocio() {
		return (this.codigosocio);
	}
	public int getCodigoAccionista() {
		return (this.codigoaccionista);
	}
	public String getCuit() {
		return (this.cuit);
	}
	public String getRazonSocial() {
		return (this.razonsocial);
	}
	public String getPorcentaje() {
		return (this.porcentaje);
	}

}
