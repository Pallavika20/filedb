package datalayer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
	
	public boolean isFileExists(String path) {
		Path pat = Paths.get(path);
		if(Files.exists(pat)) {
			return true;
		}
		else {
			return false;
		}
	}
	public void fileCreate(String path) throws IOException  {
		if(path!=null) {
		try {
		File file = new File(path);
		if(file.createNewFile()) {
			System.out.print("");
		}
		}
		catch(Exception e) {
			System.out.print("Path not found");
			
		}
		}
		else {
			try {
				String path1 = System.getProperty("user.dir");
				File file = new File(path1);
				if(file.createNewFile()) {
					System.out.print("");
				}
				}
				catch(Exception e) {
					System.out.print("");
				}
		}
		
		
	}    
	public static void main(String[] args) throws IOException {
		FileHandler obj = new FileHandler();
		System.out.print(obj.isFileExists("D:\\tot.txt"));
	    obj.fileCreate(null,"pallavi","java");         
	}
	
}
