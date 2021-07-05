package unq.poo2.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	List<SolicitudCredito> solicitudes = new ArrayList<SolicitudCredito>();
	List<Cliente> clientes = new ArrayList<Cliente>();

	
	public void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void solicitarCredito(SolicitudCredito solicitud) {
		this.solicitudes.add(solicitud);
	}

	public double montoTotalCreditosAprobados(){
		double monto = 0d;
		for (SolicitudCredito solicitud : this.solicitudes) {
			if (solicitud.esAceptable())
				monto += solicitud.getMonto();
		}
		return monto;
	}

	//para los tests
	public List<Cliente> clientesAprobados(){
		
		List<Cliente> clientesAprobados = new ArrayList<Cliente>();
		
		for (SolicitudCredito solicitud : this.solicitudes) {
			if (solicitud.esAceptable()) {
				clientesAprobados.add(solicitud.cliente());
			}
		}
		
		return clientesAprobados;
		
	}
}