package service;

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

import dao.SqlDaoImpl;
import entitry.Author;
import entitry.Book;
import entitry.Consigness;
import entitry.Detail;
import entitry.Notes;
import entitry.Orders;
import entitry.ShoppCart;
import entitry.Stort;
import entitry.User;
import util.BookInfo;
import util.PageInfo;

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
	 * 用户登录（成功返回User对象，否则返回null）?
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
	 * 用户注册（成功返回true，用户名存在返回false）?
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
		Book book = (Book) sqlDao.getOne(Book.class, bid);//根据bid得到书本信息
		if (book.getbStore() > 0) {//判断库存是否大于0
			ShoppCart shop = new ShoppCart();//声明购物车
			shop.setBid(bid);//设置书本ID'bid'
			shop.setState("未选中");//设置默认状态为‘未选中’
			shop.setUid(uid);//设置用户ID'uid'
			sqlDao.save(shop);//执行添加操作
			return true;
		} else {
			return false;//库存为0，如法添加到购物车
		}

	}
	
	/**
	 * 购物车生成订单
	 * @param u
	 * 用户User对象
	 * @param shoppids
	 * 该用户的购物车纪录
	 * @param numbers
	 * 购物车纪录对应的购买数量
	 * @param beizhu
	 * 用户备注
	 * @return
	 */
	/*
	 * 1.选出状态为‘已选中’的购物车纪录，并生成明细纪录(这里的明细缺少外键-订单ID，不能存入数据库)
	 * 2.判断购物车中的购买数量是否不大于对应书本的库存
	 * 3.判断明细记录的条数，确保用户选中了商品
	 * 4.遍历明细记录，根据其中的书本id，更新书本的销量和库存信息
	 * 5.根据书本id得到书本的单价，完成明细表的‘小计’的设置
	 * 6.根据得到的有效信息生成订单
	 * 7.查询出刚才生成的订单获得订单的主键ID
	 * 8.将订单ID加入到明细记录中并保存
	 */
	public boolean cartToOrder(User u, int[] shoppids, int[] numbers,String beizhu) {
		List<Detail> dl = xzCart(shoppids, numbers);//此明细记录的集合还缺少外键信息--订单ID
		if (numberOk(dl)) {//判断购物车中已选中的商品的购买数量是否超过库存
			Orders or=new Orders();//声明一个订单
			Double S=0.0;//用于存放订单的总金额
			SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//设置日期格式
			String date=df.format(new Date());
			for (Detail det : dl) {//遍历明细信息，更新书本的信息（库存和销量）
				Book b = (Book) sqlDao.getOne(Book.class, det.getBid());//根据明细表中的书本外键得到对应书本的信息
				b.setbStore(b.getbStore()-det.getNumber());//更新这本书的库存
				b.setbSales(b.getbSales()+det.getNumber());//更新这本书的销量
				sqlDao.update(b);//执行更新操作
				det.setMoney(b.getbPrice() * det.getNumber());// 小计(小计=购买数量*书本单价)
				S+=det.getMoney();//"小计"累加为"总金额"
			}
			//**********生成订单
			or.setConsid(u.getMyCons());//设置收货人
			or.setUid(u.getUid());//设置订单创建人
			or.setOrdPayState("未付款");//设置订单的初始‘付款状态’
			or.setOrdSendState("未发货");//设置订单的初始‘发货状态’
			or.setOrdTime(date);//设置订单的创建时间
			or.setOrdTotal(S);//设置订单的总金额
			or.setUserdetail(beizhu);//设置用户的备注信息
			sqlDao.save(or);//保存订单
			//******************
			or=(Orders) sqlDao.getList(or).get(0);//因为订单的ID是自动生成的，所以要获得包含订单ID的完整的订单信息还得用刚才的信息作为条件再去查询一次
			request.setAttribute("ordid", or.getOrdid());
			//*********生成订单明细并且删除购物车中对应的信息
			for (Detail det : dl) {//遍历明细记录并补充上订单ID
				det.setOrdid(or.getOrdid());//设置所属的订单
				sqlDao.save(det);//生成明细
				ShoppCart shop=new ShoppCart();//订单生成后，删除购物车中对应的记录
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

	/**
	 * 购物车筛选生成并返回对应的明细记录(筛选出所有被选中的购物车记录)
	 * @param shoppids
	 * 购物车id数组
	 * @param numbers
	 * 购买数量数组
	 * @return
	 */
	private List<Detail> xzCart(int[] shoppids, int[] numbers) {
		List<Detail> dl = new ArrayList<Detail>();//声明一个明细集合
		for (int i = 0; i < shoppids.length; i++) {//遍历传入的购物车ID并找出状态为"已选中"的
			ShoppCart sc = (ShoppCart) sqlDao.getOne(ShoppCart.class, shoppids[i]);//根据购物车ID拿到购物车信息
			if (sc.getState().equals("已选中")) {//状态判断（已选中的就加入到明细表中，为选中的不做操作）
				Detail det = new Detail();
				det.setBid(sc.getBid());// 书本id
				det.setNumber(numbers[i]);// 数量
				det.setShoppid(sc.getShopid());
				dl.add(det);
			}
		}
		return dl;//返回该用户由购物车中已选中的记录所组成的明细表记录集合
	}
	/**
	 * 取消订单，并还原书本信息
	 * @param ordid
	 * 订单ID
	 * @return
	 */
	public boolean cancelOrder(int ordid) {
		Detail de=new Detail();
		de.setOrdid(ordid);
		List<Detail> dl=(List<Detail>) sqlDao.getList(de);//得到该订单ID下的所有明细记录
		//**********还原书本库存和销量
		for (Detail detail : dl) {//遍历明细记录，根据每条记录中的书本ID找到并还原书本信息
			Book b=(Book) sqlDao.getOne(Book.class, detail.getBid());
			b.setbStore(b.getbStore()+detail.getNumber());//还原库存
			b.setbSales(b.getbSales()-detail.getNumber());//还原销量
			sqlDao.update(b);//执行还原操作
		}
		//****************************
		sqlDao.deleteById(Orders.class, ordid);//执行订单删除操作
		return true;
	}
	/**
	 * 判断筛选后的明细是否为空？且明细中对应的购买数量是否不大于书本的库存？
	 * @param detlist
	 * @return
	 */
	private boolean numberOk(List<Detail> detlist) {
		if(detlist.size()==0)//判断筛选后的明细是否为空
			return false;
		else {
			for(Detail det:detlist) {
				Book book=(Book) sqlDao.getOne(Book.class, det.getBid());
				if(det.getNumber()>book.getbStore())//判断明细中对应的购买数量是否不大于书本的库存
					return false;
			}
			return true;
		}
	}
	/**
	 * 多条件联合查询书本（书名+作者+类型）
	 * @param bName
	 * 书名
	 * @param autName
	 * 作者
	 * @param stName
	 * 类型
	 * @return
	 */
	public List<BookInfo> search(String bName,String autName,String stName){
		String sql="select b.bid,b.bName,a.autName,b.bPrice,b.bdetail,b.bPhoto"
				+" from Book b,Author a,Stort s"
				+" where b.stid=s.stid and b.autid=a.autid and bName like ? and autName like ? and stName like ?";
		String b="%"+bName+"%";String a="%"+autName+"%";String s="%"+stName+"%";//模糊查询内容
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
