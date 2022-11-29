package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class CentroEmpleador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;
	private String tipo;
	private ArrayList<Solicitud> solicitudes;
	private ArrayList<Persona> empleados;
	
	public CentroEmpleador(String codigo, String nombre, String direccion, String telefono, String tipo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipo = tipo;
		solicitudes = new ArrayList<Solicitud>();
		empleados = new ArrayList<Persona>();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	public ArrayList<Persona> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(ArrayList<Persona> empleados) {
		this.empleados = empleados;
	}
	
	
}