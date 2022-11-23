package logical;

import java.util.Date;

public class TestingMain {

	public static void main(String[] args) {
		BolsaLaboral bL = new BolsaLaboral();
		SolicitudUniversitario solicitud = new SolicitudUniversitario("123", 14, true, true, true, 'c', "QUe", "12345", "ing", 2004, new Date());
		bL.getSolicitudes().add(solicitud);
		System.out.println(((SolicitudUniversitario) bL.buscarSolicitudByCode("123")).getCarrera());
	}

}
