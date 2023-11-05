package persistens;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import model.User;


public class WriteFile {

	public void parseJSON(String file, ArrayList<User> user) throws FileNotFoundException{ 
		JsonReader reader = new Gson().newJsonReader(new FileReader(file));
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		String json = builder.create().toJson(user);
		PrintWriter print = new PrintWriter(file);		
		print.write(json);
		print.close();
	}
}
