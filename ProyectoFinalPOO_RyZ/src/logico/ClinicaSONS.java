package logico;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	private static Administrador loginUserAdmin;
	private static Secretario loginUserSecre;
	private static Doctor loginUserDoc;


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
		this.misUsuarios = new ArrayList<Usuario>();
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

	public static Secretario getLoginUserSecre() {
		return loginUserSecre;
	}

	public static void setLoginUserSecre(Secretario loginUserSecre) {
		ClinicaSONS.loginUserSecre = loginUserSecre;
	}

	public static Administrador getLoginUserAdmin() {
		return loginUserAdmin;
	}

	public static void setLoginUserAdmin(Administrador loginUserAdmin) {
		ClinicaSONS.loginUserAdmin = loginUserAdmin;
	}

	public static Doctor getLoginUserDoc() {
		return loginUserDoc;
	}

	public static void setLoginUserDoc(Doctor loginUserDoc) {
		ClinicaSONS.loginUserDoc = loginUserDoc;
	}

	public static ClinicaSONS getClinica() {
		return clinica;
	}

	public static void setClinica(ClinicaSONS clinica) {
		ClinicaSONS.clinica = clinica;
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
	public void insertarUsuario(Usuario usuario) {
		misUsuarios.add(usuario);
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

	public Doctor buscarDoctorPorUsuario(String usuarioDoctor) {
		Doctor doc = null;
		int i = 0;
		boolean encontrado = false;
		while (i < misPersonas.size() && !encontrado) {
			if(((Doctor)misPersonas.get(i)).getUsuario().equalsIgnoreCase(usuarioDoctor)) {
				doc = (Doctor)misPersonas.get(i);
				encontrado = true;
			}
		}
		return doc;
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

	//Confirmación de Login
	public boolean confirmLoginAdmin(String username, String pass) {
		int i = 0;
		boolean login = false;
		while(i < misUsuarios.size() && !login) {
			if (misUsuarios.get(i).getUserName().equals(username) && misUsuarios.get(i).getPass().equals(pass)&&misUsuarios.get(i) instanceof Administrador) {
				loginUserAdmin = (Administrador)misUsuarios.get(i);
				login = true;
			}
			i++;
		}
		return login;
	} 

	//Confirmación de Login
	public boolean confirmLoginSecre(String username, String pass) {
		int i = 0;
		boolean login = false;
		while(i < misUsuarios.size() && !login) {
			if (misUsuarios.get(i).getUserName().equals(username) && misUsuarios.get(i).getPass().equals(pass)&&misUsuarios.get(i) instanceof Secretario) {
				loginUserSecre = (Secretario)misUsuarios.get(i);
				login = true;
			}
			i++;
		}
		return login;
	} 


	public boolean confirmLoginDoc(String username, String pass) {
		int i = 0;
		boolean login = false;

		while(i < misPersonas.size() && !login) {
			if(misPersonas.get(i) instanceof Doctor) {
				if (((Doctor)misPersonas.get(i)).getUsuario().equals(username) && ((Doctor)misPersonas.get(i)).getContrasena().equals(pass)) {
					loginUserDoc = (Doctor)misPersonas.get(i);
					login = true;
				}
			}
			i++;
		}
		return login;
	} 

	//Busqueda de usuarios por user.
	public Usuario buscarUsuarioPorUser(String usuario) {
		Usuario user = null;
		int i = 0;
		boolean encontrado = false;
		while (i < misUsuarios.size() && !encontrado) {
			if(misUsuarios.get(i).getUserName().equalsIgnoreCase(usuario)) {
				user = misUsuarios.get(i);
				encontrado = true;
			}
			i++;
		}
		return user;
	}	

	public Cita buscarCitaPorCodigo(String codigoCita) {
		Cita cita = null; 
		boolean encontrado = false;
		int i = 0;
		while (i<misCitas.size() && !encontrado) { 
			if (misCitas.get(i).getCodigo().equalsIgnoreCase(codigoCita)) {
				cita = misCitas.get(i); 
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

	public Doctor buscarDoctorPorNombre(String nomDoctor) {
		Doctor doctor = null; 
		boolean encontrado = false;
		int i=0;
		while (!encontrado&&i<misPersonas.size()) { 
			if (misPersonas.get(i)instanceof Doctor && misPersonas.get(i).getNombre().equalsIgnoreCase(nomDoctor)) {
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
	
	
	public int cantidadDePacientesConEnfermedad(String miEnfermedad) {
		int cant = 0;
		int i= 0;
		int cantidadAntigua = 0;
		Paciente paciente = null;

		for (Persona aux : misPersonas) {
			if (aux instanceof Paciente) {
				while (i<((Paciente)aux).getMisConsultas().size()) {
					if (((Paciente)aux).getMisConsultas().get(i).getEnfermedad().getNombre().equalsIgnoreCase(miEnfermedad)&&pacienteNoRepetido(((Paciente)aux))) {
						cant++;
					
					}
						
					i++;
					
				}
			}

		}
		
		return cant;
	}

	
	public boolean pacienteNoRepetido(Paciente aux) {
		Paciente paciente = null;
		boolean noRepetido = true;
		while (noRepetido) {
				if(paciente!=aux) {
					paciente = aux;
					}else {
						noRepetido = false;
					} 
			
		} 		
			
	return noRepetido;
	}

	public int cantidadDeDoctoresPorEspecialidad(String especialidad) {
		
		int cant = 0;
		Doctor Doctor = null;

		for (Persona aux : misPersonas) {
			if (aux instanceof Doctor) {
				if (((Doctor) aux).getEspecialidad().equalsIgnoreCase(especialidad)) {
					
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
		int i = 0;
		while(i < misPersonas.size() && !encontrado) {

			if (misPersonas.get(i)instanceof Doctor && misPersonas.get(i).getCod().equalsIgnoreCase(codigo)) {
				encontrado =true;
				aux = i;
			}
			i++;
		}
		return aux;
	}

	public void modificarDoctor(Doctor miDoctor) {
		int index = buscarIndexDoctorPorCodigo(miDoctor.getCod());
		misPersonas.set(index, miDoctor);
	}

	public void eliminarDoctor(Doctor selected) {
		misPersonas.remove(selected);
	}
	public int buscarIndexCitaPorCodigo(String codigo) {
		int aux = -1;
		boolean encontrado = false;
		int i =0;
		while(i < misCitas.size() && !encontrado) {
			if (misCitas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				encontrado = true;
				aux = i;
			}
			i++;
		}
		return aux;
	}

	public void modificarCita(Cita miCita) {
		int index = buscarIndexCitaPorCodigo(miCita.getCodigo());
		misCitas.set(index, miCita);
	}	

	public void eliminarCita(Cita cita) {
		misCitas.remove(cita);
	}

	public Administrador buscarAdministradorPorUsuario(String usuario, String password) {
		int i = 0;
		boolean encontrado = false;
		Administrador admin = null;

		while(i < misUsuarios.size() && !encontrado) {
			if(misUsuarios.get(i) instanceof Administrador && misUsuarios.get(i).getUserName().equalsIgnoreCase(usuario) 
					&& misUsuarios.get(i).getPass().equalsIgnoreCase(password)) {
				admin = (Administrador)misUsuarios.get(i);
				encontrado = true;
			}
			i++;
		}
		return admin;
	}

	public Paciente buscarPacienteByConsulta(String codCons) {
		Paciente pac = null;
		boolean encontrado = false;
		int i = 0;
		int j = 0;
		while (i < misPersonas.size() && !encontrado) {
			if (misPersonas.get(i) instanceof Paciente) {
				while(j < ((Paciente)misPersonas.get(i)).getMisConsultas().size() && !encontrado) {
					if(((Paciente)misPersonas.get(i)).getMisConsultas().get(j).getCod().equalsIgnoreCase(codCons)) {
						pac = (Paciente)misPersonas.get(i);
						encontrado = true;
					}
					j++;
				}
			}
			i++;
		}
		return pac;
	}
	public Doctor buscarDoctorByConsulta(String codCons) {
		Doctor doc = null;
		boolean encontrado = false;
		int i = 0;
		int j = 0;
		while (i < misPersonas.size() && !encontrado) {
			if (misPersonas.get(i) instanceof Doctor) {
				while(j < ((Doctor)misPersonas.get(i)).getMisConsultas().size() && !encontrado) {
					if(((Doctor)misPersonas.get(i)).getMisConsultas().get(j).getCod().equalsIgnoreCase(codCons)) {
						doc = (Doctor)misPersonas.get(i);
						encontrado = true;
					}
					j++;
				}
			}
			i++;
		}
		return doc;
	}

	//Calcular edad
	public int calcularEdad(Date fechaDeNacimiento, Date fecha) {
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");                           
		int d1 = Integer.parseInt(formatter.format(fechaDeNacimiento));                            
		int d2 = Integer.parseInt(formatter.format(fecha));                          
		int edad = (d2 - d1) / 10000;                                                       
		return edad;                                                                        
	}

	public Consulta buscarConsultaByCod(String cod) {
		Consulta cons = null;
		boolean encontrado = false;
		for (Consulta aux : misConsultas) {
			if (aux.getCod().equalsIgnoreCase(cod)) {
				cons = aux;
				encontrado = true;
			}
		}
		return cons;
	}

	//Usuario Mod y Elim
	public int buscarIndexUsuarioPorUsername(String username) {
		int aux = -1;
		boolean encontrado = false;
		int i =0;
		while(i<misUsuarios.size() && !encontrado) {

			if (misUsuarios.get(i).getUserName().equalsIgnoreCase(username)) {
				encontrado =true;
				aux = i;						
			}
			i++;
		}
		return aux;
	}

	public void modificarUsuario(Usuario miUsuario) {

		int index = buscarIndexUsuarioPorUsername(miUsuario.getUserName());
		misUsuarios.set(index, miUsuario);
	}

	public void eliminarUsuario(Usuario selected) {
		misUsuarios.remove(selected);
	}

	public int buscarIndexPacienteByCode(String codPac) {
		int aux = -1;
		boolean encontrado = false;
		int i = 0;
		while(i < misPersonas.size() && !encontrado) {
			if (misPersonas.get(i).getCod().equalsIgnoreCase(codPac)) {
				encontrado =true;
				aux = i;						
			}
			i++;
		}
		return aux;
	}

	public void modificarPaciente(Paciente miPac) {
		int index = buscarIndexPacienteByCode(miPac.getCod());
		misPersonas.set(index, miPac);
	}
	public void eliminarPaciente(Paciente miPac) {
		misPersonas.remove(miPac);
	}





}