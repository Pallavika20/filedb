package datalayer;
import java.io.File;


import java.io.IOException;
import java.util.UUID;

public class FileHandler {
	
	public boolean isFileExists(String path) throws IOException {
		File fi = new File(path);
		if(fi.exists()) {
			return true;
		}
		else  {
			return false;
		}
	}
	
	public String fileCreate(String path) throws IOException  {
		if(path!=null) {
		   givenPathImplementer(path);
		}
		else {
	       path=customisePathImplementer(path);
		   
		}
		return path;
	}
	
	public String givenPathImplementer(String path) {
		try {
			File file = new File(path);
			if(file.createNewFile()) {
				System.out.print("");
			}
			}
			catch(Exception e) {
				throw new IllegalArgumentException("
				
			}
		return path;
	}
	
	public String customisePathImplementer(String path) {
		try {
			 String dir=System.getProperty("user.dir");
			 path=dir+File.separator+"fileDB.txt";

			File file = new File(path);
			if(file.createNewFile()) {
				System.out.print("");
			}
			}
			catch(Exception e) {
				System.out.print("");
			}
		return path;
	}
	
	public String customisePath(String path) {
		String dir=System.getProperty("user.dir");
		 path=dir+File.separator+"fileDB.txt";
		return path;
	}
	
	
	public boolean keyChecker(String key) { 
		if ( key.length() <= 32) {
			return true;
		}
		else {
			throw new IllegalArgumentException("Key Character limit exceeds");
		}
	}
	
}
