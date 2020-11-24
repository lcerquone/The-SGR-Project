package impl;

public class Certificado {

	private final int codigocertificado;
	private final int codigooperacion;
	private final int codigosocio;
	private final DateVO fechaemision;


	public Certificado(CertificadoDTO certificado)
	{
		this.codigocertificado=certificado.getCodigoCertificado();
		this.codigooperacion = certificado.getCodigoOperacion();
		this.codigosocio=certificado.getCodigoSocio();
		this.fechaemision = certificado.getFechaEmision();
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
