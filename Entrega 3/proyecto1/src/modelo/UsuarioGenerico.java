package modelo;

public abstract class UsuarioGenerico {
	protected String login;
	protected String password;
	protected String nombre;
	protected String type;
	
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public String getNombre() {
		return nombre;
	}
	public String getType() {
		return type;
	}
	
	
}
