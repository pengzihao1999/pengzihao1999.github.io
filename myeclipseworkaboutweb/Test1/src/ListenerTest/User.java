package ListenerTest;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionBindingListener, HttpSessionActivationListener,Serializable{
	private String name;
	private String password;
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("我被加到session域中了");	
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("我从session域中移除了");
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
	System.out.println("我被活化了");
		
	}
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
	System.out.println("我被钝化了");
		
	}
}
