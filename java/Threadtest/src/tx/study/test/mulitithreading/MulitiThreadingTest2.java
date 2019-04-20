package tx.study.test.mulitithreading;



public class MulitiThreadingTest2 {
	
	public static void main(String[] args) {
		Test2Resource resource = new Test2Resource();
		Test2Consumer consumer1 = new Test2Consumer(resource);
		Test2Producer producer1 = new Test2Producer(resource);
		Test2Consumer consumer2 = new Test2Consumer(resource);
		Test2Producer producer2 = new Test2Producer(resource);
		Test2Producer producer3 = new Test2Producer(resource);
		Thread t1 = new Thread(consumer1);
		Thread t2 = new Thread(consumer2);
		Thread t3 = new Thread(producer1);
		Thread t4 = new Thread(producer2);
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		}

}
