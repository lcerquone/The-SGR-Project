package controller;

import impl.*;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorLineaDeCredito {

    private final List<LineaCredito> lineascredito = new ArrayList<>();

    public void altaLineaCredito(int codigosocio,DateVO vigencia, String estado, double monto, ControladorSocio CS)
    {
        boolean socioPleno = CS.estadoSocio(codigosocio);
        if (socioPleno){
            int codigolineacredito=lineascredito.size() + 1;
            LineaCredito aux = new LineaCredito(codigolineacredito,codigosocio,vigencia,estado, monto);
            lineascredito.add(aux);
        } else {
            JOptionPane.showMessageDialog(null, "El socio no ha sido aprobado.");
        }
    }

    public  List<LineaCredito> getListaLineaCredito() {
        // TODO Auto-generated method stub
        return this.lineascredito;
    }

    public void addLista(List<LineaCredito> list) {
        lineascredito.clear();
        lineascredito.addAll(list);
    }

    public void addListaCertificados(List<Certificado> list) {
        for(LineaCredito listado : lineascredito){
            listado.addListaCertificados(list);
        }
    }
    public void addListaOperaciones(List<Operacion> list) {
        for(LineaCredito listado : lineascredito){
            listado.addListaOperaciones(list);
        }
    }
    public List<Operacion> getListaOperaciones(){
        List<Operacion> operaciones = new ArrayList<>();
        for (LineaCredito listado : lineascredito){
            operaciones.addAll(listado.getListaOperaciones());
        }
        return operaciones;
    }
    public List<Certificado> getListaCertificados(){
        List<Certificado> certificados = new ArrayList<>();
        for (LineaCredito listado : lineascredito){
            certificados.addAll(listado.getListaCertificados());
        }
        return certificados;
    }

    public void altaOperacionTipo1(int codigosocio,DateVO fecha,String estado,String bancocheque, String numerocheque, DateVO fechavencimiento,String cuitfirmante,double importe) throws Exception {
        LineaCredito aux = obtenerLinea(codigosocio);
        int tipo= 1;
        if (aux == null) {
            throw new Exception("Linea invalido");
        } else {
            aux.altaOperacionTipo1(codigosocio,tipo,fecha,estado,bancocheque,numerocheque,fechavencimiento,cuitfirmante,importe);
        }
    }

    public void altaOperacionTipo2(int codigosocio,DateVO fecha,String estado, String empresa, double importe, DateVO fechavencimiento) throws Exception {
        LineaCredito aux = obtenerLinea(codigosocio);
        int tipo= 2;
        if (aux == null) {
            throw new Exception("Linea invalido");
        } else {
            aux.altaOperacionTipo2(codigosocio,tipo,fecha,estado,empresa,importe,fechavencimiento);
        }
    }

    public void altaOperacionTipo3(int codigosocio,DateVO fecha,String estado,String bancoemisor, double importe, String tasa,DateVO fechaacreditacion, int cuotas,String amortizacion) throws Exception {
        LineaCredito aux = obtenerLinea(codigosocio);
        int tipo= 3;

        if (aux == null) {
            throw new Exception("Linea invalido");
        } else {
            aux.altaOperacionTipo3(codigosocio,tipo,fecha,estado,bancoemisor,importe,tasa,fechaacreditacion,cuotas,amortizacion);
        }
    }

    private LineaCredito obtenerLinea(int codigoLineaCredito) {
        LineaCredito aux = null;

        for (LineaCredito listado : lineascredito) {
            if (listado.getCodigoSocio() == codigoLineaCredito) {
                aux = listado;
                break;
            }
        }
        return aux;
    }
    public void MostrarLineasCreditos() {
        // TODO Auto-generated method stub
        System.out.println("Listado de Lineas de Credito");
        System.out.println("-------------------------");

        for (LineaCredito listado : lineascredito) {
            System.out.println(listado.getCodigoLineaCredito() + " - " + listado.getCodigoSocio() + " - " + listado.getEstado() + " - " + listado.getMonto() + " - " + listado.getVigencia());
        }

        System.out.println("-------------------------");
        System.out.println();
    }

    public double getDisponibleLineaCredito(int codigosocio, int codigoLinea) {
        double disponible=0;
        for (LineaCredito listado : lineascredito) {
            if (listado.getCodigoSocio()== codigosocio && listado.getCodigoLineaCredito()==codigoLinea) {
                disponible= listado.getDisponibleLineaCredito();
            }
        }
        return disponible;
    }

    public String getEstadoLineaCredito(int codigosocio, int codigoLinea ) {
        String estado="";
        for (LineaCredito listado : lineascredito) {
            if (listado.getCodigoSocio()== codigosocio && listado.getCodigoLineaCredito()==codigoLinea) {
                estado= listado.getEstado();
            }
        }
        return estado;
    }
    public void AprobarLineaCredito(int codigolineacredito, ControladorFDR CFDR){

        for (LineaCredito listado : lineascredito) {

            if ( listado.getCodigoLineaCredito()==codigolineacredito){
                if (CFDR.FondosDisponible(this)>= listado.getMonto()) {
                    listado.setEstado("Aprobada");
                    System.out.println("Linea de Credito Aprobada");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Fondos de Riesgo insuficientes");
                }
                break;
            }
        }
    }
    public void MostrarOperaciones() {
        // TODO Auto-generated method stub
        System.out.println("Listado de Operaciones");
        System.out.println("-------------------------");

        for (LineaCredito op : lineascredito) {
            for (Operacion listado : op.getListaOperaciones()) {
                System.out.println(listado.getCodigoOperacion() + " - " + listado.getCodigoSocio() + " - " + listado.getTipo() + " - " + listado.getEstado() + " - " + listado.getMonto());
            }
        }
        System.out.println("-------------------------");
        System.out.println();
    }
    public void CertificarOperacion(ControladorFDR CFDR, ControladorSocio CS, int codigooperacion, int codigoSocio){
        ArrayList<Integer> sociosComunes = CS.getListaDeSociosComunes(codigoSocio);
        sociosComunes.add(codigoSocio);
        double montoFDR = CFDR.FondosDisponible(this);
        montoFDR = montoFDR*0.05;
        double riesgoTotal = 0;
        for (Integer socio : sociosComunes){
            riesgoTotal = riesgoTotal + calcularRiesgoVivo(socio);
        }
        for (LineaCredito lista : lineascredito) {
            if (lista.getCodigoSocio()==codigoSocio){
                lista.CertificarOperacion(codigooperacion, riesgoTotal, montoFDR);
            }

        }
    }
    public double getRiesgoVivo(int codigosocio, int codigoLinea ) {
        double riesgoVivo=0;
        for (LineaCredito listado : lineascredito) {
            if (listado.getCodigoSocio()== codigosocio && listado.getCodigoLineaCredito()==codigoLinea) {
                riesgoVivo = listado.calcularRiesgoVivo();
            }
        }
        return riesgoVivo;
    }

    public double calcularRiesgoVivo (int codigoSocio){
        double riesgoVivo = 0;
        for (LineaCredito listado : lineascredito){
            if (listado.getCodigoSocio() == codigoSocio){
                riesgoVivo = listado.calcularRiesgoVivo();
            }
        }
        return riesgoVivo;
    }

    public void MostrarCertificados() {
        // TODO Auto-generated method stub
        System.out.println("Listado de Certificados");
        System.out.println("-------------------------");
        for (LineaCredito lista : lineascredito) {
            for (Certificado listado: lista.getListaCertificados()){
                System.out.println(listado.getCodigoCertificado() + " - " + listado.getCodigoSocio() + " - " + listado.getFechaEmision() );
            }
        }
        System.out.println("-------------------------");
        System.out.println();
    }

    public void MonetizarOperacion(int codigooperacion, int codigoSocio) {
        for (LineaCredito lista : lineascredito) {
            if (lista.getCodigoSocio()== codigoSocio) {
                lista.MonetizarOperacion(codigooperacion);
                break;
            }

        }
    }
    public void MostrarComisiones() {
        // TODO Auto-generated method stub

        for (LineaCredito lista: lineascredito)
        {
           lista.MostrarComisiones();
        }
    }
    public void FacturarComision(int codigoOperacion, int codigoSocio){
        for (LineaCredito listado: this.lineascredito){
            if (listado.getCodigoSocio() == codigoSocio){
                listado.FacturarComision(codigoOperacion);
            }
        }
    }

    //Total de comisiones calculadas en un día por operaciones de cheques presentadas en el Mercado Argentino de Valores
    public double comisionesCalculadasCheques(DateVO fecha){
        double comisionesCalculadasTotales = 0;
        for (LineaCredito listado: this.lineascredito){
            comisionesCalculadasTotales = comisionesCalculadasTotales + listado.getComisionesCheques(fecha);
        }
        return  comisionesCalculadasTotales;
    }
    // Las operaciones avaladas a nombre de un socio, en estado monetizadas en un período de tiempo
    public List<Operacion> operacionesSocioMonetizadas (DateVO inicio, DateVO fin, int codigoSocio){
        List<Operacion> listaOp = new ArrayList<>();
        for (LineaCredito listado: this.lineascredito){
            if (listado.getCodigoSocio() == codigoSocio && listado.getEstado().equals("Aprobada")){
                listaOp = listado.operacionesMonetizadas(inicio,fin,codigoSocio);
            }
        }
        return listaOp;
    }
    // Consulta porcentaje de comisión a calcularle a un socio por un tipo de operación pasada por parámetros
    public String calcularPorcentaje (int tipo) {
        ComisionTable c1 = new ComisionTable();
        return c1.calcularPorcentaje(tipo);
    }
    // Valor promedio de la tasa de descuento y total operado de cheques y pagarés para un tipo de empresa (pequeña, mediana, grande), en un período de tiempo
    public List<Double> operacionesCHTipoEmpresaYTasaDescuento (ControladorSocio CS, String tamaño, DateVO inicio, DateVO fin){
        List<Double> aux;
        List<Double> tasaYcheques = new ArrayList<>();

        for(Socio lista: CS.getListaSocios()){
            if (lista.getTamaño().equals(tamaño)){
                int codigoSocio = lista.getCodigoSocio();
                for (LineaCredito listado: lineascredito){
                    if (listado.getCodigoSocio() == codigoSocio) {

                        aux = listado.operacionesCHTipoEmpresaYTasaDescuento(inicio, fin);
                        if (!aux.isEmpty()) {
                            double tasa = aux.get(0);
                            double totalCH = aux.get(1);
                            double cant = aux.get(2);
                            // Va Acumulando el total por todos los socios
                            if (!tasaYcheques.isEmpty()) {
                                tasa = (tasa + tasaYcheques.get(0));
                                totalCH = totalCH + tasaYcheques.get(1);
                                cant = cant + tasaYcheques.get(2);
                            }
                            tasaYcheques.clear();
                            tasaYcheques.add(tasa / cant);
                            tasaYcheques.add(totalCH);
                            tasaYcheques.add(cant);
                        }
                    }
                }
            }
        }
        return tasaYcheques;
    }

}
