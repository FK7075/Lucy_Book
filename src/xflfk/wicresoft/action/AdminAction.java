package xflfk.wicresoft.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import xflfk.wicresoft.entitry.Admin;
import xflfk.wicresoft.entitry.Author;
import xflfk.wicresoft.entitry.Book;
import xflfk.wicresoft.entitry.BookInfo;
import xflfk.wicresoft.entitry.DetailInfo;
import xflfk.wicresoft.entitry.LucyCfg;
import xflfk.wicresoft.entitry.OrderInfo;
import xflfk.wicresoft.entitry.Orders;
import xflfk.wicresoft.entitry.PageInfo;
import xflfk.wicresoft.entitry.Stort;
import xflfk.wicresoft.service.AdminService;

@SuppressWarnings("all")
public class AdminAction extends ActionSupport {
	private String username;// 用户名
	private String password;// mim
	private AdminService admService = new AdminService();
	private List<BookInfo> booklist = new ArrayList<BookInfo>();// 要展示的所有书本信息的集合
	private List<Author> autlist = new ArrayList<Author>();// 所有作者信息
	private List<Stort> stlist = new ArrayList<Stort>();// 所有类型信息
	private String bookName;// 书名
	private String bookDetail;// 描述
	private String admTel;// 
	private String admPass;// 
	private Integer tableid;
	private Integer bookStore;// 库存
	private Integer bookStort;// 类型
	private Integer bookAuthor;// 作者
	private Double bookPrice;// 单价
	private File bookUp;// 文件流
	private String bookUpContentType; // 得到文件的类型
	private String bookUpFileName;// 文件名
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
	private List<OrderInfo> orderInfolist=new ArrayList<OrderInfo>();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();

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
		PageInfo pi = null;
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		pi = admService.getPageInfo(new Book(), page);
		if (page == admService.getPageSize(new Book()))
			request.setAttribute("fk", 1);
		request.setAttribute("page", page);
		String sql = "select b.bphoto,b.bName,a.autName,s.stName, b.bStore,b.bPrice,b.bid " + "from Book b,Author a,Stort s "
				+ "where b.stid=s.stid and b.autid=a.autid " + "LIMIT ?,?";
		booklist = (List<BookInfo>) admService.getList(BookInfo.class, sql, pi.getIndex(), pi.getSize());
		return "ok";
	}

	// 管理员登录（Admin/pages/admin_login）
	public String login() {
		Admin admin = new Admin();
		admin.setAdmName(username);
		admin.setAdmPassword(password);
		admin = admService.login(admin);
		if (admin != null) {
			// 把管理员信息存入到session域对象中
			session.setAttribute("admin", admin);
			request.setAttribute("pages", 1);
			return "login";
		} else {
			request.setAttribute("isOk", "on");
			return "onlogin";
		}
	}

	// 添加书本的信息准备（Admin/pages/admin_showAddBook ）
	public String showAddBook() {
		Author a = new Author();
		Stort s = new Stort();
		autlist = (List<Author>) admService.getList(a);
		stlist = (List<Stort>) admService.getList(s);
		return "showAddBookOK";
	}

	// 添加图书（Admin/pages/admin_bookUpload）
	public String bookUpload() {
		Book book = new Book();
		System.out.println("fileName:" + bookUpFileName);
		System.out.println("contentType:" + bookUpContentType);
		System.out.println("File:" + bookUp);

		// 获取要保存文件夹的物理路径(绝对路径)
		String realPath = ServletActionContext.getServletContext().getRealPath("/Lucy/books");
		File file = new File(realPath);
		// 测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
		if (!file.exists())
			file.mkdirs();
		try {
			// 保存文件
			long dt = new Date().getTime();
			String fileName = dt + bookUpFileName;
			FileUtils.copyFile(bookUp, new File(file, fileName));
			book.setAutid(bookAuthor);
			book.setBdetail(bookDetail);
			book.setbName(bookName);
			book.setbPhoto("Lucy/books/" + fileName);
			book.setbPrice(bookPrice);
			book.setbStore(bookStore);
			book.setStid(bookStort);
			admService.add(book);
			request.setAttribute("pages", 1);
			System.out.println(realPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "bookUploadOK";
	}

	// 添加一名管理员（Admin/pages/admin_adminUpload）
	public String adminUpload() {
		Admin admin = new Admin();
		admin.setAdmName(bookName);
		if (admService.addAdmin(admin) == 0) {
			request.setAttribute("addIsOk", 0);
		} else {
			System.out.println("fileName:" + bookUpFileName);
			System.out.println("contentType:" + bookUpContentType);
			System.out.println("File:" + bookUp);
			// 获取要保存文件夹的物理路径(绝对路径)
			String realPath = ServletActionContext.getServletContext().getRealPath("/Lucy/admins");
			File file = new File(realPath);
			// 测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
			if (!file.exists())
				file.mkdirs();
			try {
				// 保存文件
				long dt = new Date().getTime();
				String fileName = dt + bookUpFileName;
				FileUtils.copyFile(bookUp, new File(file, fileName));
				admin.setAdmName(bookName);
				admin.setAdmPassword(admPass);
				admin.setAdmTel(admTel);
				admin.setAdmPor("Lucy/admins/" + fileName);
				admService.update(admin);
				request.setAttribute("addIsOk", 1);
				System.out.println(realPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "adminUploadOK";
	}

	// 设置功能
	public String setting() {
		LucyCfg cfg = new LucyCfg();
		cfg.setCfgid(1);
		cfg.setPagesize(bookStore);
		cfg.setInventory(bookStort);
		admService.update(cfg);
		request.setAttribute("settingIsOk", 1);
		return "settingOK";
	}
    //库存警报及分页
	public String inveAlarm() {
		PageInfo pi = null;
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		String sql1 = "select * from Book where bStore<?";
		LucyCfg cfg = (LucyCfg) admService.getOne(LucyCfg.class, 1);
		pi = admService.getPageInfo(admService.getCount(Book.class, sql1, cfg.getInventory()), page);
		request.setAttribute("page", page);
		String sql = "select b.bphoto,b.bName,a.autName,s.stName, b.bStore,b.bPrice,b.bid " + "from Book b,Author a,Stort s "
				+ "where b.stid=s.stid and b.autid=a.autid and b.bStore<? " + "LIMIT ?,?";
		booklist = (List<BookInfo>) admService.getList(BookInfo.class, sql, cfg.getInventory(), pi.getIndex(),
				pi.getSize());
		return "inveAlarmOK";
	}
	//修改库存的准备信息
	public String showUpInven() {
		int bid=Integer.parseInt(request.getParameter("bid"));
		book=(Book) admService.getOne(Book.class, bid);
		return "showUpInvenOK";
	}
	//修改库存
	public String upInven() {
		Book b=new Book();
		b.setBid(bookStort);
		b.setbStore(bookStore);
		admService.update(b);
		request.setAttribute("pages", 1);
		return "upInvenOK";
	}
	//删除书本
	public String delBook() {
		int id=Integer.parseInt(request.getParameter("bid"));
		admService.del("Book", id);
		request.setAttribute("pages", 1);
		return "bookStoreOK";
	}
	//修改书本信息前的数据准备
	public String showUpdateBook() {
		int id=0;
		if(request.getParameter("bid")!=null)
			id=Integer.parseInt(request.getParameter("bid"));
		if(request.getAttribute("bid")!=null)
			id=(int) request.getAttribute("bid");
		book=(Book) admService.getOne(Book.class, id);
		return "showUpdateBookOK";
	}
	//修改书本信息
	public String updateBook() {
		book.setBid(tableid);book.setbName(bookName);book.setBdetail(bookDetail);book.setbPrice(bookPrice);
		book.setbStore(bookStore);
		admService.update(book);
		request.setAttribute("bid", tableid);
		return "updateBookOK";
	}
	//查看书本的详细信息
	public String BookInfo() {
		int id=0;
		if(request.getParameter("bid")!=null)
			id=Integer.parseInt(request.getParameter("bid"));
		if(request.getAttribute("bid")!=null)
			id=(int) request.getAttribute("bid");
		String sql="select b.bphoto,b.bName,a.autName,s.stName, b.bStore,b.bPrice,b.bid,b.bdetail " + "from Book b,Author a,Stort s "
				+ "where b.stid=s.stid and b.autid=a.autid and b.bid=? ";
		this.bookInfo=(BookInfo) admService.getList(BookInfo.class, sql, id).get(0);
		return "BookInfoOK";
	}
	//分页查看所有类型
	public String showStort() {
		PageInfo pi = null;
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		pi = admService.getPageInfo(new Book(), page);
		if (page == admService.getPageSize(new Book()))
			request.setAttribute("fk", 1);
		request.setAttribute("page", page);
		stortlist=(List<Stort>) admService.getListPag(new Stort(), pi.getIndex());
		return "showStortOK";
	}
	//删除类型和其下的所有书本
	public String delStort() {
		int id=Integer.parseInt(request.getParameter("stid"));
		admService.del("Stort", id);
		request.setAttribute("pages", 1);
		return "delStortOK";
	}
	//修改类型信息
	public String upStort() {
		Stort s=new Stort();
		s.setStid(tableid);
		s.setStName(bookName);
		admService.update(s);
		request.setAttribute("stid",tableid);
		return "upStortOK";
	}
	//修改类型信息前的数据准备
	public String showUpStort() {
		int id=0;
		if(request.getParameter("stid")!=null)
			id=Integer.parseInt(request.getParameter("stid"));
		if(request.getAttribute("stid")!=null)
			id=(int) request.getAttribute("stid");
		stort=(Stort) admService.getOne(Stort.class, id);
		return "showUpStortOK";
	}
	//添加类型
	public String addStort() {
		Stort st=new Stort();
		st.setStName(bookName);
		admService.add(st);
		request.setAttribute("IsOk", 1);
		return "addStortOK";
	}
	//分页显示所有作者
	public String showAuthor() {
		PageInfo pi = null;
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		pi = admService.getPageInfo(new Book(), page);
		if (page == admService.getPageSize(new Book()))
			request.setAttribute("fk", 1);
		request.setAttribute("page", page);
		authorlist=(List<Author>) admService.getListPag(new Author(), pi.getIndex());
		return "showAuthorOK";
	}
	//删除作者和其所有作品
	public String delAuthor() {
		int id=Integer.parseInt(request.getParameter("id"));
		admService.del("Author", id);
		request.setAttribute("pages", 1);
		return "delAuthorOK";
	}
	//显示作者详细信息
	public String showAuthorInfo() {
		int id=0;
		if(request.getParameter("id")!=null)
			id=Integer.parseInt(request.getParameter("id"));
		if(request.getAttribute("id")!=null)
			id=(int) request.getAttribute("id");
		author=(Author) admService.getOne(Author.class, id);
		return "showAuthorInfoOK";
	}
	//更新作者信息前的数据准备
	public String showUpAuthor() {
		int id=0;
		if(request.getParameter("id")!=null)
			id=Integer.parseInt(request.getParameter("id"));
		if(request.getAttribute("id")!=null)
			id=(int) request.getAttribute("id");
		author=(Author) admService.getOne(Author.class, id);
		return "showUpAuthorOK";
	}
	//更新作者信息
	public String upAuthor() {
		Author a=new Author();
		a.setAutid(tableid);a.setAutName(bookName);a.setAutPlace(username);
		a.setAutSex(password);a.setAutdate(admPass);a.setAutdetail(bookDetail);
		admService.update(a);
		request.setAttribute("id",tableid);
		return "upAuthorOK";
	}
	//添加作者
	public String authorUpload() {
		Author aut=new Author();
		System.out.println("fileName:" + bookUpFileName);
		System.out.println("contentType:" + bookUpContentType);
		System.out.println("File:" + bookUp);

		// 获取要保存文件夹的物理路径(绝对路径)
		String realPath = ServletActionContext.getServletContext().getRealPath("/Lucy/authors");
		File file = new File(realPath);
		// 测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
		if (!file.exists())
			file.mkdirs();
		try {
			// 保存文件
			long dt = new Date().getTime();
			String fileName = dt + bookUpFileName;
			FileUtils.copyFile(bookUp, new File(file, fileName));
			aut.setAutName(bookName);aut.setAutPlace(username);aut.setAutSex(password);
			aut.setAutPor("Lucy/authors/"+fileName);aut.setAutdate(admPass);
			aut.setAutdetail(bookDetail);
			admService.add(aut);
			request.setAttribute("pages", 1);
			System.out.println(realPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "authorUploadOK";
	}
	//分页展示订单
	public String showOrder() {
		PageInfo pi = null;
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		pi = admService.getPageInfo(new Orders(), page);
		if (page == admService.getPageSize(new Orders()))
			request.setAttribute("fk", 1);
		request.setAttribute("page", page);
		String sql="select u.uName,o.* from Orders o,User u where o.uid=u.uid LIMIT ?,?";
		orderInfolist= (List<OrderInfo>) admService.getList(OrderInfo.class, sql, pi.getIndex(),pi.getSize());
		return "showOrderOK";
	}
	//删除一条订单
	public String delOrder() {
		int id=Integer.parseInt(request.getParameter("id"));
		admService.del("Orders", id);
		request.setAttribute("pages", 1);
		return "delOrderOK";
	}
	//显示订单的明细信息
	public String showDetail() {
		int id=Integer.parseInt(request.getParameter("id"));
		String sql="select u.uName,u.uTel,b.bphoto,b.bName,d.number,d.money,c.consName,c.consTel,c.consAddre,o.userdetail"
				+ " from User u,Book b,Detail d,Consigness c,Orders o "
				+ "where d.uid=u.uid and d.consid=c.consid and d.bid=b.bid and d.ordid=o.ordid and d.ordid=? ";
		detailInfolist=(List<DetailInfo>) admService.getList(DetailInfo.class, sql, id);
		return "showDetailOK";
	}
	//分页展示"未付款"的账单
	public String noPayment() {
		PageInfo pi = null;
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		String sql1 = "select * from Orders where ordPayState=?";
		LucyCfg cfg = (LucyCfg) admService.getOne(LucyCfg.class, 1);
		pi = admService.getPageInfo(admService.getCount(Orders.class, sql1, "未付款"), page);
		request.setAttribute("page", page);
		String sql="select u.uName,o.* from Orders o,User u where o.uid=u.uid and o.ordPayState=? LIMIT ?,?";
		orderInfolist= (List<OrderInfo>) admService.getList(OrderInfo.class, sql,"未付款", pi.getIndex(),pi.getSize());
		return "noPaymentOK";
	}
	//分页展示"已付款"但还没发货的账单
	public String noDelivery() {
		PageInfo pi = null;
		int page = 0;
		if (request.getAttribute("pages") != null)
			page = (int) request.getAttribute("pages");
		else
			page = Integer.parseInt(request.getParameter("pages"));
		String sql1 = "select * from Orders where ordPayState=? and ordSendState=?";
		LucyCfg cfg = (LucyCfg) admService.getOne(LucyCfg.class, 1);
		pi = admService.getPageInfo(admService.getCount(Orders.class, sql1, "已付款","未发货"), page);
		request.setAttribute("page", page);
		String sql="select u.uName,o.* from Orders o,User u where o.uid=u.uid and o.ordPayState=? and ordSendState=? LIMIT ?,?";
		orderInfolist= (List<OrderInfo>) admService.getList(OrderInfo.class, sql,"已付款","未发货", pi.getIndex(),pi.getSize());
		System.out.println(orderInfolist);
		return "noDeliveryOK";
	}
	public String delivery() {
		int id=Integer.parseInt(request.getParameter("id"));
		Orders o=new Orders();
		o.setOrdid(id);o.setOrdSendState("已发货");
		admService.update(o);
		request.setAttribute("pages", 1);
		return "deliveryOK";
	}
}
