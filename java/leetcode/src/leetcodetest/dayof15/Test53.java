package leetcodetest.dayof15;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Test53 {
  public static int maxSubArray(int[] nums) {
	  int cur;
	  int max=nums[0];
	for(int k=0;k<=nums.length-1;k++)
	{	 cur=k;
		while(cur<=nums.length-1)
      {
			int sum=0;
	   for(int j=k;j<=cur;j++)
	   {
		sum=sum+nums[j];
	   } 
	  if(sum>max)
		max=sum; 
	  
	    cur++;	
	  }
	}
	return max;      
    }
  public static void main(String[] args) {
	int [] arr={-2,1,3,-3,4,2,-1};
	 System.out.println(maxSubArray(arr));
	  
}
}
