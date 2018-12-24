package xflfk.wicresoft.test;

import java.util.Date;

import xflfk.wicresoft.dao.BookDaoImpl;
import xflfk.wicresoft.entitry.Detail;
import xflfk.wicresoft.entitry.Orders;
import xflfk.wicresoft.factory.SqlDaoImplFactory;
import xflfk.wicresoft.service.UserService;

public class DomeTest {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		BookDaoImpl bookDaoImpl=SqlDaoImplFactory.getBookDaoImpl();
		Orders order=new Orders();
		Detail detail=new Detail();
		order.setOrdState("�Ѹ���");
		order.setOrdTime((new Date()).toString());
		order.setUid(1);
		detail.setBid(1);
		detail.setConsid(1);
		detail.setNumber(3);
		detail.setUserdetail("��㷢���ɺã���");
		detail.setMoney(bookDaoImpl.getOne(1).getbPrice()*3);
		UserService userService=new UserService();
		userService.buyBook(order, detail);
	}

}
