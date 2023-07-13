package logico;


public class Vacuna {

	
	private String codigo;
	private String nombre;
	private String laboratorio;
	private String descripcion;
	/**
	 * @param codigo
	 * @param nombre
	 * @param laboratorio
	 * @param descripcion
	 */
	public Vacuna(String codigo, String nombre, String laboratorio, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.laboratorio = laboratorio;
		this.descripcion = descripcion;
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
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	
	
	
}
