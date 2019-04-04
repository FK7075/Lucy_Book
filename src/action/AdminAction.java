package action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entitry.Admin;
import entitry.Author;
import entitry.Book;
import entitry.Notes;
import entitry.Orders;
import entitry.Stort;
import service.AdminService;
import service.UserService;
import util.BookInfo;
import util.DetailInfo;
import util.LucyUtil;
import util.OrderInfo;
import util.PageInfo;

@SuppressWarnings("all")
public class AdminAction extends ActionSupport {
	private LucyUtil lucyUtil=new LucyUtil();
	private String username;// 用户名
	private String password;// 
	private AdminService admService = new AdminService();
	private UserService usrService = new UserService();
	private List<BookInfo> booklist = new ArrayList<BookInfo>();// 要展示的所有书本信息的集合
	private List<Author> autlist = new ArrayList<Author>();// 所有作者信息
	private List<Stort> stlist = new ArrayList<Stort>();// 所有类型信息
	private List<Object> lolist = new ArrayList<Object>();
	private Admin sessionAdmin=new Admin();
	private Admin admCfg=new Admin();
	private String bookName;// 书名
	private String bookDetail;// 描述
	private String admTel;// 
	private String admPass;// 
	private Integer tableid;
	private Integer bookStore;// 库存
	private Integer bookStort;// 类型
	private Integer bookAuthor;// 作者
	private Double bookPrice;// 单价
	private File bookUp;// 文件名
	private String bookUpContentType; // 得到文件的类型
	private String bookUpFileName;// 文件名
	private Integer showStort1;
	private Integer showStort2;
	private Integer showStort3;
	private Integer showStort4;
	private Book book=new Book();
	private List<Stort> stortlist=new ArrayList<Stort>();
	private Stort stort=new Stort();
	private BookInfo bookInfo=new BookInfo();
	private Author author=new Author();
	private List<Author> authorlist=new ArrayList<Author>();
	private Orders order=new Orders();
	private List<Orders> orderlist=new ArrayList<Orders>();
	private OrderInfo orderInfo=new OrderInfo();
	private List<DetailInfo> detailInfolist=new ArrayList<DetailInfo>(); 
	private List<Notes> noteslist=new ArrayList<Notes>(); 
	private Notes notes=new Notes();
	private List<OrderInfo> orderInfolist=new ArrayList<OrderInfo>();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	
	
	public Admin getAdmCfg() {
		return admCfg;
	}

	public void setAdmCfg(Admin admCfg) {
		this.admCfg = admCfg;
	}

	public AdminAction() {
		sessionAdmin=(Admin) session.getAttribute("admin");
	}
	
	public List<Object> getLolist() {
		return lolist;
	}
	public void setLolist(List<Object> lolist) {
		this.lolist = lolist;
	}
	public Notes getNotes() {
		return notes;
	}
	public void setNotes(Notes notes) {
		this.notes = notes;
	}
	public List<Notes> getNoteslist() {
		return noteslist;
	}
	public void setNoteslist(List<Notes> noteslist) {
		this.noteslist = noteslist;
	}
	public Integer getShowStort1() {
		return showStort1;
	}
	public void setShowStort1(Integer showStort1) {
		this.showStort1 = showStort1;
	}

	public Integer getShowStort2() {
		return showStort2;
	}

	public void setShowStort2(Integer showStort2) {
		this.showStort2 = showStort2;
	}

	public Integer getShowStort3() {
		return showStort3;
	}

	public void setShowStort3(Integer showStort3) {
		this.showStort3 = showStort3;
	}

	public Integer getShowStort4() {
		return showStort4;
	}

	public void setShowStort4(Integer showStort4) {
		this.showStort4 = showStort4;
	}

	public List<DetailInfo> getDetailInfolist() {
		return detailInfolist;
	}

