package test.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import model.Usuario;
import services.UsuarioService;

import services.imp.UsuarioServiceImpl;

public class UsuarioServiceTest {

	private static final Logger logger= Logger.getLogger(UsuarioServiceTest.class.getName());
	public static void main(String[] args) {
	UsuarioService usuarioService = new UsuarioServiceImpl();
	   // Prueba de login
    try {
        String username = "admin@gmail.com";  // Reemplaza con un nombre de usuario válido
        String password = "abc123.";  // Reemplaza con la contraseña correcta

        Usuario usuarioLogeado = usuarioService.login(username, password);

        if (usuarioLogeado != null) {
            System.out.println("Login exitoso: " + usuarioLogeado);
        } else {
            System.out.println("Error: Usuario no encontrado o contraseña incorrecta.");
        }
    } catch (Exception e) {
      e.printStackTrace();
  }
	
//	  // FIND BY ID:
//    try {
//        Usuario usuarioEncontrado = usuarioService.findById(1L);
//        if (usuarioEncontrado != null) {
//            logger.info("Usuario encontrado por ID: " + usuarioEncontrado);
//        } else {
//            logger.info("No se encontró ningún usuario por ID.");
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
    // FIND BY EMAIL (Username en este caso):
//    try {
//        Usuario usuarioByEmail = usuarioService.findByEmail("admin@gmail.com");
//        if (usuarioByEmail != null) {
//            logger.info("Usuario encontrado por email (username): " + usuarioByEmail);
//        } else {
//            logger.info("No se encontró ningún usuario por email (username).");
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//    // FIND ALL:
//    try {
//        ArrayList<Usuario> usuariosEncontrados = usuarioService.findAll();
//        if (!usuariosEncontrados.isEmpty()) {
//            for (Usuario usuario : usuariosEncontrados) {
//                logger.info("Usuario encontrado: " + usuario);
//            }
//        } else {
//            logger.info("No se encontraron usuarios.");
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
	
//    // CREATE:
//    try {
//        Usuario nuevoUsuario = new Usuario();
//        nuevoUsuario.setUsername("nuevo@prueba.com");
//        nuevoUsuario.setPassword("nuevopassword");
//        nuevoUsuario.setNome("Nuevo Usuario");
//        nuevoUsuario.setRol("ADMIN");
//        nuevoUsuario.setAvatar("avatar.png");
//        nuevoUsuario.setBaixa(false);
//
//        Usuario usuarioCreado = usuarioService.registrar(nuevoUsuario);
//        logger.info("Usuario creado: " + usuarioCreado);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }

//    // UPDATE:
//    try {
//        Usuario usuarioToUpdate = usuarioService.findById(42L);
//        if (usuarioToUpdate != null) {
//            usuarioToUpdate.setNome("UserActualizado");
//            usuarioToUpdate.setPassword("nuevapassword123");
//            Usuario usuarioActualizado = usuarioService.update(usuarioToUpdate);
//            logger.info("Usuario actualizado: " + usuarioActualizado);
//        } else {
//            logger.info("No se encontró ningún usuario para actualizar.");
//        }
//  
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
    // SOFT DELETE:
//  try {
//        usuarioService.softDelete(42L);
//        logger.info("Soft delete realizado con éxito.");
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//
//
//	
	}

}
