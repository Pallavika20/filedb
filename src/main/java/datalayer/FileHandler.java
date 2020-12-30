package datalayer;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ExCeption.FileDBException;



public class FileHandler {
	File fi;
	
	public boolean isFileExists(String path) throws IOException {
		fi = new File(path);
		if(fi.exists()&&fi.isDirectory()) {
			return true;
		}
		else  {
			return false;
		}
	}
	
	public void fileWrite(String path,String son,String key) throws IOException {
		try {
				FileWriter fw = new FileWriter(path);
				fw.write(son);
				fw.close();
		}
		catch(Exception e) {
			
		}
		
	}
	
	
	
	public String nullPath(String path) {
		String dir=System.getProperty("user.dir");
		 path=dir+File.separator+"fileDB.txt";
		return path;
	}
	
	public String givenPath(String path) throws FileDBException, IOException {
		fi = new File(path);
		if(fi.isAbsolute()) {
			String path1 = path+"fileDB.txt";
			return path1;
		}
		else {
			throw new FileDBException("Path doesn't Exixts");
		}
	}
	
	public String pathChecker(String path) throws FileDBException, IOException {
		if(path==null) {
			return nullPath(path);
		}
		else {
		   return givenPath(path);
		}
	}
	public void keyChecker(String key) throws FileDBException { 
		if ( key.length() >32) {
			throw new FileDBException("Key Character limit exceeds");
		}
	}
	
	public String strbuilder(String path) throws IOException {
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
