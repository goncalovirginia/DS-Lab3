package sd2122.aula3.clients;

import sd2122.aula3.api.User;
import util.Debug;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateUserClient {
	
	private static final Logger Log = Logger.getLogger(CreateUserClient.class.getName());
	
	static {
		System.setProperty("java.net.preferIPv4Stack", "true");
	}
	
	public static void main(String[] args) throws IOException {
		Debug.setLogLevel(Level.FINE, Debug.SD2122);
		
		if (args.length != 5) {
			System.err.println("Use: java sd2122.aula3.clients.CreateUserClient url userId fullName email password");
			return;
		}
		
		String serverUrl = args[0];
		String userId = args[1];
		String fullName = args[2];
		String email = args[3];
		String password = args[4];
		
		User user = new User(userId, fullName, email, password);
		
		System.out.println("Sending request to server.");
		System.out.println("Result: " + (new RestUsersClient(URI.create(serverUrl))).createUser(user));
	}
	
}
