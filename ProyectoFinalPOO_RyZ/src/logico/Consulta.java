package logico;

import java.util.ArrayList;
import java.util.Date;

public class Consulta {

	
	private String motivo;
	private float ta;
	private float fr;
	private float temp;
	private float peso;
	private String diagnostcio;
	private ArrayList<Enfermedad> misEnfermedades;
	/**
	 * @param motivo
	 * @param ta
	 * @param fr
	 * @param temp
	 * @param peso
	 * @param diagnostcio
	 * @param listaEnfermedades
	 */
	public Consulta(String motivo, float ta, float fr, float temp, float peso, String diagnostcio) {
		super();
		this.motivo = motivo;
		this.ta = ta;
		this.fr = fr;
		this.temp = temp;
		this.peso = peso;
		this.diagnostcio = diagnostcio;
		this.misEnfermedades = new ArrayList<Enfermedad>();
	}
	
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public float getTa() {
		return ta;
	}
	public void setTa(float ta) {
		this.ta = ta;
	}
	public float getFr() {
		return fr;
	}
	public void setFr(float fr) {
		this.fr = fr;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getDiagnostcio() {
		return diagnostcio;
	}
	public void setDiagnostcio(String diagnostcio) {
		this.diagnostcio = diagnostcio;
	}

	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}

	public void setMisEnfermedades(ArrayList<Enfermedad> misEnfermedades) {
		this.misEnfermedades = misEnfermedades;
	}
	
	
	
	
	
	
	
}
