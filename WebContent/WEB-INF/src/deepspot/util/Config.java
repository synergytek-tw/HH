package deepspot.util;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Config extends HttpServlet {
	public  static ServletContext ctx;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ctx   = config.getServletContext();
		System.out.println(" !! Container Context Init !!");
	}
}