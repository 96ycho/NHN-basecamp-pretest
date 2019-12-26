package pretest.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Writing;

/**
 * Servlet implementation class Board
 */
@WebServlet("/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
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
		String read_sql = "select id, title, name, write_date, mod_date from board order by id desc";
		
		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			conn = DriverManager.getConnection(
					sc.getInitParameter("url"), 
					sc.getInitParameter("user"), 
					sc.getInitParameter("password"));
			stmt = conn.createStatement();
			rs = stmt.executeQuery(read_sql);
			
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			ArrayList<Writing> writings = new ArrayList<Writing>();
			while(rs.next()) {
				Writing w = new Writing();
				w = w.setId(rs.getInt("id"))
						.setTitle(rs.getString("title"))
						.setName(rs.getString("name"))
						.setWriteDate(rs.getTimestamp("write_date"))
						.setModDate(rs.getTimestamp("mod_date"));
				writings.add(w);
			}
			request.setAttribute("writings", writings);
			RequestDispatcher rd = request.getRequestDispatcher("/board.jsp");
			rd.include(request, response);
		} catch(Exception e) {
			throw new ServletException(e);
		} finally {
			try {if (stmt != null) rs.close();} catch(Exception e) {}
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (stmt != null) conn.close();} catch(Exception e) {}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
