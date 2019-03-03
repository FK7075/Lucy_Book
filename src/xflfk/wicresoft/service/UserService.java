package xflfk.wicresoft.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import xflfk.wicresoft.dao.SqlDaoImpl;
import xflfk.wicresoft.entitry.Author;
import xflfk.wicresoft.entitry.Book;
import xflfk.wicresoft.entitry.BookInfo;
import xflfk.wicresoft.entitry.Consigness;
import xflfk.wicresoft.entitry.Detail;
import xflfk.wicresoft.entitry.Notes;
import xflfk.wicresoft.entitry.Orders;
import xflfk.wicresoft.entitry.PageInfo;
import xflfk.wicresoft.entitry.ShoppCart;
import xflfk.wicresoft.entitry.Stort;
import xflfk.wicresoft.entitry.User;

@SuppressWarnings("all")
public class UserService {
	private SqlDaoImpl sqlDao = new SqlDaoImpl();
	private List<Notes> noteslist = new ArrayList<Notes>();
	private BookInfo bookInfo = new BookInfo();
	private List<Stort> stortlist = new ArrayList<Stort>();
	private List<BookInfo> booklist = new ArrayList<BookInfo>();
	private List<Author> authorlist = new ArrayList<Author>();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	private User sessionUser=new User();
	private HttpServletResponse response = ServletActionContext.getResponse();

	public UserService() {
		sessionUser=(User) session.getAttribute("user");
	}
	/**
	 * 显示最受欢迎的书本信息
	 * @return
	 */
	public List<BookInfo> getPopularBook() {
		String sql = "select b.bid,b.bName,a.autName,b.bPrice,b.bdetail,b.bPhoto" + " from Book b,Author a"
				+ " where b.autid=a.autid" + " ORDER BY b.bSales DESC" + " LIMIT 0,6";
		booklist = (List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql);
		return booklist;
	}

	/**
	 * 显示美文
	 * @return
	 */
	public List<Notes> getNotes() {
		noteslist = (List<Notes>) sqlDao.getList(new Notes());
		return noteslist;
	}

	/**
	 * 得到所有标记展示的类型
	 * @return
	 */
	public List<Stort> getShowStort() {
		Stort st=new Stort();
		st.setIsShow("✔");
		stortlist=(List<Stort>) sqlDao.getList(st);
		return stortlist;
	}

	/**
	 * 得到该id对应类型下销量最好的四本书的信息
	 * @param id
	 * @return
	 */
	public List<BookInfo> showBookByStort(int id) {
		String sql = "select b.bid,b.bName,a.autName,b.bPrice,b.bPhoto" + " from Book b,Author a ,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and s.stid=?" + " ORDER BY b.bSales DESC" + " LIMIT 0,4";
		booklist = (List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, id);
		return booklist;
	}

	/**
	 * 分页获得所有书本
	 * @param page
	 * 当前页码
	 * @return
	 */
	public List<BookInfo> showAllBook(int page) {
		String sql = "select b.bid,b.bName,a.autName,b.bPrice,b.bdetail,b.bPhoto" + " from Book b,Author a"
				+ " where b.autid=a.autid" + " LIMIT ?,12";
		if(sessionUser!=null)
			booklist = (List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, (page-1)*sessionUser.getChangenum());
		else
			booklist = (List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, (page-1)*6);
		return booklist;
	}

	/**
	 * 分页得到所有作者
	 * @param page
	 * 当前页码
	 * @return
	 */
	public List<Author> showAllAuthor(int page) {
		if(sessionUser!=null)
			authorlist = (List<Author>) sqlDao.getPagList(new Author(),(page-1)*sessionUser.getChangenum(), 9);
		else
			authorlist = (List<Author>) sqlDao.getPagList(new Author(),(page-1)*5, 9);
		return authorlist;
	}

	/**
	 * 拿到书库在所有的类型
	 * @return
	 */
	public List<Stort> allStort() {
		return (List<Stort>) sqlDao.getList(new Stort());
		
	}

	/**
	 * 拿到该作者的所有图书
	 * @param autid
	 * 作者ID
	 * @return
	 */
	public List<BookInfo> autToBooks(int autid) {
		String sql = "select b.bid,b.bName,a.autName,b.bPrice,b.bPhoto,a.autid" + " from Book b,Author a ,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and a.autid=?";
		booklist = (List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, autid);
		return booklist;
	}

