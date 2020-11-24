package impl;

public class Accionista {

	private final int codigoaccionista;
	private int codigosocio;
	private String cuit;
	private String razonsocial;
	private String porcentaje;

	
	public Accionista(AccionistaDTO accionista )
	{
		this.codigoaccionista=accionista.getCodigoAccionista();
		this.codigosocio=accionista.getCodigoSocio();
		this.cuit = accionista.getCuit();
		this.razonsocial = accionista.getRazonSocial();
		this.porcentaje = accionista.getPorcentaje();
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


}
