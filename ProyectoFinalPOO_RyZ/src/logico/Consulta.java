package logico;

import java.util.ArrayList;
import java.util.Date;

public class Consulta {

	
	private Paciente paciente;
	private String sintomas;
	private String diagnostico;
	private String indicacionesAnalisis;
	private String indicacionesReceta;
	private Date fecha; 
	private ArrayList<Enfermedad> misEnfermades;

	//Creo que el paciente va en el constructor porque se crea para la consulta, o ¿ya existe?
	
	public Consulta(Paciente paciente, String sintomas, String diagnostico, String indicacionesAnalisis,
			String indicacionesReceta) {
		super();
		this.paciente = paciente;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.indicacionesAnalisis = indicacionesAnalisis;
		this.indicacionesReceta = indicacionesReceta;
		this.fecha = new Date();
		this.misEnfermades= new ArrayList<Enfermedad>();
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getIndicacionesAnalisis() {
		return indicacionesAnalisis;
	}
	public void setIndicacionesAnalisis(String indicacionesAnalisis) {
		this.indicacionesAnalisis = indicacionesAnalisis;
	}
	public String getIndicacionesReceta() {
		return indicacionesReceta;
	}
	public void setIndicacionesReceta(String indicacionesReceta) {
		this.indicacionesReceta = indicacionesReceta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public ArrayList<Enfermedad> getMisEnfermades() {
		return misEnfermades;
	}
	public void setMisEnfermades(ArrayList<Enfermedad> misEnfermades) {
		this.misEnfermades = misEnfermades;
	} 
	
	
	
	
	
	
	
	
	
	
}
