package impl;

import java.util.ArrayList;
import java.util.List;

public class SocioDTO {
	private  int codigosocio;
	private String estado;
	private  String tipo;
	private  String cuit;
	private  String razonsocial;
	private  DateVO inicioactividad;
	private  String tamaño;
	private  String actividadprincipal;
	private  String domicilio;
	private  String telefono;
	private  EmailVO email;

	private final List<Accionista> accionistas = new ArrayList<Accionista>();
	private final List<Documento> documentos = new ArrayList<Documento>();

	public SocioDTO()	{}

	public void setCodigoSocio(int codigosocio) {
		this.codigosocio = codigosocio;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public void setRazonSocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public void setInicioActividad(DateVO inicioactividad) {
		this.inicioactividad = inicioactividad;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	public void setActividadPrincipal(String actividadprincipal) {
		this.actividadprincipal = actividadprincipal;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(EmailVO email) {
		this.email = email;
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

}

