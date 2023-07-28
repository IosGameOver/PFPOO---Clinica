package logico;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	public Administrador(String userName, String pass) {
		super(userName, pass);
		// TODO Auto-generated constructor stub
		this.tipo = "Administrador";
	}
	
	
	
	
	
	
	
}
