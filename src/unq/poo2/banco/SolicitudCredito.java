package unq.poo2.banco;

public abstract class SolicitudCredito {
	
	protected Cliente cliente;
	protected double monto;
	protected int plazoEnMeses;
	
	
	public double getMonto() {
		return monto;
	}
	
	public abstract boolean esAceptable();
	
	protected double montoCuota() {
		return monto / plazoEnMeses;
	}

	//getter para las pruebas
	public Cliente cliente() {
		return this.cliente;
	}
}