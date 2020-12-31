package com.company.FileStorage;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Test;

import ExCeption.FileDBException;
import accesslayer.FileDB;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws IOException 
     * @throws FileDBException 
     */
    @Test
    public void shouldAnswerWithTrue() throws FileDBException, IOException{
    	/*String aToz = "abcdefghijklmnopqrstuvwxyz";
	    Random rand=new Random();
	    StringBuilder res=new StringBuilder();
	    for (int i = 0; i < 17; i++) {
	       int randIndex=rand.nextInt(aToz.length()); 
	       res.append(aToz.charAt(randIndex));            
	    }
	    String r = res.toString();*/
       FileDB fdb = new FileDB();
       boolean out = fdb.delete("pall");
       assertEquals(true,out);
    }
}
