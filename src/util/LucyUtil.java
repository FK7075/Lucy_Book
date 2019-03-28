package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 * 工具类-用于处理重复操作
 * @author fk-7075
 *
 */
public class LucyUtil {
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * 记住密码功能
	 * @param name
	 * cookie名
	 * @param value
	 * cookie值
	 * @param isOK
	 * 是否记住密码
	 */
	public void setCookie(String name,String value,boolean isOK) {
		Cookie cookie = new Cookie(name, value);
		if(isOK) 
			cookie.setMaxAge(7 * 24 * 60 * 60);
		else
			cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	/**
	 * 获得当前页码（从Url中拿到页码，出现异常则默认为第一页）
	 * @param message
	 * 页码在request中的name值
	 * @return
	 */
	public int getPage(String message) {
		try {
			return Integer.parseInt(request.getParameter(message));
		}catch (Exception e) {
			return 1;
		}
	}
	/**
	 * 上传文件并返回文件名
	 * @param file
	 * 表单传入的文件
	 * @param url
	 * 保存地址
	 * @param name
	 * 传入的文件名
	 * @return
	 */
	public String saveFile(File file,String url,String name) {
		String realPath = ServletActionContext.getServletContext().getRealPath(url);
		File newfile = new File(realPath);
		if (!file.exists())
			file.mkdirs();//创建
		try {
			
			// 保存文件
			long dt = new Date().getTime();//获得系统时间
			String fileName = dt+getType(name);
			FileUtils.copyFile(file, new File(newfile, fileName));//把流写到文件夹里图片从本机上传到服务器
			return fileName;
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获得文件的后缀名
	 * @param filename
	 * @return
	 */
	private String getType(String filename) {
		int fist=filename.indexOf(".");
		int last=filename.length();
		return filename.substring(fist, last);
	}

	
}
