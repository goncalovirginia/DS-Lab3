package sd2122.aula3.clients;

import sd2122.aula3.api.User;
import util.Debug;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;

public class SearchUsersClient {
	
	static {
		System.setProperty("java.net.preferIPv4Stack", "true");
	}
	
	public static void main(String[] args) throws IOException {
		Debug.setLogLevel(Level.FINE, Debug.SD2122);
		
		if (args.length != 2) {
			System.err.println("Use: java sd2122.aula3.clients.SearchUsersClient url userId ");
			return;
		}
		
		String serverUrl = args[0];
		String pattern = args[1];
		
		System.out.println("Sending request to server.");
		List<User> users = (new RestUsersClient(URI.create(serverUrl))).searchUsers(pattern);
		System.out.printf("Success: (%d users)\n", users.size());
		users.forEach(System.out::println);
	}
	
}
