package logical;

import java.util.Date;

public abstract class Solicitud {
	protected String codigoSolicitud;
	protected Date fechaCreacion;
	protected float sueldo;
	protected boolean estado;
	protected boolean puedeMudarse;
	protected boolean licenciaConducir;
	protected boolean tieneVehiculo;
	protected char condicionFisica;
	protected String tipoContrato;
	
	
	public Solicitud(String codigoSolicitud, float sueldo, boolean puedeMudarse, boolean licenciaConducir,
			boolean tieneVehiculo, char condicionFisica, String tipoContrato) {
		super();
		this.codigoSolicitud = codigoSolicitud;
		this.sueldo = sueldo;
		this.puedeMudarse = puedeMudarse;
		this.licenciaConducir = licenciaConducir;
		this.tieneVehiculo = tieneVehiculo;
		this.condicionFisica = condicionFisica;
		this.tipoContrato = tipoContrato;
	}
	
	
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public boolean isPuedeMudarse() {
		return puedeMudarse;
	}
	public void setPuedeMudarse(boolean puedeMudarse) {
		this.puedeMudarse = puedeMudarse;
	}
	public boolean isLicenciaConducir() {
		return licenciaConducir;
	}
	public void setLicenciaConducir(boolean licenciaConducir) {
		this.licenciaConducir = licenciaConducir;
	}
	public boolean isTieneVehiculo() {
		return tieneVehiculo;
	}
	public void setTieneVehiculo(boolean tieneVehiculo) {
		this.tieneVehiculo = tieneVehiculo;
	}
	public char getCondicionFisica() {
		return condicionFisica;
	}
	public void setCondicionFisica(char condicionFisica) {
		this.condicionFisica = condicionFisica;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	
}
