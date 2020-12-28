package service;

import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;

import datalayer.FileHandler;

public class Service {
	FileHandler obj1 = new FileHandler();
 
	public boolean create(String path,String key,Object value) throws IOException {
		Map<String,Object> map = new HashMap<>();
		map.put(key, value);
		Gson gson = new Gson(); 
		String jsonFromMap = gson.toJson(map);
		if(obj1.isFileExists(path)) {
			return false;
		}
		else {
			obj1.fileCreate(path);
			return true;
		}
	}
	
	public boolean create(String key,String value) throws IOException {
		obj1.fileCreate(null);
		return true;
	}
	public static void main(String[] args) throws IOException {
		Service obj = new Service();
		obj.create("G:\\pallavi.txt", "name", "pallavi");
		        
	}
}
