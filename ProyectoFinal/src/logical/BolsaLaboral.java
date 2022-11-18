package logical;

import java.util.ArrayList;

public class BolsaLaboral {
	
	ArrayList<Persona> personas;
	ArrayList<CentroEmpleador> centroEmpleados;
	ArrayList<Solicitud> solicitudes;

	public BolsaLaboral(ArrayList<Persona> personas, ArrayList<CentroEmpleador> centroEmpleados,
			ArrayList<Solicitud> solicitudes) {
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
}