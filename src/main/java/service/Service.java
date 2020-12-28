package service;

import java.io.IOException;

import datalayer.FileHandler;

public class Service {
	FileHandler obj1 = new FileHandler();
 
	public boolean create(String path,String key,String value) throws IOException {
		if(obj1.isFileExists(path)) {
			return false;
		}
		else {
			fileCreate(path);
			return true;
		}
	}
		public void fileCreate(String path) throws IOException  {
			if(path!=null) {
			obj1.givenPathImplementer(path);
			}
			else {
				obj1.customisePathImplementer(path);
			}
		
	}
	public static void main(String[] args) throws IOException {
		Service obj = new Service();
		obj.create("D:\\pallavi.txt", "name", "pallavi");
		        
	}
}
