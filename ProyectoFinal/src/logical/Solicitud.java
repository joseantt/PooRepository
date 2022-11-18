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
	
	
	public Solicitud(String codigo, String tipoContrato, float sueldo, boolean puedeMudarse, boolean licenciaConducir) {
		super();
		this.codigo = codigo;
		this.tipoContrato = tipoContrato;
		this.sueldo = sueldo;
		this.puedeMudarse = puedeMudarse;
		this.licenciaConducir = licenciaConducir;
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
	public String getCodigo() {
		return codigo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	
}
