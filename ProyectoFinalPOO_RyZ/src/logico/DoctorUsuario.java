package logico;

import java.io.Serializable;

public class DoctorUsuario extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public DoctorUsuario(String userName, String pass) {
		super(userName, pass);
		this.tipo= "Doctor";
	}

}
