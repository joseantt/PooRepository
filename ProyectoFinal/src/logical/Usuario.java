package logical;

public abstract class Usuario {
	protected String nombUsuario;
	protected String contrase�a;
	
	
	public Usuario(String nombUsuario, String contrase�a) {
		super();
		this.nombUsuario = nombUsuario;
		this.contrase�a = contrase�a;
	}
	
	
	public String getNombUsuario() {
		return nombUsuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	
}
