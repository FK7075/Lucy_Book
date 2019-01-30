package xflfk.wicresoft.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.config.Order;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import xflfk.wicresoft.entitry.Author;
import xflfk.wicresoft.entitry.BookInfo;
import xflfk.wicresoft.entitry.Consigness;
import xflfk.wicresoft.entitry.Notes;
import xflfk.wicresoft.entitry.Orders;
import xflfk.wicresoft.entitry.ShoppCart;
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
	private List<Orders> ordtlist = new ArrayList<Orders>();
	private Author author = new Author();
	private Consigness cons = new Consigness();
	private List<Author> authorlist = new ArrayList<Author>();
	private List<Consigness> conslist = new ArrayList<Consigness>();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	public List<Orders> getOrdtlist() {
		return ordtlist;
	}

	public void setOrdtlist(List<Orders> ordtlist) {
		this.ordtlist = ordtlist;
	}

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

	// ��ҳ��Ϣ��ȡ
	public String homeContent() {
		// ������鱾
		booklist = usrService.getPopularBook();
		// ��������
		noteslist = usrService.getNotes();
		// Ҫչʾ����������
		stortlist = usrService.getShowStort();
		stortlist1 = usrService.allStort();
		// ��Ҫ��չʾ���������Ͷ�Ӧ�������鱾
		showStort1 = usrService.showBookByStort(stortlist.get(0).getStid());
		showStort2 = usrService.showBookByStort(stortlist.get(1).getStid());
		showStort3 = usrService.showBookByStort(stortlist.get(2).getStid());
		showStort4 = usrService.showBookByStort(stortlist.get(3).getStid());
		return "homeContentOK";
	}

	// ��ҳ��ȡ�����鱾��Ϣ
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

	// ��ҳ��ʾ��������
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

	// �������߲�ͼ��
	public String authorToBooks() {
		booklist = usrService.autToBooks(Integer.parseInt(request.getParameter("id")));
		stortlist1 = usrService.allStort();
		return "authorToBooksOK";
	}

	// �������Ͳ�ͼ��
	public String stortToBooks() {
		booklist = usrService.stoToBooks(Integer.parseInt(request.getParameter("id")));
		stortlist1 = usrService.allStort();
		return "stortToBooksOK";
	}

	// ��������
	public String autDetail() {
		author = usrService.getAuthorById(Integer.parseInt(request.getParameter("id")));
		stortlist1 = usrService.allStort();
		return "autDetailOK";
	}

	// �û���¼
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

	// �û�ע��
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

	// ע����¼
	public String loginOut() {
		session.removeAttribute("user");
		return "loginOutOK";
	}

	// �ջ����б�
	public String myConsigness() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			Consigness con = new Consigness();
			System.out.println(u);
			con.setUid(u.getUid());
			conslist = (List<Consigness>) usrService.getList(con);
			stortlist1 = usrService.allStort();
			return "ConsignessOK";
		} else
			return "ConsignessNO";
	}

	public String addCons() {
		stortlist1 = usrService.allStort();
		return "addConsOK";
	}

	// ����ջ��˲�����ΪĬ��
	public String addConsigness() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			Consigness con = new Consigness();
			con.setUid(u.getUid());
			con.setConsName(uName);
			con.setConsTel(uTel);
			con.setConsAddre(uPass);
			usrService.save(con);
			con=(Consigness) usrService.getList(con).get(0);
			u.setMyCons(con.getConsid());
			usrService.update(u);
			stortlist1 = usrService.allStort();
			return "addConsignessOK";
		} else
			return "addConsignessNO";
	}

	// ɾ���ջ���
	public String delConsigness() {
		Consigness con = new Consigness();
		con.setConsid(Integer.parseInt(request.getParameter("id")));
		usrService.del(con);
		return "delConsignessOK";
	}

	// �޸��ջ�������׼��
	public String updConsigness() {
		cons = (Consigness) usrService.getOne(Consigness.class, Integer.parseInt(request.getParameter("id")));
		stortlist1 = usrService.allStort();
		return "updConsignessOK";
	}

	// �����ջ�����Ϣ
	public String updateConsigness() {
		User u = (User) session.getAttribute("user");
		Consigness con = new Consigness();
		con.setConsid(id);
		con.setConsName(uName);
		con.setConsTel(uTel);
		con.setConsAddre(uPass);
		usrService.update(con);
		return "updateConsignessOK";
	}

	// �����ջ��˼��붩����Ϣ
	public String consToUser() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			u.setMyCons(Integer.parseInt(request.getParameter("id")));
			usrService.update(u);
			stortlist1 = usrService.allStort();
			return "consToUserOK";
		} else
			return "consToUserNO";
	}

	// ���ﳵ��Ϣ
	public String shoppingCart() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			String sql = "select b.bName,b.bPhoto,b.bPrice,s.state,s.shopid" + " FROM shoppcart s,book b,user u"
					+ " where s.bid=b.bid and s.uid=u.uid and s.uid=?";
			booklist = (List<BookInfo>) usrService.getSqlSList(BookInfo.class, sql, u.getUid());
			stortlist1 = usrService.allStort();
			return "shoppingCartOK";
		} else {
			return "shoppingCartNO";
		}
	}

	// ����ѡ�л�ѡ
	public String changeState() {
		ShoppCart shopping = (ShoppCart) usrService.getOne(ShoppCart.class,
				Integer.parseInt(request.getParameter("id")));
		if (shopping.getState().equals("δѡ��"))
			shopping.setState("��ѡ��");
		else
			shopping.setState("δѡ��");
		usrService.update(shopping);
		return "changeStateOK";
	}

	// ȫѡ�ͷ�ѡ
	public String allChoose() {
		String st = "";
		if (Integer.parseInt(request.getParameter("st")) == 1)
			st = "��ѡ��";
		if (Integer.parseInt(request.getParameter("st")) == 2)
			st = "δѡ��";
		String sql = "update ShoppCart set state=?";
		usrService.update(sql, st);
		return "allChooseOK";
	}

	// ɾ�����ﳵ�е���Ʒ
	public String delGoods() {
		ShoppCart shopp = new ShoppCart();
		shopp.setShopid(Integer.parseInt(request.getParameter("id")));
		usrService.del(shopp);
		return "delGoodsOK";
	}

	// ����Ʒ��ӵ����ﳵ
	public String addToCart() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			if (usrService.addToCart(u.getUid(), Integer.parseInt(request.getParameter("bid")))) {
				stortlist1 = usrService.allStort();
				return "addToCartOK1";
			} else {
				stortlist1 = usrService.allStort();
				return "addToCartOK2";
			}
		} else {
			return "addToCartNO";
		}
	}

	// ���ﳵ�����ɶ���
	public String cartToOrder() {
		int[] numbers = toInt((String[]) request.getParameterValues("number"));
		int[] shoppids = toInt((String[]) request.getParameterValues("shoppid"));
		String beizhu = request.getParameter("beizhu");
		User u = (User) session.getAttribute("user");
		if (usrService.cartToOrder(u, shoppids, numbers, beizhu)) {
			return "cartToOrderOK";
		} else {
			stortlist1 = usrService.allStort();
			return "cartToOrderNO";
		}
	}

	// ��ʾ��ϸ��Ϣ
	public String ordDetail() {
		stortlist1 = usrService.allStort();
		int ordid = Integer.parseInt(request.getParameter("ordid"));
		Orders or = (Orders) usrService.getOne(Orders.class, ordid);
		cons = (Consigness) usrService.getOne(Consigness.class, or.getConsid());
		String sql = "select b.bName,b.bPhoto,b.bPrice,d.money,d.number,o.ordid" + " FROM detail d,book b,Orders o"
				+ " where d.bid=b.bid and d.ordid=o.ordid and o.ordid=?";
		booklist = (List<BookInfo>) usrService.getSqlSList(BookInfo.class, sql, or.getOrdid());
		return "ordDetailOK";
	}

	// �����ջ���ҳ��
	public String changeCons() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			Consigness con = new Consigness();
			con.setUid(u.getUid());
			conslist = (List<Consigness>) usrService.getList(con);
			id = Integer.parseInt(request.getParameter("ord"));
			stortlist1 = usrService.allStort();
			return "changeConsOK";
		} else
			return "changeConsNO";
	}

	// ��֧������
	public String myOrders() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			String sql="select o.*,c.consName" + 
					" from consigness c,user u,orders o" + 
					" where o.uid=u.uid and o.consid=c.consid and u.uid=? and o.ordpaystate=?";
			ordtlist = (List<Orders>) usrService.getSqlSList(Orders.class, sql, u.getUid(),"δ����");
			stortlist1 = usrService.allStort();
			return "myOrdersOK";
		} else {
			return "myOrdersNO";
		}
	}

	// �����ջ��˲���
	public String changeConsigess() {
		Orders ord = (Orders) usrService.getOne(Orders.class, Integer.parseInt(request.getParameter("ordid")));
		ord.setConsid(Integer.parseInt(request.getParameter("cosid")));
		usrService.update(ord);
		stortlist1 = usrService.allStort();
		return "changeConsigessOK";
	}

	public String payOrder() {
		Orders ord = (Orders) usrService.getOne(Orders.class, Integer.parseInt(request.getParameter("ordid")));
		ord.setOrdPayState("�Ѹ���");
		usrService.update(ord);
		stortlist1 = usrService.allStort();
		return "payOrderOK";
	}
	// �Ѹ���δ��������
	public String payDetail() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			String sql="select o.*,c.consName" + 
					" from consigness c,user u,orders o" + 
					" where o.uid=u.uid and o.consid=c.consid and u.uid=? and o.ordpaystate=? and o.ordsendstate=?";
			ordtlist = (List<Orders>) usrService.getSqlSList(Orders.class, sql, u.getUid(),"�Ѹ���","δ����");
			stortlist1 = usrService.allStort();
			return "payDetailOK";
		} else {
			return "payDetailNO";
		}
	}
	//δ�����˵�������ɶ�����ϸ
	public String payOrdDetail() {
		stortlist1 = usrService.allStort();
		int ordid = Integer.parseInt(request.getParameter("ordid"));
		Orders or = (Orders) usrService.getOne(Orders.class, ordid);
		cons = (Consigness) usrService.getOne(Consigness.class, or.getConsid());
		String sql = "select b.bName,b.bPhoto,b.bPrice,d.money,d.number,o.ordid" + " FROM detail d,book b,Orders o"
				+ " where d.bid=b.bid and d.ordid=o.ordid and o.ordid=?";
		booklist = (List<BookInfo>) usrService.getSqlSList(BookInfo.class, sql, or.getOrdid());
		return "payOrdDetailOK";
	}
	//����ɶ���
	public String sendOrder() {
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");
			String sql="select o.*,c.consName" + 
					" from consigness c,user u,orders o" + 
					" where o.uid=u.uid and o.consid=c.consid and u.uid=? and o.ordpaystate=? and o.ordsendstate=?";
			ordtlist = (List<Orders>) usrService.getSqlSList(Orders.class, sql, u.getUid(),"�Ѹ���","�ѷ���");
			stortlist1 = usrService.allStort();
			return "sendOrderOK";
		} else {
			return "sendOrderNO";
		}
	}
	//ȡ������
	public String cancelOrder() {
		usrService.cancelOrder(Integer.parseInt(request.getParameter("ordid")));
		return "cancelOrderOK";
	}
	public String searchBook() {
		booklist = usrService.search(request.getParameter("bName"), request.getParameter("aName"), request.getParameter("sName"));
		stortlist1 = usrService.allStort();
		return "searchBookOK";
	}
	// �ַ�������תint����
	private int[] toInt(String[] s) {
		int[] n = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			n[i] = Integer.parseInt(s[i]);
		}
		return n;
	}
}
