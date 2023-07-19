package logico;

import java.util.ArrayList;

public class ClinicaSONS {

	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<Cita> misCitas;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Historial> misHistoriales;
	private ArrayList<Persona> misPersonas;
	private static ClinicaSONS clinica = null;
	/**
	 * @param misEnfermedades
	 * @param misCitas
	 * @param misConsultas
	 * @param misVacunas
	 * @param misHistoriales
	 * @param misPersonas
	 */
	private ClinicaSONS() {
		super();
		this.misEnfermedades = new ArrayList<Enfermedad>();
		this.misCitas = new ArrayList<Cita>();
		this.misConsultas = new ArrayList<Consulta>();
		this.misVacunas = new ArrayList<Vacuna>();
		this.misHistoriales = new ArrayList<Historial>();
		this.misPersonas = new ArrayList<Persona>();
	}
	
	public static ClinicaSONS getInstance() {
		if(clinica == null)
			clinica = new ClinicaSONS();
		return clinica;
	}
	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}
	public void setMisEnfermedades(ArrayList<Enfermedad> misEnfermedades) {
		this.misEnfermedades = misEnfermedades;
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
	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}
	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}
	public ArrayList<Historial> getMisHistoriales() {
		return misHistoriales;
	}
	public void setMisHistoriales(ArrayList<Historial> misHistoriales) {
		this.misHistoriales = misHistoriales;
	}
	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}
	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}
	
	public void insertarVacuna(Vacuna vacuna) {
		
		misVacunas.add(vacuna);
		
		
	}

	public void insertarEnfermedad(Enfermedad enfermedad) {
		misEnfermedades.add(enfermedad);
	}
	
	public void insertarDoctor(Doctor doctor) {
		misPersonas.add(doctor);
		
	}
	
	public void insertarPersona(Persona persona) {
		misPersonas.add(persona);
		
	}
	
	
	
	
}

	
	
	
	
	
	
	
	

