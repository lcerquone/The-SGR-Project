package impl;

import java.util.ArrayList;
import java.util.List;

public class FDR {
	
	private double monto;

	private final List<Aporte> aportes = new ArrayList<Aporte>();

	public FDR()
	{
		this.monto = 0;
	}	

	public double getMonto() {
		return (this.monto);
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}

	public void altaAporte(int codigosocio, DateVO fecha, String estado,double monto)
	{
		int codigoaporte=aportes.size() + 1;
		AporteDTO aporte= new AporteDTO();
		aporte.setCodigoAporte(codigoaporte);
		aporte.setCodigoSocio(codigosocio);
		aporte.setEstado(estado);
		aporte.setFecha(fecha);
		aporte.setMonto(monto);

		Aporte aux = new Aporte(aporte);
		aportes.add(aux);
		this.monto = this.monto + monto;
	}

	public  List<Aporte> getAportes() {
		// TODO Auto-generated method stub
		return this.aportes;
	}

}
