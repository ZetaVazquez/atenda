package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Produto;
import services.ProdutoService;
import services.imp.ProdutoServiceImpl;

import java.io.IOException;
import java.util.List;

import exceptions.Data2Exception;

@WebServlet("/logout")
public class ControladorLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControladorLogout() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destino ="/";
		HttpSession session = request.getSession();

		if(session != null) {
			session.removeAttribute("user");
			session.setAttribute("rol", "ANON");
		}
		
		request.getRequestDispatcher(destino).forward(request, response);
	}

}