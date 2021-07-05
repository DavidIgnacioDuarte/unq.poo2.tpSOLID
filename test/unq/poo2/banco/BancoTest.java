package unq.poo2.banco;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTest {

	private Banco banco; 
	
	private PropiedadInmobiliaria estudio;
	private PropiedadInmobiliaria localDePablo;
	
	private Cliente matias;
	private Cliente pablo;
	private Cliente eliana;
	private Cliente maria;
	
	
	@BeforeEach
	public void setup() {
		
		banco = new Banco();
		
		matias = new Cliente("Matias", "Castañeira","Mitre y 10", 50, 1000);
		pablo = new Cliente("Pablo", "Louta","Las Teras 500", 23, 1500);
		eliana = new Cliente("Eliana", "Marques","Avenue Ley 100", 65, 4000);
		maria = new Cliente("Maria", "Lopez","Mosconi 912", 30, 7500); 
		
		estudio = new PropiedadInmobiliaria("Estudio de Canto", "Alberdi 1005", 120000);
		localDePablo = new PropiedadInmobiliaria("Comidas Rápidas McTías", "Astrazeneca V", 70000);
	}
	
	@Test
	void testSolicitudCreditoPersonal() {
		
		//Eliana y Maria aplican para la solicitud del credito
		banco.solicitarCredito(new SolicitudCreditoPersonal(eliana, 40000, 15));
		banco.solicitarCredito(new SolicitudCreditoPersonal(maria, 30000, 12));
		
		//No aplica por no tener ingresos mensuales > 15000
		banco.solicitarCredito(new SolicitudCreditoPersonal(matias, 500, 12));
		
		//No aplica porque cuota > 70% de sus ingresos
		banco.solicitarCredito(new SolicitudCreditoPersonal(pablo, 16000, 10));
		
		
		List<Cliente> clientesAprobados = banco.clientesAprobados(); 

		assertFalse(clientesAprobados.contains(matias));
		assertFalse(clientesAprobados.contains(pablo));
		assertTrue(clientesAprobados.contains(eliana));
		assertTrue(clientesAprobados.contains(maria));
	}
	
	
	@Test
	void testSolicitudCreditoHipotecario() {
		
		//No aplica por superar los 65 años al terminar de pagar el credito
		banco.solicitarCredito(new SolicitudCreditoHipotecario(eliana, 5000, 15, localDePablo));
		
		//No aplica porque cuota > ingresos * 0.5
		banco.solicitarCredito(new SolicitudCreditoHipotecario(maria, 16000, 2, estudio));
		
		//No aplica porque monto > 70% del valorFiscal
		banco.solicitarCredito(new SolicitudCreditoHipotecario(matias, 60000, 120, localDePablo));

		
		
		//Fabio aplica para la solicitud del credito
		banco.solicitarCredito(new SolicitudCreditoHipotecario(pablo, 18000, 24, localDePablo));
		
		List<Cliente> clientesAprobados = banco.clientesAprobados(); 

		assertFalse(clientesAprobados.contains(matias));
		assertFalse(clientesAprobados.contains(eliana));
		assertFalse(clientesAprobados.contains(maria));
		assertTrue(clientesAprobados.contains(pablo));
	}
	
	
	@Test
	void testMontoTotalCreditosAprobados() {
		
		banco.solicitarCredito(new SolicitudCreditoPersonal(eliana, 35000, 15));
		banco.solicitarCredito(new SolicitudCreditoPersonal(maria, 35000, 12));
		banco.solicitarCredito(new SolicitudCreditoHipotecario(pablo, 15000, 24, localDePablo));

		//No aplica porque cuota > 70% de sus ingresos
		banco.solicitarCredito(new SolicitudCreditoPersonal(pablo, 16000, 10));
		//No aplica porque cuota > ingresos * 0.5
		banco.solicitarCredito(new SolicitudCreditoHipotecario(maria, 16000, 2, estudio));
		
		double montoTotal = banco.montoTotalCreditosAprobados();
		
		assertEquals(85000d, montoTotal);
		
	}
	
	
}