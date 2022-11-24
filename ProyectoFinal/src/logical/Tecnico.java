package logical;

import java.util.ArrayList;
import java.util.Date;

public class Tecnico extends Persona {
	private String areaEspecialidad;
	private int añosExperiencia; 
	
	
	public Tecnico(String cedula, String nombres, String apellidos, String direccion, String telefono,
			Date fechaNacimiento, char sexo, ArrayList<String> idiomas, String areaEspecialidad, int añosExperiencia) {
		super(cedula, nombres, apellidos, direccion, telefono, fechaNacimiento, sexo, idiomas);
		this.areaEspecialidad = areaEspecialidad;
		this.añosExperiencia = añosExperiencia;
	}
	
	
	public String getAreaEspecialidad() {
		return areaEspecialidad;
	}
	public void setAreaEspecialidad(String areaEspecialidad) {
		this.areaEspecialidad = areaEspecialidad;
	}
	public int getAñosExperiencia() {
		return añosExperiencia;
	}
	public void setAñosExperiencia(int añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}
	
	
	
}
