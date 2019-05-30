package model;

import java.sql.SQLException;

import dto.LoginDTO;

public interface LoginDAO {
	public boolean Login (LoginDTO l) throws SQLException;
	public boolean LoginAdmin (LoginDTO l) throws SQLException;
	public boolean LoginProfesor (LoginDTO l) throws SQLException;

	public void Añadir(LoginDTO l) throws SQLException;
	public void Eliminar(LoginDTO l) throws SQLException;
	public void Modificar(LoginDTO l) throws SQLException;


}
