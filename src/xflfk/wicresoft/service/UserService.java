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
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	///以参数中用户输入的用户名和密码作为查询条件去查询数据库，返回查询结果
	public User login(User user) {
		if(userDaoImpl.getList(user)==null)
			user=null;
		else {
			user=userDaoImpl.getList(user).get(0);
		}
		return user;
	}
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	///先判断用户用是否已经存在，如果存在返回0，注册失败；如果不存在返回1，注册成功。
	public int register(User user) {
		User u=new User();
		u.setuName(user.getuName());
		if(userDaoImpl.getList(u)!=null)
			return 0;//用户名已经存在，注册失败
		else {
			userDaoImpl.save(user);
			return 1;//用户名不存在，注册成功
		}
	}
	/**
	 * 根据id返回包含用户详细信息的User对象
	 * @param id
	 * @return
	 */
	public User showUserInfo(int id) {
		return userDaoImpl.getOne(id);
	}
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public boolean changeUserInfo(User user) {
		return userDaoImpl.update(user);
	}
	/**
	 * 添加收货人                                                                                                        
	 * @param cons
	 * @return
	 */
	public boolean addConsigness(Consigness cons) {
		return consignessDaoImpl.save(cons);
	}
	/**
	 * 买书
	 * @param order
	 * 订单信息
	 * @param detail
	 * 订单明细信息
	 * @return
	 */
	public boolean buyBook(Orders order,Detail detail) {
		ordersDaoImpl.save(order);//保存订单信息
		detail.setOrdid(ordersDaoImpl.getList(order).get(0).getOrdid());//在明细表中加入订单表的信息
		detailDaoImpl.save(detail);//保存订单明细信息
		Book book=bookDaoImpl.getOne(detail.getBid());
		book.setbStore(book.getbStore()-detail.getNumber());
		bookDaoImpl.update(book);//该书本库存量减少相应数量
		return false;
	}
}
