package unq.poo2.banco;

public class SolicitudCreditoHipotecario extends SolicitudCredito {

	private PropiedadInmobiliaria propiedadInmobiliaria;
	
	public SolicitudCreditoHipotecario(Cliente cliente, double monto, int plazoEnMeses, PropiedadInmobiliaria propiedadInmobiliaria) {
		this.cliente = cliente;
		this.monto = monto;
		this.plazoEnMeses = plazoEnMeses;
		this.propiedadInmobiliaria = propiedadInmobiliaria;
	}

	@Override 
	public boolean esAceptable() {
		return 	this.montoCuota() <= cliente.getSueldoNetoMensual() * 0.5 
				&& this.monto < this.propiedadInmobiliaria.valorFiscal() * 0.7
				&& ( this.cliente.getEdad() + (this.plazoEnMeses / 12) ) < 65 ;
	}
	
}