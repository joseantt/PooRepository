package logical;

import java.util.Date;

public class SolicitudUniversitario extends SolicitudPersona {
	private String carrera;
	private int añoGraduacion;
	
	
	public SolicitudUniversitario(String codigoSolicitud, float sueldo, boolean puedeMudarse, boolean licenciaConducir,
			boolean tieneVehiculo, char condicionFisica, String tipoContrato, String cedula, String carrera, int añoGraduacion, Date fechaCreacion) {
		super(codigoSolicitud, sueldo, puedeMudarse, licenciaConducir, tieneVehiculo, condicionFisica, tipoContrato,
				cedula, fechaCreacion);
		this.carrera = carrera;
		this.añoGraduacion = añoGraduacion;
	}


	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getAñoGraduacion() {
		return añoGraduacion;
	}
	public void setAñoGraduacion(int añoGraduacion) {
		this.añoGraduacion = añoGraduacion;
	}
}
