package xflfk.wicresoft.test;

import org.junit.jupiter.api.Test;

import xflfk.wicresoft.service.UserService;

class UserServiceTest {
private UserService usr=new UserService();

	@Test
	void test() {
		System.out.println(usr.search("", "Ìì", "ÍøÂç"));
	}

}
