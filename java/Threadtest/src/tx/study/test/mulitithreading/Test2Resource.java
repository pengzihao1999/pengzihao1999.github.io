package tx.study.test.mulitithreading;

import java.util.concurrent.Semaphore;

public class Test2Resource {
	private final int MAX_ITEMS = 500;//表示一次最多能生产500只，生产完了必须先消费。
	private String name;
	private Semaphore Pro_semaphoer = new Semaphore(MAX_ITEMS);
	private Semaphore Con_semaphoer = new Semaphore(0);
	private Semaphore lock_semaphoer = new Semaphore(1);
	public  void produce(String name){
	
		try {
			Pro_semaphoer.acquire();
			lock_semaphoer.acquire();
			this.name = "第"+(int)(MAX_ITEMS-this.Pro_semaphoer.availablePermits()-
					
					1)+"个"+name;
			System.out.println(Thread.currentThread().getName()+"生产了"+this.name);
			Con_semaphoer.release();
			lock_semaphoer.release();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public  void consumer(){
		
		try {
		
			Con_semaphoer.acquire();
			lock_semaphoer.acquire();
			
			System.out.println(Thread.currentThread().getName()+"消费了一个烤鸭"+"还剩"+(int)(Con_semaphoer.availablePermits()+1)+"个"+"可以消费");
			
			Pro_semaphoer.release();
			lock_semaphoer.release();
	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
