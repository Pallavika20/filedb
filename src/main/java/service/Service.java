package service;

import java.io.*;


import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import datalayer.FileHandler;
import datalayer.FileStorageStructure;
import ExCeption.FileDBException;
import accesslayer.FileDB;

public class Service {
	Gson gson = new Gson(); 
	FileHandler obj1 = new FileHandler();
	FileReader fr;
	FileWriter fw;
	Map<String, FileStorageStructure> dbValue;
	
	public synchronized void create(String key, Object value, Integer timeLimit) throws FileDBException, IOException {
		checkInitialConditions(key);
		dbValue = getDbValue();
		if(dbValue.containsKey(key))
			throw new FileDBException("Key aldready exists");
		dbValue.put(key, getFileStroageStructure(value, timeLimit));
		saveMapInDB(dbValue);
		
	}
		
	public synchronized Object get(String key) throws FileDBException, IOException  {
		dbValue = getDbValue();
		if(dbValue.containsKey(key)) {
			FileStorageStructure fileStorage = dbValue.get(key);
			if(fileStorage.getTime() != null && fileStorage.getTime() >= Calendar.getInstance().getTimeInMillis()) {
				return fileStorage.getData();
			}
			else if(fileStorage.getTime() == null) {
				return fileStorage.getData();
			}
			else{
				this.delete(key);
				throw new FileDBException("Deleted Key, Illegal Access");
			}
		}
		else {
			throw new FileDBException("Key doesn't Exists");
		}
		}
	
	public synchronized void delete(String key) throws FileDBException, IOException  {
		dbValue = getDbValue();
		if(dbValue.containsKey(key)) {
			dbValue.remove(key);
			saveMapInDB(dbValue);
		}
		else {
			throw new FileDBException("Key doesn't Exists");
		}
	}
	
	private void saveMapInDB(Map<String, FileStorageStructure> dbValue) throws IOException {
	  String db = gson.toJson(dbValue);
	  FileWriter fw = new FileWriter(FileDB.globalPath);
	  fw.write(db);
	  fw.close();
	}
    

	public Map<String, FileStorageStructure> getDbValue() throws IOException {
		Type mapType = new TypeToken<Map<String, FileStorageStructure>>(){}.getType();
		String st = obj1.strbuilder(FileDB.globalPath);
		dbValue = gson.fromJson(st, mapType);
		return dbValue;
	}
	
	private void checkInitialConditions( String key) throws FileDBException, IOException {
		File file = new File(FileDB.globalPath);
		obj1.keyChecker(key);
		if(obj1.isFileExists(FileDB.globalPath)) {
			sizeChecker(file);
		}
		else {
			file.createNewFile();
		}
	}
	
	public boolean sizeChecker(File file) {
		return ((double) file.length() / (1024 * 1024) < 1024);	
	}

	private FileStorageStructure getFileStroageStructure(Object value, Integer time) throws FileDBException {
		FileStorageStructure fileStorage = new FileStorageStructure();
		fileStorage.setData(value);
		if(time != null)
			fileStorage.setTime(Calendar.getInstance().getTimeInMillis() + (time * 1000));
		if(checkFileSize(new Gson().toJson(value)))
		   throw new FileDBException("Value size exceeds the limit of 16 KB");
		return fileStorage;
	}

	private boolean checkFileSize(String json){
		return json.getBytes().length > 16000;
	}
	
}
	

