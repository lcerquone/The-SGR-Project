package impl;

public class OperacionDTO {
	
	private int codigosocio;
	private int codigooperacion;
	private int tipo;
	private DateVO fecha;
	private String estado;
	private double monto;
	private OperacionTipo1 tipo1;
	private OperacionTipo2 tipo2;
	private OperacionTipo3 tipo3;
	private Comision comision ;

	public OperacionDTO( ) { }

	public int getCodigoSocio() {
		return (this.codigosocio);
	}
	public int getCodigoOperacion() {
		return (this.codigooperacion);
	}
	public String getEstado() {
		return (this.estado);
	}
	public DateVO getFecha() {
		return (this.fecha);
	}
	public double getMonto() {
		return (this.monto);
	}
	public int getTipo() {
		return (this.tipo);
	}
	public Comision getComision() {return (this.comision);}
	public OperacionTipo1 getTipo1() {return (this.tipo1);}
	public OperacionTipo2 getTipo2() {return (this.tipo2);}
	public OperacionTipo3 getTipo3() {return (this.tipo3);}

	public void setCodigoSocio(int codigosocio) {this.codigosocio=codigosocio;}
	public void setCodigoOperacion(int codigooperacion) {this.codigooperacion = codigooperacion;}
	public void setEstado(String estado) {
		this.estado= estado;
	}
	public void setFecha(DateVO fecha) {this.fecha = fecha;}
	public void setMonto(double monto) {this.monto = monto;}
	public void setTipo(int tipo) {this.tipo = tipo;}
	public void setComision(Comision comision){ this.comision = comision;}
	public void setTipo1(OperacionTipo1 tipo1) {this.tipo1 = tipo1;}
	public void setTipo2(OperacionTipo2 tipo2) {this.tipo2 = tipo2;}
	public void setTipo3(OperacionTipo3 tipo3) {this.tipo3 = tipo3;}
}
