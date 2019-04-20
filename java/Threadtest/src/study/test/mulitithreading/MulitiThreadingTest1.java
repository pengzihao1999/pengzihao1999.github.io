package study.test.mulitithreading;
/*
 * 多线程实现消费者生产者
 * 
 */
public class MulitiThreadingTest1 {

	public static void main(String[] args) {
		Test1Resource resource = new Test1Resource();
		Test1Producer producer1 = new Test1Producer(resource);
		Test1Consumer consumer1 = new Test1Consumer(resource);
		Test1Producer producer2 = new Test1Producer(resource);
		Test1Consumer consumer2 = new Test1Consumer(resource);
		Thread t1 = new Thread(producer1);
		Thread t2 = new Thread(consumer1);
		Thread t3 = new Thread(producer2);
		Thread t4 = new Thread(consumer2);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
