package dto;

import java.util.Date;

public class HardwareDTO {
	private int codigo;
	private String nombre;
	private String descripcion;
	private int año;
	private int precio;
	private int unidades;
	
	public HardwareDTO() {
		this.codigo=0;
		this.nombre="";
		this.descripcion="";
		this.año= 0;
		this.precio=0;
		this.unidades=0;
	}
	public HardwareDTO(int codigo, String nombre, String descripcion, int año, int precio, int unidades) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.año=año;
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
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "HardwareDTO [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", año=" + año
				+ ", precio=" + precio + ", unidades=" + unidades + "]";
	}
	
	

}
