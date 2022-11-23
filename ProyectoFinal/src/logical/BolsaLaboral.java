package logical;

import java.util.ArrayList;

public class BolsaLaboral {
	
	ArrayList<Persona> personas;
	ArrayList<CentroEmpleador> centroEmpleados;
	ArrayList<Solicitud> solicitudes;

	public BolsaLaboral() {
		super();
		personas = new ArrayList<Persona>();
		centroEmpleados = new ArrayList<CentroEmpleador>();
		solicitudes = new ArrayList<Solicitud>();
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
}