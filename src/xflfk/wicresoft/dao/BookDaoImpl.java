package xflfk.wicresoft.dao;

import java.util.List;

import xfl.fk.sqldao.SqlControl;
import xflfk.wicresoft.entitry.Book;

@SuppressWarnings("all") 
public class BookDaoImpl implements SqlDao<Book> {
	private	boolean isOk=false;
	private Book book=null;
	private List<Book> booklist=null;

	@Override
	public Book getOne(int id) {
		book=(Book) sqlControl.getOne(Book.class, id);
		return book;
	}

	@Override
	public boolean delete(int id) {
		String tableName=Book.class.getSimpleName();
		if(sqlControl.delete(tableName, id))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean save(Book t) {
		if(sqlControl.save(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(Book t) {
		if(sqlControl.delete(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(Book t) {
		if(sqlControl.update(t))
			isOk=true;
		return isOk;
	}

	@Override
	public List<Book> getList(Book t) {
		booklist=(List<Book>) sqlControl.getList(t);
		return booklist;
	}

	@Override
	public boolean save(String sql, Object... obj) {
		if(sqlControl.save(sql, obj))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(String sql, Object... obj) {
		if(sqlControl.delete(sql, obj))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(String sql, Object... obj) {
		if(sqlControl.update(sql, obj))
			isOk=true;
		return isOk;
	}

	@Override
	public List<Book> getList(String sql, Object... obj) {
		booklist=(List<Book>) sqlControl.getList(Book.class, sql, obj);
		return booklist;
	}

	@Override
	public List<Book> getPagList(Book t, int index, int size) {
		booklist=(List<Book>) sqlControl.getPagList(t, index, size);
		return booklist;
	}

	@Override
	public List<Book> getSortList(Book t, String property, int r) {
		booklist=(List<Book>) sqlControl.getSortList(t, property, r);
		return booklist;
	}

	@Override
	public List<Book> getFuzzyList(String property, String info) {
		booklist=(List<Book>) sqlControl.getFuzzyList(Book.class, property, info);
		return booklist;
	}

}
