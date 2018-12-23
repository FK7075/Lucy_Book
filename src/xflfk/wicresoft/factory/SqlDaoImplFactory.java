package xflfk.wicresoft.factory;

import xflfk.wicresoft.dao.AdminDaoImpl;
import xflfk.wicresoft.dao.AuthorDaoImpl;
import xflfk.wicresoft.dao.BookDaoImpl;
import xflfk.wicresoft.dao.ConsignessDaoImpl;
import xflfk.wicresoft.dao.DetailDaoImpl;
import xflfk.wicresoft.dao.NotesDaoImpl;
import xflfk.wicresoft.dao.OrdersDaoImpl;
import xflfk.wicresoft.dao.ShoppCartDaoImpl;
import xflfk.wicresoft.dao.SqlDao;
import xflfk.wicresoft.dao.StortDaoImpl;
import xflfk.wicresoft.dao.UserDaoImpl;

@SuppressWarnings("all")
public class SqlDaoImplFactory {
	public static SqlDao getAdminDaoImpl() {
		return new AdminDaoImpl();
	}
	public static SqlDao getAuthorDaoImpl() {
		return new AuthorDaoImpl();
	}
	public static SqlDao getBookDaoImpl() {
		return new BookDaoImpl();
	}
	public static SqlDao getConsignessDaoImpl() {
		return new ConsignessDaoImpl();
	}
	public static SqlDao getDetailDaoImpl() {
		return new DetailDaoImpl();
	}
	public static SqlDao getNotesDaoImpl() {
		return new NotesDaoImpl();
	}
	public static SqlDao getOrdersDaoImpl() {
		return new OrdersDaoImpl();
	}
	public static SqlDao getShoppCartDaoImpl() {
		return new ShoppCartDaoImpl();
	}
	public static SqlDao getStortDaoImpl() {
		return new StortDaoImpl();
	}
	public static SqlDao getUserDaoImpl() {
		return new UserDaoImpl();
	}
}
