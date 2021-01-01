package accesslayer;

import java.io.IOException;

import customexception.FileDBException;
import datalayer.FileHandler;
import service.Service;

public class FileDB implements IFileDB {
	
	public static String globalPath = null; 
	private FileHandler o = new FileHandler();
	private Service fileDBServices = new Service();
	
	/**
	 * 
	 * @param directory
	 * @throws FileDBException
	 * @throws IOException
	 * 
	 * Accepts directory path as a parameter to do actions.
	 */
	public FileDB(String directory) throws FileDBException, IOException{
		globalPath = o.givenPath(directory);
	}
	
	
	/**
	 * Creates file in current directory
	 */
	public FileDB(){
		globalPath = o.nullPath();
	}
    
	@Override
	public boolean create(String key,Object value) throws FileDBException, IOException {
		fileDBServices.create(key, value, null);
		return true;
	}
	
	@Override
	public boolean create(String key, Object value, int timeLimit) throws FileDBException, IOException {
		fileDBServices.create(key, value, timeLimit);
		return true;
	}
	
	/***
	 * @param String key 
	 * Creates a object with the given key
	 */
	@Override
	public Object get(String key) throws FileDBException, IOException {
		return fileDBServices.get(key);
	}

	/**
	 * @param String key
	 * Deletes the key if exists
	 */
	@Override
	public boolean delete(String key)  throws FileDBException, IOException {
      	return fileDBServices.delete(key);
    }
	
}
