package org.prairieview.relinking;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prairieview.*;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(urlPatterns="/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
        
	       dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String webInfPath = getServletConfig().getServletContext().getRealPath("WEB-INF");
		System.out.println("Web-INF path" + webInfPath);
		String seedsCount = request.getParameter("seeds");
		String keepSeeds = request.getParameter("keepSeeds");
		String profile = request.getParameter("profile");
		String centrality = request.getParameter("centrality");
		boolean keepSeedsBool= "Y".equals(keepSeeds);
		boolean profileFunction= "Y".equals(profile);
		boolean centralityFunction= "Y".equals(centrality);
		int count = 0;
        boolean hasError = false;
		count = Integer.parseInt(seedsCount);
		PrintWriter out = response.getWriter();
		if(request.getParameter("profile") == null && request.getParameter("centrality") == null) {
			out.println("<meta http-equiv='refresh' content='3;URL=homeView.jsp'>");//redirects after 3 seconds
			out.println("<p style='color:red;'>PLease select one of the checkboxes!</p>");
		}
		else {
			SeedsPairing pairing = new SeedsPairing();
			try {
				pairing.readDataBase(count,keepSeedsBool,webInfPath, profileFunction, centralityFunction);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		getServletConfig().getServletContext().getRequestDispatcher("/Result").forward(request, response);
		/*if(hasError) {
			RequestDispatcher dispatcher //
            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/resultView.jsp");

    dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/result");
		}*/
	}

}
