package logical;

import java.util.ArrayList;
import java.util.Date;

public class Solicitud {
	private String codigo;
	private boolean estado;
	private Date fechaCreacion;
	private String tipoContrato;
	private float sueldo;
	private boolean puedeMudarse;
	private boolean licenciaConducir;
	private int horasLaborales;
	private char condicionFisica;
	private ArrayList<String> habilidadesBlandas;
	private ArrayList<String> riesgosLaborales;
	private Persona persona;
	
	
	public Solicitud(String codigo, String tipoContrato, float sueldo, boolean puedeMudarse, boolean licenciaConducir, int horasLaborales,
			char condicionFisica, Persona persona) {
		super();
		this.codigo = codigo;
		this.tipoContrato = tipoContrato;
		this.sueldo = sueldo;
		this.puedeMudarse = puedeMudarse;
		this.licenciaConducir = licenciaConducir;
		this.estado = true;
		this.horasLaborales = horasLaborales;
		this.condicionFisica = condicionFisica;
		this.persona = persona;
		this.fechaCreacion = new Date();
		this.habilidadesBlandas = new ArrayList<String>();
		this.riesgosLaborales = new ArrayList<String>();
	}
	
	
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public boolean isPuedeMudarse() {
		return puedeMudarse;
	}
	public void setPuedeMudarse(boolean puedeMudarse) {
		this.puedeMudarse = puedeMudarse;
	}
	public boolean isLicenciaConducir() {
		return licenciaConducir;
	}
	public void setLicenciaConducir(boolean licenciaConducir) {
		this.licenciaConducir = licenciaConducir;
	}
	public String getCodigo() {
		return codigo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public int getHorasLaborales() {
		return horasLaborales;
	}
	public void setHorasLaborales(int horasLaborales) {
		this.horasLaborales = horasLaborales;
	}
	public ArrayList<String> getHabilidadesBlandas() {
		return habilidadesBlandas;
	}
	public void setHabilidadesBlandas(ArrayList<String> habilidadesBlandas) {
		this.habilidadesBlandas = habilidadesBlandas;
	}
	public ArrayList<String> getRiesgosLaborales() {
		return riesgosLaborales;
	}
	public void setRiesgosLaborales(ArrayList<String> riesgosLaborales) {
		this.riesgosLaborales = riesgosLaborales;
	}
	public Persona getPersona() {
		return persona;
	}
	public char getCondicionFisica() {
		return condicionFisica;
	}
	public void setCondicionFisica(char condicionFisica) {
		this.condicionFisica = condicionFisica;
	}
	
	
}
