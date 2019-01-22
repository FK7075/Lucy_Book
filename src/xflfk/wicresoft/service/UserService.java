package xflfk.wicresoft.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import xflfk.wicresoft.dao.SqlDaoImpl;
import xflfk.wicresoft.entitry.Author;
import xflfk.wicresoft.entitry.Book;
import xflfk.wicresoft.entitry.BookInfo;
import xflfk.wicresoft.entitry.Detail;
import xflfk.wicresoft.entitry.LucyCfg;
import xflfk.wicresoft.entitry.Notes;
import xflfk.wicresoft.entitry.Orders;
import xflfk.wicresoft.entitry.PageInfo;
import xflfk.wicresoft.entitry.ShoppCart;
import xflfk.wicresoft.entitry.Stort;
import xflfk.wicresoft.entitry.User;

@SuppressWarnings("all")
public class UserService {
	private SqlDaoImpl sqlDao = new SqlDaoImpl();
	private AdminService admService = new AdminService();
	private List<Notes> noteslist = new ArrayList<Notes>();
	private BookInfo bookInfo = new BookInfo();
	private List<Stort> stortlist = new ArrayList<Stort>();
	private List<BookInfo> booklist = new ArrayList<BookInfo>();
	private List<Author> authorlist = new ArrayList<Author>();
	private HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * 显示最受欢迎的书本信息
	 * 
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
	 * 
	 * @return
	 */
	public List<Notes> getNotes() {
		noteslist = (List<Notes>) sqlDao.getList(new Notes());
		return noteslist;
	}

	/**
	 * 得到所有标记展示的类型
	 * 
	 * @return
	 */
	public List<Stort> getShowStort() {
		LucyCfg cfg = (LucyCfg) sqlDao.getOne(LucyCfg.class, 1);
		Stort st = new Stort();
		stortlist.add((Stort) sqlDao.getOne(Stort.class, cfg.getShowStort1()));
		stortlist.add((Stort) sqlDao.getOne(Stort.class, cfg.getShowStort2()));
		stortlist.add((Stort) sqlDao.getOne(Stort.class, cfg.getShowStort3()));
		stortlist.add((Stort) sqlDao.getOne(Stort.class, cfg.getShowStort4()));
		return stortlist;
	}

	/**
	 * 得到该id对应类型下销量最好的四本书的信息
	 * 
	 * @param id
	 * @return
	 */
	public List<BookInfo> showBookByStort(int id) {
		String sql = "select b.bid,b.bName,a.autName,b.bPrice,b.bPhoto" + " from Book b,Author a ,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and s.stid=?" + " ORDER BY b.bSales DESC" + " LIMIT 0,4";
		booklist = (List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, id);
		return booklist;
	}

	// 分页拿书
	public List<BookInfo> showAllBook(int page) {
		PageInfo pi = admService.getPageInfo(new Book(), page);
		String sql = "select b.bid,b.bName,a.autName,b.bPrice,b.bdetail,b.bPhoto" + " from Book b,Author a"
				+ " where b.autid=a.autid" + " LIMIT ?,12";
		booklist = (List<BookInfo>) admService.getList(BookInfo.class, sql, pi.getIndex());
		return booklist;
	}

	// 分页拿作者
	public List<Author> showAllAuthor(int page) {
		PageInfo pi = admService.getPageInfo(new Book(), page);
		authorlist = (List<Author>) sqlDao.getPagList(new Author(), pi.getIndex(), 9);
		return authorlist;
	}

	// 拿到所有类型
	public List<Stort> allStort() {
		return (List<Stort>) sqlDao.getList(new Stort());
	}

	// 拿到autid对应作者下的所有书本
	public List<BookInfo> autToBooks(int autid) {
		String sql = "select b.bid,b.bName,a.autName,b.bPrice,b.bPhoto,a.autid" + " from Book b,Author a ,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and a.autid=?";
		booklist = (List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, autid);
		return booklist;
	}

	// 拿到stid对应类型下的所有书本
	public List<BookInfo> stoToBooks(int stid) {
		String sql = "select b.bid,b.bName,a.autName,b.bPrice,b.bPhoto,s.stName" + " from Book b,Author a ,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and s.stid=?";
		booklist = (List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, stid);
		return booklist;
	}

	// id拿作者信息
	public Author getAuthorById(int autid) {
		return (Author) sqlDao.getOne(Author.class, autid);
	}

	// 用户登录
	public User login(User user) {
		if (sqlDao.getList(user).size() == 0)
			return null;
		else
			return (User) sqlDao.getList(user).get(0);
	}

	// 用户注册
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

	// 添加商品到购物车
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
