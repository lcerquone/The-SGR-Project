package impl;

public class OperacionTipo3DTO {

	private int codigosocio;
	private int codigooperacion;
	private String bancoemisor;
	private double monto;
	private String tasa;
	private DateVO fechaacreditacion;
	private int cuotas;
	private String amortizacion;


	public OperacionTipo3DTO() {}

	public int getCodigoSocio() {
		return (this.codigosocio);
	}
	public int getCodigoOperacion() {
		return (this.codigooperacion);
	}
	public String getBancoemisor() {
		return (this.bancoemisor);
	}
	public double getMonto() {
		return (this.monto);
	}
	public String getTasa() {
		return (this.tasa);
	}
	public DateVO getFechaAcreditacion() {
		return (this.fechaacreditacion);
	}
	public int getCuotas() {
		return (this.cuotas);
	}
	public String getAmortizacion() {
		return (this.amortizacion);
	}

	public void setCodigoSocio(int codigosocio) {this.codigosocio = codigosocio;}
	public void setCodigoOperacion(int codigooperacion) {this.codigooperacion = codigooperacion;}
	public void setBancoEmisor(String bancoemisor) {this.bancoemisor = bancoemisor;}
	public void setMonto(double monto) {this.monto =  monto;}
	public void setTasa(String tasa) {this.tasa = tasa;}
	public void setFechaAcreditacion (DateVO fechaacreditacion) {this.fechaacreditacion = fechaacreditacion;}
	public void setCuotas(int cuotas) {this.cuotas = cuotas;}
	public void setAmortizacion(String amortizacion) {this.amortizacion = amortizacion;}
}
