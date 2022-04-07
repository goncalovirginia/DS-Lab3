package sd2122.aula3.clients;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import sd2122.aula3.api.User;
import sd2122.aula3.api.service.RestUsers;

import java.io.IOException;
import java.net.URI;

public class UpdateUserClient {
	
	public static void main(String[] args) throws IOException {
		
		if (args.length != 6) {
			System.err.println("Use: java sd2122.aula2.clients.UpdateUserClient url userId oldpwd fullName email password");
			return;
		}
		
		String serverUrl = args[0];
		String userId = args[1];
		String password = args[2];
		String newFullName = args[3];
		String newEmail = args[4];
		String newPassword = args[5];
		
		User updatedUser = new User(userId, newFullName, newEmail, newPassword);
		
		System.out.println("Sending request to server.");
		User user = (new RestUsersClient(URI.create(serverUrl))).updateUser(userId, password, updatedUser);
		System.out.println("Success:");
		System.out.println("User : " + user);
	}
	
}
