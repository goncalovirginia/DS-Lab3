package sd2122.aula3.clients;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.glassfish.jersey.client.ClientConfig;
import sd2122.aula3.api.User;
import sd2122.aula3.api.service.RestUsers;

import java.io.IOException;
import java.net.URI;

public class GetUserClient {
	
	public static void main(String[] args) throws IOException {
		
		if (args.length != 3) {
			System.err.println("Use: java sd2122.aula2.clients.GetUserClient url userId password");
			return;
		}
		
		String serverUrl = args[0];
		String userId = args[1];
		String password = args[2];
		
		System.out.println("Sending request to server.");
		User u = (new RestUsersClient(URI.create(serverUrl))).getUser(userId, password);
		System.out.println("Success:");
		System.out.println("User : " + u);
	}
	
}
