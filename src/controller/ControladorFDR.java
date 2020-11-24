package controller;

import impl.*;
import javax.swing.*;
import java.util.List;


public class ControladorFDR {

	private FDR fondo = new FDR();

	public ControladorFDR() {
		// TODO Auto-generated method stub

	}

	public void setObject(FDR fondo) {
		this.fondo = fondo;
	}

	public FDR getObject() {
		return fondo;
	}

	public void altaAporte(ControladorSocio CS,int codigosocio, DateVO fecha, String estado, double monto) {

		for (Socio listado : CS.getListaSocios()) {
			if (listado.getCodigoSocio() == codigosocio){
				if (listado.getTipo().equals("Protector")){
					fondo.altaAporte(codigosocio, fecha, estado, monto);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Solo los  socios protectores pueden realizar aportes");
				}
				break;
			}
		}

	}

	public List<Aporte> getListaAportes() {
		return fondo.getAportes();
	}

	public void MostrarFondos() {
		// TODO Auto-generated method stub
		System.out.println("Fondos de Riesgo");
		System.out.println("-------------------------");
		System.out.println(fondo.getMonto());
		System.out.println("-------------------------");
		System.out.println();
	}


	public void MostrarAportes() {
		// TODO Auto-generated method stub
		System.out.println("Listado Aportes");
		System.out.println("-------------------------");
		for (Aporte listado : fondo.getAportes()) {
			System.out.println(listado.getCodigoSocio() + " - " + listado.getEstado() + " - " + listado.getFecha() + " - " + listado.getMonto());
		}
		System.out.println("-------------------------");
		System.out.println();
	}

	public double FondosDisponible(ControladorLineaDeCredito COl){
		double comprometido=0;
		for (LineaCredito listado : COl.getListaLineaCredito()) {
			if (listado.getEstado().equals("Aprobada")) {
				comprometido = comprometido + listado.getMonto();
			}
		}
		double disponible=fondo.getMonto()-comprometido;

		System.out.println("Fondos: " + fondo.getMonto());
		System.out.println("Comprometido: " + comprometido);
		System.out.println("Disponible: " + disponible);
		System.out.println("---------------------------");

		return disponible;
	}

}


