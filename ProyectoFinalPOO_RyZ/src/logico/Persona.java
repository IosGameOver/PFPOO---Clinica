package logico;

import java.util.Date;

public class Persona {
	
	protected String cod;
	protected String cedula;
	protected String nombre;
	protected String sexo;
	protected String estadoCivil;
	protected String telefono;
	protected Date fechaNacimiento;
	protected String direccion;
	protected String tipoSangre;
	/**
	 * @param cedula
	 * @param nombre
	 * @param apellido
	 * @param sexo
	 * @param estadoCivil
	 * @param telefono
	 * @param fechaNacimiento
	 * @param direccion
	 * @param tipoSangre
	 */
	public Persona(String cod, String cedula, String nombre,  String sexo, String estadoCivil, String telefono,
			Date fechaNacimiento, String direccion, String tipoSangre) {
		super();
		this.cod = cod;
		this.cedula = cedula;
		this.nombre = nombre;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.tipoSangre = tipoSangre;
	}
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTipoSangre() {
		return tipoSangre;
	}
	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
