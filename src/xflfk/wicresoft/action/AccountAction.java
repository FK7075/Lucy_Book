package xflfk.wicresoft.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import xflfk.wicresoft.entitry.Admin;
import xflfk.wicresoft.entitry.Book;
import xflfk.wicresoft.entitry.PageInfo;
import xflfk.wicresoft.entitry.User;
import xflfk.wicresoft.service.AdminService;

@SuppressWarnings("all")
public class AccountAction extends ActionSupport {
	private int id;
	private AdminService admService = new AdminService();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private List<User> userlist = new ArrayList<User>();
	private List<Admin> adminlist = new ArrayList<Admin>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Admin> getAdminlist() {
		return adminlist;
	}

	public void setAdminlist(List<Admin> adminlist) {
		this.adminlist = adminlist;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	// ��ҳչʾ�û�
	public String allUser() {
		PageInfo pi = null;
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		pi = admService.getPageInfo(new User(), page);
		if (page == admService.getPageSize(new User()))
			request.setAttribute("fk", 1);
		request.setAttribute("page", page);
		userlist = (List<User>) admService.getListPag(new User(), pi.getIndex(), pi.getSize());
		return "allUserOK";
	}

	// ɾ���û�
	public String delUser() {
		admService.del("User", id);
		request.setAttribute("pages", 1);
		return "delUserOK";
	}

	// ��������"123456"
	public String resetPass() {
		request.setAttribute("pages", 1);
		User user = new User();
		user.setUid(id);
		user.setuPassword("123456");
		admService.update(user);
		return "resetPassOK";
	}

	// ��ҳչʾ����Ա
	public String allAdmin() {
		PageInfo pi = null;
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		pi = admService.getPageInfo(new Admin(), page);
		if (page == admService.getPageSize(new Admin()))
			request.setAttribute("fk", 1);
		request.setAttribute("page", page);
		adminlist = (List<Admin>) admService.getListPag(new Admin(), pi.getIndex(), pi.getSize());
		return "allAdminOK";
	}
	//ɾ��һ������Ա
	public String delAdmin() {
		request.setAttribute("pages", 1);
		if (id != 1 && id != 2) {
			admService.del("Admin", id);
		} else {
			request.setAttribute("fk1", 1);//�޷�ɾ����������Ա�ź�
		}
		return "delAdminOK";
	}
	public String resetAdmin() {
		request.setAttribute("pages", 1);
		if (id != 1 && id != 2) {
			Admin adm=new Admin();
			adm.setAdmid(id);
			adm.setAdmPassword("123456");
			admService.update(adm);
		} else {
			request.setAttribute("xfl1", 1);//�޷����ó�������Ա�����ź�
		}
		return "resetAdminOK";
	}

}
