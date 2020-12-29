package datalayer;
import java.io.File;

import java.io.IOException;
import java.util.Random;

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
				System.out.print("Path not found");
				
			}
		return path;
	}
	
	public String customisePathImplementer(String path) {
		try {
			 String dir=System.getProperty("user.dir");
			 path=dir+File.separator+ randomStringGenerator()+".txt";

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
		 path=dir+File.separator+ randomStringGenerator()+".txt";
		return path;
	}
	
	public String randomStringGenerator() {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 7;
        for(int i = 0; i < length; i++) {
        	int index = random.nextInt(alphabet.length());
        	 char randomChar = alphabet.charAt(index);
        	 sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
        }
	
	
	public boolean keyChecker(String key) { 
		if ( key.length() <= 32) {
			return true;
		}
		else {
			System.out.print("Size of key exeeds");
			return false;
		}
	}
	
}
