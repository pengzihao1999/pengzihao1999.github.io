import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;


public class uploadservlet1 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		/*
		 * 三步曲
		 * 1创建工厂
		 * 2创建解析器
		 * 3得到list<FileItem>
		 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        try {
			List<FileItem> list = sfu.parseRequest(req);
		
			FileItem fi = list.get(1);
			/*
			 * 核心代码
			 * 1.得到文件保存的路径 
			 * 
			 */
			String root = this.getServletContext().getRealPath("/WEB-INF/files/");
			System.out.println(root);
			/*
			 *   生成二级目录
			 *   1.得到文件名称
			 *   2.得到hashcode
			 *   3.转化为16进制
			 *   4.获取第二个字符用来生成目录
			 */
			String filename = fi.getName();
			int index = filename.lastIndexOf("\\");
			if(index==-1){
				filename = filename.substring(index+1);
			}
			//给文件名称添加uuid前缀，处理
			String savename = CommonUtils.uuid()+"——"+filename;
			System.out.println(savename);
			
			int hashcode = savename.hashCode();
			
			String hex  = Integer.toHexString(hashcode);
			
			File dirfile = new File(root,"/"+hex.charAt(0)+"/"+hex.charAt(1));
			System.out.println(dirfile.getAbsolutePath());
			
			dirfile.mkdirs();
			
			File destfile = new File(dirfile,savename);
			
			try {
				fi.write(destfile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}
