package impl;

public class Comision {

	private final int codigooperacion;
	private final int codigosocio;
	private final int tipo;
	private String estado;
	private final DateVO fechaemision;
	private final double monto;

	public Comision(ComisionDTO comision)
	{
		this.codigooperacion = comision.getCodigoOperacion();
		this.codigosocio = comision.getCodigoSocio();
		this.tipo = comision.getTipo();
		this.estado = comision.getEstado();
		this.fechaemision = comision.getFechaEmision();
		this.monto = comision.getMonto();
	}	

	public int getCodigoSocio() {
		return (this.codigosocio);
	}

	public int getCodigoOperacion() {
		return (this.codigooperacion);
	}

	public DateVO getFechaEmision() {
		return (this.fechaemision);
	}

	public String getEstado() {
		return (this.estado);
	}

	public void setEstado(String estado) { this.estado = estado; }

	public double getMonto() { return (this.monto); }

	public int getTipo() { return (this.tipo); }

}
