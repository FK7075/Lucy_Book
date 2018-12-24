package xflfk.wicresoft.service;

import java.util.List;

import xfl.fk.sqldao.Transaction;
import xflfk.wicresoft.dao.BookDaoImpl;
import xflfk.wicresoft.dao.ConsignessDaoImpl;
import xflfk.wicresoft.dao.DetailDaoImpl;
import xflfk.wicresoft.dao.OrdersDaoImpl;
import xflfk.wicresoft.dao.SqlDaoImpl;
import xflfk.wicresoft.dao.UserDaoImpl;
import xflfk.wicresoft.entitry.Book;
import xflfk.wicresoft.entitry.Consigness;
import xflfk.wicresoft.entitry.Detail;
import xflfk.wicresoft.entitry.Orders;
import xflfk.wicresoft.entitry.User;
import xflfk.wicresoft.factory.SqlDaoImplFactory;

@SuppressWarnings("all")
public class UserService {
	private UserDaoImpl userDaoImpl = SqlDaoImplFactory.getUserDaoImpl();
	private ConsignessDaoImpl consignessDaoImpl = SqlDaoImplFactory.getConsignessDaoImpl();
	private OrdersDaoImpl ordersDaoImpl = SqlDaoImplFactory.getOrdersDaoImpl();
	private DetailDaoImpl detailDaoImpl = SqlDaoImplFactory.getDetailDaoImpl();
	private BookDaoImpl bookDaoImpl = SqlDaoImplFactory.getBookDaoImpl();
	private boolean isOk = false;
	private Transaction tx = null;

	/**
	 * �û���¼
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	/// �Բ������û�������û�����������Ϊ��ѯ����ȥ��ѯ���ݿ⣬���ز�ѯ���
	public User login(User user) {
		if (userDaoImpl.getList(user) == null)
			user = null;
		else {
			user = userDaoImpl.getList(user).get(0);
		}
		return user;
	}

	/**
	 * �û�ע��
	 * 
	 * @param user
	 * @return
	 */
	/// ���ж��û����Ƿ��Ѿ����ڣ�������ڷ���0��ע��ʧ�ܣ���������ڷ���1��ע��ɹ���
	public int register(User user) {
		User u = new User();
		u.setuName(user.getuName());
		if (userDaoImpl.getList(u) != null)
			return 0;// �û����Ѿ����ڣ�ע��ʧ��
		else {
			userDaoImpl.save(user);
			return 1;// �û��������ڣ�ע��ɹ�
		}
	}

	/**
	 * ����id���ذ����û���ϸ��Ϣ��User����
	 * 
	 * @param id
	 * @return
	 */
	public User showUserInfo(int id) {
		return userDaoImpl.getOne(id);
	}

	/**
	 * �޸��û���Ϣ
	 * 
	 * @param user
	 * @return
	 */
	public boolean changeUserInfo(User user) {
		return userDaoImpl.update(user);
	}

	/**
	 * ����ջ���
	 * 
	 * @param cons
	 *(�ջ����������ջ��˵绰���ջ���ַ��������uid)
	 * @return
	 */
	public boolean addConsigness(Consigness cons) {
		return consignessDaoImpl.save(cons);
	}

	/**
	 * ���һ����ϸ��¼
	 * 
	 * @param detail
	 * (�û�uid����Ҫ�����鱾��bid�������������ջ���consid,�û���ע��Ϣ)
	 * @return
	 */
	public boolean addDetail(Detail detail) {
		if (bookDaoImpl.getOne(detail.getBid()).getbStore() < detail.getNumber()) {
			System.out.println("��Ʒ��治�㣡");
			return false;
		} else {
			detail.setDetState("δ����");// ��״̬����Ϊ"δ����"
			// ���������ϸ����Ʒ���ܼ۸�
			detail.setMoney(bookDaoImpl.getOne(detail.getBid()).getbPrice() * detail.getNumber());
			return detailDaoImpl.save(detail);
		}
	}

	/**
	 * �õ������������ϸ��¼
	 * 
	 * @param uid
	 * @return
	 */
	public List<Detail> getNewDetail(int uid) {
		return detailDaoImpl.getList("select * from Detail where uid=? and detState=?", uid, "δ����");
	}

	/**
	 * ����һ��"δ����"�������������ö�����������ϸ
	 * 
	 * @param order
	 *            ���û�uid������ʱ�䣩
	 * @param detlist
	 *            ������ϸ��¼����ɵ�List����
	 * @return
	 */
	public boolean createOrder(Orders order, List<Detail> detlist) {
		///// ���ƶ�����Ϣ
		order.setOrdState("δ����");
		Double total = 0.0;
		// �����ܼ۸�
		for (Detail d : detlist) {
			total += d.getMoney();
		}
		order.setOrdTotal(total);
		ordersDaoImpl.save(order);// �������������ݿ�
		///// ������ϸ��Ϣ
		int ordid = ordersDaoImpl.getList(order).get(0).getOrdid();
		for (Detail d : detlist) {
			d.setOrdid(ordid);
			detailDaoImpl.update(d);
		}
		return true;
	}
	/**
	 * ������ʽֱ�ӹ���
	 * @param order
	 * ������ordid��
	 * @return
	 */
	public boolean directlyBuy(Orders order) {
		SqlDaoImpl sqlDaoImpl = new SqlDaoImpl(Detail.class);
		List<Detail> list = (List<Detail>) sqlDaoImpl.getListSql("select * from detail d,orders o where d.ordid=o.ordid and d.detState=?", "δ����");
		order.setOrdState("�Ѹ���");
		ordersDaoImpl.update(order);
		for (Detail d : list) {
			d.setDetState("�Ѹ���");
			detailDaoImpl.update(d);
			Book b = bookDaoImpl.getOne(d.getBid());
			b.setbStore(b.getbStore() - d.getNumber());
			bookDaoImpl.update(b);
		}
		return true;

	}
}
