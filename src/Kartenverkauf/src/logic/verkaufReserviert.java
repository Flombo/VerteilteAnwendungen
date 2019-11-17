package logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class verkaufReserviert
 */
@WebServlet("/verkaufReserviert")
public class verkaufReserviert extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Kartenverkauf kartenverkauf = (Kartenverkauf)getServletContext().getAttribute("kartenverkauf");
			int seatID = Integer.parseInt(request.getParameter("seatID"));
			String besitzer = request.getParameter("reservierungsName");
			kartenverkauf.verkaufReserviert(seatID, besitzer);
			response.sendRedirect("index.jsp");
		} catch (IllegalArgumentException ie){
			request.setAttribute("errorMsg", ie.getLocalizedMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
