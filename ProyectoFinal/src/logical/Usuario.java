package logical;

import java.util.ArrayList;

public abstract class Usuario {
	protected String nombUsuario;
	protected String contrase�a;
	protected ArrayList<Solicitud> solicitudes;
	
	
	public Usuario(String nombUsuario, String contrase�a) {
		super();
		this.nombUsuario = nombUsuario;
		this.contrase�a = contrase�a;
		this.solicitudes = new ArrayList<Solicitud>();
	}
	
	
	public String getNombUsuario() {
		return nombUsuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}
}
