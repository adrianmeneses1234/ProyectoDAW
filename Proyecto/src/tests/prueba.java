package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dto.HardwareDTO;
import dto.LoginDTO;
import dto.SoftwareDTO;

class Prueba {
	 
    @Test
    public void test() {
        HardwareDTO dto = new HardwareDTO(1,"Pantalla de Ordenador", "Nuevo", 2019, 29, 2);
        HardwareDTO dto2 = new HardwareDTO();
        dto2.setCodigo(1);
        dto2.setNombre("Pantalla de Ordenador");
        dto2.setDescripcion("Nuevo");
        dto2.setAnyo(2019);
        dto2.setPrecio(29);
        dto2.setUnidades(2);
        assertEquals(dto, dto2);
    }
 
    @Test
    public void test2() {
        SoftwareDTO dto = new SoftwareDTO(1,"Windows","sistema operativo","34.2","licencia","28/6/19",60,4);
        SoftwareDTO dto2 = new SoftwareDTO();
        dto2.setCodigo(1);
        dto2.setNombre("Windows");
        dto2.setDescripcion("sistema operativo");
        dto2.setVersion("34.2");
        dto2.setLicencia("licencia");
        dto2.setCaducidad("28/6/19");
        dto2.setPrecio(60);
        dto2.setUnidades(4);
        assertEquals(dto, dto2);
    }
    @Test
    public void test3() {
        LoginDTO dto = new LoginDTO(1,"samu","contraseña","administrador");
        LoginDTO dto1 = new LoginDTO();
        dto1.setIdentificador(1);
        dto1.setNombre("samu");
        dto1.setContrasenya("contraseña");
        dto1.setRol("administrador");
        assertEquals(dto,dto1);
    }
    @Test
    public void test4() {
        LoginDTO dto = new LoginDTO(1,"samu","contraseña","administrador");
       
        LoginDTO dto2= new LoginDTO(dto.getIdentificador(),dto.getNombre(),dto.getContrasenya(),dto.getRol());
               
        assertEquals(dto,dto2);
    }
    @Test
    public void test5() {
    	SoftwareDTO dto = new SoftwareDTO(1,"Windows","sistema operativo","34.2","licencia","28/6/19",60,4);
    	SoftwareDTO dto2 = new SoftwareDTO(1,"Windows","sistema operativo","34.2","licencia","28/6/19",60,5);
    	
    	assertEquals(dto2, dto.sumar());


    }

}

