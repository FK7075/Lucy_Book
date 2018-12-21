package xflfk.wicresoft.service;

public interface UserService {
	
	///��¼
	public boolean login();
	
	///ע����¼
	public boolean exit();
	
	///ע��
	public boolean register();
	
	///������Ϣ�޸�
	public boolean modify();
	
	///�鿴����ͼ��
	public void showAllBook();
	
	///�鿴һ��ͼ��
	public void showOneBook();
	
	///�鿴��������
	public void showAllAuthor();
	
	///�鿴��������
	public void showOneAuthor();
	
	///ͨ��ͼ���ҵ�����
	public void bookToAuthor();
	
	///�鿴ĳ�����ߵ�������Ʒ
	public void authorToBooks();
	
	///����ջ���
	public void addConsignee();
	
	///��ӵ����ﳵ
	public void shoppingCart();
	
	///����
	public void buyBok();
	
	
}