	/**
	 * 拿到该类型下的所有图书
	 * @param stid
	 * 类型ID
	 * @return
	 */
	public List<BookInfo> stoToBooks(int stid) {
		String sql = "select b.bid,b.bName,a.autName,b.bPrice,b.bPhoto,s.stName" + " from Book b,Author a ,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and s.stid=?";
		booklist = (List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, stid);
		return booklist;
	}

	/**
	 * 根据ID得到该作者的详细信息
	 * @param autid
	 * 作者ID
	 * @return
	 */
	public Author getAuthorById(int autid) {
		return (Author) sqlDao.getOne(Author.class, autid);
	}

	/**
	 * 用户登录（成功返回User对象，否则返回null）
	 * @param user
	 * 包含用户名和密码的User对象
	 * @return
	 */
	public User login(User user) {
		if (sqlDao.getList(user).size() == 0)
			return null;
		else
			return (User) sqlDao.getList(user).get(0);
	}

	/**
	 * 用户注册（成功返回true，用户名存在返回false）
	 * @param user
	 * 包含用户注册信息的User对象
	 * @return
	 */
	public boolean register(User user) {
		User u = new User();
		u.setuName(user.getuName());
		if (sqlDao.getList(u).size() != 0) {
			return false;// 用户名已存在
		} else {
			sqlDao.save(user);
			return true;// 注册成功
		}
	}
	
	/**
	 * 得到该用户的所有收货人
	 * @param uid
	 * 用户ID
	 * @return
	 */
	public List<Consigness> getConsigness(int uid) {
		Consigness con=new Consigness();
		con.setUid(uid);
		return (List<Consigness>) sqlDao.getList(con);
	}
	
	/**
	 * 得到该用户的购物车信息
	 * @param uid
	 * 用户ID
	 * @return
	 */
	public List<BookInfo> shoppCart(int uid){
		String sql = "select b.bName,b.bPhoto,b.bPrice,s.state,s.shopid" + " FROM ShoppCart s,Book b,User u"
				+ " where s.bid=b.bid and s.uid=u.uid and s.uid=?";
		return (List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, uid);
	}
	
	/**
	 * 单个选中或反选
	 * @param shopid
	 * 购物车ID
	 */
	public void changeState(int shopid) {
		ShoppCart shopping=(ShoppCart) sqlDao.getOne(ShoppCart.class, shopid);
		if (shopping.getState().equals("未选中"))
			shopping.setState("已选中");
		else
			shopping.setState("未选中");
		sqlDao.update(shopping);
	}
	
	/**
	 * 全选和反选
	 * @param start
	 */
	public void allChoose(String start) {
		String sql = "UPDATE ShoppCart SET state=? where uid=?";
		sqlDao.update(sql, start,sessionUser.getUid());
		
	}
	
	/**
	 * 添加书本到购物车（书本库存为0则无法添加）
	 * @param uid
	 * 用户ID
	 * @param bid
	 * 书本ID
	 * @return
	 */
	public boolean addToCart(int uid, int bid) {
		Book book = (Book) sqlDao.getOne(Book.class, bid);
		if (book.getbStore() > 0) {
			ShoppCart shop = new ShoppCart();
			shop.setBid(bid);
			shop.setState("未选中");
			shop.setUid(uid);
			sqlDao.save(shop);
			return true;
		} else {
			return false;
		}

	}
	//购物车生成订单
	public boolean cartToOrder(User u, int[] shoppids, int[] numbers,String beizhu) {
		if (numberOk(shoppids, numbers)) {
			List<Detail> dl = xzCart(shoppids, numbers);
			if(dl.size()==0)
				return false;
			Orders or=new Orders();
			Double S=0.0;
			SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//设置日期格式
			String date=df.format(new Date());
			for (Detail det : dl) {
				Book b = (Book) sqlDao.getOne(Book.class, det.getBid());
				b.setbStore(b.getbStore()-det.getNumber());//更新库存
				b.setbSales(b.getbSales()+det.getNumber());//更新销量
				sqlDao.update(b);
				det.setMoney(b.getbPrice() * det.getNumber());// 小计
				S+=det.getMoney();
			}
			//**********生成订单
			or.setConsid(u.getMyCons());
			or.setUid(u.getUid());or.setOrdPayState("未付款");
			or.setOrdSendState("未发货");or.setOrdTime(date);
			or.setOrdTotal(S);or.setUserdetail(beizhu);
			sqlDao.save(or);
			//******************
			or=(Orders) sqlDao.getList(or).get(0);
			request.setAttribute("ordid", or.getOrdid());
			//*********生成订单明细并且删除购物车中对应的信息
			for (Detail det : dl) {
				det.setOrdid(or.getOrdid());
				sqlDao.save(det);//生成明细
				ShoppCart shop=new ShoppCart();
				shop.setShopid(det.getShoppid());
				sqlDao.delete(shop);//删除购物车
			}
			//********************************************
			return true;
		} else {
			System.out.println("书本数量不够");
			return false;
		}
	}

