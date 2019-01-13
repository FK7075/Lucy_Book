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
	 * ��ʾ���ܻ�ӭ���鱾��Ϣ
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
	 * ��ʾ����
	 * @return
	 */
	public List<Notes> getNotes(){
		noteslist=(List<Notes>) sqlDao.getList(new Notes());
		return noteslist;
	}
	/**
	 * �õ����б��չʾ������
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
	 * �õ���id��Ӧ������������õ��ı������Ϣ
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
	//��ҳ����
	public List<BookInfo> showAllBook(int page){
		PageInfo pi = admService.getPageInfo(new Book(), page);
		String sql="select b.bid,b.bName,a.autName,b.bPrice,b.bdetail,b.bPhoto"
				+ " from Book b,Author a"
				+ " where b.autid=a.autid"
				+ " LIMIT ?,12";
		booklist=(List<BookInfo>) admService.getList(BookInfo.class, sql, pi.getIndex());
		return booklist;
	}
	//��ҳ������
	public List<Author> showAllAuthor(int page){
		PageInfo pi = admService.getPageInfo(new Book(), page);
		authorlist=(List<Author>) sqlDao.getPagList(new Author(), pi.getIndex(),9);
		return authorlist;
	}
	//�õ���������
	public List<Stort> allStort(){
		return (List<Stort>) sqlDao.getList(new Stort());
	}
	//�õ�autid��Ӧ�����µ������鱾
	public List<BookInfo> autToBooks(int autid){
		String sql="select b.bid,b.bName,a.autName,b.bPrice,b.bPhoto,a.autid"
				+ " from Book b,Author a ,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and a.autid=?";
		booklist=(List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, autid);
		return booklist;
	}
	//�õ�stid��Ӧ�����µ������鱾
	public List<BookInfo> stoToBooks(int stid){
		String sql="select b.bid,b.bName,a.autName,b.bPrice,b.bPhoto,s.stName"
				+ " from Book b,Author a ,Stort s"
				+ " where b.autid=a.autid and b.stid=s.stid and s.stid=?";
		booklist=(List<BookInfo>) sqlDao.getSqlList(BookInfo.class, sql, stid);
		return booklist;
	}
	//id��������Ϣ
	public Author getAuthorById(int autid) {
		return (Author) sqlDao.getOne(Author.class, autid);
	}
	//�û���¼
	public User login(User user) {
		if(sqlDao.getList(user).size()==0)
			return null;
		else 
			return (User) sqlDao.getList(user).get(0);
	}
	//�û�ע��
	public boolean register(User user) {
		User u=new User();
		u.setuName(user.getuName());
		if(sqlDao.getList(u).size()!=0) {
			return false;//�û����Ѵ���
		}else {
			sqlDao.save(user);
			return true;//ע��ɹ�
		}
	}
}
