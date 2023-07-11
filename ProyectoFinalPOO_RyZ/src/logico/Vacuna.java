package logico;

import java.util.Date;

public class Vacuna {

	
	private String loteCodigo;
	private String nombre;
	private String laboratorio;
	private String dosis;
	private String descripcion;
	private Date fecha;
	private String firma;
	/**
	 * @param loteCodigo
	 * @param nombre
	 * @param laboratorio
	 * @param dosis
	 * @param descripcion
	 * @param fecha
	 * @param firma
	 */
	public Vacuna(String loteCodigo, String nombre, String laboratorio, String dosis, String descripcion, 
			String firma) {
		super();
		this.loteCodigo = loteCodigo;
		this.nombre = nombre;
		this.laboratorio = laboratorio;
		this.dosis = dosis;
		this.descripcion = descripcion;
		this.fecha = new Date();
		this.firma = firma;
	}
	public String getLoteCodigo() {
		return loteCodigo;
	}
	public void setLoteCodigo(String loteCodigo) {
		this.loteCodigo = loteCodigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getDosis() {
		return dosis;
	}
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getFirma() {
		return firma;
	}
	public void setFirma(String firma) {
		this.firma = firma;
	}
	
	
	
	
	
	
	
	
	
}