	// 购物车筛选
	private List<Detail> xzCart(int[] shoppids, int[] numbers) {
		List<Detail> dl = new ArrayList<Detail>();
		for (int i = 0; i < shoppids.length; i++) {
			ShoppCart sc = (ShoppCart) sqlDao.getOne(ShoppCart.class, shoppids[i]);
			if (sc.getState().equals("已选中")) {
				Detail det = new Detail();
				det.setBid(sc.getBid());// 书本id
				det.setNumber(numbers[i]);// 数量
				det.setShoppid(sc.getShopid());
				dl.add(det);
			}
		}
		return dl;
	}
	//取消订单的具体操作
	public boolean cancelOrder(int ordid) {
		Detail de=new Detail();
		de.setOrdid(ordid);
		List<Detail> dl=(List<Detail>) sqlDao.getList(de);
		//**********还原书本库存和销量
		for (Detail detail : dl) {
			Book b=(Book) sqlDao.getOne(Book.class, detail.getBid());
			b.setbStore(b.getbStore()+detail.getNumber());//更新库存
			b.setbSales(b.getbSales()-detail.getNumber());//更新销量
			sqlDao.update(b);
		}
		//****************************
		sqlDao.deleteById("Orders", ordid);
		return true;
	}
	// 判断书本库存是否够数
	private boolean numberOk(int[] shoppids, int[] numbers) {
		List<Detail> dl = xzCart(shoppids, numbers);
		int i = 1;
		for (Detail det : dl) {
			Book b = (Book) sqlDao.getOne(Book.class, det.getBid());
			if (b.getbStore() <det.getNumber())
				i = i * 0;
			else
				i = i * 1;
		}
		if (i == 0)
			return false;
		else
			return true;
	}
	//查询操作
	public List<BookInfo> search(String bName,String autName,String stName){
		String sql="select b.bid,b.bName,a.autName,b.bPrice,b.bdetail,b.bPhoto"
				+" from Book b,Author a,Stort s"
				+" where b.stid=s.stid and b.autid=a.autid and bName like ? and autName like ? and stName like ?";
		String b="%"+bName+"%";String a="%"+autName+"%";String s="%"+stName+"%";
		booklist=(List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql,b,a,s );
		return booklist;
	}
	
	/**
	 * 设置Cookies生命周期
	 * @param name
	 * cookie名
	 * @param value
	 * cookie值
	 * @param isOK
	 * 是否存入
	 */
	public void setCookie(String name,String value,boolean isOK) {
		Cookie cookie = new Cookie(name, value);
		if(isOK) 
			cookie.setMaxAge(7 * 24 * 60 * 60);
		else
			cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	public <T> List<?> getList(T t) {
		return sqlDao.getList(t);
	}

	public <T> boolean save(T t) {
		return sqlDao.save(t);
	}

	public <T> boolean del(T t) {
		return sqlDao.delete(t);
	}

	public Object getOne(Class c, int id) {
		return sqlDao.getOne(c, id);
	}

	public <T> boolean update(T t) {
		return sqlDao.update(t);
	}

	public List<?> getSqlSList(Class c, String sql, Object... obj) {
		return sqlDao.getSqlList(c, sql, obj);
	}

	public boolean update(String sql, Object... obj) {
		return sqlDao.update(sql, obj);
	}
}
