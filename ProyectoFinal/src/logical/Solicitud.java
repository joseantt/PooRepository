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
	private String carreraUni;
	private int añoGraduacionUni;
	private String areaTecnico;
	private int añoExpTecnico;
	private ArrayList<String> oficiosObrero;
	
	
	public Solicitud(String codigo, String tipoContrato, float sueldo, boolean puedeMudarse, boolean licenciaConducir,
			String carreraUni, int añoGraduacionUni, String areaTecnico, int añoExpTecnico,
			ArrayList<String> oficiosObrero) {
		super();
		this.codigo = codigo;
		this.tipoContrato = tipoContrato;
		this.sueldo = sueldo;
		this.puedeMudarse = puedeMudarse;
		this.licenciaConducir = licenciaConducir;
		this.carreraUni = carreraUni;
		this.añoGraduacionUni = añoGraduacionUni;
		this.areaTecnico = areaTecnico;
		this.añoExpTecnico = añoExpTecnico;
		this.oficiosObrero = oficiosObrero;
		this.estado = true;
		this.fechaCreacion = new Date();
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
	public String getCarreraUni() {
		return carreraUni;
	}
	public void setCarreraUni(String carreraUni) {
		this.carreraUni = carreraUni;
	}
	public int getAñoGraduacionUni() {
		return añoGraduacionUni;
	}
	public void setAñoGraduacionUni(int añoGraduacionUni) {
		this.añoGraduacionUni = añoGraduacionUni;
	}
	public String getAreaTecnico() {
		return areaTecnico;
	}
	public void setAreaTecnico(String areaTecnico) {
		this.areaTecnico = areaTecnico;
	}
	public int getAñoExpTecnico() {
		return añoExpTecnico;
	}
	public void setAñoExpTecnico(int añoExpTecnico) {
		this.añoExpTecnico = añoExpTecnico;
	}
	public ArrayList<String> getOficiosObrero() {
		return oficiosObrero;
	}
	public void setOficiosObrero(ArrayList<String> oficiosObrero) {
		this.oficiosObrero = oficiosObrero;
	}
	public String getCodigo() {
		return codigo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	
}
