package model;

import java.sql.SQLException;

import dto.HardwareDTO;

public interface HardwareDAO {

	public void Añadir(HardwareDTO h) throws SQLException;

	public void Eliminar(HardwareDTO h)throws SQLException;

	public void Modificar(HardwareDTO h)throws SQLException;
	

}
