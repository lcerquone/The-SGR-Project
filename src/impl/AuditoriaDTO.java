package impl;

import java.sql.Timestamp;

public class AuditoriaDTO {
	private int codigoauditoria;
	private Timestamp timestamp;
	private String evento;
	private String estadoanterior;
	private String estadoposterior;
	private String usuario;

	public AuditoriaDTO() {}

	public void setCodigoAuditoria(int codigoauditoria) {this.codigoauditoria= codigoauditoria;}
	public void setTimestamp(Timestamp timestamp) {		this.timestamp = timestamp;}
	public void setEvento(String evento) {this.evento= evento;}
	public void setEstadoAnterior(String estadoanterior) {this.estadoanterior = estadoanterior;}
	public void setEstadoPosterior(String estadoposterior) {this.estadoposterior = estadoposterior;}
	public void setUsuario(String usuario) {this.usuario = usuario;}

	public int getCodigoauditoria() {
		return (this.codigoauditoria);
	}
	public Timestamp getTimestamp() {
		return (this.timestamp);
	}
	public String getEvento() {
		return (this.evento);
	}
	public String getEstadoanterior() {
		return (this.estadoanterior);
	}
	public String getEstadoposterior() {
		return (this.estadoposterior);
	}
	public String getUsuario() {
		return (this.usuario);
	}

}
