package service;

import java.io.*;



import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import datalayer.FileHandler;
import datalayer.FileStorageStructure;
import accesslayer.FileDB;
import customexception.FileDBException;

public class Service {
	private Gson gson = new Gson();
	private static int fileSize = (1024 * 1024);
	private FileHandler fileHandler = new FileHandler();
	private Map<String, FileStorageStructure> dbValue;
	
	public synchronized void create(String key, Object value, Integer timeLimit) throws FileDBException, IOException {
		File file = checkInitialConditions(key);
		dbValue = getDbValue(file);
		if(dbValue.containsKey(key))
			throw new FileDBException("Key aldready exists");
		dbValue.put(key, getFileStroageStructure(value, timeLimit));
		saveMapInDB(dbValue);
		
	}
		
	public synchronized Object get(String key) throws FileDBException, IOException  {
		fileHandler.keyChecker(key);
		File file = new File(FileDB.globalPath);
		dbValue = getDbValue(file);
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
	
	public synchronized boolean delete(String key) throws FileDBException, IOException  {
		fileHandler.keyChecker(key);
		File file = new File(FileDB.globalPath);
		dbValue = getDbValue(file);
		if(dbValue.containsKey(key)) {
			dbValue.remove(key);
			saveMapInDB(dbValue);
			return true;
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
    

	private Map<String, FileStorageStructure> getDbValue(File file) throws IOException {
		Type mapType = new TypeToken<Map<String, FileStorageStructure>>(){}.getType();
		String st = fileHandler.strbuilder(file);
		dbValue = gson.fromJson(st, mapType);
		return dbValue;
	}
	
	private File checkInitialConditions(String key) throws FileDBException, IOException {
		File file = new File(FileDB.globalPath);
		fileHandler.keyChecker(key);
		if(fileHandler.isFileExists(file)) {
			if(sizeChecker(file)) {
				throw new FileDBException("Size of file exceeds a limit of 1GB");
			}
		}
		else {
			file.createNewFile();
		}
		return file;
	}
	
	private boolean sizeChecker(File file) throws IOException {
		return (file.length() / fileSize ) > 1;	
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
	

