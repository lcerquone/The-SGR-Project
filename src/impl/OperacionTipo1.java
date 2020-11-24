package impl;


public class OperacionTipo1 {

	private final int codigosocio;
	private final int codigooperacion;
	private final String bancocheque;
	private final String numerocheque;
	private final DateVO fechavencimiento;
	private final String cuitfirmante;
	private final double monto;
	private String tasaDescuento;



	public OperacionTipo1(OperacionTipo1DTO operaciontipo1)
	{
		this.codigosocio=operaciontipo1.getCodigoSocio();
		this.codigooperacion =operaciontipo1.getCodigoOperacion();
		this.bancocheque = operaciontipo1.getBancoCheque();
		this.numerocheque = operaciontipo1.getNumeroCheque();
		this.fechavencimiento = operaciontipo1.getFechaVencimiento();
		this.cuitfirmante = operaciontipo1.getCuitFirmante();
		this.monto = operaciontipo1.getMonto();
	}	

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
	public double getMonto() {		return (this.monto); }

	public void setTasaDescuento(String Tasa){ this.tasaDescuento = Tasa;}
	public String getTasaDescuento(){return (this.tasaDescuento);}

}
