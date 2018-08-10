package demo.midhun;

class Model {
	int num;
	boolean valueSet=false;
	public synchronized void set(int num) {
		while(valueSet) {
			try {wait();}catch(Exception e) {}
		}
		System.out.println("Setting: "+num);
		this.num=num;
		valueSet=true;
		notify();
	}

	public synchronized void get() {
		while(!valueSet) {
			try {wait();}catch(Exception e) {}
		}
		System.out.println("Getting:" +num); 
		valueSet=false;
		notify();
	}
}


class Producer implements Runnable {
	Model m;
	
	public Producer(Model m) {
		this.m = m;
		Thread t1=new Thread(this,"Producer");
		t1.start();
	}

	public void run() {
		int count=0;
		while(true) {
			m.set(count++);
			try {Thread.sleep(500);} catch(Exception e) {}
			
		}
	}
}
class Consumer implements Runnable {
Model m;
	
	public Consumer(Model m) {
		super();
		this.m = m;
		Thread t1=new Thread(this,"Consumer");
		t1.start();
	}
	public void run() {
		while(true) {
			m.get();
			try {Thread.sleep(500);} catch(Exception e) {}
		}
		
	}
}
public class ProducerConsumer {
	public static void main(String [] args) {
		Model mo =new Model();
		new Producer(mo);
		new Consumer(mo);
	}
}
