package dto;
/**
 * Clase de HardwareDTO
 * @author Adrian y Samuel 
 *@version 6/06/19
 */

public class HardwareDTO {
	/**
	 * Parametros de la clase HardwareDTO
	 */
    private int codigo;
    private String nombre;
    private String descripcion;
    private int anyo;
    private int precio;
    private int unidades;
    /**
     * Constructor por defecto de la clase
     */
    public HardwareDTO() {
        this.codigo=0;
        this.nombre="";
        this.descripcion="";
        this.anyo= 0;
        this.precio=0;
        this.unidades=0;
    }
    /**
     * Contructor parametrizado de la clase HardwareDTO
     * @param codigo ,int codigo de identificacion
     * @param nombre ,String nombre del hardware en cuestion
     * @param descripcion ,String descripcion del objeto
     * @param anyo ,int anyo de fabricacion 
     * @param precio ,int precio del productor 
     * @param unidades ,int unidades restantes 
     */
    public HardwareDTO(int codigo, String nombre, String descripcion, int anyo, int precio, int unidades) {
        this.codigo=codigo;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.anyo=anyo;
        this.precio=precio;
        this.unidades=unidades;
    }
    /**
     *  Metodo getter de la clase para conocer la unidades 
     * @return unidades , atributo de tipo int de la clase
     */
    public int getUnidades() {
        return unidades;
    }
    /**
     * Metodo setter de la clase para establecer las unidades
     * @param unidades, int parametro de tipo int que recibe para establecer las unidades 
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    /**
     * Metodo getter de la clase para conocer el codigo 
     * @return codigo , atributo de tipo string de la clase
     */
    public int getCodigo() {
        return codigo;
    }
    /**
     * Metodo setter de la clase para establecer el codigo
     * @param codigo , int parametro de tipo int que recibe para establecer las unidades
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    /**
     * Metodo getter de la clase para conocer el nombre 
     * @return nombre , atributo de tipo String de la clase
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo setter de la clase para establecer el nombre
     * @param nombre , parametro de tipo String que recibe el metodo para establecer el nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo getter de la clase para conocer la descripcion
     * @return descripcion , atributo de tipo String de la clase
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Metodo setter para establecer la descripcion 
     * @param descripcion , parametro de tipo String que recibe la clase 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Metodo getter para conocer el año
     * @return anyo , devuelve el atributo año de tipo int
     */    
    public int getAnyo() {
        return anyo;
    }
    /**
     * Metodo setter para establecer el año
     * @param anyo parametro que recibe el metodo de tipo int 
     */
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
    /**
     * Metodo getter para conocer el precio 
     * @return precio, devuelve el atributo Precio de tipo int 
     */
    public int getPrecio() {
        return precio;
    }
    /**
     * Metodo setter para establecer el precio
     * @param precio parametro de tipo int que recibe el metodo 
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    /**
     * Metodo toString que devuelve una String con todos los atributos y sus valores
     */
    @Override
    public String toString() {
        return "HardwareDTO [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", año=" + anyo
                + ", precio=" + precio + ", unidades=" + unidades + "]";
    }
   
    /**
     * Metodo para sumar + 1 al precio 
     * @return precio int 
     */
    public int sumarPrecio() {
        return this.precio=this.precio+1;
    }
    /**
     * Metodo para restar -1 al precio
     * @return precio int 
     */
    public int restarPrecio() {
        return this.precio=this.precio-1;
    }
    /**
     * Metodo para sumar +1 a las unidades
     * @return unidades int 
     */
    public int sumarUnidades() {
        return this.unidades=this.unidades+1;
    }
    /**
     * Metodo para restar -1 a las unidades 
     * @return unidades int
     */
    public int restarUnidades() {
        return this.unidades=this.unidades-1;
    }
   
 
}