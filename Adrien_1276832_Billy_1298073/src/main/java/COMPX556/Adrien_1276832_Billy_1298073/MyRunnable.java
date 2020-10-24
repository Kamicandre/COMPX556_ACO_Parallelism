package COMPX556.Adrien_1276832_Billy_1298073;

import java.util.ArrayList;
import java.util.List;

public class MyRunnable {
	public static void main(String[] args){
		List<Thread> threads = new ArrayList<Thread>();
		for(int i = 0; i <= 9; i++){
			Runnable task = new App();
			Thread antGroup = new Thread(task);
			try{
				antGroup.sleep(500);
			}catch(Exception e){System.out.println(e);}  
			antGroup.start();		
			threads.add(antGroup);
			System.out.println("Added in new antGroup " + i);
		}
		/*
		int running = 0;
        do {
            running = 0;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    running++;
                }
            }
            System.out.println("We have " + running + " running threads. ");
        } while (running > 0);
		*/
	}

	/*
	private final long countUntil;
	
	MyRunnable(long countUntil) {
		this.countUntil = countUntil;
	}
	
	
	@Override
	public void run() {
		long sum = 0;
		for(long i = 1; i < countUntil; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	*/
}
