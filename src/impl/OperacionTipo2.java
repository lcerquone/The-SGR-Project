package impl;

public class OperacionTipo2 {

	private final int codigosocio;
	private final int codigooperacion;
	private final String empresa;
	private final double  monto;
	private final DateVO fechavencimiento;


	public OperacionTipo2( OperacionTipo2DTO operaciontipo2)
	{
		this.codigosocio=operaciontipo2.getCodigoSocio();
		this.codigooperacion = operaciontipo2.getCodigoOperacion();
		this.empresa = operaciontipo2.getEmpresa();
		this.monto = operaciontipo2.getMonto();
		this.fechavencimiento = operaciontipo2.getFechaVencimiento();
	}

	public int getCodigoSocio() {
		return (this.codigosocio);
	}
	public int getCodigoOperacion() {
		return (this.codigooperacion);
	}
	public String getEmpresa() {
		return (this.empresa);
	}
	public double getMonto() {
		return (this.monto);
	}
	public DateVO getFechaVencimiento() {
		return (this.fechavencimiento);
	}

}
