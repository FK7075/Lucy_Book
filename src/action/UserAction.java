package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.config.Order;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entitry.Author;
import entitry.Consigness;
import entitry.Notes;
import entitry.Orders;
import entitry.ShoppCart;
import entitry.Stort;
import entitry.User;
import service.UserService;
import util.BookInfo;
import util.LucyUtil;

@SuppressWarnings("all")
public class UserAction extends ActionSupport {
	private Integer id;
	private String uName;
	private String uPass;
	private String uTel;
	private LucyUtil lucyUtil=new LucyUtil();
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
		booklist = usrService.getPopularBook();// ������鱾
		noteslist = usrService.getNotes();// ��������
		stortlist = usrService.getShowStort();//�õ����Ҫչʾ����������
		stortlist1 = usrService.allStort();//�õ�����е���������
		session.setAttribute("allstort", stortlist1);//����session����
		// �ñ��Ҫ��չʾ���������Ͷ�Ӧ�������鱾
		showStort1 = usrService.showBookByStort(stortlist.get(0).getStid());
		showStort2 = usrService.showBookByStort(stortlist.get(1).getStid());
		showStort3 = usrService.showBookByStort(stortlist.get(2).getStid());
		showStort4 = usrService.showBookByStort(stortlist.get(3).getStid());
		return "homeContentOK";
	}

	// ��ҳ��ȡ�����鱾��Ϣ
	public String allBook() {
		int page=lucyUtil.getPage("pages");//�ж�Url���Ƿ���ҳ�룬�����ã���������һҳ����
		request.setAttribute("page", page);//���ظ�ҳ���µ�ҳ����Ϣ
		booklist = usrService.showAllBook(page);//�õ�pageҳ���е��鱾
		return "allBookOK";
	}

	// ��ҳ��ʾ��������
	public String allAuthor() {
		int page=lucyUtil.getPage("pages");//�ж�Url���Ƿ���ҳ�룬�����ã���������һҳ����
		request.setAttribute("page", page);//���ظ�ҳ���µ�ҳ����Ϣ
		authorlist = usrService.showAllAuthor(page);//�õ�pageҳ���е�����
		return "allAuthorOK";
	}

	//�õ����������µ�����ͼ��
	public String authorToBooks() {
		booklist = usrService.autToBooks(Integer.parseInt(request.getParameter("id")));//�õ�����IDΪ"id"�������鱾
		return "authorToBooksOK";
	}

	// �õ��������µ�����ͼ��
	public String stortToBooks() {
		booklist = usrService.stoToBooks(Integer.parseInt(request.getParameter("id")));//�õ�����IDΪ"id"�������鱾
		return "stortToBooksOK";
	}

	// ��������
	public String autDetail() {
		author = usrService.getAuthorById(Integer.parseInt(request.getParameter("id")));//�õ�IDΪ"id"�����ߵ���ϸ��Ϣ
		return "autDetailOK";
	}

	// �û���¼
	public String login() {
		String isChick = request.getParameter("checkbox");//�õ�"��ѡ��"��״̬��ѡ����Ϊ�գ���ѡ����Ϊ�գ�
		lucyUtil.setCookie("LB_userID", uName, isChick != null);////���"��ס����"��ѡ��ѡ�У���uName��LB__userIDΪ���ִ洢��Coolie��
		lucyUtil.setCookie("LB_userPass", uPass, isChick != null);//
		User user = new User();  
		user.setuName(uName);//���û�������û�����Ϣ��װ��user����
		user.setuPassword(uPass);//���û������������Ϣ��װ��user����
		if (usrService.login(user) != null) {
			session.setAttribute("user", usrService.login(user));//���û���Ϣ����session���б���
			return "loginOK";//��¼�ɹ���������ҳ
		} else {
			request.setAttribute("isOk", "isOk");//������ҳ����Ϣ������������ʾ
			return "loginNO";//��¼ʧ�ܣ����ص�¼ҳ
		}
	}

	// �û�ע��
	public String register() {
		User user = new User();//����һ���û�
		user.setuTel(uTel);//���õ绰
		user.setuPassword(uPass);//��������
		user.setuName(uName);//���õ�¼��
		user.setChangenum(6);//����Ĭ�ϵķ�ҳ����6
		if (usrService.register(user)) {
			request.setAttribute("isOK", 0);//ע��ɹ�
		} else {
			request.setAttribute("isOK", 1);//ע��ʧ�ܣ��û����Ѵ���
		}
		return "register";
	}

	// ע����¼
	public String loginOut() {
		session.removeAttribute("user");//�����뵽session�����е�user�������
		return "loginOutOK";
	}

	// �ջ����б�
	public String myConsigness() {
		//���session�� �Ƿ����user,�����������ǰ���ڵ�¼״̬���ڵ�¼״̬������鿴�����򷵻�ǿ���ض��򵽵�¼ҳ��
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//ȡ��session���е�user����
			conslist = (List<Consigness>) usrService.getConsigness(u.getUid());//�������uid�õ����и��û����е��ջ�����Ϣ
			return "ConsignessOK";
		} else
			return "ConsignessNO";//�ض��򵽵�¼ҳ��
	}
	//������ջ���ҳ��
	public String addCons() {
		return "addConsOK";
	}

	// ����ջ��˲�����ΪĬ��
	public String addConsigness() {
		//���session�� �Ƿ����user,�����������ǰ���ڵ�¼״̬���ڵ�¼״̬������鿴�����򷵻�ǿ���ض��򵽵�¼ҳ��
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//ȡ��session���е�user����
			Consigness con = new Consigness();//����һ���ջ���
			con.setUid(u.getUid());//�����������û�
			con.setConsName(uName);//�����ջ��˵�����
			con.setConsTel(uTel);//�����ջ��绰
			con.setConsAddre(uPass);//�����ջ���ַ
			usrService.save(con);//ִ����Ӳ���
			con=(Consigness) usrService.getList(con).get(0);//����ID���Զ����ɵģ����Ա�������Ӻ��ڲ�ѯһ�����ȷ������ջ���ID
			u.setMyCons(con.getConsid());//���������ջ�������Ϊ���û���Ĭ���ջ���
			usrService.update(u);//����Ϊ�û���Ĭ���ջ���
			return "addConsignessOK";
		} else
			return "addConsignessNO";//�ض��򵽵�¼ҳ��
	}

	// ɾ���ջ���
	public String delConsigness() {
		Consigness con = new Consigness();//����һ���ջ���
		con.setConsid(Integer.parseInt(request.getParameter("id")));//���ý�Ҫɾ�����ջ��˵�ID
		usrService.del(con);//ִ��ɾ������
		return "delConsignessOK";
	}

	// �޸��ջ�������׼��
	public String updConsigness() {
		cons = (Consigness) usrService.getOne(Consigness.class, Integer.parseInt(request.getParameter("id")));//�õ��ջ���IDΪ��id�����ջ�����Ϣ
		return "updConsignessOK";
	}

	// �����ջ�����Ϣ
	public String updateConsigness() {
		User u = (User) session.getAttribute("user");//ȡ��session���е�user����
		Consigness con = new Consigness();//����һ���ջ���
		con.setConsid(id);//����ID
		con.setConsName(uName);//�����µ�'�ջ�������'
		con.setConsTel(uTel);//�����µġ��ջ��绰��
		con.setConsAddre(uPass);//�����µġ��ջ���ַ��
		usrService.update(con);//ִ�и��²���
		return "updateConsignessOK";
	}

	// ����Ĭ���ջ���
	public String consToUser() {
		//���session�� �Ƿ����user,�����������ǰ���ڵ�¼״̬���ڵ�¼״̬������鿴�����򷵻�ǿ���ض��򵽵�¼ҳ��
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//ȡ��session���е�user����
			u.setMyCons(Integer.parseInt(request.getParameter("id")));//���ջ���IDΪ��id�����ջ�������Ϊ���û���Ĭ���ջ���
			usrService.update(u);//ִ���޸Ĳ���
			return "consToUserOK";
		} else
			return "consToUserNO";//�ض��򵽵�¼ҳ��
	}

	// ���ﳵ��Ϣ
	public String shoppingCart() {
		//���session�� �Ƿ����user,�����������ǰ���ڵ�¼״̬���ڵ�¼״̬������鿴�����򷵻�ǿ���ض��򵽵�¼ҳ��
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//ȡ��session���е�user����
			booklist =usrService.shoppCart(u.getUid());//�õ����û����ﳵ�е�������Ϣ
			return "shoppingCartOK";
		} else {
			return "shoppingCartNO";//�ض��򵽵�¼ҳ��
		}
	}

	// ����ѡ�л�ѡ
	public String changeState() {
		usrService.changeState(Integer.parseInt(request.getParameter("id")));//����ѡ�л�ѡ��
		return "changeStateOK";
	}

	// ȫѡ�ͷ�ѡ
	public String allChoose() {
		String st = "";
		if (Integer.parseInt(request.getParameter("st")) == 1)//st=1Ϊȫѡ����
			st = "��ѡ��";
		if (Integer.parseInt(request.getParameter("st")) == 2)//st=2Ϊȫ��ѡ����
			st = "δѡ��";
		usrService.allChoose(st);//ִ��ѡ�����
		return "allChooseOK";
	}

	// ɾ�����ﳵ�е���Ʒ
	public String delGoods() {
		ShoppCart shopp = new ShoppCart();//����һ�����ﳵ
		shopp.setShopid(Integer.parseInt(request.getParameter("id")));//����Ҫɾ���Ĺ��ﳵID
		usrService.del(shopp);//ִ��ɾ������
		return "delGoodsOK";
	}

	// ����Ʒ��ӵ����ﳵ
	public String addToCart() {
		//���session�� �Ƿ����user,�����������ǰ���ڵ�¼״̬���ڵ�¼״̬������鿴�����򷵻�ǿ���ض��򵽵�¼ҳ��
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//ȡ��session���е�user����
			if (usrService.addToCart(u.getUid(), Integer.parseInt(request.getParameter("bid")))) {//�ж��鱾��棬������Ϊ0���������
				return "addToCartOK1";//��ӳɹ�
			} else {
				return "addToCartOK2";//�鱾���Ϊ0�����ʧ��
			}
		} else {
			return "addToCartNO";//�ض��򵽵�¼ҳ��
		}
	}

	// ���ﳵ�����ɶ���
	public String cartToOrder() {
		int[] numbers = toInt((String[]) request.getParameterValues("number"));//�õ����û����ﳵ��������Ʒ��������ѡ��+δѡ�У�
		int[] shoppids = toInt((String[]) request.getParameterValues("shoppid"));//�õ����û����й��ﳵID��ѡ��+δѡ�У�
		String beizhu = request.getParameter("beizhu");//�õ��û���"��ע��Ϣ"
		User u = (User) session.getAttribute("user");//�õ�session������е�user
		if (usrService.cartToOrder(u, shoppids, numbers, beizhu)) {//���ɶ���
			return "cartToOrderOK";//�ɹ�
		} else {
			return "cartToOrderNO";//��������ʧ��(������δѡ���κ���Ʒ��Ҳ�����ǹ����������������)
		}
	}

	// ��ʾ��ϸ��Ϣ
	public String ordDetail() {
		int ordid = Integer.parseInt(request.getParameter("ordid"));//�õ�����ID
		Orders or = (Orders) usrService.getOne(Orders.class, ordid);//�õ�����ID��Ӧ�Ķ���
		cons = (Consigness) usrService.getOne(Consigness.class, or.getConsid());//�õ�������Ӧ���ջ���
		String sql = "select b.bName,b.bPhoto,b.bPrice,d.money,d.number,o.ordid" + " FROM Detail d,Book b,Orders o"
				+ " where d.bid=b.bid and d.ordid=o.ordid and o.ordid=?";
		//�õ���ϸ��������Ϣ����װ��BookInfo�������
		booklist = (List<BookInfo>) usrService.getSqlSList(BookInfo.class, sql, or.getOrdid());
		return "ordDetailOK";
	}

	// �����ջ���ҳ�����Ϣ׼��
	public String changeCons() {
		//���session�� �Ƿ����user,�����������ǰ���ڵ�¼״̬���ڵ�¼״̬������鿴�����򷵻�ǿ���ض��򵽵�¼ҳ��
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//ȡ��session���е�user����
			Consigness con = new Consigness();//����һ���ջ���
			con.setUid(u.getUid());//�����û�ID
			conslist = (List<Consigness>) usrService.getList(con);//�õ����û��������ջ���
			id = Integer.parseInt(request.getParameter("ord"));//��������Ϣ����request���ṩ�����ջ��˵Ķ�����Ϣ��
			return "changeConsOK";
		} else
			return "changeConsNO";//�ض��򵽵�¼ҳ��
	}

	// ��֧������
	public String myOrders() {
		//���session�� �Ƿ����user,�����������ǰ���ڵ�¼״̬���ڵ�¼״̬������鿴�����򷵻�ǿ���ض��򵽵�¼ҳ��
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//ȡ��session���е�user����
			String sql="select o.*,c.consName" + 
					" from Consigness c,User u,Orders o" + 
					" where o.uid=u.uid and o.consid=c.consid and u.uid=? and o.ordpaystate=?";
			ordtlist = (List<Orders>) usrService.getSqlSList(Orders.class, sql, u.getUid(),"δ����");//�õ�״̬Ϊ'δ����'�Ķ���
			return "myOrdersOK";
		} else {
			return "myOrdersNO";//�ض��򵽵�¼ҳ��
		}
	}

	// �����ջ��˲���
	public String changeConsigess() {
		Orders ord = (Orders) usrService.getOne(Orders.class, Integer.parseInt(request.getParameter("ordid")));//���ݶ���ID'ordid'�õ�������Ϣ
		ord.setConsid(Integer.parseInt(request.getParameter("cosid")));//��Ҫ�޸ĵ��ջ���ID����
		usrService.update(ord);//ִ�и�������
		return "changeConsigessOK";
	}
	
	//ģ�⸶��
	public String payOrder() {
		Orders ord = (Orders) usrService.getOne(Orders.class, Integer.parseInt(request.getParameter("ordid")));//�õ�����ID'ordid'�Ķ�����Ϣ
		ord.setOrdPayState("�Ѹ���");//��������״̬����Ϊ���Ѹ��
		usrService.update(ord);//ִ�޸Ĳ���
		return "payOrderOK";
	}
	// �Ѹ���δ��������
	public String payDetail() {
		//���session�� �Ƿ����user,�����������ǰ���ڵ�¼״̬���ڵ�¼״̬������鿴�����򷵻�ǿ���ض��򵽵�¼ҳ��
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//ȡ��session���е�user����
			String sql="select o.*,c.consName" + 
					" from Consigness c,User u,Orders o" + 
					" where o.uid=u.uid and o.consid=c.consid and u.uid=? and o.ordpaystate=? and o.ordsendstate=?";
			ordtlist = (List<Orders>) usrService.getSqlSList(Orders.class, sql, u.getUid(),"�Ѹ���","δ����");//�õ����û����Ѹ����δ�����������ж���
			return "payDetailOK";
		} else {
			return "payDetailNO";//�ض��򵽵�¼ҳ��
		}
	}
	//�鿴������ϸ
	public String payOrdDetail() {
		int ordid = Integer.parseInt(request.getParameter("ordid"));//�õ�����ID'ordid'
		Orders or = (Orders) usrService.getOne(Orders.class, ordid);//�õ�������Ϣ
		cons = (Consigness) usrService.getOne(Consigness.class, or.getConsid());//�õ��ջ�����Ϣ
		String sql = "select b.bName,b.bPhoto,b.bPrice,d.money,d.number,o.ordid" + " FROM Detail d,Book b,Orders o"
				+ " where d.bid=b.bid and d.ordid=o.ordid and o.ordid=?";
		booklist = (List<BookInfo>) usrService.getSqlSList(BookInfo.class, sql, or.getOrdid());//�õ��鱾��Ϣ
		return "payOrdDetailOK";
	}
	//����ɶ���
	public String sendOrder() {
		//���session�� �Ƿ����user,�����������ǰ���ڵ�¼״̬���ڵ�¼״̬������鿴�����򷵻�ǿ���ض��򵽵�¼ҳ��
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//ȡ��session���е�user����
			String sql="select o.*,c.consName" + 
					" from Consigness c,User u,Orders o" + 
					" where o.uid=u.uid and o.consid=c.consid and u.uid=? and o.ordpaystate=? and o.ordsendstate=?";
			ordtlist = (List<Orders>) usrService.getSqlSList(Orders.class, sql, u.getUid(),"�Ѹ���","�ѷ���");//�õ����û����Ѹ�����ѷ����������ж���
			return "sendOrderOK";
		} else {
			return "sendOrderNO";//�ض��򵽵�¼ҳ��
		}
	}
	//ȡ������
	public String cancelOrder() {
		usrService.cancelOrder(Integer.parseInt(request.getParameter("ordid")));//���ݶ���ID"ordid"ȡ������������ԭ�鱾��Ϣ
		return "cancelOrderOK";
	}
	//���������ϲ�ѯͼ�飨����+����+���ͣ�
	public String searchBook() {
		booklist = usrService.search(request.getParameter("bName"), request.getParameter("aName"), request.getParameter("sName"));//�õ����ϲ�ѯ�Ľ��
		return "searchBookOK";
	}
	/**
	 * ���ַ�������ת��Ϊint����
	 * @param s
	 * @return
	 */
	private int[] toInt(String[] s) {
		int[] n = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			n[i] = Integer.parseInt(s[i]);
		}
		return n;
	}
}
