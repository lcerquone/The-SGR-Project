package impl;

import java.util.ArrayList;
import java.util.List;

public class Socio {
	private final int codigosocio;
	private String estado;
	private final String tipo;
	private final String cuit;
	private final String razonsocial;
	private final DateVO inicioactividad;
	private final String tamaño;
	private final String actividadprincipal;
	private final String domicilio;
	private final String telefono;
	private final EmailVO email;
	
	private final List<Accionista> accionistas = new ArrayList<Accionista>();
	private final List<Documento> documentos = new ArrayList<Documento>();

	public Socio(SocioDTO socio)
	{
		this.codigosocio = socio.getCodigoSocio();
		this.estado = socio.getEstado();
		this.tipo = socio.getTipo();
		this.cuit = socio.getCuit();
		this.razonsocial = socio.getRazonSocial();
		this.inicioactividad = socio.getInicioActividad();
		this.tamaño = socio.getTamaño();
		this.actividadprincipal = socio.getActividadPrincipal();
		this.domicilio = socio.getDomicilio();
		this.telefono = socio.getTelefono();
		this.email = socio.getEmail();
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCodigoSocio() {
		return (this.codigosocio);
	}
	
	public String getEstado() {
		return (this.estado);
	}
	
	public String getTipo() {
		return (this.tipo);
	}
	
	public String getCuit() {
		return (this.cuit);
	}
	
	public String getRazonSocial() {
		return (this.razonsocial);
	}
	
	public DateVO getInicioActividad() {
		return (this.inicioactividad);
	}
	
	public String getDomicilio() {
		return (this.domicilio);
	}
	
	public String getTelefono() {
		return (this.telefono);
	}

	public EmailVO getEmail() {
		return (this.email);
	}
	
	public String getTamaño() {
		return (this.tamaño);
	}
	
	public String getActividadPrincipal() {
		return (this.actividadprincipal);
	}
	
	public void altaAccionista(String cuit, String razonsocial,String porcentaje)
	{
	int codigoaccionista = accionistas.size() + 1;
	AccionistaDTO accionista = new AccionistaDTO();
	accionista.setCodigoAccionista(codigoaccionista);
	accionista.setCodigoSocio(this.codigosocio);
	accionista.setCuit(cuit);
	accionista.setRazonSocial(razonsocial);
	accionista.setPorcentaje(porcentaje);

	Accionista aux = new Accionista(accionista);
	accionistas.add(aux);
	}


	public void altaDocumento(String tipo, String estado, String usuario, DateVO fecharecepcion, String obligatorio)
	{
	int codigodocumento=documentos.size() + 1;

	DocumentoDTO documento = new DocumentoDTO();
	documento.setCodigoDocumento(codigodocumento);
	documento.setCodigoSocio(this.codigosocio);
	documento.setEstado(estado);
	documento.setTipo(tipo);
	documento.setUsuario(usuario);
	documento.setFechaRecepcion(fecharecepcion);
	documento.setObligatorio(obligatorio);
	Documento aux = new Documento(documento);
	documentos.add(aux);
	}


	public  List<Accionista> getListaAccionistas() {
		// TODO Auto-generated method stub
		return this.accionistas;
	}

	public  List<Documento> getListaDocumentos() {
		// TODO Auto-generated method stub
		return this.documentos;
	}
	
}

