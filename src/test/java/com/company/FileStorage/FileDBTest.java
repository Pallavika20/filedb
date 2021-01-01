package com.company.FileStorage;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.UUID;

import org.junit.Test;

import accesslayer.FileDB;
import customexception.FileDBException;

/**
 * Unit test for simple App.
 */
public class FileDBTest 
{
	private FileDB fileDB = new FileDB();
   
	 @Test
	    public void createWithTime() throws FileDBException, IOException{
	    	assertEquals(true,  fileDB.create("he", "SomeValue To be stored",0));
	    }
    @Test
    public void createWithKey() throws FileDBException, IOException{
    	String id = UUID.randomUUID().toString().substring(0, 32);
    	assertEquals(true, fileDB.create(id, "SomeValue To be stored"));
    }
    
    @Test
    public void createWithKeyinPath() throws FileDBException, IOException{
    	new FileDB("D:\\");
    	assertEquals(true, fileDB.create("hydera", "SomeValue To be stored"));
    }
    @Test(expected = FileDBException.class)
    public void createWithExixtsKey() throws FileDBException, IOException{
        fileDB.create("fourtynine", "SomeValue To be stored");
    }
    
    @Test(expected = FileDBException.class)
    public void createWithoutKey() throws FileDBException, IOException{
    	fileDB.create(null, "SomeValue To be stored");
    } 
    
    @Test(expected = FileDBException.class)
    public void createWithoutKeyempty() throws FileDBException, IOException{
    	fileDB.create(" ", "SomeValue To be stored");
    }
    
    @Test(expected = FileDBException.class)
    public void createWithoutKeysize() throws FileDBException, IOException{
    	fileDB.create("somthing that exceeds morethan 32 characters ", "SomeValue To be stored");
    }
    
    @Test(expected = FileDBException.class)
    public void notProperDirectorytest() throws FileDBException, IOException{
    	new FileDB("something");
    }
    
    @Test(expected = FileDBException.class)
    public void getNullTest() throws FileDBException, IOException{
    	fileDB.get(null);
    }
    
    @Test
    public void getTest() throws FileDBException, IOException{
    	assertEquals(49.0, fileDB.get("fourtynin"));
    }
    
    @Test
    public void deleteTest() throws FileDBException, IOException{
    	fileDB.create("file", 55);
    	assertEquals(true, fileDB.delete("file"));
    }
    
    
}
