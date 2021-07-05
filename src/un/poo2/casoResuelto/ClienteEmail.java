package un.poo2.casoResuelto;

import java.util.ArrayList;

public class ClienteEmail implements IClienteEmailComunicacion, IClienteEmailManejoCorreos {

	 private IServidorPop servidor;
	 private String nombreUsuario;
	 private String passusuario;
	 private ArrayList<Correo> inbox;
	 private ArrayList<Correo> borrados;
	
	public ClienteEmail(IServidorPop servidor, String nombreUsuario, String pass){
		this.servidor=servidor;
		this.nombreUsuario=nombreUsuario;
		this.passusuario=pass;
		this.inbox = new ArrayList<Correo>();
		this.borrados = new ArrayList<Correo>();
		this.conectar(nombreUsuario, pass);
	}
	
	public IServidorPop getServidor() {
		return this.servidor;
	}
	
	public void conectar(String userName, String password) {
		this.servidor.conectar(this.nombreUsuario,this.passusuario);
	}
	
	public void borrarCorreo(Correo correo){
		this.inbox.remove(correo);
		this.borrados.remove(correo);
	}
	
	public int contarBorrados(){
		return this.borrados.size();
	}
	
	public int contarInbox(){
		return this.inbox.size();
	}
	
	public void eliminarBorrado(Correo correo){
		this.borrados.remove(correo);
	}
	
	public void recibirNuevos(){
		this.servidor.recibirNuevos(this.nombreUsuario, this.passusuario);
	}
	
	public void enviarCorreo(String asunto, String destinatario, String cuerpo){
		Correo correo = new Correo(asunto, destinatario, cuerpo);
		this.servidor.enviar(correo);
	}
	
}
