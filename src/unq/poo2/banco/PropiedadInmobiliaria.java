package unq.poo2.banco;

public class PropiedadInmobiliaria {
	
	private String descripcion; 
	private String direccion; 
	private double valorFiscal;
	
	public PropiedadInmobiliaria(String descripcion, String direccion, double valorFiscal) {
		this.descripcion = descripcion; 
		this.direccion = direccion; 
		this.valorFiscal = valorFiscal;
	}
	
	
	public String descripcion() { 
		return this.descripcion; 
	}
	
	public String direccion() { 
		return this.direccion; 
	}
	
	public double valorFiscal() { 
		return this.valorFiscal; 
	}
}