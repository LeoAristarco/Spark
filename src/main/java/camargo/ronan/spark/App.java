package camargo.ronan.spark;

import static spark.Spark.get;
import static spark.Spark.init;
import static spark.Spark.port;
import static spark.Spark.post;

import com.google.gson.Gson;

import camargo.ronan.controller.UserController;

public class App 
{
    public static void main( String[] args )
    {
    	port(9000);
    	init();
  	
    	UserController userController = new UserController();
    	
    	Gson gson = new Gson();
    	
    	get("/user/all", userController::users, gson::toJson);
    	get("/user/:name", userController::usersByName, gson::toJson);
    	post("/user", userController::createUser);
    	
    }
}
