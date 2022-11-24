package logical;

import java.util.Date;

public class SolicitudTecnico extends SolicitudPersona {
	private String areaEspecialidad;
	private int añosExperiencia;
	
	
	public SolicitudTecnico(String codigoSolicitud, float sueldo, float sueldoMax, boolean puedeMudarse, boolean licenciaConducir,
			boolean tieneVehiculo, char condicionFisica, String tipoContrato, String cedula, String areaEspecialidad, int añosExperiencia, Date fechaCreacion) {
		super(codigoSolicitud, sueldo, sueldoMax, puedeMudarse, licenciaConducir, tieneVehiculo, condicionFisica, tipoContrato,
				cedula, fechaCreacion);
		this.areaEspecialidad = areaEspecialidad;
		this.añosExperiencia = añosExperiencia;
	}
	
	
	public String getAreaEspecialidad() {
		return areaEspecialidad;
	}
	public void setAreaEspecialidad(String areaEspecialidad) {
		this.areaEspecialidad = areaEspecialidad;
	}
	public int getAñosExperiencia() {
		return añosExperiencia;
	}
	public void setAñosExperiencia(int añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}
}
