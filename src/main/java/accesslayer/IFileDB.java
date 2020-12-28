package accesslayer;

public interface IFileDB {
	boolean create();
	boolean delete();
	Object get();
	Object update();
}
