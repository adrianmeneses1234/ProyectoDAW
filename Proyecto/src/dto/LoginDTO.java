package dto;
/**
 * Clase LoginDTO 
 * @author Adrian y Samuel
 * 
 * 
 */

public class LoginDTO {
	/**
	 * parametros de la clase LoginDTO
	 */
	private int identificador;
	private String nombre;
	private  String contraseña;
	private String rol;
	/**
	 * constructor por defecto
	 */
	public LoginDTO() {
		this.identificador=0;
		this.nombre="";
		this.contraseña="";
		this.rol="";
	}
	/**
	 * contructor parametrizado de la clase para establecer un nombre y contraseña
	 * @param nombre tipo String
	 * @param contraseña tipo String 
	 */
	public LoginDTO(String nombre, String contraseña) {
		this.nombre=nombre;
		this.contraseña=contraseña;
	}
	/**
	 * contructor parametrizado de la clase
	 * @param identificador tipo int
	 * @param nombre tipo String
	 * @param contraseña tipo String
	 * @param rol tipo String 
	 */
	public LoginDTO(int identificador,String nombre, String contraseña, String rol) {
		this.identificador=identificador;
		this.nombre=nombre;
		this.contraseña=contraseña;
		this.rol=rol;
	}
	/**
	 * metodo getter para conocer el nombre
	 * @return nombre tipo String 
	 */
		public String getNombre() {
		return nombre;
	}
	/**
	 * metodo setter para establecer el nombre
	 * @param nombre tipo String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * metodo getter para conocer la contraseña
	 * @return contraseña tipo String 
	 */
	public String getContraseña() {
		return contraseña;
	}
	/**
	 * metodo setter para establecer la contraseña
	 * @param contraseña tipo String
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	/**
	 * metodo getter para conocer el Rol
	 * @return rol tipo String 
	 */
	public String getRol() {
		return rol;
	}
	/**
	 * metodo setter para establecer el rol
	 * @param rol tipo String
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	/**
	 * metodo getter para conocer el identificador 
	 * @return identificador tipo int 
	 */
	public int getIdentificador() {
		return identificador;
	}
	/**
	 * metodo setter para establecer el identificador 
	 * @param identificador tipo int 
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	/**
	 * metodo toString que devuelve una String con todos los atributos y sus valores
	 */
	@Override
	public String toString() {
		return "LoginDTO [identificador=" + identificador + ", usuario=" + nombre + ", contraseña=" + contraseña
				+ ", roles=" + rol + "]";
	}
	

}