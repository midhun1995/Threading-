package demo.midhun;

/*class Hello implements Runnable {
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hello Thread running");
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
			}
		}
	}
}
class Hi implements Runnable {
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hi Thread running!");
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				
			}
		}
	}
}
*/
public class ThradMain {
	public static void main( String [] args) throws InterruptedException {
		
	/*	Runnable obj1 = ()-> {								//Using Lambda Expression
				for(int i=0;i<5;i++) {
					System.out.println("Hello Thread running");
					try {
						Thread.sleep(500);
					}
					catch(Exception e) {
					}
				}
			};
		Runnable obj2 = ()-> {							//Using Lambda Expression
				for(int i=0;i<5;i++) {
					System.out.println("Hi Thread running!");
					try {
						Thread.sleep(500);
					}
					catch(Exception e) {
						
					}
				}
			};
	*/
		Thread t1= new Thread( ()-> {								//Using Lambda Expression
			for(int i=0;i<3;i++) {
				System.out.println("Hello Thread running with priority "+ Thread.currentThread().getPriority());
				try {Thread.sleep(500);} catch(Exception e) {
				}
			}
		},"Hello Thread");
		Thread t2 = new Thread(()-> {							//Using Lambda Expression
			for(int i=0;i<3;i++) {
				System.out.println("Hi Thread running! with priority "+ Thread.currentThread().getPriority());
				try {Thread.sleep(500);}catch(Exception e) {}
			}
		},"Hi Thread");
		//t1.setName("Hello Thread");
		//t2.setName("Hi Thread");
	
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		t1.start();
		t2.start();
		t1.join();
		System.out.println(t1.isAlive());
		t2.join();
		System.out.println("Bye");
	}
}