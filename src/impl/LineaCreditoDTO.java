package impl;

public class LineaCreditoDTO {

	private int codigolineacredito;
	private int codigosocio;
	private int tipo;
	private DateVO vigencia;
	private  String estado;
	private int monto;


	public LineaCreditoDTO() { }

	public int getCodigoSocio() { return (this.codigosocio); }
	public int getCodigoLineaCredito() { return (this.codigolineacredito);}
	public int getTipo() { return (this.tipo); }
	public DateVO getVigencia() { return (this.vigencia); }
	public String getEstado() { return (this.estado); }
	public int getMonto() { return (this.monto); }

	public void setCodigoSocio(int codigosocio) { this.codigosocio=codigosocio; }
	public void setCodigoLineaCredito(int codigolineacredito) { this.codigolineacredito=codigolineacredito; }
	public void setTipo(int tipo) { this.tipo = tipo; }
	public void setVigencia(DateVO vigencia) { this.vigencia = vigencia; }
	public void setEstado(String estado){ this.estado = estado; }
	public void setMonto(int monto) { this.monto= monto; }



}
