package impl;

public class Aporte {

	private final int codigoaporte;
	private final int codigosocio;
	private final DateVO fecha;
	private final String estado;
	private final double monto;


	public Aporte(AporteDTO aporte )
	{
		this.codigoaporte = aporte.getCodigoAporte();
		this.codigosocio=aporte.getCodigoSocio();
		this.fecha = aporte.getFecha();
		this.estado = aporte.getEstado();
		this.monto = aporte.getMonto();
	}

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
