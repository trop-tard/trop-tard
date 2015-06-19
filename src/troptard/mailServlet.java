package troptard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query.FilterOperator;

@SuppressWarnings("serial")
public class mailServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    		
        throws IOException {
	    	 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    	 com.google.appengine.api.datastore.Query q = new com.google.appengine.api.datastore.Query("User");
	  		q.addFilter("moment",FilterOperator.NOT_EQUAL, null);
	  		PreparedQuery pq = datastore.prepare(q);
	
	  		ArrayList<Entity> user = new ArrayList<Entity>();
	  		for (Entity result : pq.asIterable()) {
	  			user.add(result);
	  		}
         
        try {
        	
        	for (int i = 0; i < user.size(); i++) {
				Properties props = new Properties();
				Session session = Session.getDefaultInstance(props, null);
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress("tropTard@gmail.com"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						user.get(i).getProperty("user_email").toString()));
				msg.setSubject("Evenement loopé");
				msg.setText("tu es le roi de looser du a loopé" + user.size()+" évenement: "+ "http://trop-tard.appspot.com/"+user.get(i).getProperty("user_id").toString() );
				Transport.send(msg);
			}

        } catch (MessagingException e) {

            e.printStackTrace();

        }

    }

}