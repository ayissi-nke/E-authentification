package com.sms;

import java.util.Random;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;


public class SendMessages {
	
	
	
	public static final String ACCOUNT_SID = "ACf5a59c138f266bb3b858b9140d9ec5c5";
	  public static final String AUTH_TOKEN = "d5df8986893d0e03ade80a91ada17b0f";
	  
	  public static void main(String[] args) {
		    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		    Message message = Message.creator(new PhoneNumber("+237699146458"),
		        new PhoneNumber("+13342924148"), 
		        otpGenerator()).create();
		    
		    System.out.println(message.getSid());
		  }
	  
	  
	  
	   static String otpGenerator(){ 
	  
	      String numbers = "0123456789"; 
	      String x="";
	      Random rndm_method = new Random(); 
	      char[] otp = new char[4]; 
	      for (int i = 0; i <4; i++) 
	      { 
	          otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length())); 
	          x=x+otp[i];
	          
	      } 
	      
	      System.out.println(x);
	      
;
	      return x; 
	  }
	  
	  
		}
		  
	   
	
	

