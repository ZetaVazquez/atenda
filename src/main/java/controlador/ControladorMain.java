package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;
import services.ProdutoService;
import services.imp.ProdutoServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import exceptions.Data2Exception;

@WebServlet("/")
public class ControladorMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ControladorMain.class.getName());
	
    public ControladorMain() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdutoService produtoService = new ProdutoServiceImpl(); 
		List<Produto> listaProductos=null;
		try {
			listaProductos = produtoService.findAll();
		} catch (Data2Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productos", listaProductos);
		//nada mais lanzalo xa nos envia a index.jsp
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
