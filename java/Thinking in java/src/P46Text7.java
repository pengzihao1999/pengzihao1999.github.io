import java.util.Random;


public class P46Text7 {
  public static void main(String []args)
  {
	  Random random=new Random();
	  for(int i=0;i<10;i++)
	  {
		  System.out.println((random.nextInt(19))/10);
	  }
  }
}
