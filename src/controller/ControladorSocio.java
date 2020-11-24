package controller;

import java.util.ArrayList;
import java.util.List;
import impl.*;
import javax.swing.*;


public class ControladorSocio {
	private final List<Socio> socios = new ArrayList<>();

	public ControladorSocio() {
		// TODO Auto-generated method stub

	}

	public void addLista(List<Socio> list) {
		socios.clear();
		socios.addAll(list);
	}

	public List<Socio> getListaSocios() {
		return socios;
	}

	public List<Accionista> getListaAccionista() {
		List<Accionista> accionistas = new ArrayList<>();
		for (Socio listadoSocio : socios) {
			for (Accionista listado : listadoSocio.getListaAccionistas()) {
				accionistas.add(listado);
			}
			}
		return accionistas;
	}

	public List<Documento> getListaDocumento() {
		List<Documento> documentos = new ArrayList<>();
		for (Socio listadoSocio : socios) {
			for (Documento listado : listadoSocio.getListaDocumentos()) {
				documentos.add(listado);
			}
		}
		return documentos;
	}


	public void altaSocio(String tipo, String estado, String cuit, String razonsocial, DateVO inicioactividad, String tamaño,
						  String actividadprincipal, String domicilio, String telefono, EmailVO email) {
		int codigosocio = socios.size() + 1;

		SocioDTO socio = new SocioDTO();
		socio.setCodigoSocio(codigosocio);
		socio.setTipo(tipo);
		socio.setEstado(estado);
		socio.setCuit(cuit);
		socio.setRazonSocial(razonsocial);
		socio.setInicioActividad(inicioactividad);
		socio.setTamaño(tamaño);
		socio.setActividadPrincipal(actividadprincipal);
		socio.setDomicilio(domicilio);
		socio.setTelefono(telefono);
		socio.setEmail(email);

		Socio aux = new Socio(socio);
		socios.add(aux);

	}

	public void altaAccionista(int codigosocio, String cuit, String razonsocial, String porcentaje) throws Exception {

		Socio aux = obtenerSocio(codigosocio);
		if (aux == null) {
			throw new Exception("Socio invalido");
		} else {
			boolean existe = false;
			for (Accionista listado : aux.getListaAccionistas()) {
				if (listado.getCuit().equals(cuit)) {
					existe = true;
				}
			}
			if (!existe) {
				aux.altaAccionista(cuit, razonsocial, porcentaje);
			}
		}
	}

	public ArrayList<Integer> getListaDeSociosComunes(int codigoSocio){
		// Mejorar codigo. Luis Cerquone
		ArrayList<Integer> sociosComunes = new ArrayList<>();
		List<Accionista> accionistas = new ArrayList<>();
		int cant;
		for (Socio listado : socios){
			if (listado.getCodigoSocio()==codigoSocio){
				accionistas.addAll(listado.getListaAccionistas());
			}
		}
		for (Socio listado : socios){
			cant = 1;
			if (listado.getCodigoSocio()!=codigoSocio && listado.getTipo().equals("Partícipe")){
				for (Accionista lista : listado.getListaAccionistas()){
					for (Accionista list : accionistas){
						if (lista.getCuit().equals(list.getCuit()) && cant!=0){
							sociosComunes.add(listado.getCodigoSocio());
							cant=0;
						}
					}
				}
			}
		}
		return sociosComunes;
	}


	public void MostrarSocios() {
		// TODO Auto-generated method stub
		System.out.println("Listado de Socios");
		System.out.println("-------------------------");
		for (Socio listado : socios) {
			System.out.println(listado.getCodigoSocio() + " - " + listado.getCuit() + " - " + listado.getRazonSocial() + " - " + listado.getTipo() + " - " + listado.getEstado());
		}
		System.out.println("-------------------------");
		System.out.println();
	}

