package logical;

import java.util.ArrayList;
import java.util.Date;

public class SolicitudEmpresa extends Solicitud {
	private String codigoEmpresa;
	private int cantMatcheo;
	private int empleadosNecesarios;
	private ArrayList<String> oficios;
	private String areaEspecialidad;
	private int a�osExperiencia;
	private String carrera;
	private int a�oGraduacion;
	
	
	public SolicitudEmpresa(String codigoSolicitud, float sueldo, float sueldoMax, boolean puedeMudarse, boolean licenciaConducir,
			boolean tieneVehiculo, char condicionFisica, String tipoContrato, String codigoEmpresa, int cantMatcheo, int empleadosNecesarios,
			ArrayList<String> oficios, String areaEspecialidad, int a�osExperiencia, String carrera, int a�oGraduacion, Date fechaCreacion) {
		super(codigoSolicitud, sueldo, sueldoMax, puedeMudarse, licenciaConducir, tieneVehiculo, condicionFisica, tipoContrato, fechaCreacion);
		this.codigoEmpresa = codigoEmpresa;
		this.cantMatcheo = cantMatcheo;
		this.empleadosNecesarios = empleadosNecesarios;
		this.oficios = oficios;
		this.areaEspecialidad = areaEspecialidad;
		this.a�osExperiencia = a�osExperiencia;
		this.carrera = carrera;
		this.a�oGraduacion = a�oGraduacion;
	}


	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}
	public int getCantMatcheo() {
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
	public int getA�osExperiencia() {
		return a�osExperiencia;
	}
	public String getCarrera() {
		return carrera;
	}
	public int getA�oGraduacion() {
		return a�oGraduacion;
	}
	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
	public void setCantMatcheo(int cantMatcheo) {
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
	public void setA�osExperiencia(int a�osExperiencia) {
		this.a�osExperiencia = a�osExperiencia;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public void setA�oGraduacion(int a�oGraduacion) {
		this.a�oGraduacion = a�oGraduacion;
	}
}
