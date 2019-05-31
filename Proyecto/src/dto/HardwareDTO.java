package dto;
 /**
  * clase de HardwareDTO
  * @author Adrian y Samuel 
  *
  */
public class HardwareDTO {
	/**
	 * parametros de la clase HardwareDTO
	 */
    private int codigo;
    private String nombre;
    private String descripcion;
    private int año;
    private int precio;
    private int unidades;
   /**
    * constructor por defecto de la clase
    */
    public HardwareDTO() {
        this.codigo=0;
        this.nombre="";
        this.descripcion="";
        this.año= 0;
        this.precio=0;
        this.unidades=0;
    }
    /**
     * contructor parametrizado de la clase HardwareDTO
     * @param codigo ,int codigo de identificacion
     * @param nombre ,String nombre del hardware en cuestion
     * @param descripcion ,String descripcion del objeto
     * @param año ,int año de fabricacion 
     * @param precio ,int precio del productor 
     * @param unidades ,int unidades restantes 
     */
    public HardwareDTO(int codigo, String nombre, String descripcion, int año, int precio, int unidades) {
        this.codigo=codigo;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.año=año;
        this.precio=precio;
        this.unidades=unidades;
    }
    /**
     *  metodo getter de la clase para conocer la unidades 
     * @return unidades , atributo de tipo int de la clase
     */
    public int getUnidades() {
        return unidades;
    }
    /**
     * metodo setter de la clase para establecer las unidades
     * @param unidades, int parametro de tipo int que recibe para establecer las unidades 
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    /**
     * metodo getter de la clase para conocer el codigo 
     * @return codigo , atributo de tipo string de la clase
     */
    public int getCodigo() {
        return codigo;
    }
    /**
     * metodo setter de la clase para establecer el codigo
     * @param codigo , int parametro de tipo int que recibe para establecer las unidades
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    /**
     * metodo getter de la clase para conocer el nombre 
     * @return nombre , atributo de tipo String de la clase
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * metodo setter de la clase para establecer el nombre
     * @param nombre , parametro de tipo String que recibe el metodo para establecer el nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * metodo getter de la clase para conocer la descripcion
     * @return descripcion , atributo de tipo String de la clase
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * metodo setter para establecer la descripcion 
     * @param descripcion , parametro de tipo String que recibe la clase 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * metodo getter para conocer el año
     * @return año , devuelve el atributo año de tipo int
     */
    public int getAño() {
        return año;
    }
    /**
     * metodo setter para establecer el año
     * @param año parametro que recibe el metodo de tipo int 
     */
    public void setAño(int año) {
        this.año = año;
    }
    /**
     * metodo getter para conocer el precio 
     * @return precio, devuelve el atributo Precio de tipo int 
     */
    public int getPrecio() {
        return precio;
    }
    /**
     * metodo setter para establecer el precio
     * @param precio parametro de tipo int que recibe el metodo 
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    /**
     * metodo toString que devuelve una String con todos los atributos y sus valores
     */
    @Override
    public String toString() {
        return "HardwareDTO [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", año=" + año
                + ", precio=" + precio + ", unidades=" + unidades + "]";
    }
    /**
     * metodo para sumar + 1 al precio 
     * @return precio int 
     */
    public int sumarPrecio() {
        return this.precio=this.precio+1;
    }
    /**
     * metodo para restar -1 al precio
     * @return precio int 
     */
    public int restarPrecio() {
        return this.precio=this.precio-1;
    }
    /**
     * metodo para sumar +1 a las unidades
     * @return unidades int 
     */
    public int sumarUnidades() {
        return this.unidades=this.unidades+1;
    }
    /**
     * metodo para restar -1 a las unidades 
     * @return unidades int
     */
    public int restarUnidades() {
        return this.unidades=this.unidades-1;
    }
   
 
}
