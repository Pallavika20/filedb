package accesslayer;

import java.io.IOException;

import customexception.FileDBException;

public interface IFileDB {
	boolean create(String key,Object value) throws FileDBException, IOException;
	boolean create(String key,Object value, int timeLimit) throws FileDBException, IOException;
	boolean delete(String key) throws FileDBException, IOException;
	Object get(String key) throws FileDBException, IOException; 
}
