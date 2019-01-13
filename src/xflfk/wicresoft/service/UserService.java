package xflfk.wicresoft.service;

import java.util.ArrayList;
import java.util.List;

import xflfk.wicresoft.dao.SqlDaoImpl;
import xflfk.wicresoft.entitry.Author;
import xflfk.wicresoft.entitry.Book;
import xflfk.wicresoft.entitry.BookInfo;
import xflfk.wicresoft.entitry.LucyCfg;
import xflfk.wicresoft.entitry.Notes;
import xflfk.wicresoft.entitry.PageInfo;
import xflfk.wicresoft.entitry.Stort;
import xflfk.wicresoft.entitry.User;
@SuppressWarnings("all")
public class UserService {
	private SqlDaoImpl sqlDao = new SqlDaoImpl();
	private AdminService admService=new AdminService();
	private List<Notes> noteslist=new ArrayList<Notes>();
	private BookInfo bookInfo=new BookInfo();
	private List<Stort> stortlist=new ArrayList<Stort>();
	private List<BookInfo> booklist=new ArrayList<BookInfo>();
	private List<Author> authorlist=new ArrayList<Author>();
	/**
	 * 显示最受欢迎的书本信息
	 * @return
	 */
	public List<BookInfo> getPopularBook(){
		String sql="select b.bid,b.bName,a.autName,b.bPrice,b.bdetail,b.bPhoto"
				+ " from Book b,Author a"
				+ " where b.autid=a.autid"
				+ " ORDER BY b.bSales DESC"
				+ " LIMIT 0,6";
		booklist=(List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql);
		return booklist;
	}
	/**
	 * 显示美文
	 * @return
	 */
	public List<Notes> getNotes(){
		noteslist=(List<Notes>) sqlDao.getList(new Notes());
		return noteslist;
	}
	/**
	 * 得到所有标记展示的类型
	 * @return
	 */
	public List<Stort> getShowStort(){
		LucyCfg cfg=(LucyCfg) sqlDao.getOne(LucyCfg.class, 1);
		Stort st=new Stort();
		stortlist.add((Stort)sqlDao.getOne(Stort.class, cfg.getShowStort1()));
		stortlist.add((Stort)sqlDao.getOne(Stort.class, cfg.getShowStort2()));
		stortlist.add((Stort)sqlDao.getOne(Stort.class, cfg.getShowStort3()));
		stortlist.add((Stort)sqlDao.getOne(Stort.class, cfg.getShowStort4()));
		return stortlist;
	}
	/**
	 * 得到该id对应类型下销量最好的四本书的信息
	 * @param id
	 * @return
	 */
	public List<BookInfo> showBookByStort(int id){
		String sql="select b.bid,b.bName,a.autName,b.bPrice,b.bPhoto"
				+ " from Book b,Author a ,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and s.stid=?"
				+ " ORDER BY b.bSales DESC"
				+ " LIMIT 0,4";
		booklist=(List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, id);
		return booklist;
	}
	//分页拿书
	public List<BookInfo> showAllBook(int page){
		PageInfo pi = admService.getPageInfo(new Book(), page);
		String sql="select b.bid,b.bName,a.autName,b.bPrice,b.bdetail,b.bPhoto"
				+ " from Book b,Author a"
				+ " where b.autid=a.autid"
				+ " LIMIT ?,12";
		booklist=(List<BookInfo>) admService.getList(BookInfo.class, sql, pi.getIndex());
		return booklist;
	}
	//分页拿作者
	public List<Author> showAllAuthor(int page){
		PageInfo pi = admService.getPageInfo(new Book(), page);
		authorlist=(List<Author>) sqlDao.getPagList(new Author(), pi.getIndex(),9);
		return authorlist;
	}
	//拿到所有类型
	public List<Stort> allStort(){
		return (List<Stort>) sqlDao.getList(new Stort());
	}
	//拿到autid对应作者下的所有书本
	public List<BookInfo> autToBooks(int autid){
		String sql="select b.bid,b.bName,a.autName,b.bPrice,b.bPhoto,a.autid"
				+ " from Book b,Author a ,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and a.autid=?";
		booklist=(List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, autid);
		return booklist;
	}
	//拿到stid对应类型下的所有书本
	public List<BookInfo> stoToBooks(int stid){
		String sql="select b.bid,b.bName,a.autName,b.bPrice,b.bPhoto,s.stName"
				+ " from Book b,Author a ,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and s.stid=?";
		booklist=(List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, stid);
		return booklist;
	}
	//id拿作者信息
	public Author getAuthorById(int autid) {
		return (Author) sqlDao.getOne(Author.class, autid);
	}
	//用户登录
	public User login(User user) {
		if(sqlDao.getList(user).size()==0)
			return null;
		else 
			return (User) sqlDao.getList(user).get(0);
	}
	//用户注册
	public boolean register(User user) {
		User u=new User();
		u.setuName(user.getuName());
		if(sqlDao.getList(u).size()!=0) {
			return false;//用户名已存在
		}else {
			sqlDao.save(user);
			return true;//注册成功
		}
	}
}
