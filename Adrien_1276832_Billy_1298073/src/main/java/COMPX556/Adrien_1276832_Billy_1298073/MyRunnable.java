package COMPX556.Adrien_1276832_Billy_1298073;

import java.util.ArrayList;
import java.util.List;

public class MyRunnable {
	public static void main(String[] args){
		List<Thread> threads = new ArrayList<Thread>();
		for(int i = 0; i < 10; i++){
			Runnable task = new App();
			Thread antGroup = new Thread(task);
			try{
				antGroup.sleep(500);
			}catch(Exception e){System.out.println(e);}  
			antGroup.start();		
			threads.add(antGroup);
			System.out.println("Added in new antGroup " + i);
		}
	}
}
