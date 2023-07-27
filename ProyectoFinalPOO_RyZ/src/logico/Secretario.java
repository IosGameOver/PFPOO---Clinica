package logico;

public class Secretario extends Usuario {
	private static final long serialVersionUID = 1L;

	public Secretario(String userName, String pass) {
		super(userName, pass);
		this.nvlAutoridad = 10;
	}
}
