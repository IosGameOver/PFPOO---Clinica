package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ClinicaSONS implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<Cita> misCitas;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Historial> misHistoriales;
	private ArrayList<Persona> misPersonas;
	private ArrayList<Usuario> misUsuarios;
	private static ClinicaSONS clinica = null;
	public static int codCita = 1;
	public static int codConsulta = 1;
	public static int codDoctor = 1;
	public static int codEnf = 1;
	public static int codVac = 1;
	public static int codPac = 1;
	public static int codHist = 1;
	private static Usuario loginUser;
	
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

	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}

	public void setMisUsuarios(ArrayList<Usuario> misUsuarios) {
		this.misUsuarios = misUsuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public static Usuario getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(Usuario loginUser) {
		ClinicaSONS.loginUser = loginUser;
	}

	public void insertarVacuna(Vacuna vacuna) {
		misVacunas.add(vacuna);
		codVac++;
	}

	public void insertarEnfermedad(Enfermedad enfermedad) {
		misEnfermedades.add(enfermedad);
		codEnf++;
	}

	public Doctor insertarDoctor(Doctor doctor) {
		misPersonas.add(doctor);
		codDoctor++;
		return doctor;
		
	}
	
	
	
	public void insertarPersona(Persona persona) {
		misPersonas.add(persona);
		if(persona instanceof Paciente) {
			codPac++;
		}else if(persona instanceof Doctor){
			codDoctor++;
		}
	}
	public void insertarHistorial(Historial historial) {
		misHistoriales.add(historial);
		codHist++;
	}
	public void insertarCita(Cita cita) {
		
		misCitas.add(cita);
		
		codCita++;
	}
	public void insertarConsulta(Consulta consulta) {
		misConsultas.add(consulta);
		codConsulta++;
	}
	
	

	public ArrayList<String>  listaDoctores() {
		ArrayList<String> doctors = new ArrayList<String>() ;
		
		for(Persona doc : misPersonas) {
			if (doc instanceof Doctor) {
				doctors.add(doc.getNombre());
			}
		}
		return doctors;
	}

	public Doctor buscarDoctorPorUsuarioExistente(String usuarioDoctor, String claveDoctor) {

		Doctor doctor = null; 
		boolean encontrado = false;
		
		for (Persona persona : misPersonas) {
			if (persona instanceof Doctor && ((Doctor) persona).getUsuario().equalsIgnoreCase(usuarioDoctor)&& ((Doctor) persona).getUsuario().equalsIgnoreCase(claveDoctor)) {
				doctor =(Doctor) persona;
				encontrado = true;
				
			}
		}
		return doctor;
	}
	public boolean existeDoctorPorUsuario(String usuarioDoctor, String claveDoctor) {

		Doctor doctor = null; 
		boolean encontrado = false;
		
		for (Persona persona : misPersonas) {
			if (persona instanceof Doctor && ((Doctor) persona).getUsuario().equalsIgnoreCase(usuarioDoctor)&& ((Doctor) persona).getUsuario().equalsIgnoreCase(claveDoctor)) {
				doctor =(Doctor) persona;
				encontrado = true;
				
			}
		}
		return encontrado;
	}
	/*
	  public Doctor buscarDoctorPorContrasennaExistente(String claveDoctor) {
	 

		Doctor doctor = null; 
		boolean encontrado = false;
		
		for (Persona persona : misPersonas) {
			if (persona instanceof Doctor && ((Doctor) persona).getUsuario().equalsIgnoreCase(claveDoctor)) {
				doctor =(Doctor) persona;
				encontrado = true;
				
			}
		}
		return doctor;
	}
	*/

	public boolean confirmLogin(String username, String pass) {
		boolean login = false;
		for (Usuario usuario : misUsuarios) {
			if (usuario.getUserName().equals(username)&&usuario.getPass().equals(pass)) {
				loginUser= usuario;
				login = true;
			}
		}
		
		return login;
	} 
	
	public boolean confirmLoginDoc(String username, String pass) {
		boolean login = false;
		for (Persona usuario : misPersonas) {
			if (((Doctor)usuario).getUsuario().equals(username)&&((Doctor)usuario).getContrasena().equals(pass)) {
				login = true;
			}
		}
		
		return login;
	} 
	
	
	public boolean confirmLoginSecretario(String username, String pass) {
		boolean login = false;
		for (Usuario usuario : misUsuarios) {
			if ((usuario.getUserName().equals(username)&&usuario.getPass().equals(pass))&&usuario instanceof Secretario) {
				loginUser= usuario;
				login = true;
			}
		}
		
		return login;
	} 
	

	public Usuario buscarUsuarioPorUser(String usuariotxt, String clave) {

		Usuario user = null;
		boolean login = false;
		for (Usuario usuario : misUsuarios) {
			if ((usuario.getUserName().equals(usuariotxt)&&usuario.getPass().equals(clave))&&usuario instanceof Secretario) {
				loginUser= usuario;
				user = usuario;
			}
		}
		
		return user;
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
	
	public Vacuna buscarVacunaPorNombre(String nomVacuna) {

		Vacuna vacuna = null; 
		boolean encontrado = false;
		int i=0;
		while (!encontrado&&i<misVacunas.size()) { 
			if (misVacunas.get(i).getNombre().equalsIgnoreCase(nomVacuna)) {
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

	public Historial buscarHistorialByCod(String numRecord) {
		Historial hist = null;
		boolean  encontrado = false;
		int i = 0;

		while (!encontrado && i < misHistoriales.size()) {
			if (misHistoriales.get(i).getNumRecord().equalsIgnoreCase(numRecord)) {
				hist = misHistoriales.get(i);
				encontrado = true;
			}
			i++;
		}
		return hist;
	}

	public Paciente buscarPacienteByCedula(String cedPac) {
		Paciente pac = null;
		boolean encontrado = false;
		for (Persona aux : misPersonas) {
			if(aux instanceof Paciente) {
				if (aux.getCedula().equalsIgnoreCase(cedPac)) {
					pac = (Paciente)aux;
					encontrado = true;
				}
			}
		}
		return pac;
	}
	public Enfermedad buscarEnfermedadByNombre(String nombre) {
		Enfermedad enfermedad = null;
		boolean encontrado = false;
		for (Enfermedad aux : misEnfermedades) {
			if (aux.getNombre().equalsIgnoreCase(nombre)) {
				enfermedad = aux;
				encontrado = true;
			}
		}
		return enfermedad;
	}

	//Vacuna Mod y Elim
	
	public int buscarIndexVacunaPorCodigo(String codigo) {
		int aux = -1;
		boolean encontrado = false;
		int i =0;
		while(i<misVacunas.size() && !encontrado) {
			
			if (misVacunas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				encontrado =true;
				aux = i;						
			}
			i++;
		}
		
		return aux;
	}
	
	public void modificarVacuna(Vacuna miVacuna) {

		int index = buscarIndexVacunaPorCodigo(miVacuna.getCodigo());
		misVacunas.set(index, miVacuna);

		
	}
	
	public void eliminarVacuna(Vacuna selected) {
		misVacunas.remove(selected);
	
	}
	
	//Enfermedad Mod y Elim
	
		
	public int buscarIndexEnfermedadPorCodigo(String codigo) {
		int aux = -1;
		boolean encontrado = false;
		int i =0;
		while(i<misEnfermedades.size() && !encontrado) {
			
			if (misEnfermedades.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				encontrado =true;
				aux = i;						
			}
			i++;
		}
		
		return aux;
	}
	
	public void modificarEnfermedad(Enfermedad miEnfermedad) {

		int index = buscarIndexVacunaPorCodigo(miEnfermedad.getCodigo());
		misEnfermedades.set(index, miEnfermedad);

		
	}
	
	public void eliminarEnfermedad(Enfermedad enfermedad) {
		misEnfermedades.remove(enfermedad);
	
	}
	
	//Doctor Mod y Elim
	
	
		public int buscarIndexDoctorPorCodigo(String codigo) {
			int aux = -1;
			boolean encontrado = false;
			int i =0;
			while(i<misPersonas.size() && !encontrado) {
				
				if (misPersonas.get(i)instanceof Doctor&&misPersonas.get(i).getCod().equalsIgnoreCase(codigo)) {
					encontrado =true;
					aux = i;
									
				}
				i++;
			}
			
			return aux;
		}
		
		public void modificarDoctor(Doctor miDoctor) {

			int index = buscarIndexVacunaPorCodigo(miDoctor.getCod());
			misPersonas.set(index, miDoctor);

			
		}
		
		public void eliminarDoctor(Doctor selected) {
			misPersonas.remove(selected);
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
}










