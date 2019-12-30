package pretest.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.WritingDao;

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
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("id", request.getParameter("id"));
		RequestDispatcher rd = request.getRequestDispatcher("/password.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null; 
		
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");

			WritingDao writingDao = new WritingDao();
			writingDao.setConnection(conn);
			String pass = writingDao.getPassword(Integer.parseInt(request.getParameter("id")));
			String input_pass = request.getParameter("password");
			
			if(pass.equals(input_pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("id", request.getParameter("id"));
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
		} 
	}

}
