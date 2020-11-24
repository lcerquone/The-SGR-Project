package impl;

import java.sql.Timestamp;

public class Auditoria {
	private final int codigoauditoria;
	private final Timestamp timestamp;
	private final String evento;
	private final String estadoanterior;
	private final String estadoposterior;
	private final String usuario;

	public Auditoria( AuditoriaDTO auditoria) {
		this.codigoauditoria= auditoria.getCodigoauditoria();
		this.timestamp = auditoria.getTimestamp();
		this.evento = auditoria.getEvento();
		this.estadoanterior = auditoria.getEstadoanterior();
		this.estadoposterior = auditoria.getEstadoposterior();
		this.usuario = auditoria.getUsuario();
	}

	public int getCodigoauditoria() {
		return (this.codigoauditoria);
	}
	public Timestamp getTimestamp() {
		return (this.timestamp);
	}
	public String getEvento() {	return (this.evento);}
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
