import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;


public class uploadservlet2 extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		/*
		 * 三部曲 工厂 解析器 List<FileItem>
		 * 
		 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			List<FileItem> list = sfu.parseRequest(request);
			//三部曲完成 继续下列代码
			FileItem fi = list.get(1);//得到第二项图片项
			String name = fi.getName();
			int index = name.lastIndexOf("\\");
			if(index != -1){
				name =name.substring(index+1);//对完全路径的切割
			}
			//加uuid
			String savename = CommonUtils.uuid()+"_"+name;
			int hash = savename.hashCode();
			String hex = Integer.toHexString(hash);
			String root = this.getServletContext().getRealPath("/WEB-INF/files/");
			
			File dirfile = new File(root,"/"+hex.charAt(0)+"/"+hex.charAt(1));
			dirfile.mkdirs();
			File destfile = new File(dirfile,savename);
			fi.write(destfile);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
