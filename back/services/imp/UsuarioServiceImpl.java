package services.imp;

import java.sql.Connection;

import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

import dao.UsuarioDAO;
import dao.impl.UsuarioDAOImpl;

import exceptions.Data2Exception;
import model.Usuario;
import services.UsuarioService;
import services.exceptions.UserNotFoundException;
import utils.ConnectionManager;

public class UsuarioServiceImpl implements UsuarioService{

	   private UsuarioDAO usuarioDAO=new UsuarioDAOImpl();

	 

	    @Override
	    public Usuario login(String username, String password) throws UserNotFoundException, Data2Exception {
	        Connection connection = null;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);

	            Usuario usuario = usuarioDAO.findByEmail(connection, username);

	            if(usuario !=null && BCrypt.checkpw(password,usuario.getPassword())){
	            	return usuario; 
	        }else {
	                throw new UserNotFoundException("Usuario no encontrado o contraseña incorrecta");
	            }
	            
	           
	        } catch (Exception e) {
	            throw new Data2Exception("Error al realizar la operación en la base de datos", e);
	        } finally {
	            ConnectionManager.closeConnection(connection, true);
	        }
	    }

	    @Override
	    public Usuario findByEmail(String email) throws Data2Exception, UserNotFoundException {
	        Connection connection = null;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);

	            Usuario usuario = usuarioDAO.findByEmail(connection, email);

	            if (usuario == null) {
	                throw new UserNotFoundException("Usuario no encontrado");
	            }

	            return usuario;
	        } catch (Exception e) {
	            throw new Data2Exception("Error al realizar la operación en la base de datos", e);
	        } finally {
	            ConnectionManager.closeConnection(connection, true);
	        }
	    }

	    @Override
	    public Usuario findById(Long idUsuario) throws Data2Exception, UserNotFoundException {
	        Connection connection = null;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);

	            Usuario usuario = usuarioDAO.findById(connection, idUsuario);

	            if (usuario == null) {
	                throw new UserNotFoundException("Usuario no encontrado");
	            }

	            return usuario;
	        } catch (Exception e) {
	            throw new Data2Exception("Error al realizar la operación en la base de datos", e);
	        } finally {
	            ConnectionManager.closeConnection(connection, true);
	        }
	    }

	    @Override
	    public ArrayList<Usuario> findAll() throws Data2Exception {
	        Connection connection = null;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);

	            return usuarioDAO.findAll(connection);
	        } catch (Exception e) {
	            throw new Data2Exception("Error al realizar la operación en la base de datos", e);
	        } finally {
	            ConnectionManager.closeConnection(connection, true);
	        }
	    }

	    @Override
	    public Usuario registrar(Usuario usuario) throws Data2Exception {
	        Connection connection = null;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);

	            return usuarioDAO.create(connection, usuario);
	        } catch (Exception e) {
	            throw new Data2Exception("Error al realizar la operación en la base de datos", e);
	        } finally {
	            ConnectionManager.closeConnection(connection, true);
	        }
	    }

	    @Override
	    public Usuario update(Usuario usuario) throws Data2Exception {
	        Connection connection = null;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);

	            return usuarioDAO.update(connection, usuario);
	        } catch (Exception e) {
	            throw new Data2Exception("Error al realizar la operación en la base de datos", e);
	        } finally {
	            ConnectionManager.closeConnection(connection, true);
	        }
	    }

	    @Override
	    public void softDelete(Long idUsuario) throws Data2Exception {
	        Connection connection = null;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);

	            usuarioDAO.softDelete(connection, idUsuario);
	        } catch (Exception e) {
	            throw new Data2Exception("Error al realizar la operación en la base de datos", e);
	        } finally {
	            ConnectionManager.closeConnection(connection, true);
	        }
	    }
	}