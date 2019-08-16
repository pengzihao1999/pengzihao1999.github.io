package QQdomain;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class Message {

	
	private  String  sendMsg; //发送的消息
	
	private String  from; //发送的用户名
	
	private String  date; //发送的时间
	private static Gson gson = new Gson();



	public String getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(String sendMsg) {
		this.sendMsg = sendMsg;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		if(this.from!=null){
			sb.append("用户名"+this.from);
		}
		if(this.date!=null){
			sb.append("时间"+this.date);
		if(this.sendMsg!=null){
			sb.append("\n"+this.sendMsg);
		}
		
		
		}
		return sb.toString();
	}
	public String toJson(){
	   return gson.toJson(this);
	
	}
	
}

