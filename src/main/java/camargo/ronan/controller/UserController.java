package camargo.ronan.controller;

import java.util.List;

import com.google.gson.Gson;

import camargo.ronan.model.User;
import camargo.ronan.repository.UserRepository;
import spark.Request;
import spark.Response;

public class UserController {
	
	private static Gson GSON = new Gson();
	private static String CONTENT_TYPE = "Content-Type";
	private static String APPLICATION_JSON = "application/json"; 
	
	private UserRepository userRepository = UserRepository.instance();	
	
	
	public List<User> users(Request request, Response response){
		return userRepository.allUsers();
	}
	
	public List<User> usersByName(Request request, Response response){
		String name = request.params("name");
		response.header(CONTENT_TYPE, APPLICATION_JSON);
		
		return userRepository.findUsersByName(name); 
	}
	
	public String createUser(Request request, Response response) {
		User user = GSON.fromJson(request.body(), User.class);
		
		userRepository.createUser(user);
		return "Usuario creado correctamente: " + user.getFirstName() + ", " + user.getLastName();
	}
	
}
