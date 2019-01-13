package xflfk.wicresoft.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import xflfk.wicresoft.entitry.Author;
import xflfk.wicresoft.entitry.BookInfo;
import xflfk.wicresoft.entitry.Notes;
import xflfk.wicresoft.entitry.Stort;
import xflfk.wicresoft.entitry.User;
import xflfk.wicresoft.service.UserService;

@SuppressWarnings("all")
public class UserAction extends ActionSupport {
	private String uName;
	private String uPass;
	private UserService usrService=new UserService();
	private BookInfo bookInfo=new BookInfo();
	private List<Notes> noteslist=new ArrayList<Notes>();
	private List<BookInfo> booklist=new ArrayList<BookInfo>();
	private List<BookInfo> showStort1=new ArrayList<BookInfo>();
	private List<BookInfo> showStort2=new ArrayList<BookInfo>();
	private List<BookInfo> showStort3=new ArrayList<BookInfo>();
	private List<BookInfo> showStort4=new ArrayList<BookInfo>();
	private List<Stort> stortlist=new ArrayList<Stort>();
	private List<Stort> stortlist1=new ArrayList<Stort>();
	private Author author=new Author();
	private List<Author> authorlist=new ArrayList<Author>();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	
	
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
	public void setBooklist(List<BookInfo> booklist) {
		this.booklist = booklist;
	}
	public List<Stort> getStortlist() {
		return stortlist;
	}
	public void setStortlist(List<Stort> stortlist) {
		this.stortlist = stortlist;
	}
	//��ҳ��Ϣ��ȡ
	public String homeContent() {
		//������鱾
		booklist=usrService.getPopularBook();
		//��������
		noteslist=usrService.getNotes();
		//Ҫչʾ����������
		stortlist=usrService.getShowStort();
		stortlist1=usrService.allStort();
		//��Ҫ��չʾ���������Ͷ�Ӧ�������鱾
		showStort1=usrService.showBookByStort(stortlist.get(0).getStid());
		System.out.println(showStort1);
		showStort2=usrService.showBookByStort(stortlist.get(1).getStid());
		showStort3=usrService.showBookByStort(stortlist.get(2).getStid());
		showStort4=usrService.showBookByStort(stortlist.get(3).getStid());
		return "homeContentOK";
	}
	//��ҳ��ȡ�����鱾��Ϣ
	public String allBook() {
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		request.setAttribute("page", page);
		booklist=usrService.showAllBook(page);
		stortlist1=usrService.allStort();
		return "allBookOK";
	}
	//��ҳ��ʾ��������
	public String allAuthor() {
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		request.setAttribute("page", page);
		authorlist=usrService.showAllAuthor(page);
		stortlist1=usrService.allStort();
		return "allAuthorOK";
	}
	//�������߲�ͼ��
	public String authorToBooks() {
		booklist= usrService.autToBooks(Integer.parseInt(request.getParameter("id")));
		stortlist1=usrService.allStort();
		return "authorToBooksOK";
	}
	//�������Ͳ�ͼ��
	public String stortToBooks() {
		booklist= usrService.stoToBooks(Integer.parseInt(request.getParameter("id")));
		stortlist1=usrService.allStort();
		return "stortToBooksOK";
	}
	//��������
	public String autDetail() {
		author=usrService.getAuthorById(Integer.parseInt(request.getParameter("id")));
		stortlist1=usrService.allStort();
		return "autDetailOK";
	}
	//�û���¼
	public String login() {
		User user=new User();
		user.setuName(uName);user.setuPassword(uPass);
		if(usrService.login(user)!=null) {
			session.setAttribute("user", user);
			return "loginOK";
		}
		else {
			request.setAttribute("isOk", "isOk");
			return "loginNO";
			}
	}
}
