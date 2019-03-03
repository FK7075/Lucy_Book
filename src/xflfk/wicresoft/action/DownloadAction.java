package xflfk.wicresoft.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �ļ�������ص�Action
 * @author fk-7075
 *
 */
@SuppressWarnings("all")
public class DownloadAction extends ActionSupport {
	private HttpServletRequest request = ServletActionContext.getRequest();
    //downloaPath�������ڷ�װ�������ļ���·��  
    private String downloadPath;  
    //��ʼ��Ҫ������ļ���  
    private String filename;  
    //�ļ�����·��  
    private String savePath;
	public String getDownloadPath() {
		return downloadPath;
	}
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}  
	
    public InputStream getTargetFile() throws FileNotFoundException  
    {  
    	String ip=ServletActionContext.getServletContext().getRealPath("/"+filename);
        InputStream is=new FileInputStream(ip);
        return is;  
    }  
    public String execute()  
    {  
    	request.setAttribute("pages", 1);
        return "success";  
    }  
}
