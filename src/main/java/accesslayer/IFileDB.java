package accesslayer;

import java.io.IOException;
import java.time.Instant;

import ExCeption.FileDBException;

public interface IFileDB {
	boolean create(String key,Object value) throws FileDBException, IOException;
	boolean delete(String key);
	Object get(String key);
	boolean create(String key, Object value, Instant time);
}
