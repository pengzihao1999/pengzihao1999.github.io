package tx.study.test.mulitithreading;


public class Test2Consumer implements Runnable {
	Test2Resource  resource = null;
	public Test2Consumer(Test2Resource resource) {
		this.resource = resource;
	}
	public void run(){
		while(true){
			resource.consumer();
		}
	}

}
