package controlador;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Produto;

import services.imp.ProdutoServiceImpl;


import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import exceptions.Data2Exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ControladorAdmin.
 */
@WebServlet("/admin")

public class ControladorAdmin extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(ControladorAdmin.class.getName());
	
	/** The produto service. */
	private ProdutoServiceImpl produtoService = new ProdutoServiceImpl();
	


	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Estoy en ControladorAdmin doGet");
		   Produto p =null;
		   String action = request.getParameter("action");
		   try {
		    if (action != null) {
		        switch (action) {
		            case "softdelete":
		            	
		            	p=produtoService.findById(Long.parseLong(request.getParameter("id")));
		            	produtoService.softDelete(p.getId());
		                    break;
		                case "editar":
		                	p=produtoService.findById(Long.parseLong(request.getParameter("id")));
		                    break;
		                default:
		               break;
		        }
			       
		    }
		    // Actualizar la lista de productos y redirigir a admin.jsp
		    List<Produto> listaProductos = produtoService.findAll();
	        request.setAttribute("productos", listaProductos);
	        request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	        
		    }catch(Data2Exception e) {
		        	e.printStackTrace();
				 }
		   
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.info("Estoy en ControladorAdmin Post");

		Produto produto = new Produto();
		String action =request.getParameter("action");
		// Para imágenes
		if(action !=null && action.equals("guardar")) {
		if (request.getContentType() != null && 
			    request.getContentType().toLowerCase().indexOf("multipart/form-data") > -1 ) 
			{
		            // para gardar o nome do ficheiro:
		           String fileName="";
		           for (Part part : request.getParts()) {	   
		                fileName= part.getSubmittedFileName();
				if (fileName !=null && !fileName.equals("")) {
		                        String fileExtension = fileName.substring(fileName.indexOf('.'));
					fileName += "__"+UUID.randomUUID().toString()+fileExtension;
					part.write(fileName);
					produto.setFoto(fileName);

				} else {
					String[] valor = request.getParameterValues(part.getName());

					if (valor != null) {
						for (String param : valor) {
							switch (part.getName()) {
							case ("id"):
								if (!param.equals("") && param != null) {
									produto.setId(Long.parseLong(param));
								}
								break;

							case ("nome"):
								produto.setNome(param);
								break;

							case ("prezo"):
								produto.setPrezo(Double.parseDouble(param));
								break;

							case ("desconto"):
								produto.setDesconto(Integer.parseInt(param));
								break;

							case ("coste"):
								produto.setCoste(Double.parseDouble(param));
								break;

							case ("iva"):
								produto.setIva(Integer.parseInt(param));
								break;

							case ("stock"):
								produto.setStock(Integer.parseInt(param));
								break;

							case ("baixa"):
								produto.setBaixa(Boolean.parseBoolean(param));
								break;

							}
						}

					}

				}

			}

		}
		produto.setIdCategoria((int)1);
		produto.setIdMarca((long)1);
		try {
			if (produto.getId() != null) {
				produtoService.update(produto);
			}else {
				produtoService.create(produto);
			}
		}catch (Exception e) {
			
		}
		
	}
		doGet(request, response);
}
}
