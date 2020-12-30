package accesslayer;

import java.io.IOException;

import ExCeption.FileDBException;

public class TestClass {
	public static void main(String[] args) throws FileDBException, IOException {
    FileDB obj2 = new FileDB();
    System.out.println(obj2.get("school"));
   
}
}
