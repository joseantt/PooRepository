package logical;

import java.util.ArrayList;
import java.util.Date;

public class Obrero extends Persona {
	private ArrayList<String> oficios;
	
	
	public Obrero(String cedula, String nombres, String apellidos, String direccion, String telefono,
			Date fechaNacimiento, char sexo, ArrayList<String> idiomas, ArrayList<String> oficios) {
		super(cedula, nombres, apellidos, direccion, telefono, fechaNacimiento, sexo, idiomas);
		this.oficios = oficios;
	}

	
	public ArrayList<String> getOficios() {
		return oficios;
	}

}
