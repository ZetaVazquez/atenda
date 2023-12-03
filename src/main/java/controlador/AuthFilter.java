package controlador;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


/**
 * Filtro de autenticación e autorización
 */
@WebFilter("/*")
public class AuthFilter implements Filter {
	private HttpServletRequest httpRequest;
	private Hashtable<String, String[]> taboaAutorizacions;

	public AuthFilter() {
	}
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// para logging
		httpRequest = (HttpServletRequest) request; 
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());        

		// obteño a sesión SEN crear unha nova
		HttpSession session = httpRequest.getSession(false);

		// se non hai session ou non hai user fago que o user sexa anonymous
		if (session == null || session.getAttribute("user")==null ) {
			session =  httpRequest.getSession(true);
			session.setAttribute("user", "anonymous");
			session.setAttribute("rol", "ANON");
		}

		boolean isAuthorised = isAuthorised((String)session.getAttribute("rol"), path);
		boolean isAnonymous = (session != null && session.getAttribute("rol").equals("ANON"));

	//	chain.doFilter(request, response);

		if (!isAuthorised && isAnonymous) {
			// se non está autorizado e é o usuario anonymous, despachamos á vista de login
			String loginPage = "/";
			RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
			dispatcher.forward(request, response);
		} else if (!isAuthorised) {
			// senon é anonymous e non está autorizado despachamos ao controlador principal
			httpRequest.getRequestDispatcher("/").forward(request, response);

		} else {
			// se está autorizado, invocamos ao seguinte filtro na cadea ... acaba
			chain.doFilter(request, response);
		}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// construo a taboa de autorizacións que conten para cada rol
		// unha lista das urls de controlador autorizadas
		taboaAutorizacions = new Hashtable<String, String[]>();
		String[] urlsADMIN= {"/favicon.ico", "/login", "/logout", "/", "/admin", "/images/*"};
		String[] urlsBASIC= {"/favicon.ico", "/logout", "/", "/images/*"};
		String[] urlsANON =  {"/favicon.ico","/login", "/","/images/*"};
		taboaAutorizacions.put("BASIC", urlsBASIC);
		taboaAutorizacions.put("ADMIN", urlsADMIN);
		taboaAutorizacions.put("ANON", urlsANON);	
	}
	private boolean isAuthorised(String _rol, String _url) {
		// recorro o Hashtable de roles e listas de urls autorizadas comprobando 
		// se as urls autorizadas para o _rol do parámetro incluen a 
		// url enviada como parámetro _url
		for (Map.Entry<String, String[]> entrada : taboaAutorizacions.entrySet()) {
			String rol = entrada.getKey();
			String[] urls = entrada.getValue();
			if (rol.equals(_rol)) {
				for (String url : urls) {           		
					if (url.equals(_url) ) {
						// se coincide a url solicitada coa almacenada na taboa 
						// autorizo a petición
						return true;
					}
				}
			}
		}
		return false;
	}

}