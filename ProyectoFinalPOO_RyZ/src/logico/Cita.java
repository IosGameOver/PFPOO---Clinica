package logico;

import java.util.Date;

public class Cita {

	private String codigo;
	private String nombrePersona;
	private String apellidoPersona;
	private String telefonoPersona;
	private Doctor doctor;
	private Date fechaReservada;
	

	//Creo que aquí no es necesario pasar el doctor por constructor
	
	
	public Cita(String codigo, String nombrePersona, String apellidoPersona, String telefonoPersona, /* Doctor doctor, */ 
			Date fechaReservada) {
		super();
		this.codigo = codigo;
		this.nombrePersona = nombrePersona;
		this.apellidoPersona = apellidoPersona;
		this.telefonoPersona = telefonoPersona;
		this.doctor = doctor; //Sería new Doctor();
		this.fechaReservada = fechaReservada;
	}
	
	
	
	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getApellidoPersona() {
		return apellidoPersona;
	}
	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}
	public String getTelefonoPersona() {
		return telefonoPersona;
	}
	public void setTelefonoPersona(String telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Date getFechaReservada() {
		return fechaReservada;
	}
	public void setFechaReservada(Date fechaReservada) {
		this.fechaReservada = fechaReservada;
	}
	
	
	
	
}
