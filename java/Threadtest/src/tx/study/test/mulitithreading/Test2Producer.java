package tx.study.test.mulitithreading;

public class Test2Producer implements Runnable {
	Test2Resource resource = null;
	public Test2Producer(Test2Resource resource) {
		this.resource = resource;
	}
	@Override
	public void run() {
		while(true){
			resource.produce("¿¾Ñ¼");
		}
	}
}
