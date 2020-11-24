package impl;

public class DocumentoDTO {

	private int codigodocumento;
	private int codigosocio;
	private String tipo;
	private String estado;
	private String usuario;
	private DateVO fecharecepcion;
	private String obligatorio;

	public DocumentoDTO(){}

	public void setCodigoDocumento(int codigodocumento) {
		this.codigodocumento=codigodocumento;
	}
	public void setCodigoSocio(int codigosocio) {this.codigosocio=codigosocio;	}
	public void setTipo(String tipo)   { this.tipo = tipo; }
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setFechaRecepcion(DateVO fecharecepcion) {	this.fecharecepcion = fecharecepcion;	}
	public void setObligatorio(String obligatorio ) { this.obligatorio = obligatorio;	}

	public int getCodigoSocio() {
		return (this.codigosocio);
	}
	public int getCodigoDocumento() {
		return (this.codigodocumento);
	}
	public String getUsuario() {
		return (this.usuario);
	}
	public String getEstado() {
		return (this.estado);
	}
	public DateVO getFechaRecepcion() {
		return (this.fecharecepcion);
	}
	public String getTipo() {
		return (this.tipo);
	}
	public String getObligatorio() {
		return (this.obligatorio);
	}

}
