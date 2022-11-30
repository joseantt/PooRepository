package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class BolsaLaboral implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static BolsaLaboral bolsalaboral = null;
	private ArrayList<Persona> personas;
	private ArrayList<User> misUsers;
	private ArrayList<CentroEmpleador> centroEmpleados;
	private ArrayList<Solicitud> solicitudes;
	private User loginUser;

	public BolsaLaboral() {
		super();
		personas = new ArrayList<Persona>();
		centroEmpleados = new ArrayList<CentroEmpleador>();
		solicitudes = new ArrayList<Solicitud>();
		misUsers = new ArrayList<>();

	}
	
	public static BolsaLaboral getInstance() {
		if (bolsalaboral==null) {
			bolsalaboral = new BolsaLaboral(); 	
		}
		return bolsalaboral;
	}
	
	public static void setBolsaLaboral(BolsaLaboral bolsa) {
		BolsaLaboral.bolsalaboral = bolsa;
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
	
	public ArrayList<User> getMisUsers() {
		return misUsers;
	}

	public void setMisUsers(ArrayList<User> misUsers) {
		this.misUsers = misUsers;
	}
	
	public User getLoginUser() {
		return loginUser;
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
	
	public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		for (User user : misUsers) {
			if(user.getUserName().equals(text) && user.getPass().equals(text2)){
				loginUser = user;
				login = true;
			}
		}
		return login;
	}
	
	public void regUser(User user) {
		misUsers.add(user);
		
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