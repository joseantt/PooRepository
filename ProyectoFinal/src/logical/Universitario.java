package logical;

import java.util.ArrayList;
import java.util.Date;

public class Universitario extends Persona{

		public Universitario(String cedula, String nombres, String apellidos, String direccion, String telefono,
			Date fechaNacimiento, char sexo, ArrayList<String> idiomas, String carrera, int añoGraduacion) {
		super(cedula, nombres, apellidos, direccion, telefono, fechaNacimiento, sexo, idiomas);
		this.carrera = carrera;
		this.añoGraduacion = añoGraduacion;
	}
		private String carrera;
		private int añoGraduacion;
		
		
		public String getCarrera() {
			return carrera;
		}
		public void setCarrera(String carrera) {
			this.carrera = carrera;
		}
		public int getAñoGraduacion() {
			return añoGraduacion;
		}
		public void setAñoGraduacion(int añoGraduacion) {
			this.añoGraduacion = añoGraduacion;
		}


}
