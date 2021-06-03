package un.poo2.casoResuelto;

import java.util.List;

import unq.poo2.caso1.Correo;

public interface IServidorPop {

	public List<Correo> recibirNuevos(String user, String pass);

	public void conectar(String nombreUsuario, String passusuario);

	public void enviar(Correo correo);
	
}
