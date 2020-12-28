package accesslayer;

public class FileDB implements IFileDB {

	public boolean create(String path,String key,Object value) {
		
		return false;
	}
	@Override
    public boolean create(String key,Object value) {
		
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
	}
	
}
