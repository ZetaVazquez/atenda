package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import dao.UsuarioDAO;
import exceptions.Data2Exception;

import model.Usuario;
import utils.ConnectionManager;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static final Logger logger= Logger.getLogger(UsuarioDAOImpl.class.getName());
	
	private Usuario loadNext(ResultSet resultSet) throws SQLException {
		Usuario usuario= null;
		int i = 1;
	     usuario = new Usuario();
	        usuario.setId(resultSet.getLong(i++));
	        usuario.setUsername(resultSet.getString(i++));
	        usuario.setPassword(resultSet.getString(i++));
	        usuario.setNome(resultSet.getString(i++));
	        usuario.setRol(resultSet.getString(i++));
	        usuario.setAvatar(resultSet.getString(i++));
	        usuario.setBaixa(resultSet.getBoolean(i++));
	        return usuario;
	    }
	

	@Override
	public Usuario findById(Connection connection, Long idUsuario) throws Data2Exception {
		   Usuario usuario = null;
	        StringBuilder sql = new StringBuilder();
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            sql.append("SELECT id, username, password, nome, rol, avatar, baixa FROM usuario WHERE id = ?");
	            preparedStatement = connection.prepareStatement(sql.toString());
	            preparedStatement.setLong(1, idUsuario);

	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                usuario = loadNext(resultSet);
	            }

	        } catch (SQLException e) {
	    
	            e.printStackTrace(); 
	        } finally {
	            // Cierra recursos. Lo meto en un try catch para poner la SQL exception
	            try {
	            	ConnectionManager.closeResultSet(resultSet);
					ConnectionManager.closePreparedStatement(preparedStatement);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	        }

	        return usuario;
	    }

	@Override
	public Usuario findByEmail(Connection connection, String email) throws Data2Exception {
			Usuario usuario = null;
		    StringBuilder sql = new StringBuilder();
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        sql.append("SELECT id, username, password, nome, rol, avatar, baixa FROM usuario WHERE username = ?");
		        preparedStatement = connection.prepareStatement(sql.toString());
		        preparedStatement.setString(1, email);

		        resultSet = preparedStatement.executeQuery();

		        if (resultSet.next()) {
		            usuario = loadNext(resultSet);
		        }

		    } catch (SQLException e) {
		       
		        e.printStackTrace(); 
		    } finally {
		       
		        try {
					ConnectionManager.closeResultSet(resultSet);
					 ConnectionManager.closePreparedStatement(preparedStatement);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		       
		    }

		    return usuario;
		}

	@Override
	public ArrayList<Usuario> findAll(Connection connection) throws Data2Exception {
		   ArrayList<Usuario> usuarios = new ArrayList<>();
	        StringBuilder sql = new StringBuilder();
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            sql.append("SELECT id, username, password, nome, rol, avatar, baixa FROM usuario");
	            preparedStatement = connection.prepareStatement(sql.toString());
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Usuario usuario = loadNext(resultSet);
	                usuarios.add(usuario);
	            }

	        } catch (SQLException e) {
	           
	            e.printStackTrace(); 
	        } finally {
	            
	            try {
	            	 ConnectionManager.closePreparedStatement(preparedStatement);
					ConnectionManager.closeResultSet(resultSet);
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
	           
	        }

	        return usuarios;
	    }

	@Override
	public Usuario create(Connection connection, Usuario usuario) throws Data2Exception {
		StringBuilder sql = new StringBuilder();
	    PreparedStatement preparedStatement = null;
	    ResultSet generatedKeys = null;

	    try {
	        sql.append("INSERT INTO usuario (username, password, nome, rol, avatar, baixa) VALUES (?, ?, ?, ?, ?, ?)");
	        preparedStatement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
	        preparedStatement.setString(1, usuario.getUsername());
	        preparedStatement.setString(2, usuario.getPassword());
	        preparedStatement.setString(3, usuario.getNome());
	        preparedStatement.setString(4, usuario.getRol());
	        preparedStatement.setString(5, usuario.getAvatar());
	        preparedStatement.setBoolean(6, usuario.isBaixa());

	        int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("La creación del usuario ha fallado, no se han generado claves.");
	        }

	        generatedKeys = preparedStatement.getGeneratedKeys();

	        if (generatedKeys.next()) {
	            usuario.setId(generatedKeys.getLong(1));
	        } else {
	            throw new SQLException("La creación del usuario ha fallado, no se han generado claves.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    } finally {
	     
	        try {
	        	 ConnectionManager.closePreparedStatement(preparedStatement);
				ConnectionManager.closeResultSet(generatedKeys);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	       
	    }

	    return usuario;
	}

	@Override
	public Usuario update(Connection connection, Usuario usuario) throws Data2Exception {
		 StringBuilder sql = new StringBuilder();
		    PreparedStatement preparedStatement = null;

		    try {
		        sql.append("UPDATE usuario SET ");
		        List<String> cambiaVariables = new ArrayList<>();

		        if (usuario.getUsername() != null) {
		            cambiaVariables.add("username = ?");
		        }
		        if (usuario.getPassword() != null) {
		            cambiaVariables.add("password = ?");
		        }
		        if (usuario.getNome() != null) {
		            cambiaVariables.add("nome = ?");
		        }
		        if (usuario.getRol() != null) {
		            cambiaVariables.add("rol = ?");
		        }
		        if (usuario.getAvatar() != null) {
		            cambiaVariables.add("avatar = ?");
		        }
		        cambiaVariables.add("baixa = ?");  // Actualizamos el campo baixa

		        sql.append(String.join(", ", cambiaVariables));
		        sql.append(" WHERE id = ?");

		        preparedStatement = connection.prepareStatement(sql.toString());

		        int i = 1;

		        if (usuario.getUsername() != null) {
		            preparedStatement.setString(i++, usuario.getUsername());
		        }
		        if (usuario.getPassword() != null) {
		            preparedStatement.setString(i++, usuario.getPassword());
		        }
		        if (usuario.getNome() != null) {
		            preparedStatement.setString(i++, usuario.getNome());
		        }
		        if (usuario.getRol() != null) {
		            preparedStatement.setString(i++, usuario.getRol());
		        }
		        if (usuario.getAvatar() != null) {
		            preparedStatement.setString(i++, usuario.getAvatar());
		        }

		        // No se verifica si usuario.isBaixa() != null, siempre debería ser actualizado (booleano)
		        preparedStatement.setBoolean(i++, usuario.isBaixa());

		        // El último parámetro en la cláusula WHERE
		        preparedStatement.setLong(i++, usuario.getId());

		        int affectedRows = preparedStatement.executeUpdate();

		        if (affectedRows == 0) {
		            throw new SQLException("La actualización del usuario ha fallado.");
		        }

		    } catch (SQLException e) {
		    
		        e.printStackTrace(); 
		    } finally {
		       
		        try {
					ConnectionManager.closePreparedStatement(preparedStatement);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		    }

		    return usuario;
		}


	@Override
	public void softDelete(Connection connection, Long idUsuario) throws Data2Exception {
		   StringBuilder sql = new StringBuilder();
		    PreparedStatement preparedStatement = null;

		    try {
		        sql.append("UPDATE usuario SET baixa = true WHERE id = ?");
		        preparedStatement = connection.prepareStatement(sql.toString());
		        preparedStatement.setLong(1, idUsuario);

		        int affectedRows = preparedStatement.executeUpdate();

		        if (affectedRows == 0) {
		            throw new SQLException("El borrado lógico del usuario ha fallado.");
		        }

		    } catch (SQLException e) {
		       
		        e.printStackTrace();
		    } finally {
		  
		        try {
					ConnectionManager.closePreparedStatement(preparedStatement);
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
		    }
		}

}

