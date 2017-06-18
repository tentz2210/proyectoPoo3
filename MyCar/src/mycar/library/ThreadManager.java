package mycar.library;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
	
	private ExecutorService executor;
	
	public ThreadManager(){
		executor = Executors.newFixedThreadPool(5);
	}
	
	public ExecutorService getExecutor(){
		return executor;
	}

}
