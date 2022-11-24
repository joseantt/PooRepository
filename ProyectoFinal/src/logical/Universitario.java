package logical;

import java.util.ArrayList;
import java.util.Date;

public class Universitario extends Persona{

		public Universitario(String cedula, String nombres, String apellidos, String direccion, String telefono,
			Date fechaNacimiento, char sexo, ArrayList<String> idiomas, String carrera, int a�oGraduacion) {
		super(cedula, nombres, apellidos, direccion, telefono, fechaNacimiento, sexo, idiomas);
		this.carrera = carrera;
		this.a�oGraduacion = a�oGraduacion;
	}
		private String carrera;
		private int a�oGraduacion;
		
		
		public String getCarrera() {
			return carrera;
		}
		public void setCarrera(String carrera) {
			this.carrera = carrera;
		}
		public int getA�oGraduacion() {
			return a�oGraduacion;
		}
		public void setA�oGraduacion(int a�oGraduacion) {
			this.a�oGraduacion = a�oGraduacion;
		}


}
