package logical;

public class SolicitudTecnico extends SolicitudPersona {
	private String areaEspecialidad;
	private int a�osExperiencia;
	
	
	public SolicitudTecnico(String codigoSolicitud, float sueldo, boolean puedeMudarse, boolean licenciaConducir,
			boolean tieneVehiculo, char condicionFisica, String tipoContrato, String cedula, String areaEspecialidad, int a�osExperiencia) {
		super(codigoSolicitud, sueldo, puedeMudarse, licenciaConducir, tieneVehiculo, condicionFisica, tipoContrato,
				cedula);
		this.areaEspecialidad = areaEspecialidad;
		this.a�osExperiencia = a�osExperiencia;
	}
	
	
	public String getAreaEspecialidad() {
		return areaEspecialidad;
	}
	public void setAreaEspecialidad(String areaEspecialidad) {
		this.areaEspecialidad = areaEspecialidad;
	}
	public int getA�osExperiencia() {
		return a�osExperiencia;
	}
	public void setA�osExperiencia(int a�osExperiencia) {
		this.a�osExperiencia = a�osExperiencia;
	}
}
