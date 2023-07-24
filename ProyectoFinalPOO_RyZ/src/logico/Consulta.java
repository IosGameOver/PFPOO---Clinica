package logico;

import java.util.ArrayList;
import java.util.Date;

public class Consulta {

	private String cod;
	private String motivo;
	private float ta;
	private float fr;
	private float temp;
	private float peso;
	private String diagnostico;
	private String indicaciones;
	private ArrayList<String> analisis;
	private Enfermedad enfermedad;
	/**
	 * @param motivo
	 * @param ta
	 * @param fr
	 * @param temp
	 * @param peso
	 * @param diagnostcio
	 * @param listaEnfermedades
	 */
	public Consulta(String cod, String motivo, float ta, float fr, float temp, float peso, String diagnostico,String indicaciones) {
		super();
		this.cod = cod;
		this.motivo = motivo;
		this.ta = ta;
		this.fr = fr;
		this.temp = temp;
		this.peso = peso;
		this.diagnostico = diagnostico;
		this.indicaciones = indicaciones;
		this.analisis = new ArrayList<>();
		this.enfermedad = null;
	}
	public void insertarAnalisis(String aux) {
		analisis.add(aux);
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
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
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getIndicaciones() {
		return indicaciones;
	}
	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
	public Enfermedad getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	
	
	
	
	
	
	
}
