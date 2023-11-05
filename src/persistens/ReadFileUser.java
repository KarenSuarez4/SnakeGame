package persistens;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import model.User;

public class ReadFileUser {
	
	public ArrayList<User> readMyFile(String file) throws FileNotFoundException  {	
		JsonReader reader = new Gson().newJsonReader(new FileReader(file));
		
		Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
		ArrayList<User> informationGame = new Gson().fromJson(reader, userListType);  
		
		return informationGame;
	}
}
