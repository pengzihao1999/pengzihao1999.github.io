package leetcodetest.dayof15;
/*
 * 把后面的每个字符转化为字符串 
 *  进行和buffer中的部分进行比较 如果与buffer中的字符串相同 
 */
public class Test14 {
	  public static  String longestCommonPrefix(String[] strs) {
		  if(strs.length==0)
			  return "";
		  if (strs.length == 1){
		      return strs[0];
		        }
		     
		 char base []=strs[0].toCharArray();
		 StringBuffer result= new StringBuffer();
		 int k=0;
		
		 boolean flag=true;
		 for(int s=0;s<=base.length-1&&flag==true;s++)//以头字符为基准 前缀的字符串不可能超过头字符
		 {
		 for(int i=1;i<=strs.length-1;i++ )//后面的每个字符串
		     {    
		      char [] compare=strs[i].toCharArray();//获取后面字符串的字符数组表示形式	
		      if(s>compare.length-1||compare[s]!=base[s])
		      {
		    	  flag=false;
		    	  break;
		      }
		       if(compare[s]==base[s])//如果和基本字符数组比较相同
		       {
		    		 k++;  		
		       }
		       
		    }
		 }
		 System.out.println(k);
		 int end=k/(strs.length-1);
		 for(int start=0;start<=end-1;start++)
		 {
			 result.append(base[start]);
		 }	 
		  return result.toString();
		          
	    }
	  public static void main(String[] args) {
		String [] str={""};
		System.out.println(longestCommonPrefix(str));
		
	}
}
