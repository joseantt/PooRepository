package logical;

import java.util.Date;

public class Tecnico extends Persona {
	private String areaEspecialidad;
	private int a�osExperiencia; 
	
	
	public Tecnico(String cedula, String nombres, String apellidos, String direccion, String telefono,
			Date fechaNacimiento, char sexo, char nivelEducativo, String areaEspecialidad, int a�osExperiencia) {
		super(cedula, nombres, apellidos, direccion, telefono, fechaNacimiento, sexo, nivelEducativo);
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
