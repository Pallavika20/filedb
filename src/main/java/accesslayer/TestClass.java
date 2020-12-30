package accesslayer;

import java.io.IOException;

import ExCeption.FileDBException;

public class TestClass {
	public static void main(String[] args) throws FileDBException, IOException, InterruptedException {
		final FileDB obj2 = new FileDB();
		final FileDB obj3 = new FileDB();
		Thread th1 = new Thread(new Runnable()
				{

					@Override
					public void run() {
					
						obj2.create("chettnad", 66, 19);
					}
			});
		Thread th2 = new Thread(new Runnable()
		{

			@Override
			public void run() {
			
				obj3.create("college", 66, 19);
			}
	});
		th1.start();
		th2.start();
		
		th1.join();
		th2.join();
}
}
