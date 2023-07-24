package logico;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	protected  int nvlAutoridad;
	//private String tipo;
	protected String userName;
	protected String pass;


	public Usuario(String userName, String pass) {
		super();
		
		this.userName = userName;
		this.pass = pass;
	}


	




	public int getNvlAutoridad() {
		return nvlAutoridad;
	}



	public void  setNvlAutoridad(int nvlAutoridad) {
		this.nvlAutoridad = nvlAutoridad;
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
