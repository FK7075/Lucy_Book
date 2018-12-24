package xflfk.wicresoft.service;

import xfl.fk.sqldao.Transaction;
import xflfk.wicresoft.dao.BookDaoImpl;
import xflfk.wicresoft.dao.ConsignessDaoImpl;
import xflfk.wicresoft.dao.DetailDaoImpl;
import xflfk.wicresoft.dao.OrdersDaoImpl;
import xflfk.wicresoft.dao.UserDaoImpl;
import xflfk.wicresoft.entitry.Book;
import xflfk.wicresoft.entitry.Consigness;
import xflfk.wicresoft.entitry.Detail;
import xflfk.wicresoft.entitry.Orders;
import xflfk.wicresoft.entitry.User;
import xflfk.wicresoft.factory.SqlDaoImplFactory;

@SuppressWarnings("all")
public class UserService {
	private UserDaoImpl userDaoImpl=SqlDaoImplFactory.getUserDaoImpl();
	private ConsignessDaoImpl consignessDaoImpl=SqlDaoImplFactory.getConsignessDaoImpl();
	private OrdersDaoImpl ordersDaoImpl=SqlDaoImplFactory.getOrdersDaoImpl();
	private DetailDaoImpl detailDaoImpl=SqlDaoImplFactory.getDetailDaoImpl();
	private BookDaoImpl bookDaoImpl=SqlDaoImplFactory.getBookDaoImpl();
	private boolean isOk=false;
	private Transaction tx = null;

	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return
	 */
	///�Բ������û�������û�����������Ϊ��ѯ����ȥ��ѯ���ݿ⣬���ز�ѯ���
	public User login(User user) {
		if(userDaoImpl.getList(user)==null)
			user=null;
		else {
			user=userDaoImpl.getList(user).get(0);
		}
		return user;
	}
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	///���ж��û����Ƿ��Ѿ����ڣ�������ڷ���0��ע��ʧ�ܣ���������ڷ���1��ע��ɹ���
	public int register(User user) {
		User u=new User();
		u.setuName(user.getuName());
		if(userDaoImpl.getList(u)!=null)
			return 0;//�û����Ѿ����ڣ�ע��ʧ��
		else {
			userDaoImpl.save(user);
			return 1;//�û��������ڣ�ע��ɹ�
		}
	}
	/**
	 * ����id���ذ����û���ϸ��Ϣ��User����
	 * @param id
	 * @return
	 */
	public User showUserInfo(int id) {
		return userDaoImpl.getOne(id);
	}
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 */
	public boolean changeUserInfo(User user) {
		return userDaoImpl.update(user);
	}
	/**
	 * ����ջ���                                                                                                        
	 * @param cons
	 * @return
	 */
	public boolean addConsigness(Consigness cons) {
		return consignessDaoImpl.save(cons);
	}
	/**
	 * ����
	 * @param order
	 * ������Ϣ
	 * @param detail
	 * ������ϸ��Ϣ
	 * @return
	 */
	public boolean buyBook(Orders order,Detail detail) {
		ordersDaoImpl.save(order);//���涩����Ϣ
		detail.setOrdid(ordersDaoImpl.getList(order).get(0).getOrdid());//����ϸ���м��붩�������Ϣ
		detailDaoImpl.save(detail);//���涩����ϸ��Ϣ
		Book book=bookDaoImpl.getOne(detail.getBid());
		book.setbStore(book.getbStore()-detail.getNumber());
		bookDaoImpl.update(book);//���鱾�����������Ӧ����
		return false;
	}
}