	public void MostrarAccionistas() {
		// TODO Auto-generated method stub
		System.out.println("Listado de Accionistas");
		System.out.println("-------------------------");

		for (Socio listadoSocio : socios) {
			System.out.println("Accionistas de Socio: " + listadoSocio.getCodigoSocio());
			for (Accionista listado : listadoSocio.getListaAccionistas()) {
				System.out.println(listado.getCodigoAccionista() + " - " + listado.getCuit() + " - " + listado.getRazonSocial() + " - " + listado.getPorcentaje());
			}
		}
		System.out.println("-------------------------");
		System.out.println();
	}
	public boolean estadoSocio(int codigoSocio) {
		boolean socioPleno = false;
		if (obtenerSocio(codigoSocio).getEstado().equals("Socio pleno")){
			socioPleno = true;
		}
		return socioPleno;
	}

	private Socio obtenerSocio(int codigosocio) {
		Socio aux = null;

		for (Socio listado : socios) {
			if (listado.getCodigoSocio() == codigosocio) {
				aux = listado;
				break;
			}
		}
		return aux;
	}

	public void altaDocumento(int codigosocio, String tipo, String estado, String usuario, DateVO fecharecepcion, String obligatorio) throws Exception {
		Socio aux = obtenerSocio(codigosocio);
		if (aux == null) {
			throw new Exception("Socio invalido");
		} else {
			aux.altaDocumento(tipo, estado, usuario, fecharecepcion, obligatorio);
		}

	}

	public void MostrarDocumentos() {
		// TODO Auto-generated method stub
		System.out.println("Listado de Documentos");
		System.out.println("-------------------------");

		for (Socio listadoSocio : socios) {
			System.out.println("Documentos de Socio: " + listadoSocio.getCodigoSocio());
			for (Documento listado : listadoSocio.getListaDocumentos()) {
				System.out.println(listado.getCodigoDocumento() + " - " + listado.getEstado() + " - " + listado.getUsuario() + " - " + listado.getTipo() + " - " + listado.getFechaRecepcion() + " - " + listado.getObligatorio());
			}
		}
		System.out.println("-------------------------");
		System.out.println();
	}


	public void AprobarSocio(int codigosocio) {
		boolean noEsAccionista = true;

		for (Socio listado : socios) {
			if (listado.getCodigoSocio() == codigosocio) {
				if(listado.getTipo().equals("Protector") && this.DocumentosAprobados(codigosocio) && !listado.getListaAccionistas().isEmpty()) {
					for (Socio listados : socios) {
						if (listados.getTipo().equals("Partícipe")) {
							for (Accionista accionistas : listados.getListaAccionistas()) {
								if (accionistas.getCuit().equals(listado.getCuit())) {
									JOptionPane.showMessageDialog(null, "Un socio protector no puede ser accionista del socio participe.");
									noEsAccionista = false;
									break;
								}
							}
							if (noEsAccionista){
								listado.setEstado("Socio pleno");
								System.out.println("Socio Aprobado");
							}
						}
					}

				} else if (this.DocumentosAprobados(codigosocio) && !listado.getListaAccionistas().isEmpty()){
					listado.setEstado("Socio pleno");
					System.out.println("Socio Aprobado");
				} else if (listado.getListaAccionistas().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tiene Accionistas.");
				} else {
					JOptionPane.showMessageDialog(null, "Falta Documentación.");
				}
				break;
			}
		}
	}

	public void AprobarDocumento(int codigodocumento, int codigosocio ) {

		for (Socio listadoSocio : socios) {
			if (listadoSocio.getCodigoSocio() == codigosocio) {
				for (Documento listadodocumento : listadoSocio.getListaDocumentos()) {
					if (listadodocumento.getCodigoDocumento() == codigodocumento) {
						listadodocumento.setEstado("Aprobado");
					}
					System.out.println("Documento Aprobado");
				}
				break;
			}
		}
	}



	public boolean DocumentosAprobados(int codigosocio ) {
	boolean aprobado=true;
		for (Socio listadoSocio : socios) {
			if (listadoSocio.getCodigoSocio() == codigosocio) {

				if (listadoSocio.getListaDocumentos().size()==0) {
					System.out.println("Documentos inexistentes. Debe completar documentacion.");
					aprobado = false;
				}
				else
				{
				for (Documento listadodocumento : listadoSocio.getListaDocumentos()) {
					if ((listadodocumento.getObligatorio().equals("SI") && !listadodocumento.getEstado().equals("Aprobado")) ) {
						System.out.println("Documento sin aprobar");
						aprobado = false;
					}
				} }
				break;
			}
		}
       return aprobado;
	}
}
