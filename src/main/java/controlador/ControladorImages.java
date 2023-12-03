package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;

import java.io.IOException;

import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class controladorImages.
 */
@WebServlet("/images/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10, // 10 MB
maxRequestSize = 1024 * 1024 * 15, // 15 MB
location = "c:/ficheros/images")
public class ControladorImages extends HttpServlet {
	
	/** The Constant logger. */
	private static final Logger logger= Logger.getLogger(ControladorImages.class.getName());
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new controlador images.
     *
     * @see HttpServlet#HttpServlet()
     */
    public ControladorImages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String filename=request.getParameter("foto");
    	if (filename != null) {
        File file = new File("C:/ficheros/images",filename);
        response.setHeader("Content-Type",getServletContext().getMimeType(filename));
        response.setHeader("Content-Length",String.valueOf(file.length()));
        response.setHeader("Content-Disposition","inline; filename=\""+file.getName()+"\"");
    	}else {
    		logger.info("el controlador no encuentra imágenes");
    	}
        
    	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.getWriter().append(request.getParameter("foto"));
	}

}
