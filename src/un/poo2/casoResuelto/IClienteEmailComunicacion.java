package un.poo2.casoResuelto;

public interface IClienteEmailComunicacion {

	public IServidorPop getServidor();
	
	public void conectar(String userName, String password);
	
	public void recibirNuevos();
	
	public void enviarCorreo(String asunto, String destinatario, String cuerpo);
	
}
