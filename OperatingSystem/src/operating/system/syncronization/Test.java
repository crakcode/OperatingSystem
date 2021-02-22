package operating.system.syncronization;


public class Test {
	public static void main(String[] args) throws InterruptedException {
	
	BankAccount b=new BankAccount();
	int Max=3;
	Parent p=new Parent(b,Max);
	Child c=new Child(b,Max);
	
	
	// �θ� ������� �ڽ� �����带 �����.
	p.start();
	c.start();
	
	// �θ�� �ڽ��� �����尡 ���� ���� �ϱ⸦ ��ٸ���.
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
