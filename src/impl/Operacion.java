package impl;

public class Operacion {
	
	private final int codigosocio;
	private final int codigooperacion;
	private final int tipo;
	private final DateVO fecha;
	private  String estado;
	private final double monto;
	private final OperacionTipo1 tipo1;
	private final OperacionTipo2 tipo2;
	private final OperacionTipo3 tipo3;
	private Comision comision ;


	public Operacion(OperacionDTO operacion )
	{
		this.codigosocio= operacion.getCodigoSocio();
		this.codigooperacion = operacion.getCodigoOperacion();
		this.tipo = operacion.getTipo();
		this.fecha = operacion.getFecha();
		this.estado = operacion.getEstado();
		this.monto = operacion.getMonto();
		this.tipo1 =  operacion.getTipo1();
		this.tipo2 =  operacion.getTipo2();
		this.tipo3 =  operacion.getTipo3();
		this.comision= operacion.getComision();
	}

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

	public void setEstado(String estado) {
		 this.estado= estado;
	}

	public Comision getComision(){return this.comision;}

	public void setComision(Comision comision){ this.comision =comision ;}

	public void setTasaDescuento(OperacionTipo1DTO op){ this.tipo1.setTasaDescuento(op.getTasaDescuento());
    }

	public String getTasaDescuento(){return (this.tipo1.getTasaDescuento());}

}
