package leetcodetest.dayof15;
import java.text.NumberFormat;


/*
 * 整数反转思路
 * 1.首先判断是正数还是负数 整数就从第一位开始转 负数从第二位开始转
 * 2.通过一个标记记录是正数还是负数
 * （判断溢出）
 * 3.若是正数 直接输出
 * 4.若是负数到前面加一个负号
 */
public class Test7 {
 public static int  fun(int x)
 {
	  boolean flag=(x>0?true:false);
	  int end=(flag==true?0:1);
	  System.out.println(flag+""+end);
	  String str=String.valueOf(x);
	  char [] ch=str.toCharArray();
	  StringBuffer sb=new StringBuffer();
	  for(int i=ch.length-1;i>=end;i--)
	  {
		  sb.append(ch[i]);
	  }
	  int result=0;
	  try
	  {
	    result=Integer.parseInt(sb.toString());	 
	  }
	  catch (NumberFormatException e) {
		return 0;
	  }
	  return flag==true? result:-result;
	   
	  
	  
	  
 }
 public static void main(String[] args) {
	System.out.println(fun(1234567899));
}
}
