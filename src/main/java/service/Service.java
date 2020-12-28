package service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import datalayer.FileHandler;

public class Service {
	FileHandler obj1 = new FileHandler();
 
	public boolean create(String path,String key,Object value) throws IOException {
		if(path==null) {
			path = obj1.customisePath(path);
		}
		if(obj1.isFileExists(path)) {
			Map<String,Object> map = new HashMap<>();
			map.put(key, value);
			Gson gson = new Gson(); 
			String jsonFromMap = gson.toJson(map);
			fileWrite(jsonFromMap,path,key);
			return false;
		}
		else {
			path = obj1.fileCreate(path);
			Map<String,Object> map = new HashMap<>();
			map.put(key, value);
			Gson gson = new Gson(); 
			String jsonFromMap = gson.toJson(map);
			fileWrite(jsonFromMap,path,key);
			return true;
		}
		
	}
	
	public void fileWrite(String son,String path,String key) throws IOException {
		try {
			if(obj1.keyChecker(key)) {
				FileWriter fw = new FileWriter(path);
				fw.write(son);
				fw.close();
			}
		}
		catch(Exception e) {
			System.out.print("");
		}
		
	}
	
	
	
	public boolean create(String key,String value) throws IOException {
		obj1.fileCreate(null);
		return true;
	}
	public static void main(String[] args) throws IOException {
		Service obj = new Service();
		System.out.print(obj.create(null, "pallavi", "name"));
		        
	}
}
