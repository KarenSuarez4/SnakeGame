package persistens;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import model.InformationGame;

public class ReadFile {
	
	public ArrayList<InformationGame> readMyFile(String file) throws FileNotFoundException  {	
		JsonReader reader = new Gson().newJsonReader(new FileReader(file));
		
		Type userListType = new TypeToken<ArrayList<InformationGame>>(){}.getType();
		ArrayList<InformationGame> informationGame = new Gson().fromJson(reader, userListType);  
		
		return informationGame;
	}
}
