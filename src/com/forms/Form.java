package com.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



public class Form {
	
	
    private String result ;
   
	private   Map<String, String> error = new HashMap<String , String>();
	
	  public String getResult() {
			return result;
		}


		public Map<String, String> getError() {
			return error;
		}

    
    
    public User userverification(HttpServletRequest request){
    	
    	String email = request.getParameter("email");
        String motDePasse = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");
        String nom = request.getParameter("name");
        String tel =request.getParameter("phonenumber");

		 
    	User user = new User();
    	
    	try {
			emailverification(email);
		} catch (Exception e) {
	     seterror("email",e.getMessage());
		}
    	
    	user.setEmail(email);
    	 
    	
    	try {
			phonenumberverification(tel);
		} catch (Exception e) {
			seterror("phonenumber", e.getMessage());
		}
    	
    	try {
			passwordverification(motDePasse,confirmation);
		} catch (Exception e) {
			seterror("password",e.getMessage());
			 seterror( "confirmation", null );

		}
    	
    	user.setPassword(motDePasse);
    	
    	
    	try {
			nameverification(nom);
		} catch (Exception e) {
		  seterror("name",e.getMessage() );
		}
    	user.setName(nom);
    	
    	 if ( error.isEmpty() ) {
    	        result = "Succ�s de l'inscription.";
    	    } else {
    	        result = "�chec de l'inscription.";
    	    }

    	
    	return user ;
    
    } 


	private void phonenumberverification(String tel) throws Exception {
		if(tel!=null){
			if (tel.length()!=9) {
				throw new Exception("enter a valid number with 9digit");
			}
		}
		
	}


	private void nameverification(String nom) throws Exception {
		if (nom!=null) {
			if(nom.length()<3) {
				throw new Exception("enter a password with atleast 3 letters"); 
			}
		  
		}
		
		else {
			throw new Exception("enter a passwoed");
		}
		
	}


	private void passwordverification(String motDePasse,String confirmation) throws Exception {
		if (motDePasse!=null || confirmation!=null ) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("passords missmatching");
			}
			
		
		}
		
		else {
			throw new Exception("enter a password");
			
		}
		
	}


	private void seterror(String champ, String message) {
		
		error.put(champ, message);
	}



	private void emailverification(String email) throws Exception {
		   if ( email != null ) {
		        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
		            throw new Exception( " saisir une adresse mail valide." );
		        }
		    } else {
		        throw new Exception( "Merci de saisir une adresse mail." );
		    }

			
		}
		
	}
    
    
    

