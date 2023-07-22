package logico;

import java.util.ArrayList;
import java.util.Date;

public class Paciente extends Persona {
	
	private int cantHijos;
	private String fuma;
	private String alcohol;
	private String cafe;
	private String drogas;
	private String tieneAlergias;
	private String alergias;
	private String tieneCirugias;
	private String cirugias;
	private String tieneTransfusion;
	private String transfusiones;
	private String tieneTraumatismo;
	private String traumatismo;
	private String antecedentesPersonales;
	private String antecedentesFamiliares;
	private String antecedentesFisiologicos;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Vacuna> misVacunas;
	private Historial miHistorial;

	public Paciente(String cod, String cedula, String nombre,  String sexo, String estadoCivil, String telefono,
			Date fechaNacimiento, String direccion, String tipoSangre, int cantHijos, String fuma, 
			String alcohol, String cafe, String drogas, String tieneAlergias,String alergias, String tieneCirugias, 
			String cirugias, String tieneTransfusion, String transfusiones,String tieneTraumatismo, String traumatismo, 
			String antecedentesPersonales,String antecedentesFamiliares, Historial miHistorial, String antecedentesFisiologicos) {
		super(cod, cedula, nombre,  sexo, estadoCivil, telefono, fechaNacimiento, direccion, tipoSangre);
		this.cantHijos = cantHijos;
		this.fuma = fuma;
		this.alcohol = alcohol;
		this.cafe = cafe;
		this.drogas = drogas;
		this.tieneAlergias = tieneAlergias;
		this.alergias = alergias;
		this.tieneCirugias = tieneCirugias;
		this.cirugias = cirugias;
		this.tieneTransfusion = tieneTransfusion;
		this.transfusiones = transfusiones;
		this.tieneTraumatismo = tieneTraumatismo;
		this.traumatismo = traumatismo;
		this.antecedentesPersonales = antecedentesPersonales;
		this.antecedentesFamiliares = antecedentesFamiliares;
		this.antecedentesFisiologicos = antecedentesFisiologicos;
		this.miHistorial = miHistorial;
		this.misConsultas = new ArrayList<Consulta>();
		this.misVacunas = new ArrayList<Vacuna>();
		
	}

	public int getCantHijos() {
		return cantHijos;
	}
	public void setCantHijos(int cantHijos) {
		this.cantHijos = cantHijos;
	}
	
	public String getFuma() {
		return fuma;
	}
	public void setFuma(String fuma) {
		this.fuma = fuma;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	public String getCafe() {
		return cafe;
	}
	public void setCafe(String cafe) {
		this.cafe = cafe;
	}
	public String getDrogas() {
		return drogas;
	}
	public void setDrogas(String drogas) {
		this.drogas = drogas;
	}
	public String getTieneAlergias() {
		return tieneAlergias;
	}
	public void setTieneAlergias(String tieneAlergias) {
		this.tieneAlergias = tieneAlergias;
	}
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	public String getTieneCirugias() {
		return tieneCirugias;
	}
	public void setTieneCirugias(String tieneCirugias) {
		this.tieneCirugias = tieneCirugias;
	}
	public String getCirugias() {
		return cirugias;
	}
	public void setCirugias(String cirugias) {
		this.cirugias = cirugias;
	}
	public String getTieneTransfusion() {
		return tieneTransfusion;
	}
	public void setTieneTransfusion(String tieneTransfusion) {
		this.tieneTransfusion = tieneTransfusion;
	}
	public String getTransfusiones() {
		return transfusiones;
	}
	public void setTransfusiones(String transfusiones) {
		this.transfusiones = transfusiones;
	}
	public String getTieneTraumatismo() {
		return tieneTraumatismo;
	}
	public void setTieneTraumatismo(String tieneTraumatismo) {
		this.tieneTraumatismo = tieneTraumatismo;
	}
	public String getAntecedentesPersonales() {
		return antecedentesPersonales;
	}
	public void setAntecedentesPersonales(String antecedentesPersonales) {
		this.antecedentesPersonales = antecedentesPersonales;
	}
	public String getAntecedentesFamiliares() {
		return antecedentesFamiliares;
	}
	public void setAntecedentesFamiliares(String antecedentesFamiliares) {
		this.antecedentesFamiliares = antecedentesFamiliares;
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
	public Historial getMiHistorial() {
		return miHistorial;
	}
	public void setMiHistorial(Historial miHistorial) {
		this.miHistorial = miHistorial;
	}
	public String getTraumatismo() {
		return traumatismo;
	}
	public void setTraumatismo(String traumatismo) {
		this.traumatismo = traumatismo;
	}
	public String getAntecedentesFisiologicos() {
		return antecedentesFisiologicos;
	}
	public void setAntecedentesFisiologicos(String antecedentesFisiologicos) {
		this.antecedentesFisiologicos = antecedentesFisiologicos;
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}
