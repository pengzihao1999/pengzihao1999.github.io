package test.philosophersproblem;

public class Test {

	public static void main(String[] args) {
		EatingResource eatingResource = new EatingResource();
		Thread t1 =  new Thread(new PhilosoPhers(eatingResource,0));
		Thread t2 =  new Thread(new PhilosoPhers(eatingResource,1));
		Thread t3 =  new Thread(new PhilosoPhers(eatingResource,2));
		Thread t4 =  new Thread(new PhilosoPhers(eatingResource,3));
		Thread t5 =  new Thread(new PhilosoPhers(eatingResource,4));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
