package leetcodetest.dayof15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class Test13 {
    public static int romanToInt(String s) {
		LinkedHashMap<Character, Integer> map= new LinkedHashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);		
		int result=0;		
		int sum=0;
		
		for(int i=0;i<s.length()-1;i++)
		{    			
			result=map.get(s.charAt(i));        
			 if(map.get(s.charAt(i+1))>result)//左小于右
			{ 
			  sum=sum-result;
			}
			 else if(map.get(s.charAt(i+1))<=result)//左大于等于右
			{
			  sum=sum+result;
			}		
		}
		 sum=sum+map.get(s.charAt(s.length()-1));
    	
    	return sum;
        
    }
    public static void main(String[] args) {
    System.out.println(	romanToInt("IV"));
		
	}
}
