package operating.system.syncronization;


public class Test {
	public static void main(String[] args) throws InterruptedException {
	
	BankAccount b=new BankAccount();
	int Max=3;
	Parent p=new Parent(b,Max);
	Child c=new Child(b,Max);
	
	
	// 부모 쓰레드와 자식 쓰레드를 만든다.
	p.start();
	c.start();
	
	// 부모와 자식의 쓰레드가 각각 종료 하기를 기다린다.
	p.join();
	c.join();
	System.out.println(b.getBalance());
	}
}

	
class BankAccount{
	int balance;
	void deposit(int amount) {
		balance+=amount;
	}
	
	void withdraw(int amount) {
		balance-=amount;
	}
	int getBalance() {
		return this.balance;
	}
}

class Parent extends Thread{
	BankAccount b;
	int count;
	Parent(BankAccount b,int count){
		this.b=b;
		this.count=count;
	}
	public void run() {
		for(int i=0;i<count;i++) {
			b.deposit(i);
			System.out.println("Parent"+b.getBalance());
		}
	}
	
	
}

class Child extends Thread{
	BankAccount b;
	int count;
	Child(BankAccount b,int count){
		this.b=b;
		this.count=count;
	}
	public void run() {
		for(int i=0;i<count;i++) {
			b.withdraw(i);
			System.out.println("Child"+b.getBalance());

		}
	}

}
