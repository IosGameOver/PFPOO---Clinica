package logico;

import java.util.Date;

public class Cita {

	private String codigo;
	private String nombrePersona;
	private String telefonoPersona;
	private Doctor doctor;
	private Date fechaReservada;
	private String horario;
	
	
	
	
	public Cita(String codigo, String nombrePersona, String telefonoPersona, Doctor doctor, Date fechaReservada, 
			String horario) {
		super();
		this.codigo = codigo;
		this.nombrePersona = nombrePersona;
		this.telefonoPersona = telefonoPersona;
		this.doctor = doctor; 
		this.horario = horario;
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	
	
}
