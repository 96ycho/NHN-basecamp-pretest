package pretest.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WritingDao;
import vo.Writing;

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
		response.sendRedirect("write.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Connection conn = null; 
		
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			Writing w = new Writing();
			w = w.setName(request.getParameter("name"))
					.setEmail(request.getParameter("email"))
					.setPassword(request.getParameter("password"))
					.setTitle(request.getParameter("title"))
					.setContent(request.getParameter("content"));
			WritingDao writingDao = new WritingDao();
			writingDao.setConnection(conn);
			writingDao.insert(w);
			response.sendRedirect("board");
		} catch(Exception e) {
			throw new ServletException(e);
		} 
	}

}
