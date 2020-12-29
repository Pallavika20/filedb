package accesslayer;

public interface IFileDB {
	boolean create(String path,String key,Object value);
	boolean delete();
	Object get();
	Object update();
}
