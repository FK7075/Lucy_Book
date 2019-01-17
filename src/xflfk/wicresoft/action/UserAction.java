package xflfk.wicresoft.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import xflfk.wicresoft.entitry.Author;
import xflfk.wicresoft.entitry.BookInfo;
import xflfk.wicresoft.entitry.Consigness;
import xflfk.wicresoft.entitry.Notes;
import xflfk.wicresoft.entitry.Stort;
import xflfk.wicresoft.entitry.User;
import xflfk.wicresoft.service.UserService;

@SuppressWarnings("all")
public class UserAction extends ActionSupport {
	private Integer id;
	private String uName;
	private String uPass;
	private String uTel;
	private UserService usrService = new UserService();
	private BookInfo bookInfo = new BookInfo();
	private List<Notes> noteslist = new ArrayList<Notes>();
	private List<BookInfo> booklist = new ArrayList<BookInfo>();
	private List<BookInfo> showStort1 = new ArrayList<BookInfo>();
	private List<BookInfo> showStort2 = new ArrayList<BookInfo>();
	private List<BookInfo> showStort3 = new ArrayList<BookInfo>();
	private List<BookInfo> showStort4 = new ArrayList<BookInfo>();
	private List<Stort> stortlist = new ArrayList<Stort>();
	private List<Stort> stortlist1 = new ArrayList<Stort>();
	private Author author = new Author();
	private Consigness cons = new Consigness();
	private List<Author> authorlist = new ArrayList<Author>();
	private List<Consigness> conslist = new ArrayList<Consigness>();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Consigness> getConslist() {
		return conslist;
	}

	public void setConslist(List<Consigness> conslist) {
		this.conslist = conslist;
	}

	public String getuTel() {
		return uTel;
	}

