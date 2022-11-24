package logical;

import java.util.Date;

public abstract class SolicitudPersona extends Solicitud {
	protected String cedula;
	
	
	public SolicitudPersona(String codigoSolicitud, float sueldo, float sueldoMax, boolean puedeMudarse, boolean licenciaConducir,
			boolean tieneVehiculo, char condicionFisica, String tipoContrato, String cedula, Date fechaCreacion) {
		super(codigoSolicitud, sueldo, sueldoMax, puedeMudarse, licenciaConducir, tieneVehiculo, condicionFisica, tipoContrato, fechaCreacion);
		this.cedula = cedula;
	}


	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
