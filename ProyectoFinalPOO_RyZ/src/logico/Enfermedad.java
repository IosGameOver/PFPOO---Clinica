package logico;

import java.util.ArrayList;

public class Enfermedad {	
	private String codigo;
	private String nombre;
	private String descripcion;
	private ArrayList<String> sintomas;

	public Enfermedad(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.sintomas = new ArrayList<String>();
	}
	
	public void insertarSintomas(String sintoma) {
		this.sintomas.add(sintoma);
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ArrayList<String> getSintomas() {
		return sintomas;
	}
	public void setSintomas(ArrayList<String> sintomas) {
		this.sintomas = sintomas;
	}
}
