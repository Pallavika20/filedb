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
	public boolean create(String key,Object value) {
		try {
			objec.create(globalPath,key,value);
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
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}
	


	@Override
	public Object update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
	}
	
}
