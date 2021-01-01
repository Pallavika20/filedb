package datalayer;
import java.io.BufferedReader;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import customexception.FileDBException;



public class FileHandler {
	File fi;
	
	public boolean isFileExists(File file) throws IOException {
		return file.exists();
	}
	
	public boolean isFileDirectoryExists(File filePath) {
		return filePath.isDirectory();
	}
	
	
	public String nullPath(){
		String dir = System.getProperty("user.dir");
		return dir + File.separator + "fileDB.txt";
	}
	
	public String givenPath(String path) throws FileDBException, IOException {
		fi = new File(path);
		if(fi.isAbsolute() && fi.isDirectory()) {
			String path1 = path + "fileDB.txt";
			return path1;
		}
		else {
			throw new FileDBException("Path doesn't Exixts");
		}
	}
	
	
	
	public void keyChecker(String key) throws FileDBException { 
		if(key == null) {
			throw new FileDBException("Key cannot be null");
		}
		
		if(key.trim().equals("")) {
			throw new FileDBException("Key cannot be Empty");
		}
		
		if ( key.length() >32) {
			throw new FileDBException("Key Character limit exceeds");
		}
	}
	
	public String strbuilder(File path) throws IOException {
		FileReader fr =new FileReader(path);
		BufferedReader br = new BufferedReader(fr); 
		StringBuffer sb = new StringBuffer();
		  String st; 
		while ((st = br.readLine()) != null) 
			sb.append(st);
		br.close();
		fr.close();
		String returnString = sb.toString();
		if(returnString == null) {
			returnString = "{ }";
		}
		returnString = returnString.trim();
		if(returnString.length() < 1) {
			returnString = "{ }";
		}
		return returnString;
	}

}
