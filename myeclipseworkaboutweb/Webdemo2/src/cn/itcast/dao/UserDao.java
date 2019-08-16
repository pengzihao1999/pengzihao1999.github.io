package cn.itcast.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.management.RuntimeErrorException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;

import cn.itcast.commons.CommonUtils;
import cn.itcast.domain.User;

public class UserDao {
	private String path="D:/user.xml";
   public  User findByUsername(String username)
   { 
	  //1创建解析器
	   SAXReader reader=new SAXReader();
	   //2xpath查询
	   //3检验查询结果是否为空，如果为空返回null
	   //4如果不为空，把元素封装到User对象中
	  
	   try {
		Document doc=reader.read(path);
	    Element ele=(Element)doc.selectSingleNode("//user[@username='" + username + "']");
	    
	    if(ele==null) return null;
	    
	    User user=new User();
	    String attrUsername=ele.attributeValue("username");
	    String attrPassword=ele.attributeValue("password");
	    user.setPassword(attrPassword);
	    user.setUsername(username);
	    
	    return user;
	    
	   } catch (Exception e) {
		throw new RuntimeException(e);
	    }   
   }
    public void add( User user)
    {
	  /*
	   * 1.得到Document
	   * 2.通过Document得到root元素
	   * 3.使用参数user，转发成Element对象
	   * 4.把Element对象添加到root元素中
	   * 5 保存document
	   */
    	SAXReader reader=new SAXReader();
    	try {
			Document doc=reader.read(path);
		    //得到根元素
			Element root=doc.getRootElement();
		    //通过根元素创建新元素
			Element userELe=root.addElement("user");
		    //为userEle设置属性
			userELe.addAttribute("username", user.getUsername());
			userELe.addAttribute("password", user.getPassword());
			
			org.dom4j.io.OutputFormat format=new org.dom4j.io.OutputFormat("\t", true);
			format.setTrimText(true);
			XMLWriter  writer=null;
			try{
				
				writer =new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"));
			    writer.write(doc);
			    writer.close();
			}
			catch(Exception e)
			{
				throw new RuntimeException(e);
			}
			
    	} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
    }
}
