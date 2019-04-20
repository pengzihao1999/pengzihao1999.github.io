package study.test.mulitithreading;

public class Test1Consumer implements Runnable{
	private Test1Resource resource = null;
	Test1Consumer(Test1Resource resource) {
		this.resource = resource;
	}
	@Override
	public void run() {
		while(true)
		{
			resource.consumer();
		}
	}
}
