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

	// 主页信息获取
	public String homeContent() {
		booklist = usrService.getPopularBook();// 最畅销的书本
		noteslist = usrService.getNotes();// 美文内容
		stortlist = usrService.getShowStort();//得到标记要展示的所有类型
		stortlist1 = usrService.allStort();//得到书库中的所有类型
		session.setAttribute("allstort", stortlist1);//存入session域备用
		// 得标记要到展示的所有类型对应的所有书本
		showStort1 = usrService.showBookByStort(stortlist.get(0).getStid());
		showStort2 = usrService.showBookByStort(stortlist.get(1).getStid());
		showStort3 = usrService.showBookByStort(stortlist.get(2).getStid());
		showStort4 = usrService.showBookByStort(stortlist.get(3).getStid());
		return "homeContentOK";
	}

	// 分页获取所有书本信息
	public String allBook() {
		int page=lucyUtil.getPage("pages");//判断Url中是否有页码，有则拿，无则当做第一页处理
		request.setAttribute("page", page);//返回给页面新的页码信息
		booklist = usrService.showAllBook(page);//拿到page页所有的书本
		return "allBookOK";
	}

	// 分页显示所有作者
	public String allAuthor() {
		int page=lucyUtil.getPage("pages");//判断Url中是否有页码，有则拿，无则当做第一页处理
		request.setAttribute("page", page);//返回给页面新的页码信息
		authorlist = usrService.showAllAuthor(page);//拿到page页所有的作者
		return "allAuthorOK";
	}

	//得到该作者名下的所有图书
	public String authorToBooks() {
		booklist = usrService.autToBooks(Integer.parseInt(request.getParameter("id")));//得到作者ID为"id"的所有书本
		return "authorToBooksOK";
	}

	// 得到该类型下的所有图书
	public String stortToBooks() {
		booklist = usrService.stoToBooks(Integer.parseInt(request.getParameter("id")));//得到类型ID为"id"的所有书本
		return "stortToBooksOK";
	}

	// 作者详情
	public String autDetail() {
		author = usrService.getAuthorById(Integer.parseInt(request.getParameter("id")));//得到ID为"id"的作者的详细信息
		return "autDetailOK";
	}

	// 用户登录
	public String login() {
		String isChick = request.getParameter("checkbox");//得到"复选框"的状态（选中则不为空，不选中则为空）
		lucyUtil.setCookie("LB_userID", uName, isChick != null);////如果"记住密码"复选框选中，则将uName以LB__userID为名字存储到Coolie中
		lucyUtil.setCookie("LB_userPass", uPass, isChick != null);//
		User user = new User();  
		user.setuName(uName);//将用户输入的用户名信息封装到user对象
		user.setuPassword(uPass);//将用户输入的密码信息封装到user对象
		if (usrService.login(user) != null) {
			session.setAttribute("user", usrService.login(user));//将用户信息存入session域中备用
			return "loginOK";//登录成功，进入首页
		} else {
			request.setAttribute("isOk", "isOk");//反馈给页面信息，产生弹框提示
			return "loginNO";//登录失败，返回登录页
		}
	}

	// 用户注册
	public String register() {
		User user = new User();//声明一个用户
		user.setuTel(uTel);//设置电话
		user.setuPassword(uPass);//设置密码
		user.setuName(uName);//设置登录名
		user.setChangenum(6);//加入默认的翻页设置6
		if (usrService.register(user)) {
			request.setAttribute("isOK", 0);//注册成功
		} else {
			request.setAttribute("isOK", 1);//注册失败，用户名已存在
		}
		return "register";
	}

	// 注销登录
	public String loginOut() {
		session.removeAttribute("user");//将存入到session对象中的user对象清除
		return "loginOutOK";
	}

	// 收货人列表
	public String myConsigness() {
		//检查session中 是否存在user,存在则表明当前处于登录状态，在登录状态则允许查看，否则返回强制重定向到登录页面
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//取出session域中的user对象
			conslist = (List<Consigness>) usrService.getConsigness(u.getUid());//根据外键uid拿到所有该用户所有的收货人信息
			return "ConsignessOK";
		} else
			return "ConsignessNO";//重定向到登录页面
	}
	//到添加收货人页面
	public String addCons() {
		return "addConsOK";
	}

	// 添加收货人并设置为默认
	public String addConsigness() {
		//检查session中 是否存在user,存在则表明当前处于登录状态，在登录状态则允许查看，否则返回强制重定向到登录页面
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//取出session域中的user对象
			Consigness con = new Consigness();//声明一个收货人
			con.setUid(u.getUid());//设置所属的用户
			con.setConsName(uName);//设置收货人的姓名
			con.setConsTel(uTel);//设置收货电话
			con.setConsAddre(uPass);//设置收货地址
			usrService.save(con);//执行添加操作
			con=(Consigness) usrService.getList(con).get(0);//由于ID是自动生成的，所以必须在添加后在查询一遍才能确保获得收货人ID
			u.setMyCons(con.getConsid());//将新增的收货人设置为该用户的默认收货人
			usrService.update(u);//设置为用户的默认收货人
			return "addConsignessOK";
		} else
			return "addConsignessNO";//重定向到登录页面
	}

	// 删除收货人
	public String delConsigness() {
		Consigness con = new Consigness();//声明一个收货人
		con.setConsid(Integer.parseInt(request.getParameter("id")));//设置将要删除的收货人的ID
		usrService.del(con);//执行删除操作
		return "delConsignessOK";
	}

	// 修改收货人数据准备
	public String updConsigness() {
		cons = (Consigness) usrService.getOne(Consigness.class, Integer.parseInt(request.getParameter("id")));//得到收货人ID为‘id’的收货人信息
		return "updConsignessOK";
	}

	// 更新收货人信息
	public String updateConsigness() {
		User u = (User) session.getAttribute("user");//取出session域中的user对象
		Consigness con = new Consigness();//声明一个收货人
		con.setConsid(id);//传入ID
		con.setConsName(uName);//设置新的'收货人姓名'
		con.setConsTel(uTel);//设置新的‘收货电话’
		con.setConsAddre(uPass);//设置新的‘收货地址’
		usrService.update(con);//执行更新操作
		return "updateConsignessOK";
	}

	// 更换默认收货人
	public String consToUser() {
		//检查session中 是否存在user,存在则表明当前处于登录状态，在登录状态则允许查看，否则返回强制重定向到登录页面
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//取出session域中的user对象
			u.setMyCons(Integer.parseInt(request.getParameter("id")));//将收货人ID为‘id’的收货人设置为该用户的默认收货人
			usrService.update(u);//执行修改操作
			return "consToUserOK";
		} else
			return "consToUserNO";//重定向到登录页面
	}

	// 购物车信息
	public String shoppingCart() {
		//检查session中 是否存在user,存在则表明当前处于登录状态，在登录状态则允许查看，否则返回强制重定向到登录页面
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//取出session域中的user对象
			booklist =usrService.shoppCart(u.getUid());//得到该用户购物车中的所有信息
			return "shoppingCartOK";
		} else {
			return "shoppingCartNO";//重定向到登录页面
		}
	}

	// 单个选中或反选
	public String changeState() {
		usrService.changeState(Integer.parseInt(request.getParameter("id")));//单个选中或不选中
		return "changeStateOK";
	}

	// 全选和反选
	public String allChoose() {
		String st = "";
		if (Integer.parseInt(request.getParameter("st")) == 1)//st=1为全选操作
			st = "已选中";
		if (Integer.parseInt(request.getParameter("st")) == 2)//st=2为全不选操作
			st = "未选中";
		usrService.allChoose(st);//执行选择操作
		return "allChooseOK";
	}

	// 删除购物车中的商品
	public String delGoods() {
		ShoppCart shopp = new ShoppCart();//声明一个购物车
		shopp.setShopid(Integer.parseInt(request.getParameter("id")));//设置要删除的购物车ID
		usrService.del(shopp);//执行删除操作
		return "delGoodsOK";
	}

	// 将商品添加到购物车
	public String addToCart() {
		//检查session中 是否存在user,存在则表明当前处于登录状态，在登录状态则允许查看，否则返回强制重定向到登录页面
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//取出session域中的user对象
			if (usrService.addToCart(u.getUid(), Integer.parseInt(request.getParameter("bid")))) {//判断书本库存，如果库存为0，则不让添加
				return "addToCartOK1";//添加成功
			} else {
				return "addToCartOK2";//书本库存为0，添加失败
			}
		} else {
			return "addToCartNO";//重定向到登录页面
		}
	}

	// 购物车中生成订单
	public String cartToOrder() {
		int[] numbers = toInt((String[]) request.getParameterValues("number"));//得到该用户购物车中所有商品的数量（选中+未选中）
		int[] shoppids = toInt((String[]) request.getParameterValues("shoppid"));//得到该用户所有购物车ID（选中+未选中）
		String beizhu = request.getParameter("beizhu");//得到用户的"备注信息"
		User u = (User) session.getAttribute("user");//得到session与对象中的user
		if (usrService.cartToOrder(u, shoppids, numbers, beizhu)) {//生成订单
			return "cartToOrderOK";//成功
		} else {
			return "cartToOrderNO";//订单生成失败(可能是未选中任何商品，也可能是购买数量超过库存量)
		}
	}

	// 显示明细信息
	public String ordDetail() {
		int ordid = Integer.parseInt(request.getParameter("ordid"));//得到订单ID
		Orders or = (Orders) usrService.getOne(Orders.class, ordid);//得到订单ID对应的订单
		cons = (Consigness) usrService.getOne(Consigness.class, or.getConsid());//得到订单对应的收货人
		String sql = "select b.bName,b.bPhoto,b.bPrice,d.money,d.number,o.ordid" + " FROM Detail d,Book b,Orders o"
				+ " where d.bid=b.bid and d.ordid=o.ordid and o.ordid=?";
		//得到明细的所有信息并封装到BookInfo类对象中
		booklist = (List<BookInfo>) usrService.getSqlSList(BookInfo.class, sql, or.getOrdid());
		return "ordDetailOK";
	}

	// 更换收货人页面的信息准备
	public String changeCons() {
		//检查session中 是否存在user,存在则表明当前处于登录状态，在登录状态则允许查看，否则返回强制重定向到登录页面
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//取出session域中的user对象
			Consigness con = new Consigness();//声明一个收货人
			con.setUid(u.getUid());//传入用户ID
			conslist = (List<Consigness>) usrService.getList(con);//得到该用户的所有收货人
			id = Integer.parseInt(request.getParameter("ord"));//将订单信息存入request域（提供更换收货人的订单信息）
			return "changeConsOK";
		} else
			return "changeConsNO";//重定向到登录页面
	}

	// 待支付订单
	public String myOrders() {
		//检查session中 是否存在user,存在则表明当前处于登录状态，在登录状态则允许查看，否则返回强制重定向到登录页面
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//取出session域中的user对象
			String sql="select o.*,c.consName" + 
					" from Consigness c,User u,Orders o" + 
					" where o.uid=u.uid and o.consid=c.consid and u.uid=? and o.ordpaystate=?";
			ordtlist = (List<Orders>) usrService.getSqlSList(Orders.class, sql, u.getUid(),"未付款");//得到状态为'未付款'的订单
			return "myOrdersOK";
		} else {
			return "myOrdersNO";//重定向到登录页面
		}
	}

	// 更换收货人操作
	public String changeConsigess() {
		Orders ord = (Orders) usrService.getOne(Orders.class, Integer.parseInt(request.getParameter("ordid")));//根据订单ID'ordid'得到订单信息
		ord.setConsid(Integer.parseInt(request.getParameter("cosid")));//将要修改的收货人ID传入
		usrService.update(ord);//执行更换操作
		return "changeConsigessOK";
	}
	
	//模拟付款
	public String payOrder() {
		Orders ord = (Orders) usrService.getOne(Orders.class, Integer.parseInt(request.getParameter("ordid")));//得到订单ID'ordid'的订单信息
		ord.setOrdPayState("已付款");//将‘付款状态’改为‘已付款’
		usrService.update(ord);//执修改操作
		return "payOrderOK";
	}
	// 已付款未发货订单
	public String payDetail() {
		//检查session中 是否存在user,存在则表明当前处于登录状态，在登录状态则允许查看，否则返回强制重定向到登录页面
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//取出session域中的user对象
			String sql="select o.*,c.consName" + 
					" from Consigness c,User u,Orders o" + 
					" where o.uid=u.uid and o.consid=c.consid and u.uid=? and o.ordpaystate=? and o.ordsendstate=?";
			ordtlist = (List<Orders>) usrService.getSqlSList(Orders.class, sql, u.getUid(),"已付款","未发货");//得到该用户‘已付款’‘未发货’的所有订单
			return "payDetailOK";
		} else {
			return "payDetailNO";//重定向到登录页面
		}
	}
	//查看订单明细
	public String payOrdDetail() {
		int ordid = Integer.parseInt(request.getParameter("ordid"));//得到订单ID'ordid'
		Orders or = (Orders) usrService.getOne(Orders.class, ordid);//得到订单信息
		cons = (Consigness) usrService.getOne(Consigness.class, or.getConsid());//得到收货人信息
		String sql = "select b.bName,b.bPhoto,b.bPrice,d.money,d.number,o.ordid" + " FROM Detail d,Book b,Orders o"
				+ " where d.bid=b.bid and d.ordid=o.ordid and o.ordid=?";
		booklist = (List<BookInfo>) usrService.getSqlSList(BookInfo.class, sql, or.getOrdid());//得到书本信息
		return "payOrdDetailOK";
	}
	//已完成订单
	public String sendOrder() {
		//检查session中 是否存在user,存在则表明当前处于登录状态，在登录状态则允许查看，否则返回强制重定向到登录页面
		if (session.getAttribute("user") != null) {
			User u = (User) session.getAttribute("user");//取出session域中的user对象
			String sql="select o.*,c.consName" + 
					" from Consigness c,User u,Orders o" + 
					" where o.uid=u.uid and o.consid=c.consid and u.uid=? and o.ordpaystate=? and o.ordsendstate=?";
			ordtlist = (List<Orders>) usrService.getSqlSList(Orders.class, sql, u.getUid(),"已付款","已发货");//得到该用户‘已付款’‘已发货’的所有订单
			return "sendOrderOK";
		} else {
			return "sendOrderNO";//重定向到登录页面
		}
	}
	//取消订单
	public String cancelOrder() {
		usrService.cancelOrder(Integer.parseInt(request.getParameter("ordid")));//根据订单ID"ordid"取消订单，并还原书本信息
		return "cancelOrderOK";
	}
	//多条件联合查询图书（书名+作者+类型）
	public String searchBook() {
		booklist = usrService.search(request.getParameter("bName"), request.getParameter("aName"), request.getParameter("sName"));//得到联合查询的结果
		return "searchBookOK";
	}
	/**
	 * 将字符串数组转化为int数组
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
