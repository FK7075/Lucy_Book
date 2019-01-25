package xflfk.wicresoft.action;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import xflfk.wicresoft.entitry.Admin;
import xflfk.wicresoft.entitry.Author;
import xflfk.wicresoft.entitry.BookInfo;
import xflfk.wicresoft.entitry.PageInfo;
import xflfk.wicresoft.entitry.Stort;
import xflfk.wicresoft.entitry.User;
import xflfk.wicresoft.service.AdminService;
import xflfk.wicresoft.service.UserService;
import xflfk.wicresoft.test.Conversion;

@SuppressWarnings("all")
public class AccountAction extends ActionSupport {
	private int id;
	private String ssName;
	private String uSex;
	private String uTel;
	private AdminService admService = new AdminService();
	private UserService usrService = new UserService();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private List<User> userlist = new ArrayList<User>();
	private List<Admin> adminlist = new ArrayList<Admin>();
	private List<BookInfo> booklist = new ArrayList<BookInfo>();
	private List<Author> authorlist = new ArrayList<Author>();
	private List<Stort> stortlist1 = new ArrayList<Stort>();
	private HttpSession session = request.getSession();

	public List<Stort> getStortlist1() {
		return stortlist1;
	}

	public void setStortlist1(List<Stort> stortlist1) {
		this.stortlist1 = stortlist1;
	}

	public String getuSex() {
		return uSex;
	}

	public void setuSex(String uSex) {
		this.uSex = uSex;
	}

	public String getuTel() {
		return uTel;
	}

	public void setuTel(String uTel) {
		this.uTel = uTel;
	}

	public List<Author> getAuthorlist() {
		return authorlist;
	}

	public void setAuthorlist(List<Author> authorlist) {
		this.authorlist = authorlist;
	}

	public String getSsName() {
		return ssName;
	}

	public void setSsName(String ssName) {
		this.ssName = ssName;
	}

	public List<BookInfo> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<BookInfo> booklist) {
		this.booklist = booklist;
	}

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

	// ɾ��һ������Ա
	public String delAdmin() {
		request.setAttribute("pages", 1);
		if (id != 1 && id != 2) {
			admService.del("Admin", id);
		} else {
			request.setAttribute("fk1", 1);// �޷�ɾ����������Ա�ź�
		}
		return "delAdminOK";
	}

	// ��ʼ������Ա����
	public String resetAdmin() {
		request.setAttribute("pages", 1);
		if (id != 1 && id != 2) {
			Admin adm = new Admin();
			adm.setAdmid(id);
			adm.setAdmPassword("123456");
			admService.update(adm);
		} else {
			request.setAttribute("xfl1", 1);// �޷����ó�������Ա�����ź�
		}
		return "resetAdminOK";
	}

	// �������������ߣ����Ͳ��鱾
	public String retrieveBook() {
		String xx = "%" + ssName + "%";
		String sql = "select b.bphoto,b.bName,a.autName,s.stName, b.bStore,b.bPrice,b.bid,b.bSales"
				+ " from book b,author a,stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and (a.autName like ? or b.bName like ? or s.stName like ?)";
		booklist = (List<BookInfo>) admService.getList(BookInfo.class, sql, xx, xx, xx);
		ssName=Conversion.toF(ssName);
		return "retrieveBookOK";
	}

	// �������������������������������߹����������Ա����߳������ڲ�����
	public String retrieveAuthor() {
		String xx = "%" + ssName + "%";
		String sql = "select distinct a.*" + " from book b,author a,stort s"
				+ " where a.autid=b.autid and s.stid=b.stid and (a.autName like ? or b.bName like ? or s.stName like ? or autPlace like ? or autSex like ? or autdate like ?)";
		authorlist = (List<Author>) admService.getList(Author.class, sql, xx, xx, xx, xx, xx, xx);
		ssName=Conversion.toF(ssName);
		return "retrieveAuthorOK";
	}

	// ��ʾ�û���Ϣ
	public String zbUserInfo() {
		stortlist1 = usrService.allStort();
		return "zbUserInfoOK";
	}

	// ��ʾ�޸�ҳ�����Ϣ
	public String zbNewPass() {
		stortlist1 = usrService.allStort();
		return "zbNewPassOK";
	}

	// �޸��û���Ϣ
	public String setUserInfo() {
		if (session.getAttribute("user") != null) {
			User u1 = (User) session.getAttribute("user");
			u1.setuSex(uSex);
			u1.setuTel(uTel);
			admService.update(u1);
			session.setAttribute("user", u1);
			return "setUserInfoOK";
		} else {
			return "setUserInfoNO";
		}
	}

	// �û��޸�����
	public String newPassword() {
		User u1 = (User) session.getAttribute("user");
		u1.setuPassword(uSex);
		admService.update(u1);
		session.removeAttribute("user");
		return "newPasswordOK";
	}

	// ����Ա�޸�����
	public String a_newPassword() {
		Admin u1 = (Admin) session.getAttribute("admin");
		u1.setAdmPassword(uSex);
		admService.update(u1);
		session.removeAttribute("admin");
		return "a_newPasswordOK";
	}
}
