package pretest.servlets;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppInitServlet
 */

public class AppInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppInitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException{
    	System.out.println("AppInitServlet Start...");
    	super.init(config);
    	
    	try {
    		ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			Connection conn = DriverManager.getConnection(
								sc.getInitParameter("url"), 
								sc.getInitParameter("user"), 
								sc.getInitParameter("password"));
			sc.setAttribute("conn", conn);
    	} catch(Throwable e) {
    		throw new ServletException(e);
    	}
    }
    
    @Override
    public void destroy() {
    	System.out.println("AppInitServlet Finish...");
    	super.destroy();
    	Connection conn = (Connection)this.getServletContext().getAttribute("conn");
    	
    	try {
    		if (conn!=null && conn.isClosed() == false) {
    			conn.close();
    		}
    	} catch(Exception e) {}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
