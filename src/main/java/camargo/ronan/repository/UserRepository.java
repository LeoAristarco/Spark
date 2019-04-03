package camargo.ronan.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camargo.ronan.model.User;

public class UserRepository {
	
	private static UserRepository instance;
	
	public static UserRepository instance() {
		if (instance == null) {
			instance = new UserRepository();
		}
		return instance;		
	}	
	
	private List<User> users;
	
	private UserRepository() {
		users = new ArrayList<User>();
		users.add(new User("Juan", "Perez"));
		users.add(new User("Jose", "Gonzalez"));		
	}
	
	public List<User> allUsers(){
		return users;
	}
	
	public List<User> findUsersByName(String name){
		return users.stream()
				.filter(user -> user.getFirstName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}
	
	public void createUser(User user) {
		users.add(user);
	}
	
	public List<User> findUsersLikeLastName(String query){
		return users.stream()
				.filter(user -> user.getLastName().contains(query))
				.collect(Collectors.toList());
	}
	
}
