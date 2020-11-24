package impl;

public class ComisionDTO {

	private int codigooperacion;
	private int codigosocio;
	private int tipo;
	private String estado;
	private DateVO fechaemision;
	private double monto;

	public ComisionDTO() { }

	public int getCodigoSocio() { return (this.codigosocio); }
	public int getCodigoOperacion() {
		return (this.codigooperacion);
	}
	public DateVO getFechaEmision() {
		return (this.fechaemision);
	}
	public String getEstado() {
		return (this.estado);
	}
	public double getMonto() { return (this.monto); }
	public int getTipo() { return (this.tipo); }

	public void setCodigoSocio(int codigosocio) {this.codigosocio=codigosocio;}
	public void setCodigoOperacion(int codigooperacion) {this.codigooperacion = codigooperacion;}
	public void setFechaEmision(DateVO fechaemision) {this.fechaemision = fechaemision;}
	public void setEstado(String estado) { this.estado = estado; }
	public void setMonto(double monto) { this.monto = monto; }
	public void setTipo(int tipo) { this.tipo=tipo; }

}
