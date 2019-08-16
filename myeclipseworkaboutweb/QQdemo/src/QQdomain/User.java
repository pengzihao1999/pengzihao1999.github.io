package QQdomain;

import java.io.Serializable;


public class User implements Serializable {
  @Override
	public String toString() {
		return "User [ID=" + ID + ", password=" + password + ", username="
				+ username + ", groupID=" + groupID + ", IpAddress="
				+ IpAddress + ", port=" + port + ", groupname=" + groupname
				+ "]";
	}
private String ID;
  private String password;
  private String username;
  private String groupID;
  private String IpAddress;
  private int port;
  private String groupname;
public String getGroupname() {
	return groupname;
}
public void setGroupname(String groupname) {
	this.groupname = groupname;
}
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getGroupID() {
	return groupID;
}
public void setGroupID(String groupID) {
	this.groupID = groupID;
}
public String getIpAddress() {
	return IpAddress;
}
public void setIpAddress(String ipAddress) {
	IpAddress = ipAddress;
}
public int getPort() {
	return port;
}
public void setPort(int port) {
	this.port = port;
}
  
	}
