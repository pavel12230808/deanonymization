package org.prairieview.relinking;

/**
 * Servlet implementation class Result
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Simpleform
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, FileNotFoundException, IOException {
		//response.setContentType( "text/html" );
	    // processing the request not shown...
		
		try {
		
		String filename_auxs = "/WEB-INF/Auxiliary_Src.txt";
        ServletContext context = getServletContext();
        InputStream is = context.getResourceAsStream(filename_auxs);
        String text_auxs = null;
        if (is != null) {
        		System.out.println("resding");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            text_auxs = reader.readLine();
        }
        
        System.out.println(text_auxs);
        
        String filename_auxd = "/WEB-INF/Auxiliary_Dest.txt";
        InputStream is2 = context.getResourceAsStream(filename_auxd);
        String text_auxd = null;
        if (is2 != null) {
            InputStreamReader isr = new InputStreamReader(is2);
            BufferedReader reader = new BufferedReader(isr);
            text_auxd = reader.readLine();
        }
        
        System.out.println(text_auxd);
        
        String filename_tars = "/WEB-INF/TargetUser_Src.txt";
        InputStream is3 = context.getResourceAsStream(filename_tars);
        String text_tars = null;
        if (is3 != null) {
            InputStreamReader isr = new InputStreamReader(is3);
            BufferedReader reader = new BufferedReader(isr);
            text_tars = reader.readLine();
        }
        
        System.out.println(text_tars);
        
        String filename_tard = "/WEB-INF/TargetUser_Dest.txt";
        InputStream is4 = context.getResourceAsStream(filename_tard);
        String text_tard = null;
        if (is4 != null) {
            InputStreamReader isr = new InputStreamReader(is4);
            BufferedReader reader = new BufferedReader(isr);
            text_tard = reader.readLine();
        }
        
        System.out.println(text_tard);
        
        String filename_matcha = "/WEB-INF/AuxilaryUserID.txt";
        InputStream is5 = context.getResourceAsStream(filename_matcha);
        String text_matcha = null;
        if (is5 != null) {
            InputStreamReader isr = new InputStreamReader(is5);
            BufferedReader reader = new BufferedReader(isr);
            text_matcha = reader.readLine();
        }
        
        System.out.println(text_matcha);
        
        
        String filename_matcht = "/WEB-INF/TargetUserID.txt";
        InputStream is6 = context.getResourceAsStream(filename_matcht);
        String text_matcht = null;
        if (is6 != null) {
            InputStreamReader isr = new InputStreamReader(is6);
            BufferedReader reader = new BufferedReader(isr);
            text_matcht = reader.readLine();
        }
        String filename_acc = "/WEB-INF/Acc.txt";
        InputStream isacc = context.getResourceAsStream(filename_acc);
        String text_acc = null;
        if (isacc != null) {
            InputStreamReader isac = new InputStreamReader(isacc);
            BufferedReader readeracc = new BufferedReader(isac);
            text_acc = readeracc.readLine();
        }
        System.out.println( text_matcht);
        
        System.out.println("Into result servlet");
	
		request.getSession().setAttribute("val_auxs",text_auxs);
		request.getSession().setAttribute("val_auxd",text_auxd);
		request.getSession().setAttribute("val_tars",text_tars);
		request.getSession().setAttribute("val_tard",text_tard);
		request.getSession().setAttribute("val_matcha",text_matcha);
		request.getSession().setAttribute("val_matcht",text_matcht);
		request.getSession().setAttribute("val_acc",text_acc);
		
		}
		catch(FileNotFoundException ex){
			System.out.println("File not found");
		}
		
		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/views/result.jsp");
		
	    dispatcher.forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
