
public class P40Text2 {
   public static void main(String []args)
   {
	   Text test1=new Text();
	   Text test2=new Text();
	   test1.f=86.76f;
	   test2.f=594.45f;
	   test1=test2;//这时实际上把test2的引用赋值给了test1 两个都指向一个存储空间
	    //如果对其中一个值进行修改，修改的是两个值 而没有使用的对象就将被垃圾处理回收
	   System.out.println("test1.f:"+test1.f+"test2.f:"+test2.f);
   }
}
class Text
{
	float f;
}