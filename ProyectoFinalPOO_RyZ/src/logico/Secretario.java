package logico;

import java.io.Serializable;

public class Secretario extends Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Secretario(String userName, String pass) {
		super(userName, pass);
		this.tipo= "Secretario";
	}
}
