package logico;

import java.util.ArrayList;

public class Historial {

	
	private String numRecord; 
	private ArrayList<Consulta> misConsultas;
	private String historialEnfermedadActual;
	/**
	 * @param numRecord
	 * @param historialEnfermedadActual
	 */
	public Historial(String numRecord, String historialEnfermedadActual) {
		super();
		this.numRecord = numRecord;
		this.historialEnfermedadActual = historialEnfermedadActual;
		this.misConsultas = new ArrayList<Consulta>();
	}
	public String getNumRecord() {
		return numRecord;
	}
	public void setNumRecord(String numRecord) {
		this.numRecord = numRecord;
	}
	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}
	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}
	public String getHistorialEnfermedadActual() {
		return historialEnfermedadActual;
	}
	public void setHistorialEnfermedadActual(String historialEnfermedadActual) {
		this.historialEnfermedadActual = historialEnfermedadActual;
	}
	
	
	
	
	
	
	
}