	public void setuTel(String uTel) {
		this.uTel = uTel;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPass() {
		return uPass;
	}

	public void setuPass(String uPass) {
		this.uPass = uPass;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Stort> getStortlist1() {
		return stortlist1;
	}

	public void setStortlist1(List<Stort> stortlist1) {
		this.stortlist1 = stortlist1;
	}

	public List<Author> getAuthorlist() {
		return authorlist;
	}

	public void setAuthorlist(List<Author> authorlist) {
		this.authorlist = authorlist;
	}

	public List<BookInfo> getShowStort1() {
		return showStort1;
	}

	public void setShowStort1(List<BookInfo> showStort1) {
		this.showStort1 = showStort1;
	}

	public List<BookInfo> getShowStort2() {
		return showStort2;
	}

	public void setShowStort2(List<BookInfo> showStort2) {
		this.showStort2 = showStort2;
	}

	public List<BookInfo> getShowStort3() {
		return showStort3;
	}

	public void setShowStort3(List<BookInfo> showStort3) {
		this.showStort3 = showStort3;
	}

	public List<BookInfo> getShowStort4() {
		return showStort4;
	}

	public void setShowStort4(List<BookInfo> showStort4) {
		this.showStort4 = showStort4;
	}

	public List<Notes> getNoteslist() {
		return noteslist;
	}

	public void setNoteslist(List<Notes> noteslist) {
		this.noteslist = noteslist;
	}

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public List<BookInfo> getBooklist() {
		return booklist;
	}

	public Consigness getCons() {
		return cons;
	}

	public void setCons(Consigness cons) {
		this.cons = cons;
	}

	public void setBooklist(List<BookInfo> booklist) {
		this.booklist = booklist;
	}

	public List<Stort> getStortlist() {
		return stortlist;
	}

	public void setStortlist(List<Stort> stortlist) {
		this.stortlist = stortlist;
	}

	// 主页信息获取
	public String homeContent() {
		// 最畅销的书本
		booklist = usrService.getPopularBook();
		// 美文内容
		noteslist = usrService.getNotes();
		// 要展示的所有类型
		stortlist = usrService.getShowStort();
		stortlist1 = usrService.allStort();
		// 得要到展示得所有类型对应的所有书本
		showStort1 = usrService.showBookByStort(stortlist.get(0).getStid());
		System.out.println(showStort1);
		showStort2 = usrService.showBookByStort(stortlist.get(1).getStid());
		showStort3 = usrService.showBookByStort(stortlist.get(2).getStid());
		showStort4 = usrService.showBookByStort(stortlist.get(3).getStid());
		return "homeContentOK";
	}

	// 分页获取所有书本信息
	public String allBook() {
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		request.setAttribute("page", page);
		booklist = usrService.showAllBook(page);
		stortlist1 = usrService.allStort();
		return "allBookOK";
	}

	// 分页显示所有作者
	public String allAuthor() {
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		request.setAttribute("page", page);
		authorlist = usrService.showAllAuthor(page);
		stortlist1 = usrService.allStort();
		return "allAuthorOK";
	}

	// 根据作者查图书
	public String authorToBooks() {
		booklist = usrService.autToBooks(Integer.parseInt(request.getParameter("id")));
		stortlist1 = usrService.allStort();
		return "authorToBooksOK";
	}

	// 根据类型查图书
	public String stortToBooks() {
		booklist = usrService.stoToBooks(Integer.parseInt(request.getParameter("id")));
		stortlist1 = usrService.allStort();
		return "stortToBooksOK";
	}

	// 作者详情
	public String autDetail() {
		author = usrService.getAuthorById(Integer.parseInt(request.getParameter("id")));
		stortlist1 = usrService.allStort();
		return "autDetailOK";
	}

	// 用户登录
	public String login() {
		String isChick = request.getParameter("checkbox");
		Cookie userIDcookie = new Cookie("LB_userID", uName);
		Cookie userpasscookie = new Cookie("LB_userPass", uPass);
		if (isChick != null) {
			userIDcookie.setMaxAge(7 * 24 * 60 * 60);
			userpasscookie.setMaxAge(7 * 24 * 60 * 60);
		} else {
			userIDcookie.setMaxAge(0);
			userpasscookie.setMaxAge(0);
		}
		response.addCookie(userIDcookie);
		response.addCookie(userpasscookie);
		User user = new User();
		user.setuName(uName);
		user.setuPassword(uPass);
		if (usrService.login(user) != null) {
			session.setAttribute("user", usrService.login(user));
			return "loginOK";
		} else {
			request.setAttribute("isOk", "isOk");
			return "loginNO";
		}
	}

	// 用户注册
	public String register() {
		User user = new User();
		user.setuTel(uTel);
		user.setuPassword(uPass);
		user.setuName(uName);
		if (usrService.register(user)) {
			request.setAttribute("isOK", 0);
		} else {
			request.setAttribute("isOK", 1);
		}
		return "register";
	}

	// 注销登录
	public String loginOut() {
		session.removeAttribute("user");
		return "loginOutOK";
	}
	//收货人列表
	public String myConsigness() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			Consigness con = new Consigness();
			System.out.println(u);
			con.setUid(u.getUid());
			conslist = (List<Consigness>) usrService.getList(con);
			stortlist1 = usrService.allStort();
			return "ConsignessOK";
		} 
		else
			return "ConsignessNO";
	}
	public String addCons() {
		stortlist1 = usrService.allStort();
		return "addConsOK";
	}
	//添加收货人
	public String addConsigness() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			Consigness con = new Consigness();
			con.setUid(u.getUid());con.setConsName(uName);
			con.setConsTel(uTel);con.setConsAddre(uPass);
			usrService.save(con);
			stortlist1 = usrService.allStort();
			return "addConsignessOK";
		} 
		else
			return "addConsignessNO";
	}
	//删除收货人
	public String delConsigness() {
		Consigness con=new Consigness();
		con.setConsid(Integer.parseInt(request.getParameter("id")));
		usrService.del(con);
		return "delConsignessOK";
	}
	//修改收货人数据准备
	public String updConsigness() {
		cons=(Consigness) usrService.getOne(Consigness.class, Integer.parseInt(request.getParameter("id")));
		stortlist1 = usrService.allStort();
		return "updConsignessOK";
	}
	public String updateConsigness() {
			User u = (User) session.getAttribute("user");
			Consigness con = new Consigness();
			con.setConsid(id);;con.setConsName(uName);
			con.setConsTel(uTel);con.setConsAddre(uPass);
			usrService.update(con);
			return "updateConsignessOK";
	}
	public String consToUser() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			u.setMyCons(Integer.parseInt(request.getParameter("id")));
			usrService.update(u);
			return "consToUserOK";
		} 
		else
			return "consToUserNO";
	}
}
