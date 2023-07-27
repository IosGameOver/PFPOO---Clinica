package logico;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends Persona {

	private String exeQuartur;
	private String almaMater;
	private String especialidad;
	private String usuario;
	private String contrasena;
	protected  int nvlAutoridad;
	private String correo;
	private ArrayList<Paciente> misPacientes;
	private ArrayList<Cita> misCitas;
	private ArrayList<Consulta> misConsultas;

	public Doctor(String cod, String cedula, String nombre,  String sexo, String estadoCivil, String telefono,
			Date fechaNacimiento, String direccion, String tipoSangre, String exeQuartur, String almaMater,
			String especialidad, String usuario, String contrasena, String correo) {
		super(cod, cedula, nombre,  sexo, estadoCivil, telefono, fechaNacimiento, direccion, tipoSangre);
		this.exeQuartur = exeQuartur;
		this.almaMater = almaMater;
		this.especialidad = especialidad;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.correo = correo;
		this.misCitas = new ArrayList<Cita>();
		this.misConsultas = new ArrayList<Consulta>();
		this.misPacientes = new ArrayList<Paciente>();
		this.nvlAutoridad = 5;
	}
	public void agregarCita(Cita cita) {
		misCitas.add(cita);
	}
	public void agregarConsulta(Consulta consulta) {
		misConsultas.add(consulta);
	}
	public void agregarPaciente(Paciente paciente) {
		misPacientes.add(paciente);
	}
	public String getExeQuartur() {
		return exeQuartur;
	}
	public void setExeQuartur(String exeQuartur) {
		this.exeQuartur = exeQuartur;
	}
	public String getAlmaMater() {
		return almaMater;
	}
	public void setAlmaMater(String almaMater) {
		this.almaMater = almaMater;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getNvlAutoridad() {
		return nvlAutoridad;
	}
	public ArrayList<Paciente> getMisPacientes() {
		return misPacientes;
	}
	public void setMisPacientes(ArrayList<Paciente> misPacientes) {
		this.misPacientes = misPacientes;
	}
	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}
	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}
	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}
	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}
}
