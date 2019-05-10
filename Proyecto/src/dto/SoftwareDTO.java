package dto;

public class SoftwareDTO {
	private int codigo;
	private String nombre;
	private String descripcion;
	private String version;
	private String licencia;
	private int caducidad;
	private int precio;
	private int unidades;
	
	public SoftwareDTO(){
		this.codigo=0;
		this.nombre="";
		this.descripcion="";
		this.version="";
		this.licencia="";
		this.caducidad=0;
		this.precio=0;
		this.unidades=0;
		
	}
	public SoftwareDTO(int codigo, String nombre, String descripcion, String version, String licencia, int caducidad, int precio, int unidades) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.version=version;
		this.licencia=licencia;
		this.caducidad=caducidad;
		this.precio=precio;
		this.unidades=unidades;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	public int getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(int caducidad) {
		this.caducidad = caducidad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "SoftwareDTO [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", version="
				+ version + ", licencia=" + licencia + ", caducidad=" + caducidad + ", precio=" + precio + ", unidades="
				+ unidades + "]";
	}
	
	

}
