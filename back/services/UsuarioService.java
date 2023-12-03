package services;

import java.util.ArrayList;

import exceptions.Data2Exception;
import model.Usuario;
import services.exceptions.UserNotFoundException;

public interface UsuarioService {

	public Usuario login(String username, String password) throws UserNotFoundException, Data2Exception;// autentica usuario
	public Usuario findByEmail(String email) throws Data2Exception, UserNotFoundException;// obten usuario polo email
	public Usuario findById(Long idUsuario) throws Data2Exception, UserNotFoundException;// obten usuario polo id
	public ArrayList<Usuario> findAll() throws Data2Exception;// devolve a lista de usuarios
	public Usuario registrar(Usuario usuario) throws Data2Exception;// crea usuario comprobando que email non repetido e encriptando password
	public Usuario update(Usuario usuario) throws Data2Exception; // actualiza usuario
	public void softDelete(Long idUsuario) throws Data2Exception; // borra soft usuario
}
 