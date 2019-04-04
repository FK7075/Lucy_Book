package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entitry.Admin;
import entitry.Author;
import entitry.Stort;
import entitry.User;
import service.AdminService;
import service.UserService;
import util.BookInfo;
import util.Conversion;
import util.LucyUtil;
import util.PageInfo;

@SuppressWarnings("all")
public class AccountAction extends ActionSupport {
	private int id;
	private String ssName;
	private String uSex;
	private String uTel;
	private Integer fy;
	private LucyUtil lucyUtil=new LucyUtil();
	private AdminService admService = new AdminService();
	private UserService usrService = new UserService();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private List<User> userlist = new ArrayList<User>();
	private List<Admin> adminlist = new ArrayList<Admin>();
	private List<BookInfo> booklist = new ArrayList<BookInfo>();
	private List<Author> authorlist = new ArrayList<Author>();
	private List<Stort> stortlist1 = new ArrayList<Stort>();
	private HttpSession session = request.getSession();
	private Admin sessionAdmin=new Admin();

	public Integer getFy() {
		return fy;
	}

	public void setFy(Integer fy) {
		this.fy = fy;
	}

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

	public AccountAction()
	{
		this.sessionAdmin=(Admin) session.getAttribute("admin");
	}
	// ��ҳչʾ�û�
	public String allUser() {
		int page = lucyUtil.getPage("pages");
		PageInfo pi =new PageInfo(User.class,new User(),page,sessionAdmin.getPagesize());
		if (page == pi.getPagenum())
			request.setAttribute("fk", 1);
		request.setAttribute("page", page);
		userlist = (List<User>) admService.getListPag(new User(), pi.getIndex(), pi.getSize());
		return "allUserOK";
	}

	// ɾ���û�
	public String delUser() {
		admService.del(User.class, id);
		return "delUserOK";
	}

	// ��������"123456"
	public String resetPass() {
		User user = new User();
		user.setUid(id);
		user.setuPassword("123456");
		admService.update(user);
		return "resetPassOK";
	}

	// ��ҳչʾ����Ա
	public String allAdmin() {
		int page = lucyUtil.getPage("pages");
		PageInfo pi =new PageInfo(Admin.class, new Admin(), page, sessionAdmin.getPagesize());
		if (page == pi.getPagenum())
			request.setAttribute("fk", 1);
		request.setAttribute("page", page);
		adminlist = (List<Admin>) admService.getListPag(new Admin(), pi.getIndex(), pi.getSize());
		return "allAdminOK";
	}

	// ɾ��һ������Ա
	public String delAdmin() {
		if (id != 1 && id != 2) {
			admService.del(Admin.class, id);
		} else {
			request.setAttribute("fk1", 1);// �޷�ɾ����������Ա�ź�
		}
		return "delAdminOK";
	}

	// ��ʼ������Ա����
	public String resetAdmin() {
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
				+ " from Book b,Author a,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and (a.autName like ? or b.bName like ? or s.stName like ?)";
		booklist = (List<BookInfo>) admService.getList(BookInfo.class, sql, xx, xx, xx);
//		ssName=Conversion.toF(ssName);//��=��(1-Sin��)
		return "retrieveBookOK";
	}

	// �������������������������������߹����������Ա����߳������ڲ�����
	public String retrieveAuthor() {
		String xx = "%" + ssName + "%";
		String sql = "select distinct a.*" + " from Book b,Author a,Stort s"
				+ " where a.autid=b.autid and s.stid=b.stid and (a.autName like ? or b.bName like ? or s.stName like ? or autPlace like ? or autSex like ? or autdate like ?)";
		authorlist = (List<Author>) admService.getList(Author.class, sql, xx, xx, xx, xx, xx, xx);
//		ssName=Conversion.toF(ssName);//��=��(1-Sin��)
		return "retrieveAuthorOK";
	}

	// ��ʾ�û���Ϣ
	public String zbUserInfo() {
		stortlist1 = usrService.allStort();
		return "zbUserInfoOK";
	}

	// ��ʾ�޸�ҳ�����Ϣ
	public String zbNewPass() {
		return "zbNewPassOK";
	}

	// �޸��û���Ϣ
	public String setUserInfo() {
		if (session.getAttribute("user") != null) {
			User u1 = (User) session.getAttribute("user");
			u1.setuSex(uSex);
			u1.setuTel(uTel);
			u1.setChangenum(fy);
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
