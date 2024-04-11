package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public Test() {
		Executor executor = new Invoker();
		executor.execute(()->{
			System.out.println("test\n".repeat(10));
		});
	}
	
	public static void main(String[] args) {
		new Test();
		ExecutorService exeutor  = Executors.newFixedThreadPool(10);
		exeutor.submit(new testThread());
		exeutor.submit(new testThread());
		exeutor.submit(new testThread());
		exeutor.submit(new testThread());
		exeutor.shutdownNow();
		exeutor.submit(new testThread());
	}
	
}

class testThread implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

class Invoker implements Executor {
	@Override
	public void execute(Runnable r) {
		r.run();
	}
}


