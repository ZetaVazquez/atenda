package dao;

import java.sql.Connection;
import java.util.ArrayList;

import exceptions.Data2Exception;
import model.Usuario;

public interface UsuarioDAO {

	public Usuario findById(Connection connection, Long idUsuario) throws Data2Exception;// obten usuario polo id

	public Usuario findByEmail(Connection connection, String email) throws Data2Exception;// obten usuario polo email

	public ArrayList<Usuario> findAll(Connection connection) throws Data2Exception;// devolve a lista de usuarios

	public Usuario create(Connection connection, Usuario usuario) throws Data2Exception;// crea usuario

	public Usuario update(Connection connection, Usuario usuario) throws Data2Exception; // actualiza usuario

	public void softDelete(Connection connection, Long idUsuario) throws Data2Exception; // borra soft usuario
	
}
