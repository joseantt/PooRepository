package logical;

import java.util.ArrayList;

public abstract class Usuario {
	protected String nombUsuario;
	protected String contraseña;
	protected ArrayList<Solicitud> solicitudes;
	
	
	public Usuario(String nombUsuario, String contraseña) {
		super();
		this.nombUsuario = nombUsuario;
		this.contraseña = contraseña;
		this.solicitudes = new ArrayList<Solicitud>();
	}
	
	
	public String getNombUsuario() {
		return nombUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}
}
