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
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	/// 以参数中用户输入的用户名和密码作为查询条件去查询数据库，返回查询结果
	public User login(User user) {
		if (userDaoImpl.getList(user) == null)
			user = null;
		else {
			user = userDaoImpl.getList(user).get(0);
		}
		return user;
	}

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	/// 先判断用户用是否已经存在，如果存在返回0，注册失败；如果不存在返回1，注册成功。
	public int register(User user) {
		User u = new User();
		u.setuName(user.getuName());
		if (userDaoImpl.getList(u) != null)
			return 0;// 用户名已经存在，注册失败
		else {
			userDaoImpl.save(user);
			return 1;// 用户名不存在，注册成功
		}
	}

	/**
	 * 根据id返回包含用户详细信息的User对象
	 * 
	 * @param id
	 * @return
	 */
	public User showUserInfo(int id) {
		return userDaoImpl.getOne(id);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 */
	public boolean changeUserInfo(User user) {
		return userDaoImpl.update(user);
	}

	/**
	 * 添加收货人
	 * 
	 * @param cons
	 *(收货人姓名，收货人电话，收货地址，创建人uid)
	 * @return
	 */
	public boolean addConsigness(Consigness cons) {
		return consignessDaoImpl.save(cons);
	}

	/**
	 * 添加一条明细记录
	 * 
	 * @param detail
	 * (用户uid，所要购买书本的bid，购买数量，收货人consid,用户备注信息)
	 * @return
	 */
	public boolean addDetail(Detail detail) {
		if (bookDaoImpl.getOne(detail.getBid()).getbStore() < detail.getNumber()) {
			System.out.println("商品库存不足！");
			return false;
		} else {
			detail.setDetState("未付款");// 将状态设置为"未付款"
			// 计算此条明细中商品的总价格
			detail.setMoney(bookDaoImpl.getOne(detail.getBid()).getbPrice() * detail.getNumber());
			return detailDaoImpl.save(detail);
		}
	}

	/**
	 * 得到所有新添的明细记录
	 * 
	 * @param uid
	 * @return
	 */
	public List<Detail> getNewDetail(int uid) {
		return detailDaoImpl.getList("select * from Detail where uid=? and detState=?", uid, "未付款");
	}

	/**
	 * 新增一条"未付款"订单，并产生该订单的所有明细
	 * 
	 * @param order
	 *            （用户uid，创建时间）
	 * @param detlist
	 *            新增明细记录所组成的List集合
	 * @return
	 */
	public boolean createOrder(Orders order, List<Detail> detlist) {
		///// 完善订单信息
		order.setOrdState("未付款");
		Double total = 0.0;
		// 计算总价格
		for (Detail d : detlist) {
			total += d.getMoney();
		}
		order.setOrdTotal(total);
		ordersDaoImpl.save(order);// 将订单存入数据库
		///// 完善明细信息
		int ordid = ordersDaoImpl.getList(order).get(0).getOrdid();
		for (Detail d : detlist) {
			d.setOrdid(ordid);
			detailDaoImpl.update(d);
		}
		return true;
	}
	/**
	 * 订单方式直接购买
	 * @param order
	 * （订单ordid）
	 * @return
	 */
	public boolean directlyBuy(Orders order) {
		SqlDaoImpl sqlDaoImpl = new SqlDaoImpl(Detail.class);
		List<Detail> list = (List<Detail>) sqlDaoImpl.getListSql("select * from detail d,orders o where d.ordid=o.ordid and d.detState=?", "未付款");
		order.setOrdState("已付款");
		ordersDaoImpl.update(order);
		for (Detail d : list) {
			d.setDetState("已付款");
			detailDaoImpl.update(d);
			Book b = bookDaoImpl.getOne(d.getBid());
			b.setbStore(b.getbStore() - d.getNumber());
			bookDaoImpl.update(b);
		}
		return true;

	}
}
