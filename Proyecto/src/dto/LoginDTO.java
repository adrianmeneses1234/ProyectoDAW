package dto;

public class LoginDTO {
	private int identificador;
	private String nombre;
	private  String contraseña;
	private String rol;
	
	public LoginDTO() {
		this.identificador=0;
		this.nombre="";
		this.contraseña="";
		this.rol="";
	}
	public LoginDTO(String nombre, String contraseña) {
		this.nombre=nombre;
		this.contraseña=contraseña;
	}

	public LoginDTO(int identificador,String nombre, String contraseña, String rol) {
		this.identificador=identificador;
		this.nombre=nombre;
		this.contraseña=contraseña;
		this.rol=rol;
	}
		public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	@Override
	public String toString() {
		return "LoginDTO [identificador=" + identificador + ", usuario=" + nombre + ", contraseña=" + contraseña
				+ ", roles=" + rol + "]";
	}
	

}