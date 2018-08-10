package demo.midhun;

class Increment {
	int count=0;
	public synchronized void increase() {	//only one thread can access this method at a time.
		count++;
	}

	
}
public class Counter {
	public static void main(String [] args) throws InterruptedException {
		Increment in = new Increment();
		Thread t1= new Thread(()->
		{
			for(int i=1;i<1000;i++) {
				in.increase();
			}
		});
		Thread t2= new Thread(()->
		{
			for(int i=1;i<1000;i++) {
				in.increase();
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Count is "+ in.count);
	}
}
