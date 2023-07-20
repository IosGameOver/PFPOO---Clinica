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
	
	public Cita buscarCitaPorCodigo(String codigoCita) {
		
		Cita cita = null; 
		boolean encontrado = false;
		int i=0;
		while (!encontrado&&i<misCitas.size()) { 
			if (misCitas.get(i).getCodigo().equalsIgnoreCase(codigoCita)) {
				cita= misCitas.get(i); 
				encontrado = true;
			}
			i++;
		}
		return cita;
	}	
	
	public Vacuna buscarVacunaPorCodigo(String codigoVacuna) {
		
		Vacuna vacuna = null; 
		boolean encontrado = false;
		int i=0;
		while (!encontrado&&i<misVacunas.size()) { 
			if (misVacunas.get(i).getCodigo().equalsIgnoreCase(codigoVacuna)) {
				vacuna= misVacunas.get(i); 
				encontrado = true;
			}
			i++;
		}
		return vacuna;
	}	
	
	
	public Doctor buscarDoctorPorCodigo(String codigoDoctor) {
		
		Doctor doctor = null; 
		boolean encontrado = false;
		int i=0;
		while (!encontrado&&i<misPersonas.size()) { 
			if (misPersonas.get(i).getCod().equalsIgnoreCase(codigoDoctor)&&misPersonas.get(i)instanceof Doctor) {
				doctor = (Doctor) misPersonas.get(i);
				encontrado = true;
			}
			i++;
		}
		return doctor;
	}	
	
	public Paciente buscarPacientePorCodigo(String codigoPaciente) {
		
		Paciente paciente = null; 
		boolean encontrado = false;
		int i=0;
		while (!encontrado&&i<misPersonas.size()) { 
			if (misPersonas.get(i).getCod().equalsIgnoreCase(codigoPaciente)&&misPersonas.get(i)instanceof Paciente) {
				paciente = (Paciente) misPersonas.get(i);
				encontrado = true;
			}
			i++;
		}
		return paciente;
	}	
	
	public Enfermedad buscarEnfermedadPorCodigo(String codigoEnfermedad) {
		
		Enfermedad enfermedad = null;
		boolean  encontrado = false;
		int i=0;
		
		while (!encontrado&&i<misEnfermedades.size()) {
			if (misEnfermedades.get(i).getCodigo().equalsIgnoreCase(codigoEnfermedad)) {
				enfermedad=misEnfermedades.get(i);
				encontrado=true;
			}
			i++;
		}
		return enfermedad;
	}
			
	
	
	public int cantidadDePacientesPorVacuna(String vacuna) {
		
		int cant = 0;
		Persona paciente = null;
		
		for (Persona aux : misPersonas) {
			if (aux instanceof Paciente) {
				if (((Paciente) aux).getMisVacunas().equals(vacuna)) {
					cant++;
				}
			}
		
		}
		return cant;
		
	}
	
	
	
	
	
	
	
	
	
	
}

	
	
	
	
	
	
	
	

