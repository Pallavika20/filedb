package accesslayer;

import java.io.IOException;
import java.time.Instant;

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
		objec.create(globalPath,key,value,(Instant) null);
		return true;
		}
		catch(IOException | FileDBException e) {
			e.printStackTrace();
		}
	}
	public boolean create(String key,Object value,Instant timetolive) {
	try {
		objec.create(globalPath,key,value,timetolive);
	} catch (IOException | FileDBException e) {
		e.printStackTrace();
	}
	return true;
	}
	
	@Override
	public Object get(String key) {
		try {	
		return objec.get(globalPath,key);
		}
		catch(IOException | FileDBException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(String key) {
		try {	
             objec.delete(globalPath,key);
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
