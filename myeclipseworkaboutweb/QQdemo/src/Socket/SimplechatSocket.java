package Socket;


import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import QQdomain.Message;
@ServerEndpoint("/simplechat") //服务器端建立一个chatSocket的服务  
public class SimplechatSocket {
		private  static  Map<String, Session>  sMap=new HashMap<String, Session>();
		private static Session session = null;  
		private String ID;//自己的ID可以进行转发
		private String from;
		private String to;
		//还要拿到要转发的ID 从集合中拿到转发ID的session的ID进行判断
		@OnOpen 
		//通道打开         Session理解称为通过控制反转 依赖注入通道的引用
		public void open(Session s){
		//如果要实现群聊 打开的时候就要把这个用户添加到属于类的群组集合里面
			this.session = s;//获取传入的session对象
			
			//this表示当前对象 
		
			System.out.println("查找到的ID是"+ID);
			ID = s.getQueryString();
			String from = ID.split(",")[0];
			String to = ID.split(",")[1];
			this.ID = from;
			this.to = to;
			this.from = from;
			sMap.put(from, this.session);
			try {
				FileOutputStream fl  = new FileOutputStream("D:/log.txt",true);
				String value = from+"进入了私聊"+"\r\n";
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
				String value = from +"退出了私聊"+"\r\n";
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
			boadcast(sMap,msg);
			
		
		}
		public void boadcast(Map<String, Session> sMap2, String msg) {
			// TODO Auto-generated method stub
			Set<String> get = sMap2.keySet();          

			for (String test:get) 

			{          

			System.out.println(test+","+sMap2.get(test).getId());         

			}  
			if(sMap2.containsKey(to)&&sMap2.containsKey(from)){
				Session [] ss = new Session[2];
				ss[0] = sMap2.get(to);//表示要发送的session
				ss[1] = sMap2.get(from);//表示自己的
				
				try {
					for(int i =0;i<=ss.length-1;i++){
						if(i==0){
							Message mes = new Message();
							mes.setFrom(from);
						//获取当前的日期
				        Date date = new Date();
				        //设置要获取到什么样的时间
				        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				        //获取String类型的时间
				        String createdate = sdf.format(date);
				        mes.setDate(createdate);
				        mes.setSendMsg(msg);     
						ss[0].getBasicRemote().sendText(mes.toJson());	
						}
						if(i==1){
							Message mes = new Message();
							mes.setFrom(from);
						//获取当前的日期
				        Date date = new Date();
				        //设置要获取到什么样的时间
				        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				        //获取String类型的时间
				        String createdate = sdf.format(date);
				        mes.setDate(createdate);
				        mes.setSendMsg(msg);     
						ss[1].getBasicRemote().sendText(mes.toJson());	
						}
						
					}} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
	}
		}

