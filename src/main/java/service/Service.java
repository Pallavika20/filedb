package service;

import java.io.*;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import datalayer.FileHandler;
import datalayer.FileStorageStructure;
import ExCeption.FileDBException;

public class Service {
	Gson gson = new Gson(); 
	FileHandler obj1 = new FileHandler();
	FileReader fr;
	FileWriter fw;
	Map<String, FileStorageStructure> dbValue;
	
	
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
	
	private FileStorageStructure getFileStorageStructure(Object value,Instant time) {
		FileStorageStructure fss = new FileStorageStructure();
		fss.setData(value);
		fss.setTime(time);
		return fss;
		
	}
	
	public Object get(String path,String key) throws FileDBException, IOException  {
		dbValue = getDbValue(path);
		if(dbValue.containsKey(key))
			return dbValue.get(key);
		else {
			throw new FileDBException("Key doesn't Exists");
		}
		}
	
	public void delete(String path,String key) throws FileDBException, IOException  {
		dbValue = getDbValue(path);
		if(dbValue.containsKey(key)) {
			dbValue.remove(key);
			saveMapInDB(dbValue, path);
		}
		else {
			throw new FileDBException("Key doesn't Exists");
		}
		}
	
	private void saveMapInDB(Map<String, FileStorageStructure> dbValue, String path) throws IOException {
	  String db = gson.toJson(dbValue);
	  
	  FileWriter fw = new FileWriter(path);
	  fw.write(db);
	  fw.close();
	}
    

	public Map<String, FileStorageStructure> getDbValue(String path) throws IOException {
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

	public void create(String path, String key, Object value, Instant time) throws FileDBException, IOException {
		checkInitialConditions(path, key);
		dbValue = getDbValue(path);
		if(dbValue.containsKey(key))
			throw new FileDBException("Key aldready exists");
		System.out.println(Instant.now());
		dbValue.put(key, getFileStorageStructure( value,time));
		saveMapInDB(dbValue, path);
	}
	
}
	

