package unq.poo2.banco;

public class SolicitudCreditoPersonal extends SolicitudCredito {
	
	public SolicitudCreditoPersonal(Cliente cliente, double monto, int plazoEnMeses) {
		this.cliente = cliente;
		this.monto = monto;
		this.plazoEnMeses = plazoEnMeses;
	}

	@Override 
	public boolean esAceptable() {
		double ingresosAnualesCliente = (cliente.getSueldoNetoMensual() * 12);
		return ingresosAnualesCliente > 15000 && this.montoCuota() < cliente.getSueldoNetoMensual() * 0.7 ;
	}
	
}