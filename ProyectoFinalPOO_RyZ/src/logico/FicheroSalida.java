package logico;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;



public class FicheroSalida {


	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
	//Escritura misPersonas
	
	File archivoMisPersonas = new File("MisPersonas.bin");
	FileOutputStream outputFile = new FileOutputStream (archivoMisPersonas);
		
	ObjectOutputStream oos 	= new ObjectOutputStream (outputFile);

	     
  
        oos.writeInt(ClinicaSONS.getInstance().getMisPersonas().size());
        	for (Persona persona : ClinicaSONS.getInstance().getMisPersonas()) {
				oos.writeObject(persona);
				}
        	System.out.println("Escribiendo archivo");
        	oos.close();
        	System.out.println("Archivo escrito, exitosamente");
       	
     //Escritura misUsuarios
        	
        	File archivoMisUsuarios = new File("MisUsuarios.dat");
        	FileOutputStream outputFileUser = new FileOutputStream (archivoMisUsuarios);
        		
        	ObjectOutputStream ooser 	= new ObjectOutputStream (outputFileUser);
        	              
                ooser.writeInt(ClinicaSONS.getInstance().getMisUsuarios().size());
                	for (Usuario usuario : ClinicaSONS.getInstance().getMisUsuarios()) {
        				ooser.writeObject(usuario);
        				}
                	
                	ooser.close();
                	
              //Escritura misVacunas
                	
          	File archivoMisVacunas = new File("MisVacunas.dat");
          	FileOutputStream outputFileVac = new FileOutputStream (archivoMisVacunas);
               		
          	ObjectOutputStream oosVac 	= new ObjectOutputStream (outputFileVac);
               	              
          	oosVac.writeInt(ClinicaSONS.getInstance().getMisVacunas().size());
                 	for (Vacuna vacuna : ClinicaSONS.getInstance().getMisVacunas()) {
               		oosVac.writeObject(vacuna);
               		}
                        	
                  	oosVac.close();	
	
               //Escritura misEnfermedades
                	
               	File archivoMisEnfer = new File("MisEnfermedades.dat");
               	FileOutputStream outputFileEnfer = new FileOutputStream (archivoMisEnfer);
                       		
             	ObjectOutputStream oosEnfer	= new ObjectOutputStream (outputFileEnfer);
                       	              
                oosEnfer.writeInt(ClinicaSONS.getInstance().getMisEnfermedades().size());
                   	for (Enfermedad enfermedad : ClinicaSONS.getInstance().getMisEnfermedades()) {
                         oosEnfer.writeObject(enfermedad);
                       		}
                                	
                       oosEnfer.close();	
	
        //Escritura misEnfermedades
                   	
       	File archivoMisCitas = new File("MisCitas.dat");
        FileOutputStream outputFileCit = new FileOutputStream (archivoMisEnfer);
                             		
        ObjectOutputStream oosCit	= new ObjectOutputStream (outputFileCit);
                              	              
        oosCit.writeInt(ClinicaSONS.getInstance().getMisCitas().size());
             for (Cita cita : ClinicaSONS.getInstance().getMisCitas()) {
                 oosCit.writeObject(cita);
                   	}
                                       	
             oosCit.close();	
	
             //Escritura misConsultas
            	
            File archivoMisConsult = new File("MisConsultas.dat");
            FileOutputStream outputFileConsult = new FileOutputStream (archivoMisConsult);
                                  		
            ObjectOutputStream oosConsu = new ObjectOutputStream (outputFileConsult);
                                   	              
            oosConsu.writeInt(ClinicaSONS.getInstance().getMisConsultas().size());
                  for (Consulta consulta : ClinicaSONS.getInstance().getMisConsultas()) {
                      oosCit.writeObject(consulta);
                        	}
                                            	
            oosConsu.close();	
     		
          //Escritura misHistoriales
        	
            File archivoMisHist = new File("MisCitas.dat");
            FileOutputStream outputFileHist = new FileOutputStream (archivoMisHist);
                                  		
            ObjectOutputStream oosHist = new ObjectOutputStream (outputFileHist);
                                   	              
            oosHist.writeInt(ClinicaSONS.getInstance().getMisHistoriales().size());
                  for (Historial historial : ClinicaSONS.getInstance().getMisHistoriales()) {
                	  oosHist.writeObject(historial);
                        	}
                                            	
                  oosHist.close();	
     			

            
            
            
            
	
	}
	
	
	
	
}
