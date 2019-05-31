package model;

import java.sql.SQLException;

import dto.SoftwareDTO;

public interface SoftwareDAO {
	
		public void AnyadirSoftware(SoftwareDTO s) throws SQLException;
		public void EliminarSoftware(SoftwareDTO s)throws SQLException;
		public void modificarSoftware(SoftwareDTO s)throws SQLException;

	
	}
