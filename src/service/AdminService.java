package service;

import java.util.ArrayList;
import java.util.List;

import dao.SqlDaoImpl;
import entitry.Admin;
import entitry.Book;
import entitry.Detail;
import entitry.User;
import util.PageInfo;

@SuppressWarnings("all")
public class AdminService {
	private SqlDaoImpl sqlDao = new SqlDaoImpl();

	/**
	 * 管理员登录
	 * @param admin
	 * (用户名，密码)
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
	 * @param admin
	 * @return
	 */
	public int addAdmin(Admin admin) {
		// 判断用户名是否存在
		Admin t = new Admin();
		t.setAdmName(admin.getAdmName());
		if (sqlDao.getList(t).size() == 0) {
			return 1;// 添加成功
		} else {
			return 0;// 用户名已存在
		}
	}

	/**
	 * 添加操作
	 * @param t
	 * @return
	 */
	public <T> boolean add(T t) {
		return sqlDao.save(t);
	}

	/**
	 * sql添加
	 * @param sql
	 * @param object
	 * @return
	 */
	public boolean add(String sql, Object... object) {
		return sqlDao.save(sql, object);
	}

	/**
	 * 删除操作
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
	 * @param c
	 * @param id
	 * @return
	 */
	public Object getOne(Class c, int id) {
		return sqlDao.getOne(c, id);
	}

	/**
	 * 对象方式查询
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
	 * 得到数据统计的信息
	 * @return
	 */
	public List<Object> statistical(){
		List<Object> intlist=new ArrayList<Object>();//声明一个存放数据的Object集合
		List<Book> bl=(List<Book>) sqlDao.getList(new Book());//得到所有的书本
		List<User> ul=(List<User>) sqlDao.getList(new User());//得到所有的用户
		List<Detail> dl=(List<Detail>) sqlDao.getList(new Detail()); //得到所有的明细
		Long yh=(long) 0;//存放总用户量
		Double dd=0.0;//存放总收入
		Long xl=(long) 0;//存放总销量
		yh=(long) ul.size();
		for (Book book : bl) {
			xl+=book.getbSales();//销量累加求和得到总销量
		}
		for (Detail detail : dl) {
			dd+=detail.getMoney();//小计累计求和得到总收入
		}
		intlist.add(xl);
		intlist.add(dd);
		intlist.add(yh);
		return intlist;
	}
}
