package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class BolsaLaboral implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static BolsaLaboral bolsalaboral = null;
	ArrayList<Persona> personas;
	ArrayList<CentroEmpleador> centroEmpleados;
	ArrayList<Solicitud> solicitudes;

	public BolsaLaboral() {
		super();
		personas = new ArrayList<Persona>();
		centroEmpleados = new ArrayList<CentroEmpleador>();
		solicitudes = new ArrayList<Solicitud>();
	}
	
	public static BolsaLaboral getInstance() {
		if (bolsalaboral==null) {
			bolsalaboral = new BolsaLaboral(); 	
		}
		return bolsalaboral;
	}
	
	public ArrayList<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
	public ArrayList<CentroEmpleador> getCentroEmpleados() {
		return centroEmpleados;
	}
	public void setCentroEmpleados(ArrayList<CentroEmpleador> centroEmpleados) {
		this.centroEmpleados = centroEmpleados;
	}
	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	public void regPersona(Persona persona){
		personas.add(persona);
		
	}
	
	public void regCentro(CentroEmpleador centro){
		centroEmpleados.add(centro);
		
	}
	
	public void regSolicitud(Solicitud solicitud){
		solicitudes.add(solicitud);
		
	}
	public Solicitud buscarSolicitudByCode(String codigo) {
		Solicitud solicitud = null;
		int ind = 0;
		
		while(ind < solicitudes.size() && solicitud == null) {
			if(solicitudes.get(ind).getCodigoSolicitud().equalsIgnoreCase(codigo)) {
				solicitud =  solicitudes.get(ind);
			}
			ind++;
		}
		
		return solicitud;
	}
	
	public Persona buscarPersonadByCedula(String cedula) {
		Persona persona = null;
		int ind = 0;
		
		while(ind < personas.size() && persona == null) {
			if(personas.get(ind).getCedula().equalsIgnoreCase(cedula)) {
				persona =  personas.get(ind);
			}
			ind++;
		}
		
		return persona;
	}

	public boolean eliminarPersona(Persona persona) {
		
		return personas.remove(persona);
		
	}
	
	public boolean eliminarCentro(CentroEmpleador centro) {
		
		return centroEmpleados.remove(centro);
		
	}
	
	public boolean eliminarSolicitud(Solicitud solicitud) {
		
		return solicitudes.remove(solicitud);
		
	}
	
	public CentroEmpleador buscarCentro(String codigo) {
		CentroEmpleador centro = null;
		int ind = 0;
		
		while(ind < centroEmpleados.size() && centro == null) {
			if(centroEmpleados.get(ind).getCodigo().equalsIgnoreCase(codigo)) {
				centro =  centroEmpleados.get(ind);
			}
			ind++;
		} 
		return centro;
	}
	
	public Solicitud buscarSolicitud(String codigo) {
		Solicitud solicitud = null;
		int ind = 0;
		
		while(ind < solicitudes.size() && solicitud == null) {
			if(centroEmpleados.get(ind).getCodigo().equalsIgnoreCase(codigo)) {
				solicitud =  solicitudes.get(ind);
			}
			ind++;
		} 
		return solicitud;
	}
	
	
}