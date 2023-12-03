package test.dao;


import java.util.logging.Logger;

import dao.impl.UsuarioDAOImpl;
import model.Usuario;
import utils.ConnectionManager;

public class UsuarioDAOTest {

	    private static final Logger logger = Logger.getLogger(UsuarioDAOTest.class.getName());

	    public static void main(String[] args) {
	        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();

	        // FIND BY ID:
	        try {
	            Usuario usuarioEncontrado = usuarioDAO.findById(ConnectionManager.getConnection(), 1L);
	            if (usuarioEncontrado != null) {
	                logger.info("Usuario encontrado por ID: " + usuarioEncontrado);
	            } else {
	                logger.info("No se encontró ningún usuario por ID.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        // FIND BY EMAIL (Username en este caso):
//	        try {
//	            Usuario usuarioByEmail = usuarioDAO.findByEmail(ConnectionManager.getConnection(), "zaida@prueba.com");
//	            if (usuarioByEmail != null) {
//	                logger.info("Usuario encontrado por email (username): " + usuarioByEmail);
//	            } else {
//	                logger.info("No se encontró ningún usuario por email (username).");
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//
//	        // FIND ALL:
//	        try {
//	            List<Usuario> usuariosEncontrados = usuarioDAO.findAll(ConnectionManager.getConnection());
//	            if (!usuariosEncontrados.isEmpty()) {
//	                for (Usuario usuario : usuariosEncontrados) {
//	                    logger.info("Usuario encontrado: " + usuario);
//	                }
//	            } else {
//	                logger.info("No se encontraron usuarios.");
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }

	        // CREATE:
	        try {
	            Usuario nuevoUsuario = new Usuario();
	            nuevoUsuario.setUsername("zaida@prueba.com");
	            nuevoUsuario.setPassword("password123");
	            nuevoUsuario.setNome("Zaida Vazquez");
	            nuevoUsuario.setRol("ADMIN");
	            nuevoUsuario.setAvatar("avatar.png");
	            nuevoUsuario.setBaixa(false);

	            Usuario usuarioCreado = usuarioDAO.create(ConnectionManager.getConnection(), nuevoUsuario);
	            logger.info("Usuario creado: " + usuarioCreado);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        // UPDATE:
	        try {
	            Usuario usuarioToUpdate = usuarioDAO.findById(ConnectionManager.getConnection(), 41L);
	            if (usuarioToUpdate != null) {
	                usuarioToUpdate.setNome("Usuario actualizado con update");
	                usuarioToUpdate.setPassword("yanosoyabc123.");
	                Usuario usuarioActualizado = usuarioDAO.update(ConnectionManager.getConnection(), usuarioToUpdate);
	                logger.info("Usuario actualizado: " + usuarioActualizado);
	            } else {
	                logger.info("No se encontró ningún usuario para actualizar.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        // SOFT DELETE:
	        try {
	            usuarioDAO.softDelete(ConnectionManager.getConnection(), 1L);
	            logger.info("Soft delete realizado con éxito.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


