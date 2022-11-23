package logical;

public class SolicitudUniversitario extends SolicitudPersona {
	private String carrera;
	private int aņoGraduacion;
	
	
	public SolicitudUniversitario(String codigoSolicitud, float sueldo, boolean puedeMudarse, boolean licenciaConducir,
			boolean tieneVehiculo, char condicionFisica, String tipoContrato, String cedula, String carrera, int aņoGraduacion) {
		super(codigoSolicitud, sueldo, puedeMudarse, licenciaConducir, tieneVehiculo, condicionFisica, tipoContrato,
				cedula);
		this.carrera = carrera;
		this.aņoGraduacion = aņoGraduacion;
	}


	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getAņoGraduacion() {
		return aņoGraduacion;
	}
	public void setAņoGraduacion(int aņoGraduacion) {
		this.aņoGraduacion = aņoGraduacion;
	}
}
