package Socket;



import java.io.FileOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.Collections;
import java.util.Date;

import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import QQdomain.Message;

@ServerEndpoint("/chat") //服务器端建立一个chatSocket的服务  
public class chatSocket {
	
	public static List<Session> chatsockets = Collections.synchronizedList(new ArrayList<Session>());
	private static Session session = null; 
	private String ID;
	@OnOpen 
	//通道打开         Session理解称为通过控制反转 依赖注入通道的引用
	public void open(Session s){
	//如果要实现群聊 打开的时候就要把这个用户添加到属于类的群组集合里面
		this.session = s;//获取传入的session对象
		//this表示当前对象 
		System.out.println("有对象正在连接");
		ID = s.getQueryString();
		chatsockets.add(this.session);
		try {
			FileOutputStream fl  = new FileOutputStream("D:/log.txt",true);
			String value = s.getQueryString()+"进入了群聊"+"\r\n";
			fl.write(value.getBytes());
			fl.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@OnClose
	//通道关闭
	public void close(Session s){
		System.out.println(s.getId()+"通道关闭");
		try {
			s.close();
			FileOutputStream fl  = new FileOutputStream("D:/log.txt",true);
			String value = s.getQueryString()+"退出了群聊"+"\r\n";
			fl.write(value.getBytes());
			fl.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@OnMessage
	//通道来消息了向所有用户转发
	public void message(Session s,String msg){
		
		System.out.println("客户端说"+msg);
		
		boadcast(chatsockets,msg);
		
	}
	private void boadcast(List<Session> chatsockets2, String msg) {
		System.out.println("开始进行转发了");
		
		for( Session socket:chatsockets2){
		
		
				try {
					System.out.println("转发的"+socket.getId());
					System.out.println("转发的msg"+msg);
					Message mes = new Message();
					mes.setFrom(ID);
					//获取当前的日期
			        Date date = new Date();
			        //设置要获取到什么样的时间
			        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        //获取String类型的时间
			        String createdate = sdf.format(date);
			        mes.setDate(createdate);
			        mes.setSendMsg(msg);     
					socket.getBasicRemote().sendText(mes.toJson());//群发消息
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	@Override
	public String toString() {
		return this.session.getId()+this.session.hashCode();
	}
}
