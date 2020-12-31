package accesslayer;

import java.io.IOException;

import ExCeption.FileDBException;

public class TestClass {
	public static void main(String[] args) throws FileDBException, IOException, InterruptedException{
		FileDB obj2 = new FileDB("D:\\");
		obj2.delete("home");
	}
}
