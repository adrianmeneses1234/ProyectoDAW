package dto;
/**
 * 
 * @author Adrian y Samuel 
 *
 */
public class SoftwareDTO {
	/**
	 * atributos de la clase SoftwareDTO
	 */
	private int codigo;
	private String nombre;
	private String descripcion;
	private String version;
	private String licencia;
	private String caducidad;
	private int precio;
	private int unidades;
	/**
	 * constructor por defecto de la clase
	 */
	public SoftwareDTO(){
		this.codigo=0;
		this.nombre="";
		this.descripcion="";
		this.version="";
		this.licencia="";
		this.caducidad="";
		this.precio=0;
		this.unidades=0;
		
	}
	/**
	 * constructor parametrizador de la clase
	 * @param codigo tipo int	
	 * @param nombre tipo String
	 * @param descripcion tipo String
	 * @param version tipo String 
	 * @param licencia tipo String 
	 * @param caducidad tipo String 
	 * @param precio tipo int 
	 * @param unidades tipo int 
	 */
	public SoftwareDTO(int codigo, String nombre, String descripcion, String version, String licencia, String caducidad, int precio, int unidades) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.version=version;
		this.licencia=licencia;
		this.caducidad=caducidad;
		this.precio=precio;
		this.unidades=unidades;
	}
	/**
	 * metodo para sumar +1 a las unidades
	 * @return unidades tipo int 
	 */
	public int sumar() {
		return this.unidades=this.unidades+1;
	}
	/**
	 * metodo getter para conocer las unidades 
	 * @return unidades tipo int 
	 */
	public int getUnidades() {
		return unidades;
	}
	/**
	 * metodo setter para establecer las unidades
	 * @param unidades tipo int 
 	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	/**
	 * metodo getter para conocer el codigo
	 * @return codigo tipo int
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * metodo setter para establecer el codigo
	 * @param codigo tipo int 
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	 * @param nombre  tipo String 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * metodo getter para conocer la descripcion 
	 * @return descripcion tipo String 
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * metodo setter para establercer la descripcion 
	 * @param descripcion tipo String 
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * metodo getter para conocer la version 
	 * @return version tipo String 
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * metodo setter para establecer la version
	 * @param version tipo String
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * metodo getter para conocer la licencia 
	 * @return licencia tipo String 
	 */
	public String getLicencia() {
		return licencia;
	}
	/**
	 * metodo setter para establecer la licencia 
	 * @param licencia tipo String 
	 */
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	/**
	 * metodo getter para conocer la caducidad
	 * @return caducidad tipo String 
	 */
	public String getCaducidad() {
		return caducidad;
	}
	/**
	 * metodo setter para conocer la caducidad 
	 * @param caducidad
	 */
	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}
	/**
	 * metodo getter para conocer el precio
	 * @return
	 */
	public int getPrecio() {
		return precio;
	}
	/**
	 * metodo setter para establecer el precio
	 * @param precio tipo int 
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	/**
	 * metodo toString que devuelve una String con todos los atributos y sus valores
	 */
	@Override
	public String toString() {
		return "SoftwareDTO [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", version="
				+ version + ", licencia=" + licencia + ", caducidad=" + caducidad + ", precio=" + precio + ", unidades="
				+ unidades + "]";
	}
	/**
	 * metodo para restar -1 a las unidades 
	 * @return unidades tipo int 
	 */
	public int restar() {
	return this.unidades=unidades-1;
		
	}
	
	

}
