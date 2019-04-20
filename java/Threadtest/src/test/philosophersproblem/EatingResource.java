package test.philosophersproblem;

import java.util.concurrent.Semaphore;

/*
 * 
 * 哲学家吃饭思路：
 *   假设每个哲学家先拿左边的筷子
 *   一：先拿左边的筷子
 *   二：在拿右边的筷子  如果右边的筷子被拿了 就释放左边的筷子
 *   三：如果两只筷子都拿到了 ->吃饭
 *       如果没有拿到->继续思考
 *   
 *   实现步骤:
 *      用一个标记量数组来表示筷子是否拿到 如果为true拿到了 如果为false表示筷子没有被拿到
 *          
 *   
 *   
 * 注意：每个哲学家只能同时一起拿左边或右边的筷子，如果拿到左边的筷子，没有拿到右边的，就重新把左边的筷子放下
 *   
 */
public class EatingResource {
	private boolean  flags[] = {false , false, false , false , false};
	
	//表示第i个哲学家开始了
	public void start(int i){
		System.out.println("哲学家"+i+"在进行思考");
		flags[i%5] = true;//拿到左边的筷子
	  System.out.println("哲学家"+i+"拿到左边的筷子 ");
		if(flags[(i+4)%5] == true){//尝试去拿右边的筷子失败
		     flags[i%5] = false;      //释放左边的筷子
		     System.out.println("哲学家"+i+"拿不到右边的筷子释放了左边的筷子 。。。我又开始思考了");
		}
		else{
			flags[(i+4)%5] = true; //表示拿到了右边的筷子可以开始吃饭了
			System.out.println("哲学家"+i+"两只筷子都拿到了");
			System.out.println("哲学家"+i+"开始吃饭了");
			flags[i%5]=false;//释放左右筷子
			flags[(i+4)%5]=false;
			System.out.println("哲学家"+i+"放下了两只筷子");
			
		}
	}
}


