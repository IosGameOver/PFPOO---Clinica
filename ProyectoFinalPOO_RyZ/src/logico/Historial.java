package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Historial implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String numRecord; 
	private ArrayList<Consulta> misDatosImportantes;
	
	public Historial(String numRecord) {
		super();
		this.numRecord = numRecord;
		this.misDatosImportantes = new ArrayList<Consulta>();
	}
	
	public void insertarConsulta(Consulta consulta) {
		this.misDatosImportantes.add(consulta);
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setmisDatosImportantes(ArrayList<Consulta> misDatosImportantes) {
		this.misDatosImportantes = misDatosImportantes;
	}	
}
