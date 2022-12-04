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
			if(solicitudes.get(ind).getCodigoSolicitud().equalsIgnoreCase(codigo)) {
				solicitud =  solicitudes.get(ind);
			}
			ind++;
		} 
		return solicitud;
	}
	
	public float matching(SolicitudEmpresa solicitudEmpresa, SolicitudPersona solicitudPersona) {
		float suma = 0;
		float sumaAux = 0;
		int cantRequisitos = solicitudEmpresa.getCantidadRequisitios();
		Persona persona = buscarPersonadByCedula(solicitudPersona.getCedula());
		
		if(!solicitudEmpresa.isPuedeMudarse())
			cantRequisitos--;
		
		if(!solicitudEmpresa.isLicenciaConducir())
			cantRequisitos--;
		
		if(!solicitudEmpresa.isTieneVehiculo())
			cantRequisitos--;
		
		if(solicitudEmpresa.getSueldo() >= solicitudPersona.getSueldo())
			suma++;
		
		if(solicitudEmpresa.isPuedeMudarse() && (solicitudEmpresa.isPuedeMudarse() && solicitudPersona.isPuedeMudarse())) {
			suma++;
		}
		if (solicitudEmpresa.isLicenciaConducir() &&(solicitudEmpresa.isLicenciaConducir() == solicitudPersona.isLicenciaConducir())) {
			suma++;
		}
		if(solicitudEmpresa.isTieneVehiculo() &&(solicitudEmpresa.isTieneVehiculo() == solicitudPersona.isTieneVehiculo())) {
			suma++;
		}
		if(solicitudEmpresa.getCondicionFisica() == solicitudPersona.getCondicionFisica()) {
			suma++;
		}
		if(solicitudEmpresa.getTipoContrato().equals(solicitudPersona.getTipoContrato())) {
			suma++;
		}else {
			return 0f;
		}
		if(solicitudEmpresa.getTipo().equalsIgnoreCase("Universitario") && solicitudPersona instanceof SolicitudUniversitario) {
			if(((SolicitudUniversitario)solicitudPersona).getCarrera().equals(solicitudEmpresa.getCarrera())) {
				suma += sumaRequisitosUniversitario(solicitudEmpresa, solicitudPersona);
			}
			else {
				return 0f;
			}
		}
		else if(solicitudEmpresa.getTipo().equalsIgnoreCase("Tecnico") && solicitudPersona instanceof SolicitudTecnico){
			if(((SolicitudTecnico)solicitudPersona).getAreaEspecialidad().equals(solicitudEmpresa.getAreaEspecialidad())) {
				suma += sumaRequisitosTecnico(solicitudEmpresa, solicitudPersona);
			}
			else {
				return 0f;
			}
		}
		else if(solicitudEmpresa.getTipo().equalsIgnoreCase("Obrero") && solicitudPersona instanceof SolicitudObrero) {
			sumaAux = sumaRequisitosStrList(solicitudEmpresa.getOficios(), ((SolicitudObrero)solicitudPersona).getOficios());
			if(sumaAux != 0) {
				suma += sumaAux;
			}else {
				return 0f;
			}
		}
		sumaAux = 0;
		sumaAux = sumaRequisitosStrList(solicitudEmpresa.getIdiomas(),persona.getIdiomas());
		if(sumaAux != 0) {
			suma += sumaAux;
		}else {
			return 0f;
		}
		
		
		
		return (suma / cantRequisitos) * 100;
	}
	
	public int sumaRequisitosUniversitario(SolicitudEmpresa solicitudEmpresa, SolicitudPersona solicitudPersona) {
		int suma = 0;
		if(solicitudPersona instanceof SolicitudUniversitario) {
			if(solicitudEmpresa.getCarrera().equals(((SolicitudUniversitario) solicitudPersona).getCarrera())) {
				suma++;
			}
			if(solicitudEmpresa.getAñoGraduacion() == ((SolicitudUniversitario) solicitudPersona).getAñoGraduacion()){
				suma++;
			}
		}
		return suma;
	}
	
	public int sumaRequisitosTecnico(SolicitudEmpresa solicitudEmpresa, SolicitudPersona solicitudPersona) {
		int suma = 0;
		if(solicitudPersona instanceof SolicitudTecnico) {
			if(solicitudEmpresa.getAreaEspecialidad().equals(((SolicitudTecnico)solicitudPersona).getAreaEspecialidad())) {
				suma++;
			}
			if(solicitudEmpresa.getAñosExperiencia() == ((SolicitudTecnico)solicitudPersona).getAñosExperiencia()) {
				suma++;
			}
		}
		return suma;
	}
	
	public int sumaRequisitosStrList(ArrayList<String> list, ArrayList<String> list2) {
		int suma = 0;
		
		for(String str : list2) {
			if(list.contains(str)) {
				suma++;
			}
		}
		
		return suma;
	}

	public User buscarUsuarioByNombre(String nombre) {
		User user = null;
		int ind = 0;
		
		while(ind < misUsers.size() && user == null) {
			if(misUsers.get(ind).getUserName().equalsIgnoreCase(nombre)) {
				user =  misUsers.get(ind);
			}
			ind++;
		} 
		return user;
	}
}