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
	 * ����Ա��¼
	 * @param admin
	 * (�û���������)
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
	 * @param admin
	 * @return
	 */
	public int addAdmin(Admin admin) {
		// �ж��û����Ƿ����
		Admin t = new Admin();
		t.setAdmName(admin.getAdmName());
		if (sqlDao.getList(t).size() == 0) {
			return 1;// ��ӳɹ�
		} else {
			return 0;// �û����Ѵ���
		}
	}

	/**
	 * ��Ӳ���
	 * @param t
	 * @return
	 */
	public <T> boolean add(T t) {
		return sqlDao.save(t);
	}

	/**
	 * sql���
	 * @param sql
	 * @param object
	 * @return
	 */
	public boolean add(String sql, Object... object) {
		return sqlDao.save(sql, object);
	}

	/**
	 * ɾ������
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
	 * @param c
	 * @param id
	 * @return
	 */
	public Object getOne(Class c, int id) {
		return sqlDao.getOne(c, id);
	}

	/**
	 * ����ʽ��ѯ
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
	 * �õ�����ͳ�Ƶ���Ϣ
	 * @return
	 */
	public List<Object> statistical(){
		List<Object> intlist=new ArrayList<Object>();//����һ��������ݵ�Object����
		List<Book> bl=(List<Book>) sqlDao.getList(new Book());//�õ����е��鱾
		List<User> ul=(List<User>) sqlDao.getList(new User());//�õ����е��û�
		List<Detail> dl=(List<Detail>) sqlDao.getList(new Detail()); //�õ����е���ϸ
		Long yh=(long) 0;//������û���
		Double dd=0.0;//���������
		Long xl=(long) 0;//���������
		yh=(long) ul.size();
		for (Book book : bl) {
			xl+=book.getbSales();//�����ۼ���͵õ�������
		}
		for (Detail detail : dl) {
			dd+=detail.getMoney();//С���ۼ���͵õ�������
		}
		intlist.add(xl);
		intlist.add(dd);
		intlist.add(yh);
		return intlist;
	}
}
