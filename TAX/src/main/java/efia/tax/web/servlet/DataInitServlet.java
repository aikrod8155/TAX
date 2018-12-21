package efia.tax.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import efia.tax.service.DataService;


public class DataInitServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5591203588225250985L;
	
	
	private static final String CONTEXT_INIT="tax.init";
	
	public void init() throws ServletException{
		System.out.println("fuck your self");
		ServletContext servletContext  =this.getServletContext();
		WebApplicationContext applicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
		DataService dataService =(DataService)applicationContext.getBean("DataService");
		if(servletContext.getAttribute(CONTEXT_INIT)==null) {
			dataService.init();
			servletContext.setAttribute(CONTEXT_INIT, true);
		}
		
	}
}
