package pretest.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Writing;

/**
 * Servlet implementation class Password
 */
@WebServlet("/Password")
public class Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("id", request.getParameter("id"));
		RequestDispatcher rd = request.getRequestDispatcher("/password.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null; 
		Statement stmt = null;
		ResultSet rs = null;
		String select_sql = "select password from board where id="+request.getParameter("id");
		
		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			conn = DriverManager.getConnection(
					sc.getInitParameter("url"), 
					sc.getInitParameter("user"), 
					sc.getInitParameter("password"));
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_sql);
			rs.next();
			
			response.setContentType("text/html; charset=UTF-8");
			String pass = rs.getString("password");
			String input_pass = request.getParameter("password");
			
			if(pass.equals(input_pass)) {
				//RequestDispatcher rd = request.getRequestDispatcher("/Update");
				//rd.forward(request, response);
				response.sendRedirect("update?id="+request.getParameter("id"));
			}else {
				String url = "/pretest/password?id="+request.getParameter("id");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('비밀번호가 올바르지 않습니다.'); location.href='");
				out.println(url+"'; </script>");
				out.flush();
			}
		} catch(Exception e) {
			throw new ServletException(e);
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (stmt != null) conn.close();} catch(Exception e) {}
		}
	}

}
