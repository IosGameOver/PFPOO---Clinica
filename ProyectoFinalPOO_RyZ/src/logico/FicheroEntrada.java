package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class FicheroEntrada {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
	try {
		File archivoMisPersonas = new File("MisPersonas.bin");
	   	FileInputStream inputFile = new FileInputStream (archivoMisPersonas);
       	ObjectInputStream ois = new ObjectInputStream(inputFile);
      	int size = ois.readInt();
		for (int i = 0; i < size; i++){		
			Persona	person = (Persona)ois.readObject();
			ClinicaSONS.getInstance().insertarPersona(person);
			System.out.println("Leyendo lista");
			System.out.println("Nombre: " + person.getNombre());
		
		}
		
		inputFile.close();

	} catch (IOException e) {
	    e.getStackTrace();
	}
		
	//Entrada Usuarios
	try {
		File archivoMisUsuarios = new File("MisUsuarios.dat");
	   	FileInputStream inputFileUser = new FileInputStream (archivoMisUsuarios);
       	ObjectInputStream oiser = new ObjectInputStream(inputFileUser);
       	int size = oiser.readInt();
		for (int i = 0; i < size; i++){		
			Usuario	usuario = (Usuario)oiser.readObject();
			ClinicaSONS.getInstance().insertarUsuario(usuario);
			System.out.println("Leyendo lista");
			
		
		}
		
		inputFileUser.close();

	} catch (IOException e) {
	    e.getStackTrace();
	}
	
	
	//Entrada Vacunas
	try {
		File archivoMisVacunas  = new File("MisVacunas.dat");
	   	FileInputStream inputFileVac = new FileInputStream (archivoMisVacunas);
       	ObjectInputStream oisVac= new ObjectInputStream(inputFileVac);
       	int size = oisVac.readInt();
		for (int i = 0; i < size; i++){		
			Vacuna vacuna = (Vacuna)oisVac.readObject();
			ClinicaSONS.getInstance().insertarVacuna(vacuna);
			System.out.println("Leyendo lista");
				
		}
		
		inputFileVac.close();

	} catch (IOException e) {
	    e.getStackTrace();
	}
	
	
	//Entrada Enfermedades
		try {
			File archivoMisEnfer = new File("MisEnfermedades.dat");
            
		   	FileInputStream inputFileEnfer = new FileInputStream (archivoMisEnfer);
	       	ObjectInputStream oosEnfer= new ObjectInputStream(inputFileEnfer);
	       	int size = oosEnfer.readInt();
			for (int i = 0; i < size; i++){		
				Vacuna vacuna = (Vacuna)oosEnfer.readObject();
				ClinicaSONS.getInstance().insertarVacuna(vacuna);
				System.out.println("Leyendo lista");
					
			}
			
			inputFileEnfer.close();

		} catch (IOException e) {
		    e.getStackTrace();
		}
	
	
		//Entrada Citas
				try {
					File archivoMisCitas = new File("MisCitas.dat");
		            
				   	FileInputStream inputFileCit = new FileInputStream (archivoMisCitas);
			       	ObjectInputStream oosCit= new ObjectInputStream(inputFileCit);
			       	int size = oosCit.readInt();
					for (int i = 0; i < size; i++){		
						Cita cita = (Cita)oosCit.readObject();
						ClinicaSONS.getInstance().insertarCita(cita);
						System.out.println("Leyendo lista");
							
					}
					
					inputFileCit.close();

				} catch (IOException e) {
				    e.getStackTrace();
				}
			
	//Entrada Consultas
		try {
		File archivoMisConsult = new File("MisConsultas.dat");
		            
	   	FileInputStream inputFileConsult = new FileInputStream (archivoMisConsult);
	   	ObjectInputStream oosConsu= new ObjectInputStream(inputFileConsult);
    	int size = oosConsu.readInt();
		for (int i = 0; i < size; i++){		
		Consulta consulta = (Consulta)oosConsu.readObject();
		ClinicaSONS.getInstance().insertarConsulta(consulta);
		System.out.println("Leyendo lista");
							
				}
					
		inputFileConsult.close();

		} catch (IOException e) {
		    e.getStackTrace();
			}
			
		//Entrada Historial
		try {
		File archivoMisHist = new File("MisHistorias.dat");
		            
	   	FileInputStream inputFileHist = new FileInputStream (archivoMisHist);
	   	ObjectInputStream oosHist= new ObjectInputStream(inputFileHist);
    	int size = oosHist.readInt();
		for (int i = 0; i < size; i++){		
		Historial historial = (Historial)oosHist.readObject();
		ClinicaSONS.getInstance().insertarHistorial(historial);
		System.out.println("Leyendo lista");
							
				}
					
		inputFileHist.close();

		} catch (IOException e) {
		    e.getStackTrace();
			}		
        
	}

	
	
}
