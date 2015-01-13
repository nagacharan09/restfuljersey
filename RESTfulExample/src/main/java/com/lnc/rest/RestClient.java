package com.lnc.rest;
import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RestClient {
	public static void main(String[] args) {
		try {

			User user = new User("Adriana", "Barrer");

			Client client = Client.create();

			
			// get method 
			
			/*WebResource webResource = client
					.resource("http://localhost:8080/RESTfulExample/rest/usersdata/user/charan");
			ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
			*/
			
			
			// Post method with xml data
			
			WebResource webResource = client.resource("http://localhost:8080/RESTfulExample/rest/usersdata/users");
			ClientResponse response = webResource.accept("application/xml").post(ClientResponse.class, user);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Server response : \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}