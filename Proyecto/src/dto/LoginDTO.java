package dto;

public class LoginDTO {
	private String usuario;
	private  String contraseña;
	private String roles;
	
	public LoginDTO() {
		this.usuario="";
		this.contraseña="";
		this.roles="";
	}
	public LoginDTO(String usuario, String contraseña, String roles) {
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
	@Override
	public String toString() {
		return "LoginDTO [usuario=" + usuario + ", contraseña=" + contraseña + ", roles=" + roles + "]";
	}
	

}
