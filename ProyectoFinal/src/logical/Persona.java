package logical;

import java.util.ArrayList;
import java.util.Date;


public abstract class Persona {
	protected String cedula;
	protected String nombres;
	protected String apellidos;
	protected String direccion;
	protected String telefono;
	protected Date fechaNacimiento;
	protected char sexo;
	protected boolean estado;
	protected ArrayList<String> idiomas;
	protected ArrayList<Solicitud> solicitudes;
	
	
	public Persona(String cedula, String nombres, String apellidos, String direccion, String telefono,
			Date fechaNacimiento, char sexo, ArrayList<String> idiomas) {
		super();
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.estado = false;
		this.idiomas = idiomas;
		solicitudes = new ArrayList<Solicitud>();
	}
	
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public ArrayList<String> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}
	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	public String getCedula() {
		return cedula;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public char getSexo() {
		return sexo;
	}
	

	
}