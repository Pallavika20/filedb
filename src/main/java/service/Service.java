package service;

import java.io.*;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import datalayer.FileHandler;
import ExCeption.FileDBException;

public class Service {
	Gson gson = new Gson(); 
	FileHandler obj1 = new FileHandler();
	FileReader fr;
	FileWriter fw;
	Map<String, Object> dbValue;
	
	
	/**
	 * 
	 * @param path
	 * @param key
	 * @param value
	 * @return Path where the file is generated
	 * @throws IOException
	 * 
	 * Checks for path to create if path not exists create a new file and return's the path where it got saved. 
	 * @throws InvalidkeyException 
	 */

	public void create(String path, String key, Object value) throws IOException, FileDBException {
		
		checkInitialConditions(path, key);
		dbValue = getDbValue(path);
		if(dbValue.containsKey(key))
			throw new FileDBException("Key aldready exists");
		dbValue.put(key, value);
		saveMapInDB(dbValue, path);
		}
	public Object get(String path,String key) throws FileDBException, IOException  {
		dbValue = getDbValue(path);
		if(dbValue.containsKey(key))
			return dbValue.get(key);
		else {
			throw new FileDBException("Key doesn't Exists");
		}
		}
	
	public Object remove(String path,String key) throws FileDBException, IOException  {
		dbValue = getDbValue(path);
		if(dbValue.containsKey(key))
			return dbValue.remove(key);
		else {
			throw new FileDBException("Key doesn't Exists");
		}
		}
	
	private void saveMapInDB(Map<String, Object> dbValue, String path) throws IOException {
	  String db = gson.toJson(dbValue);
	  FileWriter fw = new FileWriter(path);
	  fw.write(db);
	  fw.close();
	}
    

	public Map<String, Object> getDbValue(String path) throws IOException {
		Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
		String st = obj1.strbuilder(path);
		dbValue = gson.fromJson(st, mapType);
		return dbValue;
	}
	private void checkInitialConditions(String path, String key) throws FileDBException, IOException {
		File file = new File(path);
		obj1.keyChecker(key);
		if(obj1.isFileExists(path)) {
			sizeChecker(file);
		}
		else {
			file.createNewFile();
		}
	}
	
	public boolean sizeChecker(File file) {
		return ((double) file.length() / (1024 * 1024) < 1024);	
	}
	
}
	

