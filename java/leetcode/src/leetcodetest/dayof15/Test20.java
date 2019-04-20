package leetcodetest.dayof15;

import java.util.HashMap;
import java.util.Stack;

public class Test20 {
	 public static boolean isValid(String s) {
		 if(s.isEmpty())
		 {
			 return true;
		 }
	     Stack<Character> s1=new Stack<Character>();  
	     char [] ch=s.toCharArray();
	     HashMap<Character,Character> map=new HashMap<Character, Character>();
	     map.put('}', '{');
	     map.put(')', '(');
	     map.put(']', '[');
	     map.put('{', 'A');
	     map.put('(', 'B');
	     map.put('[', 'C');     
	     s1.push(ch[0]);//把第一个字符放入
	     for(int i=1;i<=ch.length-1;i++)//依次向后遍历后面的字符
	     {   
             if(s1.empty()==true)
             {
            	 s1.push(ch[i]);
            	 continue;
             }   	
             else
            {
           	 if(map.get(ch[i]).equals(s1.peek()))
	         {
	    	 s1.pop();
	    	 }
	    	 else
	    	 {
	    		 s1.push(ch[i]);
	    	 }
            	}
	     }
	     return (s1.empty()==true)?true:false; 	
	 }
	 public static void main(String[] args) {
		System.out.println(isValid("()[]"));
	}
}
