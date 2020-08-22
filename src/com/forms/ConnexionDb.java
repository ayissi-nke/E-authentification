package com.forms;

import java.sql.*;




public class ConnexionDb {
	
	private String url="jdbc:mysql://localhost:3306/athyusers";	
	private String passwd="joel";
	private String user	="root";
	private static Connection connexion ;
	
	
	private ConnexionDb() {
		
		
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    e.printStackTrace();
		}
		
		try {
			connexion = DriverManager.getConnection(url, user, passwd);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
	}
	
	
	public static Connection getinstance(){
		
		if (connexion==null) {
			new ConnexionDb();
		}
		
		return connexion ;
		
	}
	
	
	public static void registerusers(User user,Connection connexion){
		
		 
		
		try {
			
			PreparedStatement prepareState = connexion.prepareStatement("INSERT INTO user(name,email)VALUES(?,?)");
			prepareState.setString(1,user.getName());
			prepareState.setString(2,user.getEmail());
		   	prepareState.executeUpdate();
		
		    
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	

}
