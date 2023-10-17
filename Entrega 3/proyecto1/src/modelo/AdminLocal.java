package modelo;

public class AdminLocal extends UsuarioGenerico {
	public AdminLocal(String elTypeUsuario, String elLogin, String laPass, String elNombre )
	{
		type = elTypeUsuario;
		login = elLogin;
		password = laPass;
		nombre = elNombre;
	}
}
