package impl;


public class OperacionTipo1DTO {

	private int codigosocio;
	private int codigooperacion;
	private String bancocheque;
	private String numerocheque;
	private DateVO fechavencimiento;
	private String cuitfirmante;
	private double monto;
	private String tasaDescuento;



	public OperacionTipo1DTO() { }

	public int getCodigoSocio() {
		return (this.codigosocio);
	}
	public int getCodigoOperacion() {
		return (this.codigooperacion);
	}
	public String getBancoCheque() {
		return (this.bancocheque);
	}
	public String getNumeroCheque() {
		return (this.numerocheque);
	}
	public DateVO getFechaVencimiento() {
		return (this.fechavencimiento);
	}
	public String getCuitFirmante() {
		return (this.cuitfirmante);
	}
	public double getMonto() {
		return (this.monto);
	}
	public String getTasaDescuento() {return (this.tasaDescuento);}


	public void setCodigoSocio(int codigosocio) {this.codigosocio=codigosocio;}
	public void setCodigoOperacion(int codigooperacion) {this.codigooperacion = codigooperacion;}
	public void setBancoCheque(String bancocheque) {this.bancocheque = bancocheque;}
	public void setNumeroCheque(String numerocheque) {this.numerocheque = numerocheque;}
	public void setFechaVencimiento(DateVO fechavencimiento) {this.fechavencimiento = fechavencimiento;}
	public void setCuitFirmante (String cuitfirmante) {this.cuitfirmante = cuitfirmante;}
	public void setMonto (double monto) {this.monto = monto;}
	public void setTasaDescuento(String tasaDescuento) { this.tasaDescuento = tasaDescuento;}

}