	public void setDetailInfolist(List<DetailInfo> detailInfolist) {
		this.detailInfolist = detailInfolist;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public List<OrderInfo> getOrderInfolist() {
		return orderInfolist;
	}

	public void setOrderInfolist(List<OrderInfo> orderInfolist) {
		this.orderInfolist = orderInfolist;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Author> getAuthorlist() {
		return authorlist;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public List<Orders> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<Orders> orderlist) {
		this.orderlist = orderlist;
	}

	public void setAuthorlist(List<Author> authorlist) {
		this.authorlist = authorlist;
	}

	public Stort getStort() {
		return stort;
	}

	public void setStort(Stort stort) {
		this.stort = stort;
	}

	public List<Stort> getStortlist() {
		return stortlist;
	}

	public void setStortlist(List<Stort> stortlist) {
		this.stortlist = stortlist;
	}

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public void setTableid(Integer tableid) {
		this.tableid = tableid;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setAdmTel(String admTel) {
		this.admTel = admTel;
	}

	public void setAdmPass(String admPass) {
		this.admPass = admPass;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}

	public void setBookStore(Integer bookStore) {
		this.bookStore = bookStore;
	}

	public void setBookStort(Integer bookStort) {
		this.bookStort = bookStort;
	}

	public void setBookAuthor(Integer bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public void setBookUp(File bookUp) {
		this.bookUp = bookUp;
	}

	public void setBookUpContentType(String bookUpContentType) {
		this.bookUpContentType = bookUpContentType;
	}

	public void setBookUpFileName(String bookUpFileName) {
		this.bookUpFileName = bookUpFileName;
	}

	public List<Author> getAutlist() {
		return autlist;
	}

	public void setAutlist(List<Author> autlist) {
		this.autlist = autlist;
	}

	public List<Stort> getStlist() {
		return stlist;
	}

	public void setStlist(List<Stort> stlist) {
		this.stlist = stlist;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<BookInfo> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<BookInfo> booklist) {
		this.booklist = booklist;
	}

	// 分页显示所有图书url(Admin/pages/admin_showBook)
	public String showBook() {
		//得到当前页码
		int page=lucyUtil.getPage("pages");
		//得到分页处理类对象
		PageInfo pi = new PageInfo(Book.class,new Book(),page,sessionAdmin.getPagesize());
		if (page == pi.getPagenum())//判断当前页码是否为最后一页
			request.setAttribute("fk", 1);//(当前页码是最后一页，将信息反馈给页面)
		request.setAttribute("page", page);//拿到书本后返回页面并更新页面页数
		String sql = "select b.bphoto,b.bName,a.autName,s.stName, b.bStore,b.bPrice,b.bid,b.bSales " + "from Book b,Author a,Stort s "
				+ "where b.stid=s.stid and b.autid=a.autid " + "LIMIT ?,?";
		booklist = (List<BookInfo>) admService.getList(BookInfo.class, sql, pi.getIndex(), pi.getSize());//得到page页所有的书本信息
		return "ok";
	}

	// 管理员登录（Admin/pages/admin_login)
	public String login() {
		String isChick=request.getParameter("checkbox");//"记住密码"复选框的状态（选中则不为空，不选中则为空）
		//----是否记住密码
		lucyUtil.setCookie("LB_adminID", username, isChick != null);//如果"记住密码"复选框选中，则将username以LB__adminID为名字存储到Coolie中
		lucyUtil.setCookie("LB_adminPass", password, isChick != null);
		//--------------
		Admin admin = new Admin();
		admin.setAdmName(username);
		admin.setAdmPassword(password);
		admin = admService.login(admin);
		if (admin != null) {
			// 把管理员信息存入到session域对象中
			session.setAttribute("admin", admin);
			return "login";//登录成功
		} else {
			request.setAttribute("isOk", "on");
			return "onlogin";//登录失败
		}
			
	}

	// 添加书本的信息准备（Admin/pages/admin_showAddBook )
	public String showAddBook() {
		Author a = new Author();
		Stort s = new Stort();
		autlist = (List<Author>) admService.getList(a);//得到所有作者
		stlist = (List<Stort>) admService.getList(s);//得到所有类型
		return "showAddBookOK";
	}

	// 添加图书（Admin/pages/admin_bookUpload)?
	public String bookUpload() {
		String fileName= lucyUtil.saveFile(bookUp, "/Lucy/books",bookUpFileName);//将上传的文件保存到服务器的‘Lucy/books’的目录下
		Book book = new Book();
			book.setAutid(bookAuthor);//设置作者
			book.setBdetail(bookDetail);//设置书本介绍
			book.setbName(bookName);//设置书名
			book.setbPhoto("Lucy/books/" + fileName);//设置图片的读取路径
			book.setbPrice(bookPrice);//设置书本的单价
			book.setbStore(bookStore);//设置书本类型
			book.setStid(bookStort);//设置书本库存
			book.setbSales(0);//设置默认销量为0
			admService.add(book);//执行添加操作
		return "bookUploadOK";
	}

	// 添加一名管理员（Admin/pages/admin_adminUpload)?
	public String adminUpload() {
		Admin admin = new Admin();
		admin.setAdmName(bookName);
		if (admService.addAdmin(admin) == 0) {//判断管理员的登录名是否已经存在
			request.setAttribute("addIsOk", 0);
		} else {
				String fileName= lucyUtil.saveFile(bookUp, "/Lucy/admins/",bookUpFileName);//将上传的文件保存到服务器的‘Lucy/admins’的目录下
				admin.setAdmName(bookName);//设置管理员登录名
				admin.setAdmPassword(admPass);//设置管理员登密码
				admin.setAdmTel(admTel);//设置管理员电话
				admin.setPagesize(4);//设置默认分页设置为4
				admin.setInventory(100);//设置默认库存警报为100
				admin.setAdmPor("Lucy/admins/" + fileName);//设置图片的读取路径
				admService.add(admin);//执行添加操作
				request.setAttribute("addIsOk", 1);
		}
		return "adminUploadOK";
	}

	// 设置功能
	public String setting() {
		sessionAdmin.setInventory(bookStort);//更新库存警报
		sessionAdmin.setPagesize(bookStore);//更新分页数
		admService.update(sessionAdmin);//执行更改
		request.setAttribute("settingIsOk", 1);//执行成功，并将信息反馈给页面
		return "settingOK";
	}
    //库存警报及分页
	public String inveAlarm() {
		int page=lucyUtil.getPage("pages");//获得当前页码（从Url中拿到页码，出现异常则默认为第一页）
		String sql1 = "select * from Book where bStore<?";
		PageInfo pi = new PageInfo(Book.class,page,sessionAdmin.getPagesize(),sql1,sessionAdmin.getInventory());//获得分页所需的所有信息
		if (page == pi.getPagenum())//判断是否是最后一页
			request.setAttribute("fk", 1);//‘最后一页’的信息提示
		request.setAttribute("page", page);//返回页面最新的页码
		String sql = "select b.bphoto,b.bName,a.autName,s.stName, b.bStore,b.bPrice,b.bid " + "from Book b,Author a,Stort s "
				+ "where b.stid=s.stid and b.autid=a.autid and b.bStore<? " + "LIMIT ?,?";
		booklist = (List<BookInfo>) admService.getList(BookInfo.class, sql, sessionAdmin.getInventory(), pi.getIndex(),
				pi.getSize());//得到page页所有的满足库存警报的书本信息
		return "inveAlarmOK";
	}
	//修改库存的准备信息
	public String showUpInven() {
		int bid=Integer.parseInt(request.getParameter("bid"));//拿到从页面传入的书本ID(bid)
		book=(Book) admService.getOne(Book.class, bid);//拿到bid对应的书本信息
		return "showUpInvenOK";
	}
	//修改库存
	public String upInven() {
		Book b=new Book();//声明一个书本类对象
		b.setBid(bookStort);//设置书本的ID
		b.setbStore(bookStore);//设置书本的新库存
		admService.update(b);//执行更改
		return "upInvenOK";
	}
	//删除书本
	public String delBook() {
		int id=Integer.parseInt(request.getParameter("bid"));//获得书本ID'bid'
		admService.del(Book.class, id);//执行删除操作
		return "bookStoreOK";
	}
	//修改书本信息前的数据准备
	public String showUpdateBook() {
		int id=0;
		if(request.getParameter("bid")!=null)
			id=Integer.parseInt(request.getParameter("bid"));//url方式获得bid
		if(request.getAttribute("bid")!=null)
			id=(int) request.getAttribute("bid");//request域方式得到bid
		book=(Book) admService.getOne(Book.class, id);//得到书本ID为‘bid’的详细信息
		return "showUpdateBookOK";
	}
	//修改书本信息
	public String updateBook() {
		book.setBid(tableid);//设置书本ID
		book.setbName(bookName);//设置新书名
		book.setBdetail(bookDetail);//设置新简介
		book.setbPrice(bookPrice);//设置新价格
		book.setbStore(bookStore);//设置新库存
		admService.update(book);//执行更改操作
		request.setAttribute("bid", tableid);
		return "updateBookOK";
	}
	//查看书本的详细信息
	public String BookInfo() {
		int id=0;
		if(request.getParameter("bid")!=null)
			id=Integer.parseInt(request.getParameter("bid"));//url方式获得bid
		if(request.getAttribute("bid")!=null)
			id=(int) request.getAttribute("bid");//request域方式得到bid
		String sql="select b.bphoto,b.bName,a.autName,s.stName, b.bStore,b.bPrice,b.bid,b.bdetail " + "from Book b,Author a,Stort s "
				+ "where b.stid=s.stid and b.autid=a.autid and b.bid=? ";
		this.bookInfo=(BookInfo) admService.getList(BookInfo.class, sql, id).get(0);//得到该书本的详细信息
		return "BookInfoOK";
	}
	//分页查看所有类型
	public String showStort() {
		int page=lucyUtil.getPage("pages");//获得当前页码（从Url中拿到页码，出现异常则默认为第一页）
		PageInfo pi = new PageInfo(Stort.class,new Stort(),page,sessionAdmin.getPagesize());//得到分页所需要的信息
		if (page == pi.getPagenum())//判断是否是最后一页
			request.setAttribute("fk", 1);//‘最后一页’的信息提示
		request.setAttribute("page", page);//返回页面最新的页码
		stortlist=(List<Stort>) admService.getListPag(new Stort(), pi.getIndex(),pi.getSize());//得到page页所有的类型信息
		return "showStortOK";
	}
	//删除类型和其下的所有书本
	public String delStort() {
		int id=Integer.parseInt(request.getParameter("stid"));//得到要删除的类型ID'stid'
		admService.del(Stort.class, id);//执行删除操作
		return "delStortOK";
	}
	//修改类型信息
	public String upStort() {
		Stort s=new Stort();//声明一个类型
		s.setStid(tableid);//传入类型ID
		s.setStName(bookName);//设置信类型名
		admService.update(s);//执行修改
		request.setAttribute("stid",tableid);//将类型ID存入request域
		return "upStortOK";
	}
	//修改类型信息前的数据准备
	public String showUpStort() {
		int id=0;
		if(request.getParameter("stid")!=null)
			id=Integer.parseInt(request.getParameter("stid"));//url方式获得‘stid’
		if(request.getAttribute("stid")!=null)
			id=(int) request.getAttribute("stid");//request域方式获得‘stid’
		stort=(Stort) admService.getOne(Stort.class, id);//得到该类型的类型信息
		return "showUpStortOK";
	}
	//添加类型
	public String addStort() {
		Stort st=new Stort();//声明一个类型
		st.setStName(bookName);//设置类型名
		if(admService.getList(st).size()==0) {//判断该类型名是否存在
			st.setIsShow("__");//设置首页展示为不展示
			admService.add(st);//执行添加操作
			request.setAttribute("IsOk", 1);
		}else {
			request.setAttribute("IsOk", 0);//类型名存在
		}
		return "addStortOK";
	}
	//是否展示类型（单击'✔'变为'__',单击'__'变为'✔'）
	public String isShowStrot() {
		Stort s1=new Stort();
		s1.setIsShow("✔");
		int stid=Integer.parseInt(request.getParameter("stid"));
		Stort st=(Stort) admService.getOne(Stort.class, stid);
		if("✔".equals(st.getIsShow())) {//'✔'变为'__'
			st.setIsShow("__");
			admService.update(st);
		}else if(admService.getList(s1).size()<4) {//'__'变为'✔'
			st.setIsShow("✔");
			admService.update(st);
		}
		return "isShowStrotOK";
	}
	//分页显示所有作者
	public String showAuthor() {
		int page=lucyUtil.getPage("pages");//获得当前页码（从Url中拿到页码，出现异常则默认为第一页）
		PageInfo pi = new PageInfo(Author.class,new Author(),page,sessionAdmin.getPagesize());//得到分页所需要的信息
		if (page == pi.getPagenum())//判断是否是最后一页
			request.setAttribute("fk", 1);//‘最后一页’的信息提示
		request.setAttribute("page", page);//返回页面最新的页码
		authorlist=(List<Author>) admService.getListPag(new Author(), pi.getIndex(),pi.getSize());//得到page页所有的作者信息
		return "showAuthorOK";
	}
	//删除作者和其所有作品
	public String delAuthor() {
		int id=Integer.parseInt(request.getParameter("id"));//获得要删除的作者ID'id'
		admService.del(Author.class, id);//执行删除操作
		return "delAuthorOK";
	}
	//显示作者详细信息
	public String showAuthorInfo() {
		int id=0; // 
		if(request.getParameter("id")!=null) //url方式获得‘id’
			id=Integer.parseInt(request.getParameter("id"));
		if(request.getAttribute("id")!=null)
			id=(int) request.getAttribute("id"); //request域方式获得‘id’
		author=(Author) admService.getOne(Author.class, id);//得到该作者的详细信息
		return "showAuthorInfoOK";
	}
	//更新作者信息前的数据准备
	public String showUpAuthor() {
		int id=0;
		if(request.getParameter("id")!=null)
			id=Integer.parseInt(request.getParameter("id"));//url方式获得‘id’
		if(request.getAttribute("id")!=null)
			id=(int) request.getAttribute("id");//request域方式获得‘id’
		author=(Author) admService.getOne(Author.class, id);//得到该作者的所有信息
		return "showUpAuthorOK";
	}
	//更新作者信息
	public String upAuthor() {
		Author a=new Author();//声明一个新的作者
		a.setAutid(tableid);//传入ID
		a.setAutName(bookName);//设置新的姓名
		a.setAutPlace(username);//设置新的国籍
		a.setAutSex(password);//设置新的性别
		a.setAutdate(admPass);//设置新的出生年月
		a.setAutdetail(bookDetail);//设置新的作者详情
		admService.update(a);//执行跟新操作
		request.setAttribute("id",tableid);
		return "upAuthorOK";
	}
	//添加作者
	public String authorUpload() {
		Author aut=new Author();//声明一个作者
		String fileName= lucyUtil.saveFile(bookUp, "Lucy/authors/",bookUpFileName);//将上传的文件保存到服务器的‘Lucy/authors’的目录下
		aut.setAutName(bookName);//设置姓名
		aut.setAutPlace(username);//设置国籍
		aut.setAutSex(password);//设置性别
		aut.setAutPor("Lucy/authors/"+fileName);//设置图片的读取路径
		aut.setAutdate(admPass);//设置出生年月
		aut.setAutdetail(bookDetail);//设置作者详情
		admService.add(aut);//执行添加操作
		return "authorUploadOK";
	}
	//分页展示订单
	public String showOrder() {
		int page=lucyUtil.getPage("pages");//获得当前页码（从Url中拿到页码，出现异常则默认为第一页）
		PageInfo pi = new PageInfo(Orders.class,new Orders(),page,sessionAdmin.getPagesize());//得到分页所需要的信息
		if (page == pi.getPagenum())//判断是否是最后一页
			request.setAttribute("fk", 1);//‘最后一页’的信息提示
		request.setAttribute("page", page);//返回页面最新的页码
		String sql="select u.uName,o.* from Orders o,User u where o.uid=u.uid LIMIT ?,?";
		orderInfolist= (List<OrderInfo>) admService.getList(OrderInfo.class, sql, pi.getIndex(),pi.getSize());//得到page页所有的订单信息
		return "showOrderOK";
	}
	//删除所条订单
	public String delOrder() {
		int id=Integer.parseInt(request.getParameter("id"));//获得要删除的订单ID‘id’
		usrService.cancelOrder(id);//执行删除操作
		return "delOrderOK";
	}
	//显示订单的明细信息
	public String showDetail() {
		int id=Integer.parseInt(request.getParameter("id"));//获得要展示的订单ID‘id’
		String sql="select u.uName,u.uTel,b.bphoto,b.bName,d.number,d.money,c.consName,c.consTel,c.consAddre,o.userdetail"
				+ " from User u,Book b,Detail d,Consigness c,Orders o "
				+ "where o.uid=u.uid and o.consid=c.consid and d.bid=b.bid and d.ordid=o.ordid and d.ordid=? ";
		detailInfolist=(List<DetailInfo>) admService.getList(DetailInfo.class, sql, id);//得到要展示的订单信息
		return "showDetailOK";
	}
	//分页展示"未付款"的账单
	public String noPayment() {
		int page=lucyUtil.getPage("pages");//获得当前页码（从Url中拿到页码，出现异常则默认为第一页）
		String sql1 = "select * from Orders where ordPayState=?";
		PageInfo pi = new PageInfo(Orders.class,page,sessionAdmin.getPagesize(),sql1,"未付款");//得到分页所需要的信息
		if (page == pi.getPagenum())//判断是否是最后一页
			request.setAttribute("fk", 1);//‘最后一页’的信息提示
		request.setAttribute("page", page);//返回页面最新的页码
		String sql="select u.uName,o.* from Orders o,User u where o.uid=u.uid and o.ordPayState=? LIMIT ?,?";
		orderInfolist= (List<OrderInfo>) admService.getList(OrderInfo.class, sql,"未付款", pi.getIndex(),pi.getSize());//得到page页所有的‘未付款’订单信息
		return "noPaymentOK";
	}
	//分页展示"已付款"但还'没发货'的账单
	public String noDelivery() {
		int page=lucyUtil.getPage("pages");//获得当前页码（从Url中拿到页码，出现异常则默认为第一页）
		String sql1 = "select * from Orders where ordPayState=? and ordSendState=?";
		PageInfo pi = new PageInfo(Orders.class,page,sessionAdmin.getPagesize(),sql1,"已付款","未发货");//得到分页所需要的信息
		if (page == pi.getPagenum())//判断是否是最后一页
			request.setAttribute("fk", 1);//‘最后一页’的信息提示
		request.setAttribute("page", page);//返回页面最新的页码
		String sql="select u.uName,o.* from Orders o,User u where o.uid=u.uid and o.ordPayState=? and ordSendState=? LIMIT ?,?";
		orderInfolist= (List<OrderInfo>) admService.getList(OrderInfo.class, sql,"已付款","未发货", pi.getIndex(),pi.getSize());//得到page页所有的"已付款"但还'没发货'订单信息
		return "noDeliveryOK";
	}
	//发货
	public String delivery() {
		int id=Integer.parseInt(request.getParameter("id"));//得到要发货的订单ID'id'
		Orders o=new Orders();
		o.setOrdid(id);o.setOrdSendState("已发货");//将发货状态改为‘已发货’
		admService.update(o);//执行更改
		return "deliveryOK";
	}
	//导出为Excel表格
	public String exportOrder() throws IOException {
		List<OrderInfo> all=new ArrayList<OrderInfo>();//全部订单
		List<OrderInfo> yes=new ArrayList<OrderInfo>();//已发货
		List<OrderInfo> no=new ArrayList<OrderInfo>();//未发货
		String sql="select u.uName,b.bName,o.ordTime,d.number,c.consName,c.consTel,c.consAddre,o.userdetail,o.ordSendState,o.ordPayState"
				+ " from User u,Orders o,Book b,Detail d,Consigness c "
				+ "where o.uid=u.uid and d.bid=b.bid and d.ordid=o.ordid and o.consid=c.consid";
		String sql2=sql+ " and o.ordSendState=?";
		String sql3=sql2+" and o.ordPayState=?";
		all=(List<OrderInfo>) admService.getList(OrderInfo.class, sql);
		yes=(List<OrderInfo>) admService.getList(OrderInfo.class, sql2,"已发货");
		no=(List<OrderInfo>) admService.getList(OrderInfo.class, sql3,"未发货","已付款");
		// 创建Excel工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
	    // 创建"全部订单"的工作表
	    HSSFSheet sheet1= workbook.createSheet("全部订单");
	    //写入表头
	    HSSFRow rows1 = sheet1.createRow(0);
	   	rows1.createCell(0).setCellValue("订单发起人");
	   	rows1.createCell(1).setCellValue("创建时间");
	   	rows1.createCell(2).setCellValue("商品名称");
	   	rows1.createCell(3).setCellValue("购买数量");
	   	rows1.createCell(4).setCellValue("收货人姓名");
	   	rows1.createCell(5).setCellValue("收货人电话");
	   	rows1.createCell(6).setCellValue("收货人地址");
	   	rows1.createCell(7).setCellValue("用户备注");
	   	rows1.createCell(8).setCellValue("发货状态");
	   	rows1.createCell(9).setCellValue("付款状态");
	   	if(all.size()!=0) {
	    for(int row=0;row<all.size();row++) {
	    	// 向工作表中添加数剧
	    	 HSSFRow rows = sheet1.createRow(row+1);
	    	 rows.createCell(0).setCellValue(all.get(row).getuName());
	    	 rows.createCell(1).setCellValue(all.get(row).getOrdTime());
	    	 rows.createCell(2).setCellValue(all.get(row).getbName());
	    	 rows.createCell(3).setCellValue(all.get(row).getNumber());
	    	 rows.createCell(4).setCellValue(all.get(row).getConsName());
	    	 rows.createCell(5).setCellValue(all.get(row).getConsTel());
	    	 rows.createCell(6).setCellValue(all.get(row).getConsAddre());
	    	 rows.createCell(7).setCellValue(all.get(row).getUserdetail());
	    	 rows.createCell(8).setCellValue(all.get(row).getOrdSendState());
	    	 rows.createCell(9).setCellValue(all.get(row).getOrdPayState());
	    }
	   	}
	    // 创建"已完成订单"的工作表
	    HSSFSheet sheet2= workbook.createSheet("已完成订单");
	    HSSFRow rows2 = sheet2.createRow(0);
	   	rows2.createCell(0).setCellValue("订单发起人");
	   	rows2.createCell(1).setCellValue("创建时间");
	   	rows2.createCell(2).setCellValue("商品名称");
	   	rows2.createCell(3).setCellValue("购买数量");
	   	rows2.createCell(4).setCellValue("收货人姓名");
	   	rows2.createCell(5).setCellValue("收货人电话");
	   	rows2.createCell(6).setCellValue("收货人地址");
	   	rows2.createCell(7).setCellValue("用户备注");
	   	rows2.createCell(8).setCellValue("发货状态");
	   	rows2.createCell(9).setCellValue("付款状态");
	   	if(yes.size()!=0) {
	    for(int row=0;row<yes.size();row++) {
	    	// 向工作表中添加数剧
	    	 HSSFRow rows = sheet2.createRow(row+1);
	    	 rows.createCell(0).setCellValue(yes.get(row).getuName());
	    	 rows.createCell(1).setCellValue(yes.get(row).getOrdTime());
	    	 rows.createCell(2).setCellValue(yes.get(row).getbName());
	    	 rows.createCell(3).setCellValue(yes.get(row).getNumber());
	    	 rows.createCell(4).setCellValue(yes.get(row).getConsName());
	    	 rows.createCell(5).setCellValue(yes.get(row).getConsTel());
	    	 rows.createCell(6).setCellValue(yes.get(row).getConsAddre());
	    	 rows.createCell(7).setCellValue(yes.get(row).getUserdetail());
	    	 rows.createCell(8).setCellValue(yes.get(row).getOrdSendState());
	    	 rows.createCell(9).setCellValue(yes.get(row).getOrdPayState());
	    }
	   	}
	    // 创建"已付款未发货订单"的工作表
	    HSSFSheet sheet3= workbook.createSheet("已付款未发货订单");
	    HSSFRow rows3 = sheet3.createRow(0);
	   	rows3.createCell(0).setCellValue("订单发起人");
	   	rows3.createCell(1).setCellValue("创建时间");
	   	rows3.createCell(2).setCellValue("商品名称");
	   	rows3.createCell(3).setCellValue("购买数量");
	   	rows3.createCell(4).setCellValue("收货人姓名");
	   	rows3.createCell(5).setCellValue("收货人电话");
	   	rows3.createCell(6).setCellValue("收货人地址");
	   	rows3.createCell(7).setCellValue("用户备注");
	   	rows3.createCell(8).setCellValue("发货状态");
	   	rows3.createCell(9).setCellValue("付款状态");
	   	if(no.size()!=0) {
	    for(int row=0;row<no.size();row++) {
	    	// 向工作表中添加数剧
	    	 HSSFRow rows = sheet3.createRow(row+1);
	    	 rows.createCell(0).setCellValue(no.get(row).getuName());
	    	 rows.createCell(1).setCellValue(no.get(row).getOrdTime());
	    	 rows.createCell(2).setCellValue(no.get(row).getbName());
	    	 rows.createCell(3).setCellValue(no.get(row).getNumber());
	    	 rows.createCell(4).setCellValue(no.get(row).getConsName());
	    	 rows.createCell(5).setCellValue(no.get(row).getConsTel());
	    	 rows.createCell(6).setCellValue(no.get(row).getConsAddre());
	    	 rows.createCell(7).setCellValue(no.get(row).getUserdetail());
	    	 rows.createCell(8).setCellValue(no.get(row).getOrdSendState());
	    	 rows.createCell(9).setCellValue(no.get(row).getOrdPayState());
	    }
	   	}
	      File xlsFile = new File(ServletActionContext.getServletContext().getRealPath("/order.xls"));
	      FileOutputStream xlsStream = new FileOutputStream(xlsFile);
	      workbook.write(xlsStream);
		return "exportOrderOK";
	}
	
	//显示设置信息
	public String showSetting() {
		admCfg=sessionAdmin;//从session对象中得到admin对象
		return "showSettingOK";
	}
	//注销登录（清除session）?
	public String loginOut() {
		session.removeAttribute("admin");//移除登录时存入session中admin
		return "loginOutOK";
	}
	//所有美文
	public String showNotes() {
		noteslist=(List<Notes>) admService.getList(new Notes());//得到所有的美文
		return "showNotrsOK";
	}
	//删除美文
	public String delNotes() {
		admService.del(Notes.class, Integer.parseInt(request.getParameter("id")));//删除美文ID为'id'的那两篇美文
		return "delNotesOK";
	}
	//添加美文
	public String addNotes() {
		Notes n=new Notes();//声明一个美文
		n.setArticle1(admTel);//设置左页的内容
		n.setArticle2(bookDetail);//设置右页的内容
		admService.add(n);//执行添加操作
		return "addNotesOK";
	}
	//显示美文信息
	public String showNoteInfo() {
		int id=0;
		if(request.getParameter("id")!=null)
			id=Integer.parseInt(request.getParameter("id"));//url方式获得‘id’
		if(request.getAttribute("id")!=null)
			id=(int)request.getAttribute("id");//request域方式获得‘id’
		notes=(Notes) admService.getOne(Notes.class, id);//根据美文ID‘id’找到该美文的详细信息
		return "showNoteInfoOK";
	}
	//修改美文
	public String updateNote() {
		Notes n=new Notes();//声明美文
		n.setBufid(tableid);//传入ID
		n.setArticle1(admTel);//设置新的左页信息
		n.setArticle2(bookDetail);//设置新的右页信息
		admService.update(n);//执行更改操作
		request.setAttribute("id", tableid);
		return "updateNoteOK";
	}
	//数据统计
	public String statistical() {
		lolist=admService.statistical();//得到数据统计的信息
		return "statisticalOK";
	}
}
