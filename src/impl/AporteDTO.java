package impl;

public class AporteDTO {

	private  int codigoaporte;
	private  int codigosocio;
	private  DateVO fecha;
	private  String estado;
	private  double monto;


	public AporteDTO() { }

	public void setCodigoAporte(int codigoaporte){		this.codigoaporte = codigoaporte; }

	public void setCodigoSocio( int codigosocio){		this.codigosocio=codigosocio; }

	public void setFecha(DateVO fecha){	this.fecha = fecha; }

	public void setEstado(String estado){				this.estado = estado; }

	public void setMonto(double monto){			this.monto = monto; }

	public int getCodigoAporte() {
		return (this.codigoaporte);
	}

	public int getCodigoSocio() {
		return (this.codigosocio);
	}

	public String getEstado() {
		return (this.estado);
	}
	
	public double getMonto() {
		return (this.monto);
	}

	public DateVO getFecha() {
		return (this.fecha);
	}

}
