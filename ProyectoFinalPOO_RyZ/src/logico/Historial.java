package logico;

import java.util.ArrayList;

public class Historial {

	
	private String numRecord; 
	private ArrayList<Consulta> misDatosImportantes;
	
		
	public Historial(String numRecord) {
		super();
		this.numRecord =numRecord;
		this.misDatosImportantes = new ArrayList<Consulta>();
	}
	public String getNumRecord() {
		return numRecord;
	}
	public void setNumRecord(String numRecord) {
		this.numRecord = numRecord;
	}
	public ArrayList<Consulta> getmisDatosImportantes() {
		return misDatosImportantes;
	}
	public void setmisDatosImportantes(ArrayList<Consulta> misDatosImportantes) {
		this.misDatosImportantes = misDatosImportantes;
	}
	
	
	
	
	
	
	
	
}
