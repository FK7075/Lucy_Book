package xflfk.wicresoft.service;

public interface UserService {
	
	///登录
	public boolean login();
	
	///注销登录
	public boolean exit();
	
	///注册
	public boolean register();
	
	///个人信息修改
	public boolean modify();
	
	///查看所有图书
	public void showAllBook();
	
	///查看一本图书
	public void showOneBook();
	
	///查看所有作者
	public void showAllAuthor();
	
	///查看单个作者
	public void showOneAuthor();
	
	///通过图书找到作者
	public void bookToAuthor();
	
	///查看某个作者的所有作品
	public void authorToBooks();
	
	///添加收货人
	public void addConsignee();
	
	///添加到购物车
	public void shoppingCart();
	
	///购买
	public void buyBok();
	
	
}
