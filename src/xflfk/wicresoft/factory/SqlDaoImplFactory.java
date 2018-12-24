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
	public static AdminDaoImpl getAdminDaoImpl() {
		return new AdminDaoImpl();
	}
	public static AuthorDaoImpl getAuthorDaoImpl() {
		return new AuthorDaoImpl();
	}
	public static BookDaoImpl getBookDaoImpl() {
		return new BookDaoImpl();
	}
	public static ConsignessDaoImpl getConsignessDaoImpl() {
		return new ConsignessDaoImpl();
	}
	public static DetailDaoImpl getDetailDaoImpl() {
		return new DetailDaoImpl();
	}
	public static NotesDaoImpl getNotesDaoImpl() {
		return new NotesDaoImpl();
	}
	public static OrdersDaoImpl getOrdersDaoImpl() {
		return new OrdersDaoImpl();
	}
	public static ShoppCartDaoImpl getShoppCartDaoImpl() {
		return new ShoppCartDaoImpl();
	}
	public static StortDaoImpl getStortDaoImpl() {
		return new StortDaoImpl();
	}
	public static UserDaoImpl getUserDaoImpl() {
		return new UserDaoImpl();
	}
}
