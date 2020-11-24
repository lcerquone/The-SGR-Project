package impl;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LineaCredito {

	private final int codigolineacredito;
	private final int codigosocio;
	private final DateVO vigencia;
	private  String estado;
	private final double monto;

	private final List<Operacion> operaciones = new ArrayList<>();
	private final List<Certificado> certificados = new ArrayList<>();
	private final String pattern = "dd/MM/yyyy";

	public LineaCredito(int codigolineacredito, int codigosocio,DateVO vigencia,String estado, double monto )
	{
		this.codigolineacredito=codigolineacredito;
		this.codigosocio=codigosocio;
		this.vigencia = vigencia;
		this.estado = estado;
		this.monto = monto;
	}	

	public int getCodigoSocio() {
		return (this.codigosocio);
	}
	
	public int getCodigoLineaCredito() {
		return (this.codigolineacredito);
	}

	public DateVO getVigencia() {
		return (this.vigencia);
	}
	
	public String getEstado() {
		return (this.estado);
	}
	
	public double getMonto() {
		return (this.monto);
	}

	public void setEstado(String estado) { this.estado= estado; }

	public void altaOperacionTipo1(int codigosocio, int tipo,DateVO fecha,String estado,String bancocheque, String numerocheque, DateVO fechavencimiento,String cuitfirmante,double monto) throws Exception {

		int codigooperacion=operaciones.size() + 1;
		OperacionTipo1DTO auxtipo1dto = new OperacionTipo1DTO();
		auxtipo1dto.setCodigoOperacion(codigooperacion);
		auxtipo1dto.setCodigoSocio(codigosocio);
		auxtipo1dto.setBancoCheque(bancocheque);
		auxtipo1dto.setNumeroCheque(numerocheque);
		auxtipo1dto.setFechaVencimiento(fechavencimiento);
		auxtipo1dto.setCuitFirmante(cuitfirmante);
		auxtipo1dto.setMonto(monto);

		OperacionTipo1 auxtipo1 = new OperacionTipo1(auxtipo1dto);

		OperacionDTO auxdto = new OperacionDTO();
		auxdto.setCodigoOperacion(codigooperacion);
		auxdto.setCodigoSocio(codigosocio);
		auxdto.setTipo(tipo);
		auxdto.setFecha(fecha);
		auxdto.setEstado(estado);
		auxdto.setMonto(monto);
		auxdto.setTipo1(auxtipo1);
		Operacion aux = new Operacion(auxdto);
		operaciones.add(aux);

	}

	public void altaOperacionTipo2(int codigosocio, int tipo,DateVO fecha,String estado, String empresa, double monto, DateVO fechavencimiento) throws Exception {

		int codigooperacion=operaciones.size() + 1;
		OperacionTipo2DTO auxtipo2dto = new OperacionTipo2DTO();
		auxtipo2dto.setCodigoOperacion(codigooperacion);
		auxtipo2dto.setCodigoSocio(codigosocio);
		auxtipo2dto.setEmpresa(empresa);
		auxtipo2dto.setMonto(monto);
		auxtipo2dto.setFechaVencimiento(fechavencimiento);

		OperacionTipo2 auxtipo2 = new OperacionTipo2(auxtipo2dto);

		OperacionDTO auxdto = new OperacionDTO();
		auxdto.setCodigoOperacion(codigooperacion);
		auxdto.setCodigoSocio(codigosocio);
		auxdto.setTipo(tipo);
		auxdto.setFecha(fecha);
		auxdto.setEstado(estado);
		auxdto.setMonto(monto);
		auxdto.setTipo2(auxtipo2);
		Operacion aux = new Operacion(auxdto);

		operaciones.add(aux);
	}

	public void altaOperacionTipo3(int codigosocio, int tipo,DateVO fecha,String estado,String bancoemisor, double monto, String tasa,DateVO fechaacreditacion, int cuotas,String amortizacion) throws Exception {

		int codigooperacion=operaciones.size() + 1;
		OperacionTipo3DTO auxtipo3dto = new OperacionTipo3DTO();
		auxtipo3dto.setCodigoOperacion(codigooperacion);
		auxtipo3dto.setCodigoSocio(codigosocio);
		auxtipo3dto.setBancoEmisor(bancoemisor);
		auxtipo3dto.setMonto(monto);
		auxtipo3dto.setTasa(tasa);
		auxtipo3dto.setFechaAcreditacion(fechaacreditacion);
		auxtipo3dto.setCuotas(cuotas);
		auxtipo3dto.setAmortizacion(amortizacion);

		OperacionTipo3 auxtipo3 = new OperacionTipo3(auxtipo3dto);

		OperacionDTO auxdto = new OperacionDTO();
		auxdto.setCodigoOperacion(codigooperacion);
		auxdto.setCodigoSocio(codigosocio);
		auxdto.setTipo(tipo);
		auxdto.setFecha(fecha);
		auxdto.setEstado(estado);
		auxdto.setMonto(monto);
		auxdto.setTipo3(auxtipo3);
		Operacion aux = new Operacion(auxdto);
		operaciones.add(aux);

	}
	public List<Operacion> getListaOperaciones(){
		return operaciones;
	}

	public List<Certificado> getListaCertificados(){
		return certificados;
	}

	public void addListaCertificados(List<Certificado> listacertificado) {
		certificados.clear();
		for (Certificado listado : listacertificado) {
			if (listado.getCodigoSocio() == codigosocio)
				certificados.add(listado);
		}
	}
	public void addListaOperaciones(List<Operacion> listaoperacion) {
		operaciones.clear();
		for (Operacion listado: listaoperacion)
			if( listado.getCodigoSocio()==codigosocio)
				operaciones.add(listado);
	}
	public void CertificarOperacion(int codigooperacion, double riesgoTotal, double montoFDR){
		for(Operacion listado : operaciones){
			if ( listado.getCodigoOperacion()==codigooperacion){
				double disponible= getDisponibleLineaCredito();
				double totalFacturas = getListaMontoFactura();
				if (disponible >= listado.getMonto() && estado.equals("Aprobada") && riesgoTotal <= montoFDR && totalFacturas<(this.getMonto()*0.1)) {

					String dateInString =new SimpleDateFormat(pattern).format(new Date());

					try {
						DateVO fecha = new DateVO(dateInString);
						int codigocertificado= getListaCertificados().size()+1;
						CertificadoDTO certificado = new CertificadoDTO();
						certificado.setCodigoCertificado(codigocertificado);
						certificado.setCodigoOperacion(codigooperacion);
						certificado.setCodigoSocio(listado.getCodigoSocio());
						certificado.setFechaEmision(fecha);
						Certificado aux = new Certificado(certificado);
						certificados.add(aux);
						listado.setEstado("Con certificado emitido");
						System.out.println("Certificado exitoso.");

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				else
				{
					JOptionPane.showMessageDialog(null, "No tiene linea de credito o saldo disponible");
				}
			}
		}
	}

	public double getListaMontoFactura(){
		double montoFactura = 0;
		for (Operacion listado: this.operaciones){
			if(listado.getEstado().equals("Monetizado") && listado.getComision().getEstado().equals("Facturada")){
				montoFactura= montoFactura + listado.getComision().getMonto();
			}
		}
		return montoFactura;

	}
	public double calcularRiesgoVivo() {
		double riesgoVivo = 0;
		for (Operacion oper : operaciones){
			if (oper.getEstado().equals("Monetizado")){
				riesgoVivo = riesgoVivo + oper.getMonto();
			}
		}
		return riesgoVivo;
	}

	public void MonetizarOperacion(int codigooperacion) {
		for (Operacion listado : operaciones) {
			if (listado.getCodigoOperacion() == codigooperacion) {
				String dateInString =new SimpleDateFormat(pattern).format(new Date());

				try {
					DateVO fecha = new DateVO(dateInString);
					listado.setEstado("Monetizado");
					if (listado.getTipo()==1) {
						OperacionTipo1DTO aux = new OperacionTipo1DTO();
						String tasaDescuento = JOptionPane.showInputDialog("Introduzca la Tasa de Descuento: ");
						aux.setTasaDescuento(tasaDescuento);
						listado.setTasaDescuento(aux);
					}
					double monto = calcularComision (listado.getTipo(), listado.getMonto());
					String estado= "Calculada";
					ComisionDTO comision = new ComisionDTO();
					comision.setCodigoOperacion(codigooperacion);
					comision.setCodigoSocio(listado.getCodigoSocio());
					comision.setEstado(estado);
					comision.setTipo(listado.getTipo());
					comision.setFechaEmision(fecha);
					comision.setMonto(monto);

					Comision aux = new Comision(comision);
					listado.setComision(aux);
					System.out.println("Monetizado exitoso.");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public double calcularComision (double tipo,double monto) {
		double comision;

		if (tipo == 3)
			comision=(monto*4)/100;
		else
		{
			comision=(monto*3)/100;
		}
		return comision;
	}
	public void FacturarComision (int codigoOperacion) {

		for (Operacion listado : this.operaciones) {
			if (listado.getCodigoOperacion() == codigoOperacion) {
				if (listado.getEstado().equals("Monetizado") && listado.getComision().getEstado().equals("Calculada")) {
					listado.getComision().setEstado("Facturada");
					System.out.println("Comision Facturada.");
				} else {
					JOptionPane.showMessageDialog(null, "La comision no ha sido calculada.");
				}
				break;
			}
		}
	}
	public void MostrarComisiones() {
		// TODO Auto-generated method stub
		System.out.println("Listado de Comisiones");
		System.out.println("-------------------------");

		for (Operacion listado: operaciones)
		{
			Comision aux= listado.getComision();
			if (aux != null)
			System.out.println( aux.getCodigoOperacion() + " - " + aux.getCodigoSocio() + " - " + aux.getTipo() + " - " + aux.getEstado() + " - " + aux.getFechaEmision() + " - " + aux.getMonto());
		}
		System.out.println("-------------------------");
		System.out.println();
	}
	public double getDisponibleLineaCredito(){
		double utilizado = 0;
		for (Operacion listado: operaciones){
			if (listado.getEstado().equals("Con certificado emitido")){
				utilizado = utilizado + listado.getMonto();
			} else if (listado.getEstado().equals("Monetizado")){
				utilizado = utilizado + listado.getMonto();
			}
		}
		utilizado = this.monto - utilizado;
		return utilizado;
	}

	public double getComisionesCheques(DateVO dia){
		double comisionesCalculadasTotales = 0;
		for (Operacion listado: operaciones){
			if (listado.getTipo() == 1 && listado.getEstado().equals("Monetizado") && listado.getComision().getFechaEmision().equals(dia) && listado.getComision().getEstado().equals("Facturada")){
				comisionesCalculadasTotales = comisionesCalculadasTotales +listado.getComision().getMonto();
			}
		}
		return comisionesCalculadasTotales;
	}

	public List<Operacion> operacionesMonetizadas(DateVO inicio,DateVO fin, int codigosocio){
		List<Operacion> listaOp = new ArrayList<>();
		for (Operacion listado :this.getListaOperaciones()){
			if ( listado.getCodigoSocio() == codigosocio  && listado.getEstado().equals("Monetizado") && listado.getFecha().compararFechas(inicio) >= 0 && listado.getFecha().compararFechas(fin) <= 0 ){
				listaOp.add(listado);
			}
		}
		return listaOp;
	}

	public List<Double> operacionesCHTipoEmpresaYTasaDescuento (DateVO inicio, DateVO fin){
		List<Double> tasaYcheques = new ArrayList<>();
		double promTasa = 0;
		double cant = 0;
		double totalCH = 0;

		for (Operacion listado: operaciones){
			if (listado.getEstado().equals("Monetizado") && listado.getFecha().compararFechas(inicio) >= 0 && listado.getFecha().compararFechas(fin) <= 0 && listado.getTipo() == 1 ){
				promTasa = promTasa + Integer.parseInt(listado.getTasaDescuento());
				totalCH = totalCH + listado.getMonto();
				cant++;
			}
		}
		// En la primera posicion esta el promedio de la tasa de descuento y en la segunda posicion esta el total operado por cheques.
		if (cant > 0) {
			tasaYcheques.add(promTasa);
			tasaYcheques.add(totalCH);
			tasaYcheques.add(cant);
		}
		else
		{
			tasaYcheques.clear();
		}
		// Acumula por cada Linea
		return tasaYcheques;
	}

}
