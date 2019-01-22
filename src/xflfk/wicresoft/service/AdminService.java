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
	 * ����Ա��¼
	 * 
	 * @param admin
	 *            (�û���������)
	 * @return
	 */
	public Admin login(Admin admin) {
		if (sqlDao.getList(admin).size() == 0) {
			return null;// ��¼ʧ��
		} else {
			return (Admin) sqlDao.getList(admin).get(0);// ��¼�ɹ�
		}
	}

	/**
	 * ��ӹ���Ա��0-�û����Ѵ��� 1-��ӳɹ���
	 * 
	 * @param admin
	 * @return
	 */
	public int addAdmin(Admin admin) {
		// �ж��û����Ƿ����
		Admin t = new Admin();
		t.setAdmName(admin.getAdmName());
		if (sqlDao.getList(t).size() == 0) {
			sqlDao.save(admin);
			return 1;// ��ӳɹ�
		} else {
			return 0;// �û����Ѵ���
		}
	}

	/**
	 * �޸����ã���ҳ���ã������ʾ���ޣ�
	 * 
	 * @param cfg
	 * @return
	 */
	public boolean setConfig(LucyCfg cfg) {
		return sqlDao.update(cfg);
	}

	/**
	 * ��Ӳ���
	 * 
	 * @param t
	 * @return
	 */
	public <T> boolean add(T t) {
		return sqlDao.save(t);
	}

	/**
	 * sql���
	 * 
	 * @param sql
	 * @param object
	 * @return
	 */
	public boolean add(String sql, Object... object) {
		return sqlDao.save(sql, object);
	}

	/**
	 * ɾ������
	 * 
	 * @param t
	 * @return
	 */
	public <T> boolean del(T t) {
		return sqlDao.delete(t);
	}
	/**
	 * ����+idɾ��
	 * @param tableName
	 * @param id
	 * @return
	 */
	public boolean del(String tableName,int id) {
		return sqlDao.deleteById(tableName, id);
	}

	/**
	 * sqlɾ��
	 * 
	 * @param sql
	 * @param object
	 * @return
	 */
	public boolean del(String sql, Object... object) {
		return sqlDao.delete(sql, object);
	}

	/**
	 * ���²���
	 * 
	 * @param t
	 * @return
	 */
	public <T> boolean update(T t) {
		return sqlDao.update(t);
	}

	/**
	 * sql����
	 * 
	 * @param sql
	 * @param object
	 * @return
	 */
	public boolean update(String sql, Object... object) {
		return sqlDao.update(sql, object);
	}

	/**
	 * sql��ѯ
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
	 * id��ѯ
	 * 
	 * @param c
	 * @param id
	 * @return
	 */
	public Object getOne(Class c, int id) {
		return sqlDao.getOne(c, id);
	}

	/**
	 * ����ʽ��ѯ
	 * 
	 * @param t
	 * @return
	 */
	public <T> List<?> getList(T t) {
		return sqlDao.getList(t);
	}
	/**
	 * ��ҳ��ѯ
	 * @param t
	 * @param index
	 * @return
	 */
	public <T> List<?> getListPag(T t,int index,int pageSize){
		return sqlDao.getPagList(t, index,pageSize);
	}
	/**
	 * ����ĳ������ܼ�¼��
	 * 
	 * @param t
	 * @return
	 */
	public <T> int getCount(T t) {
		return sqlDao.getList(t).size();
	}

	/**
	 * sql��ʽ����ĳ������ܼ�¼��
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
	 * sql��ʽ����ĳ�����ҳ�����ҳ��
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
	 * ����ĳ�����ҳ�����ҳ��
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
	 * ��÷�ҳ��Ϣ
	 * 
	 * @param t
	 *            ������Ӧ�Ŀն���
	 * @param nextIndex
	 *            ��һҳҳ��
	 * @return
	 */
	public <T> PageInfo getPageInfo(T t, int nextIndex) {
		LucyCfg cfg = (LucyCfg) sqlDao.getOne(LucyCfg.class, 1);
		PageInfo pi = new PageInfo();
		pi.setSize(cfg.getPagesize());// ÿҳ��¼��
		pi.setCount(getCount(t));// ����ܼ�¼��
		pi.setPagenum(getPageSize(t));// ��ҳ��
		pi.setIndex(cfg.getPagesize()*(nextIndex-1));
		return pi;
	}
	/**
	 *  ��÷�ҳ��Ϣ
	 * @param pagenum
	 * @param nowIndex
	 * @return
	 */
	public PageInfo getPageInfo(int pagenum, int nowIndex) {
		LucyCfg cfg = (LucyCfg) sqlDao.getOne(LucyCfg.class, 1);
		PageInfo pi = new PageInfo();
		pi.setSize(cfg.getPagesize());// ÿҳ��¼��
		pi.setPagenum(pagenum);// ��ҳ��
		pi.setIndex(cfg.getPagesize()*(nowIndex-1));
		return pi;
	}
	public LucyCfg getLucyCfg(){
		LucyCfg cfg=(LucyCfg) sqlDao.getOne(LucyCfg.class, 1);
		return cfg;
	}
	//ͳ��
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
