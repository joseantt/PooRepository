import java.util.Date;

public class Universitario extends Persona{

		public Universitario(String cedula, String nombres, String apellidos, String direccion, String telefono,
			Date fechaNacimiento, char sexo, char nivelEducativo, String carrera, int aņoGraduacion) {
		super(cedula, nombres, apellidos, direccion, telefono, fechaNacimiento, sexo, nivelEducativo);
		this.carrera = carrera;
		this.aņoGraduacion = aņoGraduacion;
	}
		private String carrera;
		private int aņoGraduacion;
		
		
		public String getCarrera() {
			return carrera;
		}
		public void setCarrera(String carrera) {
			this.carrera = carrera;
		}
		public int getAņoGraduacion() {
			return aņoGraduacion;
		}
		public void setAņoGraduacion(int aņoGraduacion) {
			this.aņoGraduacion = aņoGraduacion;
		}


}
