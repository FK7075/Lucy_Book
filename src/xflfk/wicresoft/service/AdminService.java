package xflfk.wicresoft.service;

import java.util.ArrayList;
import java.util.List;

import xflfk.wicresoft.dao.SqlDaoImpl;
import xflfk.wicresoft.entitry.Admin;
import xflfk.wicresoft.entitry.Book;
import xflfk.wicresoft.entitry.Detail;
import xflfk.wicresoft.entitry.LucyCfg;
import xflfk.wicresoft.entitry.PageInfo;
import xflfk.wicresoft.entitry.User;

@SuppressWarnings("all")
public class AdminService {
	private SqlDaoImpl sqlDao = new SqlDaoImpl();

	/**
	 * 管理员登录
	 * 
	 * @param admin
	 *            (用户名，密码)
	 * @return
	 */
	public Admin login(Admin admin) {
		if (sqlDao.getList(admin).size() == 0) {
			return null;// 登录失败
		} else {
			return (Admin) sqlDao.getList(admin).get(0);// 登录成功
		}
	}

	/**
	 * 添加管理员（0-用户名已存在 1-添加成功）
	 * 
	 * @param admin
	 * @return
	 */
	public int addAdmin(Admin admin) {
		// 判断用户名是否存在
		Admin t = new Admin();
		t.setAdmName(admin.getAdmName());
		if (sqlDao.getList(t).size() == 0) {
			sqlDao.save(admin);
			return 1;// 添加成功
		} else {
			return 0;// 用户名已存在
		}
	}

	/**
	 * 修改配置（分页配置，库存提示下限）
	 * 
	 * @param cfg
	 * @return
	 */
	public boolean setConfig(LucyCfg cfg) {
		return sqlDao.update(cfg);
	}

	/**
	 * 添加操作
	 * 
	 * @param t
	 * @return
	 */
	public <T> boolean add(T t) {
		return sqlDao.save(t);
	}

	/**
	 * sql添加
	 * 
	 * @param sql
	 * @param object
	 * @return
	 */
	public boolean add(String sql, Object... object) {
		return sqlDao.save(sql, object);
	}

	/**
	 * 删除操作
	 * 
	 * @param t
	 * @return
	 */
	public <T> boolean del(T t) {
		return sqlDao.delete(t);
	}
	/**
	 * 类名+id删除
	 * @param tableName
	 * @param id
	 * @return
	 */
	public boolean del(String tableName,int id) {
		return sqlDao.deleteById(tableName, id);
	}

	/**
	 * sql删除
	 * 
	 * @param sql
	 * @param object
	 * @return
	 */
	public boolean del(String sql, Object... object) {
		return sqlDao.delete(sql, object);
	}

	/**
	 * 更新操作
	 * 
	 * @param t
	 * @return
	 */
	public <T> boolean update(T t) {
		return sqlDao.update(t);
	}

	/**
	 * sql更新
	 * 
	 * @param sql
	 * @param object
	 * @return
	 */
	public boolean update(String sql, Object... object) {
		return sqlDao.update(sql, object);
	}

	/**
	 * sql查询
	 * 
	 * @param c
	 * @param sql
	 * @param obj
	 * @return
	 */
	public List<?> getList(Class c, String sql, Object... obj) {
		return sqlDao.getSqlList(c, sql, obj);
	}

	/**
	 * id查询
	 * 
	 * @param c
	 * @param id
	 * @return
	 */
	public Object getOne(Class c, int id) {
		return sqlDao.getOne(c, id);
	}

	/**
	 * 对象方式查询
	 * 
	 * @param t
	 * @return
	 */
	public <T> List<?> getList(T t) {
		return sqlDao.getList(t);
	}
	/**
	 * 分页查询
	 * @param t
	 * @param index
	 * @return
	 */
	public <T> List<?> getListPag(T t,int index,int pageSize){
		return sqlDao.getPagList(t, index,pageSize);
	}
	/**
	 * 返回某个表的总记录数
	 * 
	 * @param t
	 * @return
	 */
	public <T> int getCount(T t) {
		return sqlDao.getList(t).size();
	}

	/**
	 * sql方式返回某个表的总记录数
	 * 
	 * @param c
	 * @param sql
	 * @param obj
	 * @return
	 */
	public int getCount(Class c, String sql, Object... obj) {
		return sqlDao.getSqlList(c, sql, obj).size();
	}

	/**
	 * sql方式返回某个表分页后的总页数
	 * 
	 * @param c
	 * @param sql
	 * @param obj
	 * @return
	 */
	public int getPageSize(Class c, String sql, Object... obj) {
		LucyCfg cfg = (LucyCfg) sqlDao.getOne(LucyCfg.class, 1);
		if (getCount(c, sql, obj) % cfg.getPagesize() == 0)
			return (getCount(c, sql, obj) / cfg.getPagesize());
		else
			return (getCount(c, sql, obj) / cfg.getPagesize() + 1);
	}

	/**
	 * 返回某个表分页后的总页数
	 * 
	 * @param t
	 * @return
	 */
	public <T> int getPageSize(T t) {
		LucyCfg cfg = (LucyCfg) sqlDao.getOne(LucyCfg.class, 1);
		if (getCount(t) % cfg.getPagesize() == 0)
			return (getCount(t) / cfg.getPagesize());
		else
			return (getCount(t) / cfg.getPagesize() + 1);
	}

	/**
	 * 获得分页信息
	 * 
	 * @param t
	 *            表所对应的空对象
	 * @param nextIndex
	 *            下一页页数
	 * @return
	 */
	public <T> PageInfo getPageInfo(T t, int nextIndex) {
		LucyCfg cfg = (LucyCfg) sqlDao.getOne(LucyCfg.class, 1);
		PageInfo pi = new PageInfo();
		pi.setSize(cfg.getPagesize());// 每页记录数
		pi.setCount(getCount(t));// 表的总记录数
		pi.setPagenum(getPageSize(t));// 总页数
		pi.setIndex(cfg.getPagesize()*(nextIndex-1));
		return pi;
	}
	/**
	 *  获得分页信息
	 * @param pagenum
	 * @param nowIndex
	 * @return
	 */
	public PageInfo getPageInfo(int pagenum, int nowIndex) {
		LucyCfg cfg = (LucyCfg) sqlDao.getOne(LucyCfg.class, 1);
		PageInfo pi = new PageInfo();
		pi.setSize(cfg.getPagesize());// 每页记录数
		pi.setPagenum(pagenum);// 总页数
		pi.setIndex(cfg.getPagesize()*(nowIndex-1));
		return pi;
	}
	public LucyCfg getLucyCfg(){
		LucyCfg cfg=(LucyCfg) sqlDao.getOne(LucyCfg.class, 1);
		return cfg;
	}
	//统计
	public List<Object> statistical(){
		List<Object> intlist=new ArrayList<Object>();
		List<Book> bl=(List<Book>) sqlDao.getList(new Book());
		List<User> ul=(List<User>) sqlDao.getList(new User());
		List<Detail> dl=(List<Detail>) sqlDao.getList(new Detail()); 
		Long yh=(long) 0;
		Double dd=0.0;
		Long xl=(long) 0;
		yh=(long) ul.size();
		for (Book book : bl) {
			xl+=book.getbSales();
		}
		for (Detail detail : dl) {
			dd+=detail.getMoney();
		}
		intlist.add(xl);
		intlist.add(dd);
		intlist.add(yh);
		return intlist;
	}
}
