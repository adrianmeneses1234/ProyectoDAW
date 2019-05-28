package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dto.HardwareDTO;

class Prueba {

	@Test
	public void test() {
		HardwareDTO dto = new HardwareDTO(1,"Pantalla de Ordenador", "Nuevo", 2019, 29, 2);
		HardwareDTO dto2 = new HardwareDTO(1,"Pantalla de Ordenador", "Nuevo", 2019, 29, 2);
		assertEquals(dto2, dto);
	}

	@Test
	public void test2() {
		
	}
	@Test
	public void test3() {
		
		
	}
	@Test
	public void test4() {
		
		
	}
	@Test
	public void test5() {
		
		
	}

}

