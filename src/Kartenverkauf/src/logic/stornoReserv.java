package logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/stornoReserv")
public class stornoReserv extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Kartenverkauf kartenverkauf = (Kartenverkauf)getServletContext().getAttribute("kartenverkauf");
			kartenverkauf.stornoAllReserv();
			response.sendRedirect("index.jsp");
		} catch (IllegalArgumentException ie){
			request.setAttribute("errorMsg", ie.getLocalizedMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
