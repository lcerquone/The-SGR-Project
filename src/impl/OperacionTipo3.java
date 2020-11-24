package impl;

public class OperacionTipo3 {

	private final int codigosocio;
	private final int codigooperacion;
	private final String bancoemisor;
	private final double monto;
	private final String tasa;
	private final DateVO fechaacreditacion;
	private final int cuotas;
	private final String amortizacion;


	public OperacionTipo3(OperacionTipo3DTO operaciontipo3)
	{
		this.codigosocio=operaciontipo3.getCodigoSocio();
		this.codigooperacion = operaciontipo3.getCodigoOperacion();
		this.bancoemisor = operaciontipo3.getBancoemisor();
		this.monto = operaciontipo3.getMonto();
		this.tasa = operaciontipo3.getTasa();
		this.fechaacreditacion = operaciontipo3.getFechaAcreditacion();
		this.cuotas = operaciontipo3.getCuotas();
		this.amortizacion = operaciontipo3.getAmortizacion();
	}

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

}
