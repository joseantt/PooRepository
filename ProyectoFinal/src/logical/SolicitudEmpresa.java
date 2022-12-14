package logical;

import java.util.ArrayList;
import java.util.Date;

public class SolicitudEmpresa extends Solicitud {
	private String codigoEmpresa;
	private int cantMatcheo;
	private int empleadosNecesarios;
	private ArrayList<String> oficios;
	private ArrayList<String> idiomas;
	private String areaEspecialidad;
	private int añosExperiencia;
	private String carrera;
	private int añoGraduacion;
	private String tipo;
	
	
	public SolicitudEmpresa(String codigoSolicitud, float sueldo, boolean puedeMudarse, boolean licenciaConducir,
			boolean tieneVehiculo, char condicionFisica, String tipoContrato, String codigoEmpresa, int cantMatcheo, int empleadosNecesarios,
			ArrayList<String> oficios, String areaEspecialidad, int añosExperiencia, String carrera, int añoGraduacion, Date fechaCreacion, ArrayList<String> idioma, String tipo) {
		super(codigoSolicitud, sueldo, puedeMudarse, licenciaConducir, tieneVehiculo, condicionFisica, tipoContrato, fechaCreacion);
		this.codigoEmpresa = codigoEmpresa;
		this.cantMatcheo = cantMatcheo;
		this.empleadosNecesarios = empleadosNecesarios;
		this.oficios = oficios;
		this.areaEspecialidad = areaEspecialidad;
		this.añosExperiencia = añosExperiencia;
		this.carrera = carrera;
		this.añoGraduacion = añoGraduacion;
		this.idiomas = idioma;
		this.setTipo(tipo);
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
	public void setAñosExperiencia(int añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public void setAñoGraduacion(int añoGraduacion) {
		this.añoGraduacion = añoGraduacion;
	}


	public ArrayList<String> getIdiomas() {
		return idiomas;
	}


	public void setIdiomas(String idioma) {
		this.idiomas.add(idioma);
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getCantidadRequisitios() {
		int cant = 6;
		if(tipo.equalsIgnoreCase("Universitario") || tipo.equalsIgnoreCase("Tecnico")) {
			cant = 8;
		}
		return cant + idiomas.size() + oficios.size();
	}

}
