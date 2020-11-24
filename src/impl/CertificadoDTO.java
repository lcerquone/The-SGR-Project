package impl;

public class CertificadoDTO {

	private  int codigocertificado;
	private  int codigooperacion;
	private  int codigosocio;
	private  DateVO fechaemision;

	public CertificadoDTO() {	}

	public void setCodigoCertificado(int codigocertificado) {
		this.codigocertificado=codigocertificado;
	}
	public void setCodigoOperacion(int  codigooperacion) {
		this.codigooperacion = codigooperacion;
	}
	public void setCodigoSocio(int codigosocio) {
		this.codigosocio=codigosocio;
	}
	public void setFechaEmision(DateVO fechaemision) {
		this.fechaemision = fechaemision;
	}


	public int getCodigoSocio() {
		return (this.codigosocio);
	}
	public int getCodigoOperacion() {
		return (this.codigooperacion);
	}
	public int getCodigoCertificado() {
		return (this.codigocertificado);
	}
	public DateVO getFechaEmision() {
		return (this.fechaemision);
	}

}
