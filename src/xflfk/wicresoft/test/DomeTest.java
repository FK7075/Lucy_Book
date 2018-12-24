package xflfk.wicresoft.test;


import xflfk.wicresoft.entitry.Orders;
import xflfk.wicresoft.service.UserService;

public class DomeTest {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		Orders o=new Orders();
		o.setOrdid(3);
		UserService u=new UserService();
		u.directlyBuy(o);
	}

}
