package logical;

import java.util.ArrayList;

public class SolicitudEmpresa extends Solicitud {
	private String codigoEmpresa;
	private String cantMatcheo;
	private int empleadosNecesarios;
	private ArrayList<String> oficios;
	private String areaEspecialidad;
	private int añosExperiencia;
	private String carrera;
	private int añoGraduacion;
	
	
	public SolicitudEmpresa(String codigoSolicitud, float sueldo, boolean puedeMudarse, boolean licenciaConducir,
			boolean tieneVehiculo, char condicionFisica, String tipoContrato, String codigoEmpresa, String cantMatcheo, int empleadosNecesarios,
			ArrayList<String> oficios, String areaEspecialidad, int añosExperiencia, String carrera, int añoGraduacion) {
		super(codigoSolicitud, sueldo, puedeMudarse, licenciaConducir, tieneVehiculo, condicionFisica, tipoContrato);
		this.codigoEmpresa = codigoEmpresa;
		this.cantMatcheo = cantMatcheo;
		this.empleadosNecesarios = empleadosNecesarios;
		this.oficios = oficios;
		this.areaEspecialidad = areaEspecialidad;
		this.añosExperiencia = añosExperiencia;
		this.carrera = carrera;
		this.añoGraduacion = añoGraduacion;
	}


	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}
	public String getCantMatcheo() {
		return cantMatcheo;
	}
	public int getEmpleadosNecesarios() {
		return empleadosNecesarios;
	}
	public ArrayList<String> getOficios() {
		return oficios;
	}
	public String getAreaEspecialidad() {
		return areaEspecialidad;
	}
	public int getAñosExperiencia() {
		return añosExperiencia;
	}
	public String getCarrera() {
		return carrera;
	}
	public int getAñoGraduacion() {
		return añoGraduacion;
	}
	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
	public void setCantMatcheo(String cantMatcheo) {
		this.cantMatcheo = cantMatcheo;
	}
	public void setEmpleadosNecesarios(int empleadosNecesarios) {
		this.empleadosNecesarios = empleadosNecesarios;
	}
	public void setOficios(ArrayList<String> oficios) {
		this.oficios = oficios;
	}
	public void setAreaEspecialidad(String areaEspecialidad) {
		this.areaEspecialidad = areaEspecialidad;
	}
	public void setAñosExperiencia(int añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public void setAñoGraduacion(int añoGraduacion) {
		this.añoGraduacion = añoGraduacion;
	}
}
