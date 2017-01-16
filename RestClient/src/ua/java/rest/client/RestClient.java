package ua.java.rest.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestClient {
	
	final private static String URL = "http://localhost:8080/RestCalcServer/calc/1+1";
	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		
		String response = target.request(MediaType.TEXT_XML).get(String.class);
		
		System.out.print(response);
	}
}