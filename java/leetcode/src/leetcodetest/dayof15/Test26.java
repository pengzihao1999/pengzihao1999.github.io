package leetcodetest.dayof15;

public class Test26 {
    public static  int removeDuplicates(int[] nums) {
		int p=1;
		for(int i=1;i<=nums.length-1;i++)
		{
     		if(nums[p-1]!=nums[i])
     		{
     			nums[p]=nums[i];
     			p++;
     		}
     		else if(nums[p-1]==nums[i])
     		{
     			continue;
     		}
		}
		return p;
        
 }
    public static void main(String[] args) {
    	int arr[] ={0,0,1,2,2,3,3,4,4,5,5};
    	System.out.println(removeDuplicates(arr));;
	}
}
