package datalayer;
import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
	
	public boolean isFileExists(String path) throws IOException {
		Path pat = Paths.get(path);
		if(Files.exists(pat)) {
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
				System.out.print("Path not found");
				
			}
		return path;
	}
	
	public String customisePathImplementer(String path) {
		try {
			 String dir=System.getProperty("user.dir");
			 path=dir+File.separator+"sample.txt";

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
		 path=dir+File.separator+"sample.txt";
		return path;
	}
	
	public boolean keyChecker(String key) { 
		return key.length() < 32; 
	}
	
}
