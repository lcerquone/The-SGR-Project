package impl;

public class Documento {

	private final int codigodocumento;
	private final int codigosocio;
	private final String tipo;
	private String estado;
	private final String usuario;
	private final DateVO fecharecepcion;
	private final String obligatorio;
	
	public Documento( DocumentoDTO documento )
	{
		this.codigodocumento=documento.getCodigoDocumento();
		this.codigosocio=documento.getCodigoSocio();
		this.usuario = documento.getUsuario();
		this.tipo = documento.getTipo();
		this.estado = documento.getEstado();
		this.fecharecepcion = documento.getFechaRecepcion();
		this.obligatorio = documento.getObligatorio();
	}	

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

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
