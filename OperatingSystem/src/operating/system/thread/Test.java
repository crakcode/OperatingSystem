package operating.system.thread;

public class Test {

	
	public static void main(String[] args) {
		System.out.println("hell owlrd");

		MyThread mt=new MyThread();
		mt.start();
		for(int i=0;i<1000;i++) {
			System.out.println("A");
		}
	}
	
	
	
	
	
	
}


class MyThread extends Thread{
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("B");
		}
	}


	
}