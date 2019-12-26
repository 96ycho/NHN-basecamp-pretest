package pretest.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Writing;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null; 
		Statement stmt = null;
		ResultSet rs = null;
		String select_sql = "select id, name, email, password, title, content from board where id="+request.getParameter("id");
		
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
			request.setCharacterEncoding("UTF-8");

			Writing w = new Writing();
			w = w.setId(rs.getInt("id"))
					.setTitle(rs.getString("title"))
					.setName(rs.getString("name"))
					.setEmail(rs.getString("email"))
					.setPassword(rs.getString("password"))
					.setContent(rs.getString("content"));
			request.setAttribute("writing", w);
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.include(request, response);
		} catch(Exception e) {
			throw new ServletException(e);
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (stmt != null) conn.close();} catch(Exception e) {}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null; 
		PreparedStatement stmt = null;
		String write_sql = "update board set name=?, email=?, password=?, title=?, content=? where id=?";
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			conn = DriverManager.getConnection(sc.getInitParameter("url"), sc.getInitParameter("user"), sc.getInitParameter("password"));
			stmt = conn.prepareStatement(write_sql);
			stmt.setString(1, request.getParameter("name"));
			stmt.setString(2, request.getParameter("email"));
			stmt.setString(3, request.getParameter("password"));
			stmt.setString(4, request.getParameter("title"));
			stmt.setString(5, request.getParameter("content"));
			stmt.setInt(6, Integer.parseInt(request.getParameter("id")));
			stmt.executeUpdate();
			response.sendRedirect("board");
		} catch(Exception e) {
			throw new ServletException(e);
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (stmt != null) conn.close();} catch(Exception e) {}
		}
	}

}
