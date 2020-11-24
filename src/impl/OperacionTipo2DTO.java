package impl;


public class OperacionTipo2DTO {

	private int codigosocio;
	private int codigooperacion;
	private String empresa;
	private double monto;
	private DateVO fechavencimiento;


	public OperacionTipo2DTO() { }

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

	public void setCodigoSocio(int codigosocio) {this.codigosocio=codigosocio;}
	public void setCodigoOperacion(int codigooperacion) {this.codigooperacion = codigooperacion;}
	public void setEmpresa(String empresa) {this.empresa = empresa;}
	public void setMonto (double monto) {this.monto = monto;}
	public void setFechaVencimiento(DateVO fechavencimiento) {this.fechavencimiento = fechavencimiento;}
}
