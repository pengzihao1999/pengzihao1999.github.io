package test.philosophersproblem;

public class PhilosoPhers implements Runnable{
	private EatingResource resource = null;
	private int positon ;
	PhilosoPhers(EatingResource resource,int position) {
		this.resource = resource;
		this.positon = position;
	}
	public void run(){
		while(true)
		{
			resource.start(positon);
		}
	}
}
