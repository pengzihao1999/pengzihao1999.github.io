package study.test.mulitithreading;

public class Test1Producer implements Runnable{
	private Test1Resource resource = null;

	Test1Producer(Test1Resource resource) {
		this.resource = resource;
	}
	public void run() {
		while(true){
		resource.produce("¿¾Ñ¼");
		}
	}
}
