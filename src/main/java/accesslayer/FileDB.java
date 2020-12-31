package accesslayer;

import java.io.IOException;

import ExCeption.FileDBException;
import datalayer.FileHandler;
import service.Service;

public class FileDB implements IFileDB {
	
	public static String globalPath = null; 
	FileHandler o = new FileHandler();
	Service objec = new Service();
	
	public FileDB(String path) throws FileDBException, IOException{
		globalPath = o.pathChecker(path);
		
	}
	
	public FileDB() throws FileDBException, IOException{
		globalPath = o.pathChecker(null);
	}
    
	@Override
	public boolean create(String key,Object value) throws FileDBException, IOException {
		try {
		objec.create(key, value,  null);
		return true;
		}
		catch(IOException | FileDBException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean create(String key, Object value, int timeLimit) throws FileDBException, IOException {
		try {
		objec.create(key, value, timeLimit);
		return true;
		}
		catch(IOException | FileDBException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Object get(String key) {
		try {
		return objec.get(key);
		}
		catch(IOException | FileDBException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(String key) {
		try {	
             objec.delete(key);
             return true;
			}
			catch(IOException | FileDBException e) {
				e.printStackTrace();
			return false;	
			}
      }
	
	public static void main(String[] args) {
		
	}
	
}
