package dto;

public class LoginDTO {
	private int identificador;
	private String usuario;
	private  String contraseña;
	private String roles;
	
	public LoginDTO() {
		this.identificador=0;
		this.usuario="";
		this.contraseña="";
		this.roles="";
	}
	public LoginDTO(int identificador,String usuario, String contraseña, String roles) {
		this.usuario=usuario;
		this.contraseña=contraseña;
		this.roles=roles;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	@Override
	public String toString() {
		return "LoginDTO [identificador=" + identificador + ", usuario=" + usuario + ", contraseña=" + contraseña
				+ ", roles=" + roles + "]";
	}
	

}