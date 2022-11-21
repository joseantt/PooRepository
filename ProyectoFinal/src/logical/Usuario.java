package logical;

public abstract class Usuario {
	protected String nombUsuario;
	protected String contraseña;
	
	
	public Usuario(String nombUsuario, String contraseña) {
		super();
		this.nombUsuario = nombUsuario;
		this.contraseña = contraseña;
	}
	
	
	public String getNombUsuario() {
		return nombUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	
}
