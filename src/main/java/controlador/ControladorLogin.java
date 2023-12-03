package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioService;
import services.exceptions.UserNotFoundException;
import services.imp.UsuarioServiceImpl;


import java.io.IOException;
import java.util.logging.Logger;

import exceptions.Data2Exception;

@WebServlet("/login")
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ControladorLogin.class.getName());
	public ControladorLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// autenticar + asignar roles + gardalos na session -> fallo = ANON
		String destino = "/";
		String login = request.getParameter("username");
		String password = request.getParameter("password");
		Usuario usuarioLogeado=null;
		
		if (login != null && password != null) {
			
			UsuarioService usuarioSer = new UsuarioServiceImpl();
			try {
			usuarioLogeado=usuarioSer.login(login, password);
			
			logger.info("estoy den controladorLogin");
			
			if (usuarioLogeado != null) {
				
				if (usuarioLogeado.getRol().equals("BASIC")) {
					request.getSession().setAttribute("user", "user");
					request.getSession().setAttribute("rol", "BASIC");
					destino = "/";
					logger.info("estoy en basic");
				}
				if (usuarioLogeado.getRol().equals("ADMIN")) {
					request.getSession().setAttribute("user", "admin");
					request.getSession().setAttribute("rol", "ADMIN");
					destino = "/admin";
					logger.info("estoy en admin");

				} else {
					// no login no password = anon
					request.getSession().setAttribute("user", "anonymous");
					request.getSession().setAttribute("rol", "ANON");
					destino = "/";
				;
				}
			}
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			} catch (Data2Exception e) {
				e.printStackTrace();
			}
		}

		request.getRequestDispatcher(destino).forward(request, response);
	}
}
