package com.emails;

import com.sendgrid.*;
import java.io.IOException;

public class SendEmails {
	
	public static void main(String[] args) throws IOException {
	    Email from = new Email("test@example.com");
	    String subject = "TEST OK";
	    Email to = new Email("ayissi.nke.joel@gmail.com");
	    Content content = new Content("text/plain", "TO GOD be the GLORY");
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid("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");
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
	  }
}
