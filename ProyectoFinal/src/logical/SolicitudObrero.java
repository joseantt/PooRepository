package logical;

import java.util.ArrayList;

public class SolicitudObrero extends SolicitudPersona {
	private ArrayList<String> oficios;
	
	
	public SolicitudObrero(String codigoSolicitud, float sueldo, boolean puedeMudarse, boolean licenciaConducir,
			boolean tieneVehiculo, char condicionFisica, String tipoContrato, String cedula, ArrayList<String> oficios) {
		super(codigoSolicitud, sueldo, puedeMudarse, licenciaConducir, tieneVehiculo, condicionFisica, tipoContrato,
				cedula);
		this.oficios = oficios;
	}

	
	public ArrayList<String> getOficios() {
		return oficios;
	}
	public void setOficios(ArrayList<String> oficios) {
		this.oficios = oficios;
	}
}
