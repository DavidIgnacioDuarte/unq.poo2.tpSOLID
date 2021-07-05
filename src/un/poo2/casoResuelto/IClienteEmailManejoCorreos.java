package un.poo2.casoResuelto;

public interface IClienteEmailManejoCorreos {

	public void borrarCorreo(Correo correo);
	
	public int contarBorrados();
	
	public int contarInbox();
	
	public void eliminarBorrado(Correo correo);
	
}
