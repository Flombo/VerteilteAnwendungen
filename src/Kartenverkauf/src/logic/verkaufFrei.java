package logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verkauffrei")
public class verkaufFrei extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Kartenverkauf kartenverkauf = (Kartenverkauf)getServletContext().getAttribute("kartenverkauf");
			int index = Integer.parseInt(request.getParameter("seatID"));
			kartenverkauf.verkauf(index);
	        response.sendRedirect("index.jsp");
		} catch (IllegalArgumentException ie){
			request.setAttribute("errorMsg", ie.getLocalizedMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
