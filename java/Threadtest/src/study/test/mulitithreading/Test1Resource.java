package study.test.mulitithreading;

public class Test1Resource {
	private int count = 0;//用来记录现有产品的个数
	private boolean flag = false;//生产好为true 没生产好为false
	private String name;
	public synchronized void produce(String name){
		while(flag == true){//标记为true表示生产好了
			try {
				this.wait();
			} catch (Exception e) {throw new RuntimeException();}
		}
		//标记为true生产好了
		count++;
		this.name = "第"+count+"个"+name;
		System.out.println(Thread.currentThread().getName()+"生产了"+this.name);
		this.flag = true;
		this.notifyAll();
	}
	
	public synchronized void consumer(){
		while(flag == false){
			try{
				this.wait();
			}catch (Exception e) {throw new RuntimeException();}	
		}
		System.out.println(Thread.currentThread().getName()+"消费了"+this.name);
		this.flag = false;
		this.notifyAll();
	}
}
