package pretest.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Write
 */
@WebServlet("/Write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Write() {
        super();
        // TODO Auto-generated constructor stub
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null; 
		PreparedStatement stmt = null;
		String db_url = "jdbc:mysql://localhost/studydb";
		String u_id = "eunji";
		String u_pass = "11111";
		String write_sql = "insert into board(name, email, password, title, text) values(?, ?, ?, ?, ?)";
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(db_url, u_id, u_pass);
			stmt = conn.prepareStatement(write_sql);
			stmt.setString(1, request.getParameter("name"));
			stmt.setString(2, request.getParameter("email"));
			stmt.setString(3, request.getParameter("password"));
			stmt.setString(4, request.getParameter("title"));
			stmt.setString(5, request.getParameter("content"));
			stmt.executeUpdate();
		} catch(Exception e) {
			throw new ServletException(e);
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (stmt != null) conn.close();} catch(Exception e) {}
		}
		
	}

}
