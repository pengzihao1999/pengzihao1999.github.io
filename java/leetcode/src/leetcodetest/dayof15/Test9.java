package leetcodetest.dayof15;

public class Test9 {
   public static boolean isPalindrome(int x) {
	  
	   String str=String.valueOf(x);
	   boolean flag=x>=0?true:false;
	   int end=(flag==true)?0:1;
	   char [] ch=str.toCharArray();
	   StringBuffer sb=new StringBuffer();
	   for(int i=ch.length-1;i>=end;i--)
	   {
		   sb.append(ch[i]);
	   }
	   if(flag==false) sb.append("-");
	   String result=sb.toString();
	   System.out.println(result);
	   if(result.equals(String.valueOf(x)))
		   return true;
	   else return false;
    }
   public static void main(String[] args) {
	   {
		   System.out.println(isPalindrome(10));
	   }
}
}
