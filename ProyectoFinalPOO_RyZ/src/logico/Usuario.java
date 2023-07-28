package logico;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	protected  String tipo;
	protected String userName;
	protected String pass;


	public Usuario(String userName, String pass) {
		super();
		this.userName = userName;
		this.pass = pass;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
