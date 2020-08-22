package com.buea.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forms.ConnexionDb;
import com.forms.User;
import com.forms.Form;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp") 
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  public	final String ATT_USER = "user";
  public  final String ATT_FORM = "form";

 public  Connection connexion;

private String resultat;
  
    
       
    /**  
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/signup.jsp" ).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		Form form = new Form();
		User user = form.userverification(request);
		resultat=form.getResult();
		
		System.out.println(form.getResult());
		System.out.println(form.getResult());
		
		 
		if(form.getError().isEmpty()){
			connexion = ConnexionDb.getinstance();
			ConnexionDb.registerusers(user,connexion);
			
			this.getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
		}
		
		else{
	
			request.setAttribute("user", user);
			request.setAttribute("form", form);
			request.setAttribute("resultat", resultat);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/signup.jsp" ).forward( request, response );
			
		}
		

		
		
		
		

		

		 
		

	}
 
}
