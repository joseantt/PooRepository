package logical;

import java.util.Date;

public class SolicitudUniversitario extends SolicitudPersona {
	private String carrera;
	private int a�oGraduacion;
	
	
	public SolicitudUniversitario(String codigoSolicitud, float sueldo, boolean puedeMudarse, boolean licenciaConducir,
			boolean tieneVehiculo, char condicionFisica, String tipoContrato, String cedula, String carrera, int a�oGraduacion, Date fechaCreacion) {
		super(codigoSolicitud, sueldo, puedeMudarse, licenciaConducir, tieneVehiculo, condicionFisica, tipoContrato,
				cedula, fechaCreacion);
		this.carrera = carrera;
		this.a�oGraduacion = a�oGraduacion;
	}


	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getA�oGraduacion() {
		return a�oGraduacion;
	}
	public void setA�oGraduacion(int a�oGraduacion) {
		this.a�oGraduacion = a�oGraduacion;
	}
}
