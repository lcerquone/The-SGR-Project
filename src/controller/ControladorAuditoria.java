package controller;

import impl.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class ControladorAuditoria {

	private final List<Auditoria> auditorias = new ArrayList<>();

	public ControladorAuditoria() {
		// TODO Auto-generated method stub

	}

	public void altaAuditoria( String evento, String estadoanterior, String estadoposterior, String usuario) {
		int codigoauditoria = auditorias.size() + 1;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		AuditoriaDTO auditoria = new AuditoriaDTO();
		auditoria.setCodigoAuditoria(codigoauditoria);
		auditoria.setTimestamp(timestamp);
		auditoria.setEvento(evento);
		auditoria.setEstadoAnterior(estadoanterior);
		auditoria.setEstadoPosterior(estadoposterior);
		auditoria.setUsuario(usuario);
		Auditoria aux = new Auditoria(auditoria);
		auditorias.add(aux);

		MostrarAuditoria();
	}


	public void MostrarAuditoria() {
		// TODO Auto-generated method stub
		System.out.println("Listado de Auditorias");
		System.out.println("-------------------------");
		for (Auditoria listado : auditorias) {
			System.out.println(listado.getCodigoauditoria() + " - " + listado.getTimestamp() + " - " + listado.getEvento() + " - " + listado.getEstadoanterior() + " - " + listado.getEstadoposterior() + " - " + listado.getUsuario());
		}
		System.out.println("-------------------------");
		System.out.println();
	}

	public List<Auditoria> getListaAuditorias() {
		return auditorias;
	}

	public void addListaAuditorias(List<Auditoria> list) {
		auditorias.clear();
		auditorias.addAll(list);
	}

}


